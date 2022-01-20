package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para simular escrita em campos.
 */
public interface IEscrever {

	/**
	 * Escreve no campo definido pelo by.
	 * 
	 * @param by    O by que define o campo a receber o texto.
	 * @param texto O texto a ser escrito.
	 */
	static void escrever(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		elemento.clear();
		elemento.sendKeys(texto);
	}

	/**
	 * Escreve no campo definido pelo elemento.
	 * 
	 * @param elemento O elemento a receber o texto.
	 * @param texto    O texto a ser escrito.
	 */
	static void escrever(WebElement elemento, String texto) {
		BRQLogger.logMethod(elemento, texto);

		elemento.clear();
		elemento.sendKeys(texto);
	}

	/**
	 * Escreve no campo definido pelo by, com cada tecla tendo uma espera, simulando
	 * uma pessoa escrevendo.
	 * 
	 * @param by    O by que define o elemento a receber o texto.
	 * @param texto
	 */
	static void escreverUmaLetraPorVez(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			String s = new StringBuilder().append(c).toString();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			elemento.sendKeys(s);
		}
	}

	/**
	 * Escreve no campo definido, com cada tecla tendo uma espera, simulando uma
	 * pessoa escrevendo.
	 * 
	 * @param elemento O elemento do campo.
	 * @param texto    O texto a ser escrito.
	 */
	static void escreverUmaLetraPorVez(WebElement elemento, String texto) {
		BRQLogger.logMethod(elemento, texto);

		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			String s = new StringBuilder().append(c).toString();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			elemento.sendKeys(s);
		}
	}

	/**
	 * Limpa todos os caractéres do campo usando o comando CTRL + A, DEL.
	 * 
	 * @param by O by que define o campo a ser limpo.
	 */
	static void limparCampo(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		elemento.sendKeys(Keys.LEFT_CONTROL, "a");
		elemento.sendKeys(Keys.BACK_SPACE);
	}
}
