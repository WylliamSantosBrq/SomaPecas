package com.brq.interfaces.somapecas;

import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;

public interface SPPesquisa extends Pesquisa {
	
	@Override
	default void pesquisar(String texto) {
		BRQLogger.logMethod(texto);
		
//		TODO
	}

}
