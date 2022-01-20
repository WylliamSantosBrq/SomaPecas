package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para trabalhar com frames.
 */
public interface IFrame {

	/**
	 * Muda o foco para o frame definido.
	 * 
	 * @param nomeOuId Nome ou ID usado para identificar o frame.
	 */
	static void entrarFrame(String nomeOuId) {
		BRQLogger.logMethod(nomeOuId);

		WebDriver driver = DriverWeb.getDriver();

		driver.switchTo().frame(nomeOuId);
	}

	/**
	 * Muda o foco para o primeiro frame encontrado pelo By.
	 * 
	 * @param by O By usado para encontrar o frame.
	 */
	static void entrarFrame(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		driver.switchTo().frame(elemento);
	}

	/**
	 * Retorna o foco para o padrão.
	 */
	static void sairFrame() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();

		driver.switchTo().defaultContent();
	}

}