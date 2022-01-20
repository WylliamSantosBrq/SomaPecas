package com.brq.interfaces.somaweb;

import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;

public interface SWObterVistoriasPesquisa extends Pesquisa {

	@Override
	default void pesquisar(String textoParaPesquisar) {
		BRQLogger.logMethod(textoParaPesquisar);
		
		
		
	}

	@Override
	default void selecionarResultado(String resultado) {
		// TODO Auto-generated method stub
		Pesquisa.super.selecionarResultado(resultado);
	}

	@Override
	default void selecionarResultado(int indice) {
		// TODO Auto-generated method stub
		Pesquisa.super.selecionarResultado(indice);
	}

	@Override
	default void selecionarPrimeiroResultado() {
		// TODO Auto-generated method stub
		Pesquisa.super.selecionarPrimeiroResultado();
	}

	
	
}
