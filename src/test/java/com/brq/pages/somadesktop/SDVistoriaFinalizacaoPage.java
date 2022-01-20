package com.brq.pages.somadesktop;

import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliAbaFinalizacaoElementos;
import com.brq.elementos.somadesktop.SikuliVistoriaAbaElementos;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;
import com.brq.steps.StepsMaster;

public class SDVistoriaFinalizacaoPage extends DesktopPage {

	Screen s = new Screen();
	
	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
	
		switch (botao) {
		case "SALVAR E TRANSMITIR":
			try {
				s.mouseMove(SikuliVistoriaAbaElementos.getAbaFotos().targetOffset(0, 300));
				s.wheel(Button.WHEEL_DOWN, 15);
				s.click(SikuliAbaFinalizacaoElementos.getBtnSalvarETransmitir());
				StepsMaster.setPaginaAtual(new SDSituacoesVistoriaPage());
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão de [SALVAR E TRANSMITIR] não foi encontrado em tela.");
			}
			break;
		}
	}

}
