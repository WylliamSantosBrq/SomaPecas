package com.brq.interfaces.somadesktop;

import org.sikuli.script.Screen;

import com.brq.drivers.desktop.Sikuli;
import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.MenuLateral;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somaweb.SWObterVistorias;
import com.brq.steps.StepsMaster;
import com.brq.utils.webservices.SomaWebSoapHelper;

public interface SDMenuLateral extends MenuLateral {

	Screen s = Sikuli.getScreen();
//	String userToken = new SomaWebSoapHelper().getToken();
	String urlObterVistorias = "http://washmlsoma/somaWeb/integracao?token=%s&service=car";

	@Override
	default void acessarMenuLateral(String... ordemDeMenus) {
		BRQLogger.logMethod(ordemDeMenus);

		switch (ordemDeMenus[0]) {
		case "Obter Vistorias":
			clicarObterVistorias();
			break;

		default:
			throw new ErroAutomacao("O menu [%s] não foi definido no método [acessarMenuLateral].", ordemDeMenus[0]);
		}
	}

	default void clicarObterVistorias() {
		BRQLogger.logMethod();

		String url = String.format(urlObterVistorias, new SomaWebSoapHelper().getToken());
		DriverWeb.getDriver().navigate().to(url);
		StepsMaster.setPaginaAtual(new SWObterVistorias());

//		try {
//			s.wait(SikuliMenuLateralElementos.getBtnObterVistorias(), 60);
//			s.click(SikuliMenuLateralElementos.getBtnObterVistorias());
//			s.waitVanish(SikuliMenuLateralElementos.getBtnObterVistorias(), 10);
//			s.wait(SikuliChromeElementos.getValidacaoChromeAberto(), 10);
//			s.click();
//			s.waitVanish(SikuliChromeElementos.getInputChromeURLBar(), 10);
//			s.type("l", KeyModifier.CTRL);
//			s.type("c", KeyModifier.CTRL);
//			s.type("w", KeyModifier.CTRL);
//			String ctrlC = ClipboardHelper.getText();
//			BRQLogger.info(ctrlC);
//			if (ctrlC.length() < 100) 
//				throw new ErroInesperado("Não foi possível capturar a URL contendo o token antes da página ser redirecionada.");

//		} catch (FindFailed e) {
//			throw new ErroSistema(e, "O menu lateral não foi encontrado.");
//		} catch (IOException e) {
//			throw new ErroInesperado(e, "Não foi possível capturar a URL do site.");
//		}
	}

}
