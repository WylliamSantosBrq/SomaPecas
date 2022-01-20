package com.brq.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brq.interfaces.log.LogMessage;

public class ErroInteracaoElemento extends AssertionError {
	private static final long serialVersionUID = -9145998444937890997L;
	private static final String DEFAULT_MESSAGE = "Ocorreu um erro ao interagir com elemento.";

	public ErroInteracaoElemento() {
		LogMessage.builder().withMessage(DEFAULT_MESSAGE).error();
	}

	public ErroInteracaoElemento(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());
	}

	public ErroInteracaoElemento(Throwable t) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).error());
	}

	public ErroInteracaoElemento(Exception e) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).error());
	}

	public ErroInteracaoElemento(By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroInteracaoElemento(WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroInteracaoElemento(By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroInteracaoElemento(WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroInteracaoElemento(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroInteracaoElemento(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}
}
