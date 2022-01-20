package com.brq.interfaces.web;

import java.io.File;
import java.time.LocalDateTime;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.log.BRQLogger;
import com.brq.util.FileHelper;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

/**
 * Interface com métodos para captura de tela.
 * 
 * @author ymnoda
 *
 */
public interface IPrint {

	static final int PAGE_TIMEOUT = 500;// padrão era 5000, tentando diminuir esse valor

	/**
	 * Tira um print da tela atual, salvando na pasta correspondente ao status do
	 * cenário, retornando o caminho relativo à pasta de evidências.
	 * 
	 * @param scenario
	 * @return
	 */
	default String printAndSave(Scenario scenario) {
		BRQLogger.logMethod(scenario);

		String pastaDeEvidencias = FileHelper.projectFolder("Evidencias");
		String pastaSucesso = FileHelper.projectFolder("Evidencias", "Prints_Sucesso");
		String pastaErro = FileHelper.projectFolder("Evidencias", "Prints_Erro");
		String destino;
		String nome = LocalDateTime.now().toString().replace("-", "_").replace(":", "_").replace("\\.", "_")
				.replace("T", "_");

		IAlert alert = new IAlert() {
		};
		IUtils utils = new IUtils() {
		};

		try {
			if (alert.alertaPresente()) {
				Reporter.addStepLog(alert.obterTextoDoAlerta());

				alert.aceitarAlerta();
			}

			utils.diretorioExiste(pastaDeEvidencias);

			destino = scenario.isFailed() ? pastaErro : pastaSucesso;

			utils.diretorioExiste(destino);

			Shutterbug.shootPage(DriverWeb.getDriver(), Capture.FULL, PAGE_TIMEOUT, true).withName(nome).save(destino);

			String retorno = scenario.isFailed() ? "Prints_Erro" : "Prints_Sucesso";

			return retorno + File.separator + nome + ".png";

		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado.");
		}
	}

}
