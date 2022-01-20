package com.brq.pages;

import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.DesktopPrint;

import cucumber.api.Scenario;

public class DesktopPage extends Pagina implements DesktopPrint {
	
	@Override
	public String printAndSave(Scenario cenario) {
		BRQLogger.logMethod(cenario);
		
		return DesktopPrint.tirarPrintDesktop(cenario);
	}

	public void pressionarTecla(int tecla) {
		BRQLogger.logMethod(tecla);

		s.keyDown(tecla);
		esperarMilisegundos(50);
		s.keyUp(tecla);
	}

	public void pressionarTeclas(int tecla, int repeticoes) {
		BRQLogger.logMethod(tecla, repeticoes);

		for (int i = repeticoes; i > 0; i--) {
			pressionarTecla(tecla);
		}
	}

}
