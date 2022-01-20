package com.brq.pages.abas;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasU10HomeElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Campos;
import com.brq.interfaces.Combos;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.abas.focos.AbasU10Mensagens;
import com.brq.pages.abas.focos.AbasU10SedexReverso;
import com.brq.steps.StepsMaster;

public class AbasU10HomePage extends Pagina implements Mensagens, Campos, Combos {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Download do resumo do Aviso":
			clicarEmDownloadDoResumoDoAviso();
			break;

		case "Mensagens":
			clicarEmMensagens();
			break;

		case "Sedex Reverso":
			clicarEmSedexReverso();
			break;

		case "Atendimento Online":
			clicarEmAtendimentoOnline();
			break;
			
		case "Enviar":
			clicarEmEnviar();
			break;
			
		case "Reagendar vistoria de sinistro":
			clicarEmReagendarVistoriaDeSinistro();
			break;
			
		case "Orçamento de Reparo":
			clicarEmOrcamentoDeReparo();
			break;

			case "Consultar Aviso":
				clicarEmConsultarAviso();
				break;
		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmOrcamentoDeReparo() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_ORCAMENTO_REPARO.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
			StepsMaster.setPaginaAtual(new AbasU10OrcamentoPage());
			
		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}
	
	public void clicarEmReagendarVistoriaDeSinistro() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_REAGENDAR_VISTORIA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar().esperarSegundos(1);
			trocarJanelaPorTituloContains("Etapa 5");
			StepsMaster.setPaginaAtual(new AbasU10RemarcarVistoriaPage());
			
		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	public void clicarEmEnviar() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_ENVIAR.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
			StepsMaster.setPaginaAtual(new AbasU10UploadDeDocumentosPage());
			esperarPaginaAbrirContains("Upload de Documentos", 15);

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	public void clicarEmAtendimentoOnline() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_ATENDIMENTO_ONLINE.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
			StepsMaster.setPaginaAtual(new AbasU10ChatPage());

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	private void clicarEmDownloadDoResumoDoAviso() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_DOWNLOAD_RESUMO_AVISO.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	private void clicarEmMensagens() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_MENSAGENS.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
			setFocoAtual(new AbasU10Mensagens());

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	public void clicarEmSedexReverso() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()) {
			AbasU10HomeElementos.BTN_SEDEX_REVERSO.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
			setFocoAtual(new AbasU10SedexReverso());

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	public void clicarEmConsultarAviso(){
		BRQLogger.logMethod();

		try(Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).entrar()){
			AbasU10HomeElementos.BTN_CONSULTA_AVISO.moverJavascript().esperarMilisegundos(500).clicarJavascript();
			AbasU10HomeElementos.BTN_CONSULTA_AVISO.esperarSegundos(7);
			AbasAbaElementos.FRAME_PRINCIPAL.sair();
			StepsMaster.setPaginaAtual(new AbasRegistrarSinistroPage("Aviso de Sinistro"));
		}catch (Exception e){
			throw new ErroSistema(e);
		}
	}

	@Override
	public void esperarExibicao(String objeto) {
		getFocoAtual().esperarExibicao(objeto);
	}

	@Override
	public void validarBotaoDisponivel(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "":

			break;

		case "Prosseguir":
			getFocoAtual().validarBotaoDisponivel(botao);
			break;

		default:
			throw new ErroAutomacao(botao);
		}
	}

	@Override
	public void fecharCaixa(String caixa) {
		getFocoAtual().fecharCaixa(caixa);
	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarListaDeMensagens() {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCampo(String campo, String valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCampos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub

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
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
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
	public void validarCamposDisponiveis(List<String> campos) {
		((Campos) getFocoAtual()).validarCamposDisponiveis(campos);
	}

	@Override
	public void validarCampoDisponivel(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selecionarCombo(String combo, String opcao) {
		BRQLogger.logMethod(combo, opcao);

		switch (combo) {
		case "Outros Documentos":
			selecionarComboOutrosDocumentos(opcao);
			break;

		default:
			throw new ErroAutomacao("O combo [%s] não foi definido no método [selecionarCombo].", combo);
		}
	}

	public void selecionarComboOutrosDocumentos(String opcao) {
		BRQLogger.logMethod(opcao);

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()) {
			AbasU10HomeElementos.COMBO_OUTROS_DOCUMENTOS.selecionarPorTexto(opcao);
			
		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	@Override
	public void selecionarCombos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCombo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCombo(String combo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarDadosCombo(String textoCombo, String textoComboFinal) {

	}

}
