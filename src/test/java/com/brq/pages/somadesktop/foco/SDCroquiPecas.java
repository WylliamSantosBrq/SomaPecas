package com.brq.pages.somadesktop.foco;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliCroquiPecasElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;
import com.brq.pages.somadesktop.SDOrientacaoDeDanosPage;

public class SDCroquiPecas extends Foco {

	Screen s = new Screen();
	
	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Capuz Motor":
			clicarEmCapuzMotor();
			break;
			
		case "Ferramenta":
		case "Configurações":
			clicarEmConfiguracoes();
			break;
		
		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}
	
	public void clicarEmCapuzMotor() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliCroquiPecasElementos.getCroquiCapuzMotor(), 15);
			s.click(SikuliCroquiPecasElementos.getCroquiCapuzMotor());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "Não foi possível encontrar o elemento em tela.");
		}
	}
	
	public void clicarEmConfiguracoes() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliCroquiPecasElementos.getCroquiConfiguracoes(), 15);
			s.click(SikuliCroquiPecasElementos.getCroquiConfiguracoes());
			setPaginaAtual(new SDOrientacaoDeDanosPage());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "Não foi possível encontrar o elemento em tela.");
		}
	}

}
