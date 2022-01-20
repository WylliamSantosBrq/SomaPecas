package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para simular cliques usando métodos de Javascript.
 */
public interface ICliqueJS {

	/**
	 * Clica no elemento definido pelo by usando o método {@code element.click()} de
	 * javascript.
	 * 
	 * @param by O by que define o elemento a ser clicado.
	 */
	static void clicarJavascript(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", driver.findElement(by));
	}

	static void clicarJavascript(By by, Integer indice) {
		BRQLogger.logMethod(by, indice);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", driver.findElements(by).get(indice));
	}

	/**
	 * Clica no elemento usando o método {@code element.click()} de Javascript.
	 * 
	 * @param elemento O elemento a ser clicado.
	 */
	static void clicarJavascript(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", elemento);
	}

}