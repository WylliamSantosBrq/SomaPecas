package com.brq.drivers.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.brq.interfaces.log.BRQLogger;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

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
		
		try {
			driver = new ChromeDriver(options);

		} catch (Exception e) {
			
//			List<String> versions = new ArrayList<>(WebDriverManager.getInstance(DriverManagerType.CHROME).getDriverVersions());
//			versions.add(0,"93.0.4577.63");
//			versions.add(1,"78.0.3904.105");
//			versions.stream()//
//			.forEach(x -> BRQLogger.debug(x));
//			for (String ver : versions) {
//				try {
//					WebDriverManager.chromedriver().driverVersion(ver).setup();
//					driver = new ChromeDriver(options);
//					break;
//				} catch (Exception e2) {
//					BRQLogger.debug("não conseguiu instanciar com essa versão");
//					BRQLogger.debug(ver);
//				}
//			}
//			if (driver == null)
//				Assert.fail("Nenhuma versão do Chrome disponível");
			
			WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
			driver = new ChromeDriver(options);


		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		BRQLogger.info("Chrome iniciado com sucesso.");
	}

	/*
	 * private static final String DRIVER_PADRAO = "93.0.4577.63";
	 * 
	 * private ChromeDriver driver;
	 * 
	 * private static final String FILTRO_VERSOES_RESERVA = "";
	 * 
	 * static Logger logger = LogWeb.getLogger(DriverChrome.class);
	 * 
	 * public DriverChrome(Boolean headless) {
	 * 
	 * List<String> versions = WebDriverManager.chromedriver().getDriverVersions();
	 * 
	 * for (String ver : versions) {
	 * 
	 * logger.info(String.format("Versão disponível:[%s]", ver));
	 * 
	 * }
	 * 
	 * for (Object ver : versions.parallelStream().filter(s ->
	 * s.startsWith(FILTRO_VERSOES_RESERVA)).sorted()
	 * 
	 * .distinct().toArray()) {
	 * 
	 * logger.info(
	 * 
	 * String.format("Versão disponível que começa com %s:[%s]",
	 * FILTRO_VERSOES_RESERVA, ver.toString()));
	 * 
	 * }
	 * 
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * System.setProperty("webdriver.chrome.args", "--disable-logging");
	 * 
	 * System.setProperty("webdriver.chrome.silentOutput", "true");
	 * 
	 * ChromeOptions options = setupChromeBrowser(headless);
	 * 
	 * try {
	 * 
	 * WebDriverManager.chromedriver().browserVersion(DRIVER_PADRAO).setup();
	 * 
	 * driver = new ChromeDriver(options);
	 * 
	 * logger.info(String.format("Carregou o driver de versão %s", DRIVER_PADRAO));
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * logger.error(e.getMessage());
	 * 
	 * driver = null;
	 * 
	 * List<String> tmp = new ArrayList<>();
	 * 
	 * for (Object v : versions.parallelStream().filter(s ->
	 * s.startsWith(FILTRO_VERSOES_RESERVA)).sorted()
	 * 
	 * .distinct().toArray()) {
	 * 
	 * tmp.add(v.toString());
	 * 
	 * }
	 * 
	 * versions = tmp;
	 * 
	 * Iterator<String> it = versions.iterator();
	 * 
	 * while (driver == null) {
	 * 
	 * try {
	 * 
	 * if (it.hasNext()) {
	 * 
	 * String version = it.next();
	 * 
	 * logger.debug(String.format("Testando a versão %s", version));
	 * 
	 * WebDriverManager.chromedriver().driverVersion(version).setup();
	 * 
	 * driver = new ChromeDriver(options);
	 * 
	 * logger.debug(String.format("Versão [%s] foi aceita pelo sistema", version));
	 * 
	 * } else {
	 * 
	 * logger.fatal("Nenhuma versão disponível do ChromeDriver");
	 * 
	 * throw new
	 * ErroAutomacao("Nenhuma versão do chromedriver funciona nesse ambiente");
	 * 
	 * }
	 * 
	 * } catch (WebDriverException snce) {
	 * 
	 * logger.error("Versão incompatível do Chrome, tentando outra");
	 * 
	 * logger.error(snce.getMessage());
	 * 
	 * } catch (Throwable t) {
	 * 
	 * t.printStackTrace();
	 * 
	 * throw t;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().deleteAllCookies();
	 * 
	 * logger.info("Chrome iniciado com sucesso.");
	 * 
	 * logger.debug(driver.toString());
	 * 
	 * }
	 */
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
		options.setAcceptInsecureCerts(true);
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
