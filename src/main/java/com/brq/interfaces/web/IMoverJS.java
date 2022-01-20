package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para simular movimentação no navegador usando métodos de
 * Javascript.
 */
public interface IMoverJS {

	/**
	 * Move a tela para que o primeiro elemento encontrado pelo By esteja alinhado
	 * com o topo da janela, mesmo que sobreposto por outros com.brq.elementos, usando o
	 * método {@code element.scrollIntoView(true)} do Javascript.
	 * 
	 * @param by O By usado para encontrar o elemento.
	 */
	static void moverParaElementoJavascript(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = driver.findElement(by);

		executor.executeScript("arguments[0].scrollIntoView(true);", elemento);
	}

	/**
	 * Move a tela para que o elemento esteja alinhado com o topo da janela, mesmo
	 * que sobreposto por outros com.brq.elementos, usando o método
	 * {@code element.scrollIntoView(true)} do Javascript.
	 * 
	 * @param elemento O elemento que será movido.
	 */
	static void moverParaElementoJavascript(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].scrollIntoView(true);", elemento);
	}

	/**
	 * Move a tela pela distância definida.
	 * 
	 * @param scroll A distância do scroll.
	 */
	static void scrollJavascript(int scroll) {
		BRQLogger.logMethod(scroll);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("window.scrollBy(0, arguments[0])", scroll);
	}

	/**
	 * Move o elemento para o topo da tela e mais um offset definido.
	 * 
	 * @param by     O By usado para encontrar o elemento.
	 * @param offset O quanto o elemento será deslocado depois.
	 */
	static void moverParaElementoComOffsetJavascript(By by, int offset) {
		BRQLogger.logMethod(by, offset);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = driver.findElement(by);

		executor.executeScript("arguments[0].scrollIntoView(true);", elemento);
		executor.executeScript("window.scrollBy(0, arguments[0])", offset);
	}

	/**
	 * Move o elemento para o centro da tela.
	 * 
	 * @param by O By usado para encontrar o elemento.
	 */
	static void moverElementoParaOCentroDaTela(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = driver.findElement(by);
		int offset;

		executor.executeScript("arguments[0].scrollIntoView(true);", elemento);
		offset = (int) executor.executeScript("return window.innerHeight") / 2;
		executor.executeScript("window.scrollBy(0, arguments[0])", offset);
	}

}