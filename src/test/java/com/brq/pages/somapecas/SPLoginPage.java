package com.brq.pages.somapecas;

import com.brq.elementos.Botao;
import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.somapecas.SPLogin;
import com.brq.pages.Pagina;
import org.openqa.selenium.By;

public class SPLoginPage extends Pagina implements SPLogin {

	public SPLoginPage() {
		BRQLogger.logMethod();
	}

	public void deslogar(){
		BRQLogger.logMethod();
		Botao BTN_LOGOFF = new Botao(By.cssSelector("form#logoutForm > a"));

		BTN_LOGOFF.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT).clicarJavascript();
		SPCarregamentoElementos.GIF_CARREGAMENTO.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT).esperarSegundos(1);
	}
}
