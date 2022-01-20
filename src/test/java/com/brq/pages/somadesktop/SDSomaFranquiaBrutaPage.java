package com.brq.pages.somadesktop;

import org.sikuli.script.FindFailed;

import com.brq.elementos.somadesktop.SikuliSomaFranquiaBrutaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;

public class SDSomaFranquiaBrutaPage extends DesktopPage {
	
//	aviso
	
	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		switch(botao) {
		case "Ok":
			clicarEmOk();
			break;
			
			default:
				throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmOk() {
		BRQLogger.logMethod();
		
		try {
			s.wait(SikuliSomaFranquiaBrutaElementos.getTituloSomaFranquiaBruta(), 5);
			s.click(SikuliSomaFranquiaBrutaElementos.getBtnOk());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão [Ok] não foi encontrado em tela.");
		}
	}

}