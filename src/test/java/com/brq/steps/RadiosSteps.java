package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Radios;
import com.brq.pages.abas.AbasRegistrarSinistroPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RadiosSteps extends StepsMaster {

	@Given("^que (?:o usuário )?selecionou o radio \"(.*?)\" em \"(.*?)\"$")
	@When("^(?:o usuário )?selecionar o radio \"(.*?)\" em \"(.*?)\"$")
	public static void selecionarORadio(String radio, String label) {
		if (!(getPaginaAtual() instanceof Radios))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Radios].", getPaginaAtual().getClass());
		
		((Radios) getPaginaAtual()).clicarNoRadio(label, radio);
	}
	
//<<<<<<< HEAD
//	@Then("^o radio \"(.*?)\" do campo \"(.*?)\" estará selecionado")
//	public static void oRadioEstaraSelecionado(String radio) {
//		if (!(getPaginaAtual() instanceof Radios))
//			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Radios].", getPaginaAtual().getClass());
//		
////		((Radios) getPaginaAtual()).validarRadioSelecionado(radio);
//	}
//	
//=======
	@Then("^validar que a pergunta \"([^\"]*)\" foi respondida com um \"([^\"]*)\"$")
	public void validarQueAPerguntaFoiRespondidaComUm(String pergunta, String resposta) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instância de [AbasRegistrarSinistroPage].");

		((AbasRegistrarSinistroPage) getPaginaAtual()).validarPerguntaResposta(pergunta, resposta);
			
	}
	
}
