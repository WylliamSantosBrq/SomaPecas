package com.brq.utils.erros;

import org.apache.log4j.Logger;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;

/**
 * Classe estática usada no final do teste para verificar se algum elemento de
 * erro definido em {@link com.brq.utils.erros.ElementoErro} está presente na tela,
 * explicando o motivo da falha do teste.
 * 
 * @author ymnoda
 *
 */
public class ErrorHelper {
	/**
	 * O logger a ser usado para documentação.
	 */
	static Logger logger = Logger.getLogger("BrowserLogger");

	/**
	 * Checa todos os com.brq.elementos mapeados em {@link com.brq.utils.erros.ElementoErro},
	 * jogando um erro caso o mesmo seja encontrado.
	 */
	public static void checarErrosSistema() {
		BRQLogger.logMethod();

		for (ElementoErro item : ElementoErro.values()) {
			try {
				DriverWeb.getDriver().findElement(item.by);
				throw new ErroSistema(item.by, item.mensagem);
			} catch (Exception e) {
				BRQLogger.info("O elemento de erro [%s] não está presente.", item.by);
			}
		}
	}

	public static void salvarLogs() {
		BRQLogger.logMethod();

		StringBuilder builder = new StringBuilder();
		LogEntries entries = DriverWeb.getDriver().manage().logs().get(LogType.BROWSER);

		for (LogEntry entry : entries) {
			String log = String.format("[%5s] %s - %s%n", entry.getLevel().getName(), entry.getTimestamp(),
					entry.getMessage());
			builder.append(log);
		}

		logger.info(String.format("StackTrace do console:%n%s", builder.toString()));

	}

}
