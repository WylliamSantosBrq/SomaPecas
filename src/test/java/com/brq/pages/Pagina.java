package com.brq.pages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.executar.CucumberExecuteTest;
import com.brq.interacoes.InteracaoNavegador;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.Loggable;
import com.brq.pages.sistemascorporativos.SCLoginPage;
import com.brq.pages.somapecas.SPLoginPage;
import com.brq.steps.StepsMaster;

/**
 * Página padrão que contém métodos genéricos. As funcionalidades de sites
 * específicos devem ser definidos nas classes filhas.
 * 
 * @author ymnoda
 *
 */
public class Pagina implements InteracaoNavegador, Loggable {

	/**
	 * Instância do focoAtual ativo na página atual. É importante de lembrar que, ao
	 * usar algum método do {@link #focoAtual}, deve-se redefinir o valor de
	 * Foco/Pagina dentro do próprio método, caso necessário. <br>
	 * <br>
	 * <code>
	 * paginaAtual.getFocoAtual().algumMetodo();<br>
	 * </code>
	 * 
	 * <dt>Exemplo:</dt>
	 * <dd>Ao clicar em um botão que abre uma interface, mantendo a instância da
	 * página atual, essa interface seria o {@link #focoAtual} atual da página, onde
	 * podem acontecer interações específicas, sem deixar de perder as outras da
	 * {@link StepsMaster#paginaAtual}.</dd>
	 */
	private Foco focoAtual;

	protected static int DEFAULT_STEPS_TIMEOUT = CucumberExecuteTest.DEFAULT_STEPS_TIMEOUT;
	protected int EXTREMELY_LONG_STEPS_TIMEOUT = CucumberExecuteTest.EXTREMELY_LONG_STEPS_TIMEOUT;

	public final void acessarUrl(String url) {
		BRQLogger.logMethod(url);

		abrirUrl(url);

		switch (url) {
		case "http://aplwebhml/seweb/trs/":
		case "http://aplweb.portoseguro.brasil/seweb/trs/":
		case "http://aplwebhml.portoseguro.brasil/seweb/trs/":
		case "http://172.26.170.5/seweb/trs/":
			StepsMaster.setPaginaAtual(new SCLoginPage());
			return;

		case "http://172.26.171.101/security-somapecas/login.xhtml":
			StepsMaster.setPaginaAtual(new SPLoginPage());
			return;

		default:
			throw new ErroAutomacao("A URL [%s] não foi definida no método [acessarUrl].", url);
		}
	}

	public void acessarSistema(String sistema) {
		BRQLogger.logMethod(sistema);

		switch (sistema) {
		case "Sistemas Corporativos":
			acessarUrl("http://aplwebhml/seweb/trs/");
			return;

		case "SOMA Peças":
			acessarUrl("http://172.26.171.101/security-somapecas/login.xhtml");
			return;

		default:
			throw new ErroAutomacao("O sistema [%s] não foi definido no método [acessarSistema].", sistema);
		}
	}

	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		throw new ErroAutomacao("Método padrão de clique.");
	}

	public final static Pagina cast(Class<?> class1) {
		BRQLogger.logMethod(class1);

		Constructor<?>[] ctors = class1.getDeclaredConstructors();
		Constructor<?> ctor = null;
		for (int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if (ctor.getGenericParameterTypes().length == 0)
				break;
		}

		try {
			return (Pagina) ctor.newInstance();

		} catch (InstantiationException e) {
			throw new ErroAutomacao(e, "A classe [%s] não pôde ser instanciada.", ctor.getDeclaringClass());
		} catch (IllegalAccessException e) {
			throw new ErroAutomacao(e, "Construtores da classe [Pagina] devem ser públicos.");
		} catch (IllegalArgumentException e) {
			throw new ErroAutomacao(e, "Construtores da classe [Pagina] não devem conter nenhum argumento.");
		} catch (InvocationTargetException e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao instanciar a classe [%s].",
					ctor.getDeclaringClass());
		}

	}

	public final Foco getFocoAtual() {
		BRQLogger.logMethod();

		return focoAtual;
	}

	public final void setFocoAtual(Foco focoAtual) {
		BRQLogger.logMethod(focoAtual);

		this.focoAtual = focoAtual;
	}

	public void focar(String foco) {
		BRQLogger.logMethod(foco);

		throw new ErroAutomacao("Método padrão de [focar].");
	}

	public void fecharJanela(String janela) {
		BRQLogger.logMethod(janela);

		throw new ErroAutomacao("Método padrão de [fecharJanela].");
	}

	public void salvarDados(String conjuntoDeDados) {
		BRQLogger.logMethod(conjuntoDeDados);

		throw new ErroAutomacao("Método padrão de [salvarDados].");
	}

	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		throw new ErroAutomacao("Método padrão de [fecharCaixa].");
	}

	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		throw new ErroAutomacao("Método padrão de [esperarExibicao].");
	}

	public void validarBotaoDisponivel(String botao) {
		BRQLogger.logMethod(botao);

		throw new ErroAutomacao("Método padrão de [validarBotaoDisponivel].");
	}

	public void validarCaixaDe(String tituloCaixa) {
		BRQLogger.logMethod(tituloCaixa);

		throw new ErroAutomacao("Método padrão de [validarCaixaDe].");
	}

	public void moverCursorSobre(String objeto) {
		BRQLogger.logMethod(objeto);

		throw new ErroAutomacao("Método padrão de [moverCursorSobre].");
	}

	public void validarDadosEmTela(List<String> campos) {
		BRQLogger.logMethod(campos);

		for (String campo : campos)
			validarDadoEmTela(campo);
	}

	public void validarDadoEmTela(String campo) {
		BRQLogger.logMethod(campo);

		throw new ErroAutomacao("Método padrão de [validarDadoEmTela].");
	}

}
