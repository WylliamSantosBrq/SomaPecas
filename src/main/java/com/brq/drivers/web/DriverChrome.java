package com.brq.drivers.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.brq.interfaces.log.BRQLogger;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Classe responsavel por criar a instância do chrome driver
 * 
 * @author leonardoananias
 *
 */
public class DriverChrome {

	private ChromeDriver driver;

	public DriverChrome(Boolean headless) {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = setupChromeBrowser(headless);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		BRQLogger.info("Chrome iniciado com sucesso.");
	}

	private ChromeOptions setupChromeBrowser(Boolean headless) {
		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.directory_upgrade", true);
		chromePrefs.put("safebrowsing.enabled", "true");
		chromePrefs.put("profile.default_content_setting_values.notifications", 2);

		// Configurando Opcoes de Navegador
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--lang=pt-BR");
		options.addArguments("--incognito");
		options.addArguments("--ignore-certificate-errors");

		if (Boolean.TRUE.equals(headless)) {
			options.addArguments("--headless");
			options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
			options.addArguments("--window-size=1920,1080");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		}

		return options;

	}

	public static void finalizarProcessoChromeLinux() {
		try {
			Process process = Runtime.getRuntime().exec("pkill chrome");
			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(process.getInputStream());
			while (leitor.hasNextLine()) {
				BRQLogger.info(leitor.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void finalizarProcessoChrome() {
		try {
			Process process = Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(process.getInputStream());
			while (leitor.hasNextLine()) {
				BRQLogger.info(leitor.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

}
