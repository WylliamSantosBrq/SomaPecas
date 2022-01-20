package com.brq.drivers.web;

import org.openqa.selenium.WebDriver;

import com.brq.enums.Browser;
import com.brq.enums.TipoOS;
import com.brq.interfaces.log.BRQLogger;

public class DriverPath {

	private static final String NAVEGADOR_NAO_ENCONTRADO = "Navegador não encontrado.";
	static String sistema = System.getProperty("os.name").toLowerCase();
	static DriverChrome driverChrome;
	static DriverFirefox driverFirefox;
	static DriverInternetExplorer driverInternet;

	private DriverPath() {
	}

	public static void informarPathDoDriver(Browser navegador, Boolean headless) {
		switch (sistemaOperacional()) {
		case WINDOWS:
			pathWindows(navegador, headless);
			break;

		case MAC:
			pathMac(navegador, headless);
			break;

		case LINUX:
			pathLinux(navegador, headless);
			break;

		default:
			BRQLogger.info("Não foi possível inicializar o driver web.");
			break;
		}
	}

	public static WebDriver driverInicializado(Browser navegador) {
		switch (navegador) {
		case CHROME:
			return driverChrome.getDriver();
		case FIREFOX:
			return driverFirefox.getDriver();
		case EXPLORER:
			return driverInternet.getDriver();
		default:
			BRQLogger.info(NAVEGADOR_NAO_ENCONTRADO);
			break;
		}
		return null;
	}

	private static void pathWindows(Browser navegador, Boolean headless) {
		switch (navegador) {
		case CHROME:
			driverChrome = new DriverChrome(headless);
			break;
		case FIREFOX:
			driverFirefox = new DriverFirefox(headless);
			break;
		case EXPLORER:
			driverInternet = new DriverInternetExplorer(headless);
			break;
		default:
			BRQLogger.info(NAVEGADOR_NAO_ENCONTRADO);
			break;
		}
	}

	private static void pathMac(Browser navegador, Boolean headless) {
		switch (navegador) {
		case CHROME:
			driverChrome = new DriverChrome(headless);
			break;
		case FIREFOX:
			driverFirefox = new DriverFirefox(headless);
			break;
		case EXPLORER:
			driverInternet = new DriverInternetExplorer(headless);
			break;
		default:
			BRQLogger.info(NAVEGADOR_NAO_ENCONTRADO);
			break;
		}
	}

	private static void pathLinux(Browser navegador, Boolean headless) {
		switch (navegador) {
		case CHROME:
			driverChrome = new DriverChrome(headless);
			break;
		case FIREFOX:
			driverFirefox = new DriverFirefox(headless);
			break;
		case EXPLORER:
			driverInternet = new DriverInternetExplorer(headless);
			break;
		default:
			BRQLogger.info(NAVEGADOR_NAO_ENCONTRADO);
			break;
		}
	}

	private static TipoOS sistemaOperacional() {
		if (sistema.contains("windows")) {
			return TipoOS.WINDOWS;
		} else if (sistema.contains("mac")) {
			return TipoOS.MAC;
		} else {
			return TipoOS.LINUX;
		}
	}
}
