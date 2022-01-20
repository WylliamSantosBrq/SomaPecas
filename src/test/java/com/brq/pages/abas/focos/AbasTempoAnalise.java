package com.brq.pages.abas.focos;

import com.brq.dados.abas.AbasTempoAnaliseDados;
import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasTempoAnaliseElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasTempoAnalise extends Foco {

	public AbasTempoAnalise() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void salvarDados(String conjuntoDeDados) {
		BRQLogger.logMethod(conjuntoDeDados);

		switch (conjuntoDeDados) {
		case "Tempo de Análise":
			salvarDadosTempoAnalise();
			break;

		default:
			throw new ErroAutomacao("O conjunto de dados [%s] não foi definido no método [salvarDados].",
					conjuntoDeDados);
		}
	}

	private void salvarDadosTempoAnalise() {
		BRQLogger.logMethod();

		String dataAviso, diasEncerrado, diasAguardandoDoc, diasAguardandoVistoria, dataConclusaoSinistro, tempoTotalRegulacao, tempoRestanteRegulacao;

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			dataAviso = AbasTempoAnaliseElementos.DATA_AVISO_SINISTRO.esperarSerVisivel(5).obterTexto();
			diasEncerrado = AbasTempoAnaliseElementos.DIAS_ENCERRADO.esperarSerVisivel(5).obterTexto();
			diasAguardandoDoc = AbasTempoAnaliseElementos.DIAS_AGUARDANDO_DOC.esperarSerVisivel(5).obterTexto();
			diasAguardandoVistoria = AbasTempoAnaliseElementos.DIAS_AGUARDANDO_VISTORIA.esperarSerVisivel(5).obterTexto();
			dataConclusaoSinistro = AbasTempoAnaliseElementos.DATA_CONCLUSÃO_SINISTRO.obterTexto();
			tempoTotalRegulacao = AbasTempoAnaliseElementos.TEMPO_TOTAL_REGULACAO.esperarSerVisivel(5).obterTexto();
			tempoRestanteRegulacao = AbasTempoAnaliseElementos.TEMPO_RESTANTE_REGULACAO.esperarSerVisivel(5).obterTexto();

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
		
		BRQLogger.logList("Dados capturados", dataAviso, diasEncerrado, diasAguardandoDoc, diasAguardandoVistoria, dataConclusaoSinistro, tempoTotalRegulacao, tempoRestanteRegulacao);

		AbasTempoAnaliseDados.setDataAvisoSinistro(dataAviso);
		AbasTempoAnaliseDados.setDataConclusaoSinistro(dataConclusaoSinistro);
		AbasTempoAnaliseDados.setQtdeDiasAguardandoDocumento(diasAguardandoDoc);
		AbasTempoAnaliseDados.setQtdeDiasAguardandoVistoria(diasAguardandoVistoria);
		AbasTempoAnaliseDados.setQtdeDiasEncerrado(diasEncerrado);
		AbasTempoAnaliseDados.setTempoRestateRegulacaoSinistro(tempoRestanteRegulacao);
		AbasTempoAnaliseDados.setTempoTotalRegulacaoSinistro(tempoTotalRegulacao);
	}

	
}
