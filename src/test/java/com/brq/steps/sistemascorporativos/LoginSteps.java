package com.brq.steps.sistemascorporativos;

import com.brq.erros.ErroAutomacao;
import com.brq.pages.sistemascorporativos.SCLoginPage;
import com.brq.steps.StepsMaster;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginSteps extends StepsMaster {

	public LoginSteps() {
	}

	@Given("^que (?:o usuário )?esteja logado no Sistemas Corporativos$")
	@When("^logar no Sistema Corporativos$")
	public static final void queEuEstejaLogadoNoSistemasCorporativos() {
		if (!(getPaginaAtual() instanceof SCLoginPage))
			throw new ErroAutomacao("A página atual não é uma instância de [SCLoginPage].");
		
		((SCLoginPage) getPaginaAtual()).realizarLogin();
	}
}
