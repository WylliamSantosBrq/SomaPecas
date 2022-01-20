package com.brq.pages.somadesktop;

import org.sikuli.script.FindFailed;

import com.brq.elementos.somadesktop.SikuliSituacoesVistoriaElementos;
import com.brq.elementos.somadesktop.SikuliSomaFranquiaBrutaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;
import com.brq.steps.StepsMaster;

public class SDSituacoesVistoriaPage extends DesktopPage {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		switch(botao) {
		case "Sim":
			clicarEmSim();
			break;
			
		case "Não":
			clicarEmNao();
			break;
			
			default:
				throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	private void clicarEmNao() {
		BRQLogger.logMethod();
		
		try {
			s.wait(SikuliSituacoesVistoriaElementos.getBtnNao(), 15);
			s.click(SikuliSituacoesVistoriaElementos.getBtnNao());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão [Não] não apareceu em tela.");
		}
	}

	private void clicarEmSim() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliSituacoesVistoriaElementos.getBtnSim(), 15);
			s.click(SikuliSituacoesVistoriaElementos.getBtnSim());
			
			if (s.has(SikuliSomaFranquiaBrutaElementos.getTituloSomaFranquiaBruta()))
				StepsMaster.setPaginaAtual(new SDSomaFranquiaBrutaPage());
			
			StepsMaster.setPaginaAtual(new SDSituacoesAtencaoPage());
			
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão [Sim] não apareceu em tela.");
		}
	}
	
}
