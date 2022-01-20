package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Login;

import com.brq.pages.somapecas.SPLoginPage;
import cucumber.api.java.en.Given;

public class LoginSteps extends StepsMaster {

	@Given("^que (?:o usuário )?fez login$")
	public void queEuFacaLogin() throws Throwable {
		if (!(getPaginaAtual() instanceof Login))
			throw new ErroAutomacao("A página atual não é uma instância de [Login].");

		((Login) getPaginaAtual()).realizarLogin();
	}

	@Given("^que (?:o usuário )?fez login como \"(.*?)\"$")
	public void fazerLoginComo(String perfil) throws Throwable {
		if (!(getPaginaAtual() instanceof Login))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Login].", getPaginaAtual().getClass());

		((Login) getPaginaAtual()).realizarLoginComo(perfil);
	}

	@Given("^faço logout do sistema$")
	public void façoLogoutDoSistema() throws Throwable {
		if (!(getPaginaAtual() instanceof SPLoginPage))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [SPLoginPage].", getPaginaAtual().getClass());

		((SPLoginPage) getPaginaAtual()).deslogar();
	}

}
