package com.brq.pages.abas;

import com.brq.interfaces.abas.AbasMenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.pages.Pagina;

public class AbasHomePage extends Pagina implements AbasMenuSuperior {

	public AbasHomePage() {
		BRQLogger.logMethod();
		//trocarJanelaPorIndice(0);
		IEsperaWeb.esperarJanelaComTitulo("Aviso de Sinistro", 30);
		esperarPaginaAbrirContains("Aviso de Sinistro", 30);
	}

}
