package com.brq.interfaces.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para lidar com alertas do navegador.
 */
public interface IAlert {

	/**
	 * Aceita o alerta no navegador.
	 */
	default void aceitarAlerta() {
		BRQLogger.logMethod();

		Alert alert = DriverWeb.getDriver().switchTo().alert();
		alert.accept();
	}

	/**
	 * Obtém a mensagem presente no alerta.
	 * 
	 * @return
	 */
	default String obterTextoDoAlerta() {
		BRQLogger.logMethod();

		Alert alert = DriverWeb.getDriver().switchTo().alert();
		return alert.getText();
	}

	/**
	 * Recusar o alerta no navegador.
	 */
	default void negarAlerta() {
		BRQLogger.logMethod();

		Alert alert = DriverWeb.getDriver().switchTo().alert();
		alert.dismiss();
	}

	/**
	 * Insere o texto no campo do alerta.
	 * 
	 * @param texto Texto a ser escrito
	 */
	default void escreverNoAlerta(String texto) {
		BRQLogger.logMethod(texto);

		Alert alert = DriverWeb.getDriver().switchTo().alert();
		alert.sendKeys(texto);
	}

	/**
	 * Retorna se o alerta está presente no
	 * 
	 * @return
	 */
	default Boolean alertaPresente() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		String handle = driver.getWindowHandle();

		try {
			driver.switchTo().alert();
			return true;
			
		} catch (Exception e) {
			return false;
			
		} finally {
			driver.switchTo().window(handle);
		}

	}
	
}