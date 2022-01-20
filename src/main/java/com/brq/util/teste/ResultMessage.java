package com.brq.util.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;

import com.brq.erros.ErroValidacao;
import com.brq.interfaces.web.IClique;
import com.brq.interfaces.web.ICliqueJS;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.interfaces.web.IMover;
import com.brq.interfaces.web.IObter;
import com.brq.util.StringHelper;

/**
 * Enum que contém as recomendações de melhoria associadas com o tipo de erro
 * retornado pelo teste.
 * 
 * @author ymnoda
 * @see com.brq.util.teste.TestHelper
 */
public enum ResultMessage {
	ELEMENT_NOT_INTERACTABLE(ElementNotInteractableException.class,
			"Verifique se a interação anterior para tornar o elemento interativo funcionou.\n"
					+ "Tente usar os seguintes métodos:\n"
					+ StringHelper.methodLocation(ICliqueJS.class, "clicarJavascript", By.class)
					+ " caso tenha tentado realizar o clique com o clicar da classe IClique.\n"
					+ StringHelper.methodLocation(IEsperaWeb.class, "esperarElementoSerClicavel", By.class, long.class)
					+ " caso o elemento só tenha demorado para ser interativo."),

	ELEMENT_CLICK_INTERCEPTED(ElementClickInterceptedException.class,
			"Tente usar os seguintes métodos:\n"
					+ StringHelper.methodLocation(IClique.class, "clicarQuandoNaoForInterceptado", By.class, long.class)
					+ " caso o elemento que interceptou o clique tenha demorado para sumir.\n"
					+ StringHelper.methodLocation(IMover.class, "moverParaElementoEClicar", By.class)
					+ " caso o elemento esteja fora da tela no momento em que o clique foi feito."), //

	ERRO_VALIDACAO(ErroValidacao.class,
			"Caso a validação seja baseada em algum texto do sistema que veio em branco, tente usar algum desses métodos:\n"
					+ StringHelper.methodLocation(IObter.class, "obterTextoHidden", By.class)
					+ " caso o texto de apenas um elemento esteja sendo validado.\n"
					+ StringHelper.methodLocation(IObter.class, "obterTextoHiddenDosElementos", By.class)
					+ " caso mais de um elemento esteja sob validação.\n\n"
					+ "Caso a validação seja algum elemento em tela, certifique-se de que o localizador foi definido corretamente.");

	private final Class<? extends Throwable> throwable;
	private final String mensagem;

	private ResultMessage(Class<? extends Throwable> throwable, String mensagem) {
		this.throwable = throwable;
		this.mensagem = mensagem;
	}

	public Class<? extends Throwable> getThrowable() {
		return throwable;
	}

	public String getMensagem() {
		return mensagem;
	}
}
