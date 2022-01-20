package com.brq.steps.somapecas;

import com.brq.erros.ErroAutomacao;
import com.brq.pages.somapecas.SPEntregaPecaOficina;
import com.brq.pages.somapecas.SPPecaCancelada;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.StepsMaster;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SPCancelamentoSteps extends StepsMaster{
	
	@And("^(?:o sistema )?apresentará o pedido somente com as peças canceladas$")
    public void apresentaraPedidoPecasCanceladas() {
    	if (!(getPaginaAtual() instanceof SPPecaCancelada)) 
    		throw new ErroAutomacao("A página atual não é uma instâncida de [SPPecaCancelada].");
    	
    	((SPPecaCancelada) getPaginaAtual()).validarPecas(SPAtenderPedido.NUMERO_PEDIDO);
    }
	
	@Then("^(?:o sistema )?apresentará o pedido somente com as peças que não foram canceladas$")
    public void apresentaraPedidoPecasNaoCanceladas() {
    	if (!(getPaginaAtual() instanceof SPEntregaPecaOficina)) 
    		throw new ErroAutomacao("A página atual não é uma instâncida de [SPPecaCancelada].");
    	
    	((SPEntregaPecaOficina) getPaginaAtual()).validarPecas(SPAtenderPedido.NUMERO_PEDIDO);
    }
}
