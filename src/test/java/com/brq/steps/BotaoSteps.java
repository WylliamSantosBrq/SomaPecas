package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.pages.abas.AbasRegistrarSinistroPage;

import cucumber.api.java.en.Then;

public class BotaoSteps extends StepsMaster {

	@Then("^validar que o botão \"([^\"]*)\" está disponível$")
	public void validarQueOBotãoEstáDisponível(String botao) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instância de [Formulario].");

		((AbasRegistrarSinistroPage) getPaginaAtual()).validarBotaoDisponivel(botao);
	}

}
