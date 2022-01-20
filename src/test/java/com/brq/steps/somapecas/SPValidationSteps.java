package com.brq.steps.somapecas;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.PDF;
import com.brq.interfaces.Pesquisa;
import com.brq.pages.somapecas.SPAbrirPedidos;
import com.brq.pages.somapecas.SPAvisoPedidoPage;
import com.brq.pages.somapecas.SPDashBoardPage;
import com.brq.pages.somapecas.SPPesquisaPedidoPage;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.StepsMaster;

import cucumber.api.java.en.Then;

public class SPValidationSteps extends StepsMaster {

	@Then("^(?:o sistema )?apresentará a lista de pedidos aguardando atendimento$")
	public static void validarListaDePedidosAguardandoAtendimento() {
		if (!(getPaginaAtual().getFocoAtual() instanceof SPAtenderPedido))
			throw new ErroAutomacao("A página atual não é uma instância de [SPAtenderPedido].");

		((SPAtenderPedido) getPaginaAtual().getFocoAtual()).validarListaDePedidosAguardandoAtendimento();
	}

	@Then("^(?:o sistema )?apresentará data e hora do início e previsão de encerramento da tarefa$")
	public static void apresentaraDataEHoraDoInicioEPrevisaoDeEncerramentoDaTarefa() {
		if (!(getPaginaAtual().getFocoAtual() instanceof SPAtenderPedido))
			throw new ErroAutomacao("A página atual não é uma instância de [SPAtenderPedido].");

		((SPAtenderPedido) getPaginaAtual().getFocoAtual()).validarCriticidadePopUp();
	}

	@Then("^(?:o sistema )?apresentará as informações do (.*?) pedido$")
	public static void apresentaraAsInformacoesDoPedido(String indice) {
		if (!(getPaginaAtual().getFocoAtual() instanceof SPAtenderPedido))
			throw new ErroAutomacao("A página atual não é uma instância de [SPAtenderPedido].");

		((SPAtenderPedido) getPaginaAtual().getFocoAtual()).validarInformacoesDoPedido(indice);
	}

	@Then("^(?:o sistema )?abrirá um arquivo PDF com as informações do pedido$")
	public static void abriraUmArquivoPdfComAsInformacoesDoPedido() {
		if (!(getPaginaAtual() instanceof PDF))
			throw new ErroAutomacao("A página atual não é uma instância de [SPAtenderPedido].");

		((PDF) getPaginaAtual()).validarPdfEmTela();
	}

	@Then("^(?:o sistema )?apresentará o combo \"(.*?)\" em cada uma das peças$")
	public static void sistemaApresenaCombbo(String texto) {
		if (!(getPaginaAtual() instanceof SPDashBoardPage))
			throw new ErroAutomacao("A página atual não é uma instância de [SPDashBoardPage].");

		((SPDashBoardPage) getPaginaAtual()).validarNovoCombo(texto);
	}

	@Then("^(?:o sistema )?o combo \"(.*?)\" terá a opção \"(.*?)\" selecionada na \"(.*?)\" peça$")
    public void oComboTeráAOpçãoSelecionadaNa(String combo, String textoCombo, String indicePeca) {
		if (!(getPaginaAtual() instanceof SPDashBoardPage))
			throw new ErroAutomacao("A página atual não é uma instância de [SPDashBoardPage].");

		((SPDashBoardPage) getPaginaAtual()).validarDadosComboPecas(combo, textoCombo, indicePeca);
    }

	@Then("^(?:o sistema )?apresenta o checkbox \"(.*?)\" preenchido com a opção \"(.*?)\" para a \"(.*?)\" peça$")
	public void oSistemaApresentaOCheckboxPreenchidoComAOpçãoParaAPeça(String combo, String textoCombo, String indicePeca) {
		if (!(getPaginaAtual() instanceof SPDashBoardPage))
			throw new ErroAutomacao("A página atual não é uma instância de [SPDashBoardPage].");

		((SPDashBoardPage) getPaginaAtual()).validarDadosComboPecas(combo, textoCombo, indicePeca);
	}

	@Then("^(?:o sistema )?apresentará o combo \"(.*?)\" na \"(.*?)\" peça$")
	public void oSistemaApresentaráOComboNaPeça(String combo, String indice) {
		if (!(getPaginaAtual() instanceof SPDashBoardPage))
			throw new ErroAutomacao("A página atual não é uma instância de [SPDashBoardPage].");

		((SPDashBoardPage) getPaginaAtual()).validarNovoCombo(combo);
	}


	@Then("^(?:o sistema )?apresenta a mensagem de sucesso na funcionalidade atender pedido$")
	public void oSistemaApresentaMsg() {
		if (!(getPaginaAtual() instanceof Mensagens))
			throw new ErroAutomacao("A página atual não é uma instância de [Mensagens].");

		((Mensagens) getPaginaAtual()).validarMensagem("Operação realizada com sucesso");
	}

	@Then("^(?:o sistema )?apresenta na tela o pedido pesquisado$")
    public void oSistemaApresentaNaTelaOPedidoPesquisado() {
		if (!(getPaginaAtual() instanceof SPPesquisaPedidoPage))
			throw new ErroAutomacao("A página atual não é uma instância de [SPPesquisaPedidoPage].");

		((SPPesquisaPedidoPage) getPaginaAtual()).pedidoPesquisado();
    }

	@Then("^(?:o sistema )?exibirá Informações Fornecedor$")
	public void oSistemaExibiráInformaçõesFornecedor() {
		if (!(getPaginaAtual() instanceof SPAbrirPedidos))
			throw new ErroAutomacao("A página atual não é uma instância de [MenuSuperior].");

		((SPAbrirPedidos) getPaginaAtual()).validarInfoFornecedor();
	}
}
