package com.brq.pages.somadesktop;

import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.somadesktop.SDMenuLateral;
import com.brq.interfaces.somadesktop.SDPesquisaVistorias;
import com.brq.pages.Pagina;

public class SDHomePage extends Pagina implements SDMenuLateral, SDPesquisaVistorias {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		switch (botao) {
		
		}
	}
	
}
