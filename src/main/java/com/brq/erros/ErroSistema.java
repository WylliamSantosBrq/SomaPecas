package com.brq.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brq.interfaces.log.LogMessage;

public class ErroSistema extends AssertionError {
	private static final long serialVersionUID = -42759536757942704L;
	private static final String DEFAULT_MESSAGE = "Ocorreu um erro de sistema.";

	public ErroSistema() {
		LogMessage.builder().withMessage(DEFAULT_MESSAGE).error();
	}

	public ErroSistema(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());
	}

	public ErroSistema(Throwable t) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).error());
	}

	public ErroSistema(Exception e) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).error());
	}

	public ErroSistema(By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroSistema(WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroSistema(By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroSistema(WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroSistema(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroSistema(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}
}
