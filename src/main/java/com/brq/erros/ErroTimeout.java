package com.brq.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brq.interfaces.log.LogMessage;

public class ErroTimeout extends AssertionError {
	private static final long serialVersionUID = 361670798339424578L;
	private static final String DEFAULT_MESSAGE = "Tempo excedido para realizar ação.";

	public ErroTimeout() {
		LogMessage.builder().withMessage(DEFAULT_MESSAGE).error();
	}

	public ErroTimeout(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());
	}

	public ErroTimeout(Throwable t) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).error());
	}

	public ErroTimeout(Exception e) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).error());
	}

	public ErroTimeout(By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroTimeout(WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroTimeout(By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroTimeout(WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroTimeout(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroTimeout(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroTimeout(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroTimeout(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroTimeout(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroTimeout(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroTimeout(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroTimeout(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}

	public ErroTimeout(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroTimeout(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}
}
