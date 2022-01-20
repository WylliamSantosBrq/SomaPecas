package com.brq.interfaces.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos de rolagem em JavaScript.
 */
public interface IRolarJS {

	/**
	 * Rola a tela por uma quantidade de pixels usando um método JavaScript.
	 * 
	 * @param quantidade Quantidade de pixels a ser rolado para baixo.
	 */
	static void rolarJavascript(int quantidade) {
		BRQLogger.logMethod(quantidade);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("window.scrollBy(0, arguments[0])", quantidade);
	}
}