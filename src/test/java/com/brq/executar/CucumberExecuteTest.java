package com.brq.executar;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.brq.drivers.web.DriverWeb;
import com.brq.drivers.web.DriverWebJenkins;
import com.brq.enums.Browser;
import com.brq.interfaces.log.LogWeb;
import com.brq.util.PropertiesHelper;
import com.brq.utils.EvidenciasHelper;
import com.cucumber.listener.Reporter;
import com.hpe.alm.octane.OctaneCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

/**
 * Classe onde inicia a execução dos testes. É onde estão os métodos anotados
 * com {@link BeforeClass} e {@link AfterClass}.
 */
@RunWith(OctaneCucumber.class)
@CucumberOptions(features = "src/test/resources/features/", //
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Evidencias/Status - Automacao de Testes.html", //
				"pretty", //
				"html:target/cucumber-reports/", //
				"json:target/cucumber-reports/cucumber.json", //
				"junit:target/cucumber-reports/Cucumber.xml" //
		}, //
		glue = { "com.brq.steps", "com.brq.executar" }, //
		tags = {  
				  "@CT001, "
//				+ "@CT002, "
//				+ "@CT003, "
//   	        + "@CT004, "
// 				  "@CT005, "
//				+ "@CT006, "
//				+ "@CT007, "
//				+ "@CT008, "
// 			    + "@CT009, "
//				+ "@CT010, "
//				+ "@CT011, "
//				+ "@CT012, "
				}, //
		
		snippets = SnippetType.CAMELCASE, //
		monochrome = true, //
		dryRun = false, //
		strict = true)

public class CucumberExecuteTest {
	public final static long IMPLICIT_TIMEOUT = Long.parseLong(PropertiesHelper.getProjectProperty("implicit_timeout"));
	public final static long PAGE_LOAD_TIMEOUT = Long
			.parseLong(PropertiesHelper.getProjectProperty("page_load_timeout"));
	public final static int DEFAULT_STEPS_TIMEOUT = Integer
			.parseInt(PropertiesHelper.getProjectProperty("default_steps_timeout"));
	public final static int EXTREMELY_LONG_STEPS_TIMEOUT = Integer
			.parseInt(PropertiesHelper.getProjectProperty("extremely_long_steps_timeout"));

	/**
	 * Método executado logo no começo na execução, antes de qualquer teste.
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IOException
	 */
	@BeforeClass
	public static void setarConfiguracoes() throws NoSuchMethodException, SecurityException, IOException {
		LogWeb.configLogs();

		EvidenciasHelper.deletarPrints();
		String driver = "Chrome";
		
		switch (driver) {
		case "Jenkins":
			DriverWebJenkins.getDriver();
			break;
		case "Chrome":
			DriverWeb.getDriver(Browser.CHROME, true);
			DriverWeb.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			DriverWeb.getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			break;
		default:
			break;
		}
		
	}

	/**
	 * Método executado no final da execução, depois de todos os testes.
	 */
	@AfterClass
	public static void fecharNavegador() {
		DriverWeb.finalizarDriver();
		Reporter.loadXMLConfig(new File("Configuracao/extension-config.xml"));
		Reporter.setSystemInfo("Usuário Executor", System.getProperty("user.name"));
		Reporter.setSystemInfo("Sistema Operacional", System.getProperty("os.name"));
		Reporter.setTestRunnerOutput("Relatório de execução dos testes automatizados");
	}

}