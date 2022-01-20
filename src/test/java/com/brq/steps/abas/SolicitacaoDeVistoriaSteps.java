package com.brq.steps.abas;

import java.io.IOException;

import com.brq.erros.ErroAutomacao;
import com.brq.pages.abas.AbasSolicitacaoDeVistoriaPage;
import com.brq.steps.StepsMaster;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;

public class SolicitacaoDeVistoriaSteps extends StepsMaster {

	@Then("^o sistema exibirá a vistoria desejada$")
	public void oSistemaExibiraAVistoriaDesejada() throws IOException {
		if (!(getPaginaAtual() instanceof AbasSolicitacaoDeVistoriaPage))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [AbasSolicitacaoDeVistoria].", getPaginaAtual().getClass());
		
		try {
			((AbasSolicitacaoDeVistoriaPage) getPaginaAtual()).oSistemaExibiraAVistoria("PRIMEIRA VISTORIA");
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da vistoria desejada.");
		}
	}
	
	@Then("^validar que o sinistro possui vistoria \"([^\"]*)\" em uma oficina$")
	public void validarQueOSinistroPossuiVistoriaEmUmaOficina(String status) throws IOException {
		if (!(getPaginaAtual() instanceof AbasSolicitacaoDeVistoriaPage))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [AbasSolicitacaoDeVistoria].", getPaginaAtual().getClass());
		
		try {
			((AbasSolicitacaoDeVistoriaPage) getPaginaAtual()).validarStatusVistoria(status);
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação do status da vistoria.");
		}
	}
	
}
