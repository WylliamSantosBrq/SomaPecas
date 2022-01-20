package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Mensagens;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;

public class MensagemSteps extends StepsMaster {

	@Then("^o sistema exibirá a mensagem \"(.*?)\"$")
	public static final void oSistemaExibiraAMensagem(String mensagemEsperada) throws Throwable {
		try {
			if (getPaginaAtual().getFocoAtual() != null) {
				try {
					((Mensagens) getPaginaAtual().getFocoAtual()).validarMensagem(mensagemEsperada);
					return;
				} catch (ErroAutomacao e) {
					throw new ErroAutomacao(e, "A página atual não tem o método para validar a mensagem [%s].",
							mensagemEsperada);
				}
			}
			if (!(getPaginaAtual() instanceof Mensagens))
				throw new ErroAutomacao("A página atual não é uma instância de [Mensagens].");
			((Mensagens) getPaginaAtual()).validarMensagem(mensagemEsperada);

		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da mensagem exibida.");
		}
	}

	@Then("^o sistema exibirá uma lista de mensagens$")
	public static final void oSistemaExibiraUmaListaDeMensagens() throws Throwable {
		try {
			if (!(getPaginaAtual() instanceof Mensagens))
				throw new ErroAutomacao("A página atual não é uma instância de [Mensagens].");

			((Mensagens) getPaginaAtual()).validarListaDeMensagens();

		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da mensagem exibida.");
		}
	}
	
	@Then("^(?:o sistema )?abrirá um pop-up com a mensagem \"(.*?)\"$")
	public static final void oSistemaAbriraUmPopUpComAMensagem(String mensagem) throws Throwable {
		if (!getPaginaAtual().obterTextoDoAlerta().equalsIgnoreCase(mensagem))
			throw new ErroValidacao("O texto do elemento não condiz com [%s].", mensagem);
	}

}
