package com.brq.pages.somapecas;

import com.brq.elementos.somapecas.SPHistoricoPedidoElementos;
import com.brq.interfaces.Combos;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.CamposSteps;
import com.brq.steps.CombosSteps;
import com.brq.steps.StepsMaster;
import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.somapecas.SPDashBoardElementos;
import com.brq.elementos.somapecas.SPHistoricoPedidoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

import java.util.Map;

public class SPHistoricoPedido extends Pagina{

	@Override	
    public void validarDadoEmTela(String campo){
        BRQLogger.logMethod(campo);

        switch (campo) {
			case "Data":
				validarData();
				break;

			case "Fluxo":
				validarFluxo();
				break;

			case "Responsável":
				validarResponsavel();
				break;

			case "Detalhe":
				validarDetalhe();
				break;

			case "Data - Peça":
				validarDataPeca();
				break;

			case "Descrição - Peça":
				validarDescricao();
				break;

			case "Detalhe - Peça":
				validarDetalhePeca();
				break;

			case "Motivo - Peça":
				validarMotivoPeca();
				break;

			case "Responsável - Peça":
				validarResponsavelPeca();
				break;

            default:
                throw new ErroAutomacao("O campo [%s] não foi definido no método [validarDadoEmTela].", campo);
        }
    }

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
			case "Histórico do Pedido":
				abrirHistoricoPedido();
				break;

			case "Histórico da Peça":
				abrirHistoricoPecas();
				break;
		}
	}

	@Override
	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		switch (caixa) {
			case "Histórico - Pedido":
				fecharModalPedido();
				break;

			case "Histórico - Peça":
				fecharModalPeca();
				break;
		}

	}

	public void abrirHistoricoPedido() {
		BRQLogger.logMethod();
		Botao btn = (Botao) SPDashBoardElementos.BTN_PEDIDO//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)//
				.mover();//

		btn.esperarSegundos(2);// TODO

		try {
			btn.clicar();
		} catch (Throwable e) {
			BRQLogger.error("Não conseguiu abrir histórico");
			throw e;
		}

	}

	public void abrirHistoricoPecas() {
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.BTN_PEDIDO.esperarSegundos(1);
		SPHistoricoPedidoElementos.BTN_PEDIDO.clicar(2);
	}

	private void validarData(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_DATA//
					.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
					.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarDataPeca(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_DATA_PECA//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarFluxo(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_FLUXO//
					.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
					.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarResponsavel(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_RESPONSAVEL//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarResponsavelPeca(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_RESPONSAVEL_PECA//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarDetalhe(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_DETALHE//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarDescricao(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_DESCRICAO_PECA//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarDetalhePeca(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_DETALHES_PECA//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void validarMotivoPeca(){
		BRQLogger.logMethod();

		SPHistoricoPedidoElementos.TXT_MOTIVO_PECA//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void fecharModalPedido(){
		BRQLogger.logMethod();
		Botao fechar = new Botao(By.cssSelector("div#historicoPedidoModalCDiv input"));
		fechar.esperarExistir(DEFAULT_STEPS_TIMEOUT);
		fechar.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
		try {
			fechar.esperarSegundos(1);
			fechar.clicarJavascript();
		} catch (Throwable e) {
			BRQLogger.error("Não conseguiu fechar o Histórico de pedido");
			throw e;
		}
	}

	private void fecharModalPeca(){
		BRQLogger.logMethod();
		Botao fechar = new Botao(By.cssSelector("div#historicoPecaModalContentDiv input"));
		fechar.esperarExistir(DEFAULT_STEPS_TIMEOUT);
		fechar.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
		try {
			fechar.esperarSegundos(1);
			fechar.clicarJavascript();
		} catch (Throwable e) {
			BRQLogger.error("Não conseguiu fechar o Histórico de pedido");
			throw e;
		}

		StepsMaster.setPaginaAtual(new SPDashBoardPage());
	}

}
