package com.brq.interfaces.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos para simular o arraste do mouse.
 */
public interface IArrastar {

	/**
	 * Arrasta o primeiro elemento para a posição do segundo.
	 * 
	 * @param by  By do elemento a ser arrastado.
	 * @param by2 By do elemento onde o primeiro será arrastado.
	 */
	static void arrastar(By by, By by2) {
		BRQLogger.logMethod(by, by2);

		WebDriver driver = DriverWeb.getDriver();
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(by), driver.findElement(by2)).perform();
	}
}
