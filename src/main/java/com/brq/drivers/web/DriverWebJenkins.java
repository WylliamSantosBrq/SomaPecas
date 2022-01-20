package com.brq.drivers.web;

import com.brq.util.PropertiesHelper;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import com.brq.enums.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class DriverWebJenkins {

    private static WebDriver driver = null;
    private static boolean maximizarJanela = true;
    private static String navegador = Browser.CHROME.toString();
    private static String caminhoDriver = System.getProperties().getProperty("pathDriver");
    private static String executarSemInterface = System.getProperties().getProperty("headless");
    private static String browserSetadoViaPrompt = System.getProperties().getProperty("browser");
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private static FirefoxOptions firefoxOptions = new FirefoxOptions();
    private static FirefoxProfile firefoxProfile = new FirefoxProfile();
    private static InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();

    public static WebDriver getDriver() {
        //if(driver != null)
        return driver;
        //else
        //	return DriverWeb.getDriver(Browser.CHROME, null, true);
    }

    public static WebDriver getDriver(Browser navegadorDeExecucao, String caminhoDoDriver,
                                      boolean maximizarJanelaDoNavegador) {

        boolean executarSemInterfaceGrafica = Boolean.parseBoolean(PropertiesHelper.getProjectProperty("executarSemInterfaceGrafica"));

        validarCaminhoWebDriver(caminhoDoDriver);
        definirPropriedadesIniciais(navegadorDeExecucao, maximizarJanelaDoNavegador, executarSemInterfaceGrafica);
        if (driver == null) {
            if (browserSetadoViaPrompt == null) {
                definirOptionsExtras(navegadorDeExecucao.toString().toLowerCase());
            } else {
                definirOptionsExtras(browserSetadoViaPrompt.toLowerCase());
            }
            setarConfiguracoesDoDriver();
            maximizarJanela();
            deletarCookies();
        }
        return driver;
    }

    private static void validarCaminhoWebDriver(String caminhoDoDriver) {
        if (caminhoDriver == null && caminhoDoDriver == null) {
            caminhoDriver = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers"
                    + File.separator;
        } else if (caminhoDriver == null && caminhoDoDriver != null) {
            caminhoDriver = caminhoDoDriver;
        }
    }

    private static void definirPropriedadesIniciais(Browser navegadorDeExecucao, boolean maximizarJanelaDoNavegador,
                                                    boolean executarSemInterfaceGrafica) {
        navegador = navegadorDeExecucao.toString();
        maximizarJanela = maximizarJanelaDoNavegador;
        executarSemInterface = String.valueOf(executarSemInterfaceGrafica);
    }

    private static void setarConfiguracoesDoDriver() {
        if (browserSetadoViaPrompt != null) {
            navegador = browserSetadoViaPrompt;
            if (browserSetadoViaPrompt.contains(Browser.CHROME.toString())
                    || browserSetadoViaPrompt.contains(Browser.FIREFOX.toString())
                    || browserSetadoViaPrompt.contains(Browser.EXPLORER.toString())) {
                configs();
            }
        } else {
            if (navegador.contains(Browser.CHROME.toString()) || navegador.contains(Browser.FIREFOX.toString())
                    || navegador.contains(Browser.EXPLORER.toString())) {
                configs();
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    private static void configs() {
        obterDriverEsetarNaPath();
        configHeadless();
        iniciarNavegador();
    }

    private static void obterDriverEsetarNaPath() {
        if (System.getProperty("os.name").toLowerCase().contains("mac"))
            setarDriverMac();
        else if (System.getProperty("os.name").toLowerCase().contains("windows"))
            setarDriverWindows();
        else
            setarDriverLinux();
    }

    private static void setarDriverMac() {
        if (navegador.contains(Browser.EXPLORER.toString()))
            System.setProperty("webdriver.ie.driver", "");
        else if (navegador.contains(Browser.CHROME.toString()))
            System.setProperty("webdriver.chrome.driver", caminhoDriver + File.separator + "Mac" + File.separator + "chromedriver");
        else if (navegador.contains(Browser.FIREFOX.toString()))
            System.setProperty("webdriver.gecko.driver", "");
    }

    private static void setarDriverWindows() {
        if (navegador.contains(Browser.EXPLORER.toString()))
            System.setProperty("webdriver.ie.driver", caminhoDriver + "explorer.exe");
        else if (navegador.contains(Browser.CHROME.toString()))
            System.setProperty("webdriver.chrome.driver", caminhoDriver + "chromedriver.exe");
        else if (navegador.contains(Browser.FIREFOX.toString()))
            System.setProperty("webdriver.gecko.driver", caminhoDriver + "geckodriver.exe");
    }

    private static void setarDriverLinux() {
        if (navegador.contains(Browser.EXPLORER.toString()))
            System.setProperty("webdriver.ie.driver", caminhoDriver + "explorer");
        else if (navegador.contains(Browser.CHROME.toString()))
            //System.setProperty("webdriver.chrome.driver", caminhoDriver + File.separator + "Linux" + File.separator + "chromedriver");
            //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            System.setProperty("webdriver.chrome.driver", "/opt/webdrivers//chromedriver");
        else if (navegador.contains(Browser.FIREFOX.toString()))
            System.setProperty("webdriver.gecko.driver", caminhoDriver + "geckodriver");
    }

    private static void iniciarNavegador() {
        if (navegador.contains(Browser.EXPLORER.toString()))
            iniciarExplorer();
        else if (navegador.contains(Browser.CHROME.toString()))
            iniciarChrome();
        else if (navegador.contains(Browser.FIREFOX.toString()))
            iniciarFirefox();
    }

    private static void definirOptionsExtras(String navegador) {

        if (navegador.contains(Browser.CHROME.toString().toLowerCase())) {

            //Permite download de xml.
            Map<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("safebrowsing.enabled", "true");
            chromePrefs.put("profile.default_content_setting_values.notifications", 2);

            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            chromeOptions.addArguments("test-type");
            chromeOptions.addArguments("enable-automation");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--enable-precise-memory-info");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-default-apps");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-gpu");
        }

        if (navegador.contains(Browser.FIREFOX.toString().toLowerCase())) {
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
            firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "application/zip,application/octet-stream,image/jpeg,application/vnd.ms-outlook,text/html,application/pdf, text/xml,application/xml,application/xhtml+xml,text/javascript,application/json");
            firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
            firefoxProfile.setPreference("browser.download.manager.useWindow", false);
            firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
            firefoxOptions.setProfile(firefoxProfile);

        }
    }

    private static void iniciarExplorer() {
        driver = (internetExplorerOptions != null) ? new InternetExplorerDriver(internetExplorerOptions)
                : new InternetExplorerDriver();
    }

    private static void iniciarChrome() {
        driver = (chromeOptions != null) ? new ChromeDriver(chromeOptions) : new ChromeDriver();
    }

    private static void iniciarFirefox() {
        driver = (firefoxOptions != null) ? new FirefoxDriver(firefoxOptions) : new FirefoxDriver();
    }

    private static void maximizarJanela() {
        if (maximizarJanela)
            driver.manage().window().maximize();
    }

    private static void deletarCookies() {
        driver.manage().deleteAllCookies();
    }

    private static void configHeadless() {
        if (executarSemInterface != null && executarSemInterface == "true") {
            if (navegador.contains(Browser.FIREFOX.toString())) {
                firefoxOptions.setHeadless(true);
                firefoxProfile.setPreference("browser.download.folderList", 2);
                firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                        "application/zip,application/octet-stream,image/jpeg,application/vnd.ms-outlook,text/html,application/pdf, text/xml,application/xml,application/xhtml+xml,text/javascript,application/json");
                firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
                firefoxProfile.setPreference("browser.download.manager.useWindow", false);
                firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
                firefoxOptions.addArguments("window-size=1920,1080");
                firefoxOptions.setProfile(firefoxProfile);
            } else if (navegador.contains(Browser.CHROME.toString())) {

                Map<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("safebrowsing.enabled", "true");
                chromePrefs.put("profile.default_content_setting_values.notifications", 2);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.setAcceptInsecureCerts(true);
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--enable-precise-memory-info");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-default-apps");
                chromeOptions.addArguments("window-size=1920,1080");
            } else if (navegador.contains(Browser.EXPLORER.toString())) {
                fail("---- O navegador Internet Explorer não suporta o modo headless");
            }
        }
    }

    public static void finalizarDriver() {
        if (driver != null) {
            driver.quit();
            if (System.getProperty("os.name").toLowerCase().contains("mac"))
                finalizarNavegadorMac();
            else if (System.getProperty("os.name").toLowerCase().contains("windows"))
                finalizarNavegadorWindows();
            else
                finalizarNavegadorLinux();
            driver = null;
        }
    }

    private static void finalizarNavegadorLinux() {
        if (navegador.toUpperCase().equals("CHROME")) {
            finalizarProcessoChromeLinux();
        } else if (navegador.toUpperCase().equals("FIREFOX")) {
            finalizarProcessoFirefox();
        }
    }


    private static void finalizarNavegadorWindows() {
        if (navegador.toUpperCase().equals("CHROME")) {
            finalizarProcessoChrome();
        } else if (navegador.toUpperCase().equals("FIREFOX")) {
            finalizarProcessoFirefox();
        }
    }

    private static void finalizarProcessoChromeLinux() {
        try {
            Process process = Runtime.getRuntime().exec("pkill chrome");
            @SuppressWarnings("resource")
            Scanner leitor = new Scanner(process.getInputStream());
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void finalizarProcessoChrome() {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
            @SuppressWarnings("resource")
            Scanner leitor = new Scanner(process.getInputStream());
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void finalizarProcessoFirefox() {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
            @SuppressWarnings("resource")
            Scanner leitor = new Scanner(process.getInputStream());
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void finalizarNavegadorMac() {

    }

}