package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interfaces com métodos para limpeza de campo.
 */
public interface ILimpar {

	/**
	 * Deleta todos os caractéres o primeiro campo encontrado com o By.
	 * 
	 * @param by O By usado para encontrar o campo.
	 */
	static void limpar(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		elemento.clear();
	}

	/**
	 * Deleta todos os caractéres do campo.
	 * 
	 * @param elemento O elemento do campo.
	 */
	static void limpar(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		elemento.clear();
	}
}
