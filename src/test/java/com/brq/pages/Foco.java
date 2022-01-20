package com.brq.pages;

import com.brq.erros.ErroAutomacao;
import com.brq.executar.CucumberExecuteTest;
import com.brq.interacoes.InteracaoNavegador;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.Loggable;
import com.brq.steps.StepsMaster;

public abstract class Foco implements InteracaoNavegador, Loggable {

	protected final int DEFAULT_STEPS_TIMEOUT = CucumberExecuteTest.DEFAULT_STEPS_TIMEOUT;

	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		throw new ErroAutomacao("Método padrão de [clicarEm].");
	}

	public static final Pagina getPaginaAtual() {
		BRQLogger.logMethod();

		return StepsMaster.getPaginaAtual();
	}

	public static final void setPaginaAtual(Pagina pagina) {
		BRQLogger.logMethod(pagina);

		StepsMaster.setPaginaAtual(pagina);
	}

	public void salvarDados(String conjuntoDeDados) {
		BRQLogger.logMethod(conjuntoDeDados);

		throw new ErroAutomacao("Método padrão de [salvarDados].");
	}

	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		throw new ErroAutomacao("Método padrão de [esperarExibicao].");
	}

	public void validarBotaoDisponivel(String botao) {
		BRQLogger.logMethod(botao);

		throw new ErroAutomacao("Método padrão de [validarBotaoDisponivel].");
	}

	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		throw new ErroAutomacao("Método padrão de [fecharCaixa].");
	}

	public void moverCursorSobre(String objeto) {
		BRQLogger.logMethod(objeto);

		throw new ErroAutomacao("Método padrão de [moverCursorSobre].");
	}

	public void validarDadoEmTela(String campo) {
		BRQLogger.logMethod(campo);

		throw new ErroAutomacao("Método padrão de [validarDadoEmTela].");
	}

}
