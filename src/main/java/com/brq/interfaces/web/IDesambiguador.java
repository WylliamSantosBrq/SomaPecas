package com.brq.interfaces.web;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

public interface IDesambiguador extends IEsperaWeb {

	/**
	 * Aguarda um dos com.brq.elementos da lista existirem, o primeiro que existir será
	 * retornado.
	 * 
	 * @param Lista de com.brq.elementos
	 * @return elemento
	 * @author mquiterio
	 */
	default By desambiguador(ArrayList<By> bys) {
		BRQLogger.logMethod(bys);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);

		ExpectedCondition<By> condicao = webDriver -> {
			for (By by : bys) {
				if (!webDriver.findElements(by).isEmpty())
					return by;
			}
			return null;
		};

		return wait.until(condicao);

	}

}
