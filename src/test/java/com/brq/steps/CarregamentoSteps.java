package com.brq.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CarregamentoSteps extends StepsMaster {

	@Given("^que (?:o usuário )?esperou (\\d+) segundos$")
	@When("^esperar (\\d+) segundos$")
	public void esperarCarregamento(int segundos) throws Throwable {
		getPaginaAtual().esperarSegundos(segundos);
	}

}
