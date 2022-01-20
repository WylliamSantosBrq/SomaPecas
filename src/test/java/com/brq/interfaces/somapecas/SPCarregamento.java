package com.brq.interfaces.somapecas;

import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.interfaces.Carregamento;
import com.brq.interfaces.log.BRQLogger;

public interface SPCarregamento extends Carregamento {
	
	@Override
	default void esperarCarregamentoTerminar(int timeout) {
		BRQLogger.logMethod(timeout);
		
		SPCarregamentoElementos.GIF_CARREGAMENTO.esperarSerInvisivel(timeout);
	}
}
