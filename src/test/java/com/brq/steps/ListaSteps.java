package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Lista;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ListaSteps extends StepsMaster {
	
	@Given("^que (?:o usuário )?selecionou o primeiro item da lista$")
	@When("^selecionar o primeiro item da lista$")
	public void selecionarOPrimeiroResultado() {
		if (!(getPaginaAtual() instanceof Lista))
			throw new ErroAutomacao("A página atual não é uma instância de [Lista].");
		
		((Lista) getPaginaAtual()).selecionarPrimeiroItemDaLista();
	}

}
