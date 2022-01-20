package com.brq.interfaces.web;

import org.openqa.selenium.WebDriver;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.log.BRQLogger;

public interface IValidacoesBrowser {

	/**
	 * Valida se o título da página atual é igual ao esperado.
	 * 
	 * @param tituloEsperado
	 */
	default void validarTituloDoBrowser(String tituloEsperado) {
		BRQLogger.logMethod(tituloEsperado);

		WebDriver driver = DriverWeb.getDriver();
		String tituloOriginal = driver.getTitle();

		if (!tituloOriginal.equalsIgnoreCase(tituloEsperado))
			throw new ErroValidacao("Título diferente!\n%s\n%s", tituloOriginal, tituloEsperado);
	}

	/**
	 * Valida se o título da página atual contém o texto definido.
	 * 
	 * @param tituloEsperado
	 */
	default void validarTituloDoBrowserContains(String tituloEsperado) {
		BRQLogger.logMethod(tituloEsperado);

		WebDriver driver = DriverWeb.getDriver();
		String tituloOriginal = driver.getTitle();

		if (!tituloOriginal.contains(tituloEsperado))
			throw new ErroValidacao("Título diferente!\n%s\n%s", tituloOriginal, tituloEsperado);
	}

	/**
	 * Valida se a URL atual é igual ao esperado.
	 * 
	 * @param urlEsperado
	 */
	default void validarUrlAtual(String urlEsperado) {
		BRQLogger.logMethod(urlEsperado);

		WebDriver driver = DriverWeb.getDriver();
		String urlOriginal = driver.getCurrentUrl();

		if (!urlOriginal.equalsIgnoreCase(urlEsperado))
			throw new ErroValidacao("URL diferente!\n%s\n%s", urlOriginal, urlEsperado);
	}

	/**
	 * Valida se os textos definidos são diferentes.
	 * 
	 * @param texto1
	 * @param texto2
	 */
	default void validarDiferentes(String texto1, String texto2) {
		BRQLogger.logMethod(texto1, texto2);

		if (texto1.equalsIgnoreCase(texto2))
			throw new ErroValidacao("Mensagem igual!\n%s\n%s", texto1, texto2);
	}

	/**
	 * Valida se os inteiros definidos são diferentes.
	 * 
	 * @param int1
	 * @param int2
	 */
	default void validarDiferentes(int int1, int int2) {
		BRQLogger.logMethod(int1, int2);

		if (int1 == int2)
			throw new ErroValidacao("Valor igual!\n%d\n%d", int1, int2);
	}

	/**
	 * Valida se os textos definidos são iguais.
	 * 
	 * @param texto1
	 * @param texto2
	 */
	default void validarIguais(String texto1, String texto2) {
		BRQLogger.logMethod(texto1, texto2);

		if (!texto1.equalsIgnoreCase(texto2))
			throw new ErroValidacao("Mensagem Diferente!\n%s\n%s", texto1, texto2);
	}

	/**
	 * Valida se os inteiros definidos são iguais.
	 * 
	 * @param int1
	 * @param int2
	 */
	default void validarIguais(int int1, int int2) {
		BRQLogger.logMethod(int1, int2);

		if (int1 != int2)
			throw new ErroValidacao("Valor diferente!\n%d\n%d", int1, int2);
	}

	/**
	 * Valida se o status não é null ou false.
	 * 
	 * @param status
	 */
	default void validarOK(boolean status) {
		BRQLogger.logMethod(status);

		if (!status)
			throw new ErroValidacao("O resultado foi %s!", status);
	}

	/**
	 * Valida se o texto não é null ou vazio.
	 * 
	 * @param status
	 */
	default void validarNaoVazio(String texto) {
		BRQLogger.logMethod(texto);

		if (texto == null || texto.trim().isEmpty())
			throw new ErroValidacao("O texto está vazio.", texto);
	}

}
