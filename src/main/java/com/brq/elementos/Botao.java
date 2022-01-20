package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.web.IValidacoesWeb;

public class Botao extends Elemento {
	
	public Botao(By by) {
		super(by);
	}
	
	public boolean estaDisponivel() {
		return IValidacoesWeb.elementoDisponivel(by);
	}

}
