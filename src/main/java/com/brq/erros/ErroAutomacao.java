package com.brq.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brq.interfaces.log.LogMessage;

public class ErroAutomacao extends AssertionError {
	private static final long serialVersionUID = 3949578720833058049L;
	private static final String DEFAULT_MESSAGE = "Ocorreu um erro de automação.";

	public ErroAutomacao() {
		LogMessage.builder().withMessage(DEFAULT_MESSAGE).error();
	}

	public ErroAutomacao(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());
	}

	public ErroAutomacao(Throwable t) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).error());
	}

	public ErroAutomacao(Exception e) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).error());
	}

	public ErroAutomacao(By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroAutomacao(WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroAutomacao(By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroAutomacao(WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroAutomacao(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroAutomacao(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}
}
