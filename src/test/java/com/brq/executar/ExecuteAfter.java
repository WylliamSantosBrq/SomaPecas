package com.brq.executar;

import static com.brq.executar.CucumberExecuteTest.IMPLICIT_TIMEOUT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.brq.drivers.web.DriverWeb;
import com.brq.drivers.web.DriverWebJenkins;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.TimeLabel;
import com.brq.interfaces.log.TimeLogger;
import com.brq.interfaces.web.IPrint;
import com.brq.steps.StepsMaster;
import com.brq.util.BrowserHelper;
import com.brq.util.teste.TestHelper;
import com.brq.utils.EvidenciasHelper;
import com.brq.utils.erros.ErrorHelper;
import com.cucumber.listener.Reporter;
import com.itextpdf.text.log.Logger;

import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * Classe que contém o método a ser executado depois de cada teste Métodos a
 * serem executados depois de todos os cenários devem estar no
 * {@link CucumberExecuteTest#fecharNavegador()}
 */
public class ExecuteAfter implements IPrint {
	private static final Boolean pipelinefixa = true;
	
	@After
	public void tearDown(Scenario cenario) throws IOException {
//		if (pipelinefixa) {
//			return;
//		}
		TimeLogger.stop(TimeLabel.TESTE);
		TimeLogger.logAll(cenario);
		

		BRQLogger.info("Classe da página atual: [%s].", StepsMaster.getPaginaAtual().getClass());
//		try {
//			DriverWeb.getDriver();
//		} catch (Exception e) {
//			BRQLogger.info("Uso de Driver Web Mal Sucedido");
//			return;
//		}
		
		if (cenario.isFailed()) {
			DriverWeb.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			try {
				ErrorHelper.salvarLogs();

				ErrorHelper.checarErrosSistema();

			} finally {
				DriverWeb.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

				String printPath = printAndSave(cenario);
				Reporter.addScreenCaptureFromPath(printPath, "Print de erro.");
				BrowserHelper.salvarHtml();
				EvidenciasHelper.logEvidencias(cenario.getSourceTagNames());

				BrowserHelper.manterJanelasAbertas(1);

				TestHelper.recomendarMelhorias(cenario);

			}
		}
	}

}
