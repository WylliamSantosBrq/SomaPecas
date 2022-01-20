package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para simular os movimentos no navegador.
 */
public interface IMover extends IMoverJS {

	/**
	 * Move a tela para que o elemento encontrado pelo By esteja dentro dos limites
	 * do monitor, mesmo que sobreposto por outros com.brq.elementos.
	 * 
	 * @param by O By usado para encontrar o elemento.
	 */
	static void moverParaElemento(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);
		WebElement elemento = driver.findElement(by);

		actions.moveToElement(elemento).build().perform();
	}

	/**
	 * Move a tela para que o elemento esteja dentro dos limites do monitor, mesmo
	 * que sobreposto por outros com.brq.elementos.
	 * 
	 * @param elemento O elemento a ser colocado em tela.
	 */
	static void moverParaElemento(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);

		actions.moveToElement(elemento).build().perform();
	}

	/**
	 * Move a tela para que o elemento encontrado pelo By esteja dentro dos limites
	 * do monitor, mesmo que sobreposto por outros com.brq.elementos, e realiza um clique.
	 * 
	 * @param by O By usado para encontrar o elemento.
	 */
	static void moverParaElementoEClicar(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);
		WebElement elemento = driver.findElement(by);

		actions.moveToElement(elemento).click().build().perform();
	}

	/**
	 * Move a tela para que o elemento esteja dentro dos limites do monitor, mesmo
	 * que sobreposto por outros com.brq.elementos, e realiza um clique.
	 * 
	 * @param elemento O elemento a ser clicado.
	 */
	static void moverParaElementoEClicar(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);

		actions.moveToElement(elemento).click().build().perform();
	}

	/**
	 * Clica e mantém pressionado o primeiro elemento encontrado pelo By.
	 * 
	 * @param by O By usado para encontrar o elemento.
	 */
	static void manterElementoPressionado(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);
		WebElement elemento = driver.findElement(by);

		actions.clickAndHold(elemento).build().perform();
	}

	/**
	 * Move a tela para que o elemento encontrado pelo By esteja dentro dos limites
	 * do monitor, mesmo que sobreposto por outros com.brq.elementos, e escreve o texto
	 * definido no mesmo.
	 * 
	 * @param by    O By usado para encontrar o elemento.
	 * @param texto O texto a ser escrito no campo.
	 */
	static void moverParaElementoEEscrever(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);
		WebElement elemento = driver.findElement(by);

		actions.moveToElement(elemento).click().pause(10).sendKeys(texto).build().perform();
	}

	/**
	 * Move a tela para que o elemento esteja dentro dos limites do monitor, mesmo
	 * que sobreposto por outros com.brq.elementos, e escreve o texto definido no mesmo.
	 * 
	 * @param by    O elemento a receber o texto.
	 * @param texto O texto a ser escrito no campo.
	 */
	static void moverParaElementoEEscrever(WebElement elemento, String texto) {
		BRQLogger.logMethod(elemento, texto);

		WebDriver driver = DriverWeb.getDriver();
		Actions actions = new Actions(driver);

		actions.moveToElement(elemento).click().pause(10).sendKeys(texto).build().perform();
	}

}