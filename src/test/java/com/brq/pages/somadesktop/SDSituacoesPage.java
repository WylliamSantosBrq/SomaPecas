package com.brq.pages.somadesktop;

import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;

import com.brq.elementos.somadesktop.SikuliSituacoesElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Radios;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;

public class SDSituacoesPage extends DesktopPage implements Radios {

	@Override
	public void clicarNoRadio(String label, String radio) {
		BRQLogger.logMethod(label, radio);

		switch (label) {
		case "Situações obrigatórias":
			clicarNoRadioSituacoesObrigatorias(radio);
			break;

		default:
			throw new ErroAutomacao("A seção de radios [%s] não foi definida no método [clicarNoRadio].", label);
		}
	}

	public void clicarNoRadioSituacoesObrigatorias(String radio) {
		BRQLogger.logMethod(radio);
		
		esperarSegundos(1);
		
		int maximoRolagens = 100;
		
		while (!s.hasText(radio)) {
			rolarParaBaixoSituacoesObrigatorias(5);
			if (maximoRolagens-- <= 0)
				throw new ErroSistema("O rádio [%s] não foi encontrado em tela.", radio);
		}
		
		try {
			int radioX = s.find(SikuliSituacoesElementos.getTituloSituacoes()).getX() - 10;
			int radioY = s.findText(radio).getY();
			
			s.click(new Region(radioX, radioY));
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
}

	public void rolarParaBaixoSituacoesObrigatorias(int repeticoes) {
		BRQLogger.logMethod(repeticoes);
 
		try {
			s.mouseMove(SikuliSituacoesElementos.getTituloSituacoes().targetOffset(0, 50));
			s.wheel(Button.WHEEL_DOWN, repeticoes);

		} catch (FindFailed e) {
			throw new ErroSistema(e, "A janela de [Situações] não está presente em tela.");
		}
	}

	@Override
	public void validarPerguntaResposta(String pergunta, String resposta) {
		// TODO Auto-generated method stub
		
	}

}
