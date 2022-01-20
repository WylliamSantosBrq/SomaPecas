package com.brq.interfaces.abas;

import java.util.Map;

import com.brq.elementos.Campo;
import com.brq.elementos.abas.AbasPesquisaSinistroPorNumeroElementos;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.abas.AbasRegistrarSinistroPage;
import com.brq.steps.StepsMaster;

public interface AbasPesquisaSinistroPorNumero extends Pesquisa {

	@Override
	default void pesquisar(String textoParaPesquisar) {
		BRQLogger.logMethod(textoParaPesquisar);

		String[] dadosDoSinistro = textoParaPesquisar.split(" ");

		AbasPesquisaSinistroPorNumeroElementos.FRAME_PRINCIPAL.entrar();

		((Campo) AbasPesquisaSinistroPorNumeroElementos.INPUT_RAMO.mover()).preencher(dadosDoSinistro[0]);
		AbasPesquisaSinistroPorNumeroElementos.INPUT_ANO_SINISTRO.preencher(dadosDoSinistro[1]);
		AbasPesquisaSinistroPorNumeroElementos.INPUT_NUMERO_DO_SINISTRO.preencher(dadosDoSinistro[2]);

		if (dadosDoSinistro.length == 4)
			AbasPesquisaSinistroPorNumeroElementos.INPUT_ITEM_SINISTRO.preencher(dadosDoSinistro[3]);
		
		AbasPesquisaSinistroPorNumeroElementos.BTN_PESQUISAR.clicarJavascript();
	}

	@Override
	default void selecionarResultado(String resultado) {
		BRQLogger.logMethod(resultado);

		AbasPesquisaSinistroPorNumeroElementos.FRAME_PRINCIPAL.sair();

		// TODO Auto-generated method stub
		StepsMaster.setPaginaAtual(new AbasRegistrarSinistroPage());
	}

	@Override
	default void selecionarResultado(int indice) {
		BRQLogger.logMethod(indice);

		AbasPesquisaSinistroPorNumeroElementos.TABLE_RESULTADOS.getLinha(indice).get("//a").esperarSerVisivel(30)
				.clicar();

		if (((Pagina) this).alertaPresente())
			((Pagina) this).aceitarAlerta();

		AbasPesquisaSinistroPorNumeroElementos.FRAME_PRINCIPAL.sair();

		StepsMaster.setPaginaAtual(new AbasRegistrarSinistroPage());
	}

	@Override
	default void selecionarPrimeiroResultado() {
		BRQLogger.logMethod();

		selecionarResultado(0);
	}

	@Override
	default void filtrarPor(Map<String, String> filtros) {
		BRQLogger.logMethod(filtros);

//		TODO
	}

}
