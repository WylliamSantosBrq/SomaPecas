package com.brq.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brq.interfaces.log.LogMessage;

public class ErroInesperado extends AssertionError {
	private static final long serialVersionUID = 56587072717382301L;
	private static final String DEFAULT_MESSAGE = "Ocorreu um erro inesperado.";

	public ErroInesperado() {
		LogMessage.builder().withMessage(DEFAULT_MESSAGE).error();
	}

	public ErroInesperado(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());
	}

	public ErroInesperado(Throwable t) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).error());
	}

	public ErroInesperado(Exception e) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).error());
	}

	public ErroInesperado(By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroInesperado(WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withElement(elemento).error());
	}

	public ErroInesperado(By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroInesperado(WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(DEFAULT_MESSAGE).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroInesperado(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroInesperado(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).withElement(elemento).error());
	}
}
