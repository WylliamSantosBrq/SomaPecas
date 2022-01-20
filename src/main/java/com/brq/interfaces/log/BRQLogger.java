package com.brq.interfaces.log;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import cucumber.api.Scenario;

/**
 * Classe estática para métodos de log.
 * 
 * @author ymnoda
 *
 */
public class BRQLogger {
	/**
	 * O logger a ser usado para documentação.
	 */
	static Logger logger = Logger.getLogger("BRQLogger");

	private BRQLogger() {
	}

	public static void debug(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		logger.debug(msgFormatada);
	}

	public static void info(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		logger.info(msgFormatada);
	}

	public static void warn(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		logger.warn(msgFormatada);
	}

	public static void error(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		logger.error(msgFormatada);
	}

	public static void fatal(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		logger.fatal(msgFormatada);
	}

	public static void rawLog() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement currentMethod = stackTrace[2];
		StackTraceElement currentLocation = stackTrace[3];
		String className = currentMethod.getClassName();
		String methodName = currentMethod.getMethodName();
		String fileName = currentLocation.getFileName();
		int lineNumber = currentLocation.getLineNumber();

		BRQLogger.debug(String.format("%s.%s(%s:%d)", className, methodName, fileName, lineNumber));
	}

	/**
	 * Método para documentar o método executado.
	 * <dl>
	 * <dt>Exemplo:</dt>
	 * <dd>{@code public void someMethod(int int1, String string)} {</dd>
	 * <dd>{@code BRQLogger.logMethod(int1string);}</dd>
	 * <dd>}</dd>
	 * </dl>
	 * 
	 * @param args Os argumentos do método a ser documentado.
	 */
	public static void logMethod(Object... args) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement currentMethod = stackTrace[2];
		StackTraceElement currentLocation = stackTrace[3];
		String className = currentMethod.getClassName();
		String methodName = currentMethod.getMethodName();
		String fileName = currentLocation.getFileName();
		int lineNumber = currentLocation.getLineNumber();

		BRQLogger.debug("(%s:%d) %s.%s(%s)", fileName, lineNumber, className, methodName, StringUtils.join(args, ", "));
	}

	/**
	 * Passa para o log a localização no projeto de onde o método é chamado.
	 * 
	 * @param message Mensagem passado junto da localização.
	 */
	public static void logLocation(String message) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement currentMethod = stackTrace[2];
		String fileName = currentMethod.getFileName();
		int lineNumber = currentMethod.getLineNumber();

		BRQLogger.debug(String.format("%s (%s:%d)", message, fileName, lineNumber));
	}

	/**
	 * Passa para o log uma lista de maneira mais legível.
	 * 
	 * @param tituloDaLista Título que a lista terá no log.
	 * @param lista         A lista a ser documentada.
	 */
	public static void logList(String tituloDaLista, Collection<?> lista) {

		StringBuilder listaFormatada = new StringBuilder();

		listaFormatada.append(String.format(":%n", tituloDaLista));

		for (Object item : lista) {
			listaFormatada.append(String.format("\t%s%n", item.toString()));
		}

		BRQLogger.info(listaFormatada.toString());
	}

	/**
	 * Passa para o log uma lista de dados mais legível.
	 * 
	 * @param tituloDaLista Título que a lista terá no log.
	 * @param lista         A lista a ser documentada.
	 */
	public static void logList(String tituloDaLista, Object... lista) {

		StringBuilder listaFormatada = new StringBuilder();

		listaFormatada.append(String.format(":%n", tituloDaLista));

		for (Object item : lista) {
			listaFormatada.append(String.format("\t%s%n", item.toString()));
		}

		BRQLogger.info(listaFormatada.toString());
	}

	public static void logScenario(Scenario cenario) {
		BRQLogger.info("%n%n\t%s%n\t%s%n", String.join(" ", cenario.getSourceTagNames()), cenario.getName(),
				cenario.getId());
	}
}
