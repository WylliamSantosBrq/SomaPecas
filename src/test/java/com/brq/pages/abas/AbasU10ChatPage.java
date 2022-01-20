package com.brq.pages.abas;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;

public class AbasU10ChatPage extends Pagina {

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "CHAT virtual":
			esperarExibicaoChatVirtual(DEFAULT_STEPS_TIMEOUT);
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	public void esperarExibicaoChatVirtual(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		esperarPaginaAbrir("Chat - SMARKIO", tempoEmSegundos);
	}

	@Override
	public void fecharJanela(String janela) {
		BRQLogger.logMethod(janela);

		switch (janela) {
		case "Atendimento Online":
			fecharJanelaAtendimentoOnline();
			break;

		default:
			throw new ErroAutomacao("A janela [%s] não foi definida no método [fecharJanela].", janela);
		}
	}

	private void fecharJanelaAtendimentoOnline() {
		BRQLogger.logMethod();
		
		fecharAba();
		
		StepsMaster.setPaginaAtual(new AbasU10HomePage());
	}

}
