package com.brq.steps;

import java.io.IOException;

import com.brq.erros.ErroAutomacao;
import com.brq.executar.CucumberExecuteTest;
import com.brq.interfaces.Fotos;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FotosSteps extends StepsMaster {

	@When("^apresentar as fotos$")
	@Then("^apresentará as fotos$")
	public void apresentarAsFotos() throws IOException {
		try {
			if (!(getPaginaAtual() instanceof Fotos))
				throw new ErroAutomacao("A página atual não é uma instância de [Fotos].");

			((Fotos) getPaginaAtual()).esperarFotos(CucumberExecuteTest.DEFAULT_STEPS_TIMEOUT);
			Reporter.addStepLog(String.format("O sistema exibiu as fotos."));
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, String.format("Validação da exibição das fotos."));
		}
	}

	@Then("^a imagem será ampliada$")
	public void aImagemSeraAmpliada() throws IOException {
		try {
			if (!(getPaginaAtual() instanceof Fotos))
				throw new ErroAutomacao("A página atual não é uma instância de [Fotos].");

			((Fotos) getPaginaAtual()).validarZoom();
			Reporter.addStepLog(String.format("O sistema ampliou a foto."));
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, String.format("Validação da ampliação de foto."));
		}
	}

}
