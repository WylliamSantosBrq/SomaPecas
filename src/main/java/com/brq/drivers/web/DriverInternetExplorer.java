package com.brq.drivers.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.brq.interfaces.log.BRQLogger;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Classe responsavel por criar a instância do Internet explorer
 * 
 * @author leonardoananias
 *
 */
public class DriverInternetExplorer {
	private InternetExplorerDriver driver;

	public DriverInternetExplorer(boolean headless) {
		WebDriverManager.iedriver().setup();
		InternetExplorerOptions capability = setupBrowser();
		this.driver = new InternetExplorerDriver(capability);
		BRQLogger.info("Internet Explorer iniciado com sucesso.");
	}

	private static InternetExplorerOptions setupBrowser() {
		String site = "";
		InternetExplorerOptions capability = new InternetExplorerOptions();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, site);

		return capability;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
