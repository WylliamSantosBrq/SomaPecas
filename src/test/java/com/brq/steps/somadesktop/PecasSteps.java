package com.brq.steps.somadesktop;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.somadesktop.SDTabelaOrcamentoPecas;
import com.brq.steps.StepsMaster;

import cucumber.api.java.en.Then;

public class PecasSteps extends StepsMaster {

	@Then("^o sistema carregará a peça na tabela de orçamento do veículo$")
	public void validar() {
		if (!(getPaginaAtual() instanceof SDTabelaOrcamentoPecas))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [SDTabelaOrcamentoPecas].",
					getPaginaAtual().getClass());

		((SDTabelaOrcamentoPecas) getPaginaAtual()).validarPecaNaTabela();
	}

}
