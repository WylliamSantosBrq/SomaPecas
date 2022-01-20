package com.brq.pages.abas;

import com.brq.interfaces.abas.AbasMenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasHomePage extends Pagina implements AbasMenuSuperior {

	public AbasHomePage() {
		BRQLogger.logMethod();
		trocarJanelaPorIndice(0);
		esperarPaginaAbrirContains("Aviso de Sinistro", 30);
	}

}
