package com.brq.interfaces.abas;

import com.brq.elementos.Frame;
import com.brq.elementos.Texto;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroTimeout;
import com.brq.interfaces.Abas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.abas.focos.AbasApolice;
import com.brq.pages.abas.focos.AbasCausador;
import com.brq.pages.abas.focos.AbasDadosBasicos;
import com.brq.pages.abas.focos.AbasDocumentos;
import com.brq.pages.abas.focos.AbasHistorico;
import com.brq.pages.abas.focos.AbasLiberacao;
import com.brq.pages.abas.focos.AbasLocal;
import com.brq.pages.abas.focos.AbasLocalizacao;
import com.brq.pages.abas.focos.AbasMovimentos;
import com.brq.pages.abas.focos.AbasNotas;
import com.brq.pages.abas.focos.AbasOcorrencias;
import com.brq.pages.abas.focos.AbasQuestionario;
import com.brq.pages.abas.focos.AbasSegurado;
import com.brq.pages.abas.focos.AbasSiasiOnline;
import com.brq.pages.abas.focos.AbasTarefas;
import com.brq.pages.abas.focos.AbasTempoAnalise;
import com.brq.pages.abas.focos.AbasVitima;

public interface AbasAba extends Abas {

	@Override
	default void mudarAba(String nomeDaAba) throws Exception {
		BRQLogger.logMethod(nomeDaAba);

		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30)).entrar();

		switch (nomeDaAba) {

		case "Tempo Análise":
		case "Tempo Analise":
			mudarAbaTempoAnalise();
			break;

		case "Dados Básicos":
		case "Dados Basicos":
			mudarAbaDadosBasicos();
			break;

		case "Local":
			mudarAbaLocal();
			break;

		case "Questionário":
		case "Questionario":
			mudarAbaQuestionario();
			break;

		case "Vítima":
		case "Vitima":
			mudarAbaVitima();
			break;

		case "Apólice":
		case "Apolice":
			mudarAbaApolice();
			break;

		case "Notas":
			mudarAbaNotas();
			break;

		case "Histórico":
		case "Historico":
			mudarAbaHistorico();
			break;

		case "Tarefas":
			mudarAbaTarefas();
			break;

		case "SIASI Online":
			mudarAbaSiasiOnline();
			break;

		case "Localização":
			mudarAbaLocalizacao();
			break;

		case "Documentos":
			mudarAbaDocumentos();
			break;

		case "Movimentos":
			mudarAbaMovimentos();
			break;

		case "Ocorrências":
		case "Ocorrencias":
			mudarAbaOcorrencias();
			break;

		case "Liberação":
			mudarAbaLiberacao();
			break;

		case "Segurado":
			mudarAbaSegurado();
			break;

		case "Causador":
			mudarAbaCausador();
			break;

		default:
			throw new ErroAutomacao("Aba [%s] não definida no método [mudarAba].", nomeDaAba);
		}

		AbasAbaElementos.FRAME_PRINCIPAL.sair();
	}

	default void mudarAbaTempoAnalise() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_TEMPO_ANALISE.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasTempoAnalise());
	}

	default void mudarAbaDadosBasicos() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_DADOS_BASICOS.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasDadosBasicos());
	}

	default void mudarAbaLocal() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_LOCAL.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasLocal());
	}

	default void mudarAbaQuestionario() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_QUESTIONARIO.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasQuestionario());
	}

	default void mudarAbaVitima() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_VITIMA.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasVitima());
	}

	default void mudarAbaApolice() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_APOLICE.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasApolice());
	}

	default void mudarAbaNotas() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_NOTAS.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasNotas());
	}

	default void mudarAbaHistorico() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_HISTORICO.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasHistorico());
	}

	default void mudarAbaTarefas() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_TAREFAS.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasTarefas());
	}

	default void mudarAbaSiasiOnline() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_SIASI_ONLINE.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasSiasiOnline());
	}

	default void mudarAbaLocalizacao() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_LOCALIZACAO.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasLocalizacao());
	}

	default void mudarAbaDocumentos() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_DOCUMENTOS.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasDocumentos());
	}

	default void mudarAbaMovimentos() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_MOVIMENTOS.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasMovimentos());
	}

	default void mudarAbaOcorrencias() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_OCORRENCIAS.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasOcorrencias());
	}

	default void mudarAbaLiberacao() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_LIBERACAO.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasLiberacao());
	}

	default void mudarAbaSegurado() throws Exception {
		BRQLogger.logMethod();

		try {
			AbasAbaElementos.ABA_SEGURADO.esperarExistir(5);

		} catch (Exception|ErroTimeout e) {
			throw new Exception("Aba segurado não estava visivel na página");
		}
		AbasAbaElementos.ABA_SEGURADO.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasSegurado());
	}

	default void mudarAbaCausador() {
		BRQLogger.logMethod();

		AbasAbaElementos.ABA_CAUSADOR.clicarJavascript();

		((Pagina) this).setFocoAtual(new AbasCausador());
	}

	default void validarAbaAtual(String abaEsperada) {
		BRQLogger.logMethod(abaEsperada);

		if (((Pagina) this).alertaPresente())
			((Pagina) this).aceitarAlerta();

		try {
			((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30)).entrar();
		} catch (Exception e) {
		}

		((Texto) AbasAbaElementos.TXT_ABA_ATUAL.esperarSegundos(1)).validarTextoIgual(abaEsperada);

		AbasAbaElementos.FRAME_PRINCIPAL.sair();
	}

	@Override
	default String getAbaAtual() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			return AbasAbaElementos.TXT_ABA_ATUAL.esperarExistir(30).obterTexto();
		} catch (Exception e) {
			throw new ErroAutomacao(e, "Não foi possível encontrar o texto da aba atual.");
		}

	}

}
