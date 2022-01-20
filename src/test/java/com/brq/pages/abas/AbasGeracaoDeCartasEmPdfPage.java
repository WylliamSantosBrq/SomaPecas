package com.brq.pages.abas;

import com.brq.elementos.Campo;
import com.brq.elementos.abas.AbasGeracaoDeCartasEmPdfElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;

public class AbasGeracaoDeCartasEmPdfPage extends Pagina implements Campos {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Visualizar Carta":
			clicarEmVisualizarCarta();
			break;

		case "Enviar para Aprovação":
			clicarEmEnviarParaAprovacao();
			break;

		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmEnviarParaAprovacao() {
		BRQLogger.logMethod();
		
		AbasGeracaoDeCartasEmPdfElementos.BTN_ENVIAR_PARA_APROVACAO.esperarSerVisivel(5).clicar();
		
//		TODO Definir data e hora atual como dado.		
		
		StepsMaster.setPaginaAtual(new AbasMensagemCartaPage());
	}

	public void clicarEmVisualizarCarta() {
		BRQLogger.logMethod();

		AbasGeracaoDeCartasEmPdfElementos.BTN_VISUALIZAR_CARTA.esperarSerVisivel(5).clicar();
//		StepsMaster.setPaginaAtual(new Page());
	}

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "Geração de Cartas em PDF":
			esperarExibicaoGeracaoDeCartasEmPdf(DEFAULT_STEPS_TIMEOUT);
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	public void esperarExibicaoGeracaoDeCartasEmPdf(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		AbasGeracaoDeCartasEmPdfElementos.TEXTO_GERACAO_DE_CARTAS_EM_PDF.esperarSerVisivel(tempoEmSegundos);
	}

	@Override
	public void preencherCampo(String campo, String valor) {
		BRQLogger.logMethod(campo, valor);

		switch (campo) {
		case "Data":
			preencherCampoData(valor);
			break;

		case "Apólice":
			preencherCampoApolice(valor);
			break;

		case "Item":
			preencherCampoItem(valor);
			break;

		case "Suc":
			preencherCampoSuc(valor);
			break;

		case "Veículo":
			preencherCampoVeiculo(valor);
			break;

		case "Modelo":
			preencherCampoModelo(valor);
			break;

		case "Sinistro":
			preencherCampoSinistro(valor);
			break;

		case "Corretora":
			preencherCampoCorretora(valor);
			break;

		case "SUSEP":
			preencherCampoSusep(valor);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [preencherCampo].", campo);
		}
	}

	public void preencherCampoData(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_DATA.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoApolice(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_APOLICE.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoItem(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_ITEM.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoSuc(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_SUC.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoVeiculo(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_VEICULO.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoModelo(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_MODELO.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoSinistro(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_SINISTRO_1.esperarSerVisivel(5))
				.preencher(valor.substring(0, 3));
		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_SINISTRO_2.esperarSerVisivel(5))
				.preencher(valor.substring(3, 7));
		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_SINISTRO_3.esperarSerVisivel(5))
				.preencher(valor.substring(7, 11));
	}

	public void preencherCampoCorretora(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_CORRETORA.esperarSerVisivel(5)).preencher(valor);
	}

	public void preencherCampoSusep(String valor) {
		BRQLogger.logMethod(valor);

		((Campo) AbasGeracaoDeCartasEmPdfElementos.TEXTAREA_SUSEP.esperarSerVisivel(5)).preencher(valor);
	}

	@Override
	public void limparCampo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCampo(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCampos(String campos, String valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCampoPreenchido(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCampoDisponivel(String campo) {
		// TODO Auto-generated method stub

	}

}
