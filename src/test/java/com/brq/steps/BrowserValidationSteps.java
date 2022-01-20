package com.brq.steps;

import java.io.IOException;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Login;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;

public class BrowserValidationSteps extends StepsMaster {

	@Then("^o título da janela será \"(.*?)\"$")
	public void oTituloDaJanelaSera(String tituloDaJanela) throws IOException {
		try {
			getPaginaAtual().validarTituloDoBrowser(tituloDaJanela);
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação do título da janela.");
		}
	}

	@Then("^estará na tela de login$")
	public void estouNaTelaDeLogin() throws IOException {
		if (!(getPaginaAtual() instanceof Login))
			throw new ErroAutomacao("A página atual não é uma instância de [Login].");
		
		try {
			((Login) getPaginaAtual()).validarTelaDeLogin();
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da tela de login.");
		}
	}

}
