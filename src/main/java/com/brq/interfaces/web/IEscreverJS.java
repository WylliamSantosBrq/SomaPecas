package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para simular ações de escrita usando Javascript.
 */
public interface IEscreverJS {

	/**
	 * Escreve no campo definido pelo by usando o método
	 * {@code element.value="some text"} do Javascript.
	 * 
	 * @param by    O by que define o campo a receber o texto.
	 * @param texto O texto a ser escrito.
	 */
	default void escreverJavascript(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = driver.findElement(by);

		executor.executeScript(String.format("arguments[0].value=\"%s\";", texto), elemento);
	}

	/**
	 * Escreve no campo definido pelo by usando o método
	 * {@code element.value="some text"} do Javascript.
	 * 
	 * @param elemento O elemento do campo a receber o texto.
	 * @param texto    O texto a ser escrito.
	 */
	default void escreverJavascript(WebElement elemento, String texto) {
		BRQLogger.logMethod(elemento, texto);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript(String.format("arguments[0].value=\"%s\";", texto), elemento);
	}
}