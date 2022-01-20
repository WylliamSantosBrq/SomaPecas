package com.brq.interfaces.abas;

import com.brq.elementos.abas.AbasCarregamentoElementos;
import com.brq.interfaces.Carregamento;
import com.brq.interfaces.log.BRQLogger;

public interface AbasCarregamento extends Carregamento {

	@Override
	default void esperarCarregamentoTerminar(int timeout) {
		BRQLogger.logMethod(timeout);
		
		AbasCarregamentoElementos.LOADING_PADRAO.esperarMilisegundos(500).esperarSerInvisivel(timeout);
	}

}
