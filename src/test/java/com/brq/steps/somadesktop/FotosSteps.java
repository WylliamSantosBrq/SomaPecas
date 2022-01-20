package com.brq.steps.somadesktop;

import com.brq.erros.ErroAutomacao;
import com.brq.pages.somadesktop.SDVistoriaFotosPage;
import com.brq.steps.StepsMaster;

import cucumber.api.java.en.Then;

public class FotosSteps extends StepsMaster {

	@Then("^o sistema deve carregar as (\\d+) fotos com sucesso$")
	public static void deveCarregarAsFotosComSucesso(int quantidadeDeFotos) {
		if (!(getPaginaAtual() instanceof SDVistoriaFotosPage))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					SDVistoriaFotosPage.class);

		((SDVistoriaFotosPage) getPaginaAtual()).validarFotosCarregadas(quantidadeDeFotos);

	}

}
