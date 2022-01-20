package com.brq.pages.abas;

import com.brq.elementos.abas.AbasExibicaoDeItensDaArvoreElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.abas.AbasExibicaoDeItensDaArvoreMenu;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasExibicaoDeItensDaArvorePage extends Pagina implements AbasExibicaoDeItensDaArvoreMenu {

	public AbasExibicaoDeItensDaArvorePage() {
		BRQLogger.logMethod();

		esperarPaginaAbrirContains("Novo Sinistro Auto", 30);
	}

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "Exibição de Itens da Árvore":
			esperarExibicaoDeItensDaArvore(DEFAULT_STEPS_TIMEOUT);
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	public void esperarExibicaoDeItensDaArvore(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		AbasExibicaoDeItensDaArvoreElementos.TEXTO_EXIBICAO_DE_ITENS_DA_ARVORE.esperarSerVisivel(tempoEmSegundos);
	}

}
