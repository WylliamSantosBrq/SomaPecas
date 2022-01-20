package com.brq.steps.somapecas;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Mensagens;
import com.brq.pages.Pagina;
import com.brq.pages.somapecas.SPDashBoardPage;
import com.brq.steps.StepsMaster;

import com.cucumber.listener.Reporter;
import cucumber.api.java.en.When;

public class SPNavigationSteps extends StepsMaster {

	@When("^clicar em \"(.*?)\" do \"(.*?)\" pedido$")
	public void clicarEmDoPedido(String botao, String indicePedido) {
		((SPDashBoardPage) getPaginaAtual()).clicarNoBotaoDoPedidoPorIndice(botao, indicePedido);
	}

	@When("^clico no fornecedor do pedido$")
	public void clicarEmDoPedido() {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instâncida de [SPTarefasEncerradas].");

		((Pagina) getPaginaAtual()).clicarEm("Fornecedor");
	}
}
