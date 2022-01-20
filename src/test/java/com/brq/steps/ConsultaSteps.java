package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Pesquisa;
import com.brq.pages.somapecas.SPConsultaPage;
import com.brq.pages.somapecas.focos.SPAtenderPedido;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ConsultaSteps extends StepsMaster{

    @When("^procuro o fornecedor pela \"([^\"]*)\" com o nome \"([^\"]*)\"$")
    public void procuroOFornecedorPelaRazãoSocial(String campo, String texto) {
        if (!(getPaginaAtual() instanceof SPConsultaPage))
            throw new ErroAutomacao("A página atual não é uma instâncida de [SPConsultaPage].");

        ((SPConsultaPage) getPaginaAtual()).pesquisaFornecedor(campo, texto);
    }
    
    @And("^localizo o pedido \"(.*?)\"$")
    public void localizarPedido(String nPedido) {
    	if (!(getPaginaAtual() instanceof Pesquisa)) 
    		throw new ErroAutomacao("A página atual não é uma instâncida de [SPPecaCancelada].");
    	
    	((Pesquisa) getPaginaAtual()).pesquisar(SPAtenderPedido.NUMERO_PEDIDO);
    }
    
    @And("^localizo o sinistro \"(.*?)\"$")
    public void localizarSinistro(String nSinistro) {
    	if (!(getPaginaAtual() instanceof Pesquisa)) 
    		throw new ErroAutomacao("A página atual não é uma instâncida de [SPPecaCancelada].");
    	
    	((Pesquisa) getPaginaAtual()).pesquisar(SPAtenderPedido.NUMERO_SINISTRO);
    }
}
