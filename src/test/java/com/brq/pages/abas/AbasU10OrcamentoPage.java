package com.brq.pages.abas;

import org.openqa.selenium.By;

import com.brq.elementos.abas.AbasU10HomeElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasU10OrcamentoPage extends Pagina {

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "Orçamento Detalhado":
			esperarExibicaoOrcamentoDetalhado(DEFAULT_STEPS_TIMEOUT);
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	public void esperarExibicaoOrcamentoDetalhado(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		esperarSegundos(8);
		By by = AbasU10HomeElementos.TEXTO_RELATORIO_VERSAO_ORCAMENTO.getBy();
		esperarPaginaComElementoAbrir(by, tempoEmSegundos);
	}
}

