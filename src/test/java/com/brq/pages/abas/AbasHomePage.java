package com.brq.pages.abas;

import org.apache.log4j.Logger;

import com.brq.interfaces.abas.AbasMenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.pages.Pagina;

public class AbasHomePage extends Pagina implements AbasMenuSuperior {
	Logger logger = Logger.getLogger("AbasHomePage");

	public AbasHomePage() {
		BRQLogger.logMethod();
		try {

			// trocarJanelaPorIndice(0);
			IEsperaWeb.esperarJanelaComTitulo("Aviso de Sinistro", 30);

			esperarPaginaAbrirContains("Aviso de Sinistro", 30);
		} catch (Throwable e) {
			logger.error(e.getMessage());
			String url = "";
			for (String hand : getHandles()) {
				trocarJanelaPorHandle(hand);
				url = getUrl();
				logger.debug(url);
				logger.debug(getTitle());
			}
		}
	}

}
