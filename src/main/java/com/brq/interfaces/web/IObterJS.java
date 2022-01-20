package com.brq.interfaces.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos de obtenção de com.brq.dados presentes em tela usando
 * JavaScript.
 */
public interface IObterJS {

	/**
	 * Obtém o valor CSS do elemento localizado pelo id definido.
	 * 
	 * @param id O id do elemento a ser obtido o valor.
	 * @return O valor style do elemento.
	 */
	static String obterValorCssJavascriptPorId(String id) {
		BRQLogger.logMethod(id);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		return (String) executor
				.executeScript("if (document.getElementById(arguments[0]).style.display == 'none'){   }", id);
	}
}