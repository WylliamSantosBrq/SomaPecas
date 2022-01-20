package com.brq.util.teste;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.brq.erros.ErroInesperado;
import com.brq.erros.MelhoriaFramework;
import com.brq.interfaces.log.BRQLogger;

import cucumber.api.Scenario;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;

/**
 * Contém métodos para analisar qual foi a mensagem de erro que o teste
 * retornou, recomendando melhorias com base nas mensagens do enum
 * {@link com.brq.util.teste.ResultMessage}.
 * 
 * @author ymnoda
 * @see com.brq.util.teste.ResultMessage
 *
 */
public class TestHelper {

	private TestHelper() {
	}

	@SuppressWarnings("unchecked")
	public static List<Result> getResults(Scenario cenario) {
		BRQLogger.logMethod(cenario);

		Field field = FieldUtils.getField(((ScenarioImpl) cenario).getClass(), "stepResults", true);
		field.setAccessible(true);

		try {
			return (ArrayList<Result>) field.get(cenario);

		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro ao acessar o resultado da execução do teste.");

		} finally {
			field.setAccessible(false);
		}
	}

	/**
	 * Recomenda melhorias para o framework com base na última mensagem de erro
	 * obtida no teste.
	 * 
	 * @param cenario
	 */
	public static void recomendarMelhorias(Scenario cenario) {
		BRQLogger.logMethod(cenario);

		for (Result resultado : getResults(cenario)) {
			Throwable throwable = resultado.getError();

			if (throwable == null)
				continue;

			Class<? extends Throwable> throwableClass = throwable.getClass();

			for (ResultMessage resultMessage : ResultMessage.values()) {
				Class<? extends Throwable> expectedThrowableClass = resultMessage.getThrowable();

				if (throwableClass.equals(expectedThrowableClass)) {
					throw new MelhoriaFramework(resultMessage.getMensagem());
				}
			}
		}
	}

}
