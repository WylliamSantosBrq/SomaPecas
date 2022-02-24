package com.brq.pages.abas;

import com.brq.interfaces.abas.AbasMenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasHomePage extends Pagina implements AbasMenuSuperior {
    Logger logger = Logger.getLogger("AbasHomePage");

	public AbasHomePage() {
		BRQLogger.logMethod();
		try{
		trocarJanelaPorIndice(0);
		esperarPaginaAbrirContains("Aviso de Sinistro", 30);
		}
		catch(Throwable e)
		{
		    logger.error(e.getMessage());
		    String url = "";
		    for(String hand:getHandles())
		    {
		        trocarJanela(hand);
		        url = getUrl();
		        logger.debug(url);
		        logger.debug(getTitle());
		    }
		    esperarPadrao(999);
		}
	}

}
