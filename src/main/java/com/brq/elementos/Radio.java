package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.web.IValidacoesWeb;

public class Radio extends Elemento {

	public Radio(By by) {
		super(by);
	}
	
	public boolean estaSelecionado() {
		return IValidacoesWeb.elementoSelecionado(by);
	}
	
}
