package com.brq.interfaces.somapecas;

import com.brq.interfaces.Menu;
import com.brq.interfaces.log.BRQLogger;

public interface SPMenuSuperior extends Menu {

	@Override
	default void acessarMenu(String... ordemDeMenus) {
		BRQLogger.logMethod(ordemDeMenus);

//		TODO
	}
	
}
