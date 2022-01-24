package com.brq.executar;

import com.brq.dados.DadosUsuarioDesligamento;
import com.brq.drivers.web.DriverWeb;
import com.brq.drivers.web.DriverWebJenkins;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.TimeLabel;
import com.brq.interfaces.log.TimeLogger;
import com.brq.steps.StepsMaster;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

/**
 * Classe que contém o método a ser executado antes de cada teste Métodos a
 * serem executados antes de todos os cenários devem estar no
 * {@link CucumberExecuteTest#setarConfiguracoes()}
 */
public class ExecuteBefore {
	private static final Boolean pipelinefixa = true;
	/**
	 * Método que será executado antes de cada cenário.
	 * 
	 * @param scenario O cenário atual.
	 * @throws Throwable
	 */
	@Before
	public void before(Scenario scenario) throws Throwable {
		BRQLogger.logScenario(scenario);
		
//		if (pipelinefixa) {
//			return;
//		}
//		DadosMaster.resetAll();
		new DadosUsuarioDesligamento().reset();

		TimeLogger.start(TimeLabel.TESTE);

		StepsMaster.setCurrentScenario(scenario);
		
		try {
			DriverWebJenkins.getDriver();
			DriverWeb.getDriver().manage().deleteAllCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
