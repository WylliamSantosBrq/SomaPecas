package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IValidacoesWeb;

public class Texto extends Elemento implements IValidacoesWeb {

	public Texto(By by) {
		super(by);
	}

	public Elemento validarTextoIgual(String textoEsperado) {
		BRQLogger.logMethod(textoEsperado);
		
		validarIguais(obterTexto(), textoEsperado);
		
		return this;
	}

	public Elemento validarTextoHiddenIgual(String textoEsperado) {
		BRQLogger.logMethod(textoEsperado);
		
		validarIguais(obterTextoHidden(), textoEsperado);
		
		return this;
	}

	public Elemento validarTextoDiferente(String textoNaoEsperado) {
		BRQLogger.logMethod(textoNaoEsperado);
		
		validarDiferentes(obterTexto(), textoNaoEsperado);
		
		return this;
	}

	public Elemento validarTextoHiddenDiferente(String textoNaoEsperado) {
		BRQLogger.logMethod(textoNaoEsperado);
		
		validarDiferentes(obterTextoHidden(), textoNaoEsperado);
		
		return this;
	}
	
}
