package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.web.ICombo;

public class Combo extends Elemento implements ICombo {

	public Combo(By by) {
		super(by);
	}
	
	public Elemento selecionarPorTexto(String opcao) {
		ICombo.selecionarComboPorTexto(by, opcao);
		
		return this;
	}
	
	public Elemento selecionarPorIndice(int indice) {
		ICombo.selecionarComboPorIndice(by, indice);
		
		return this;
	}
	
	public String obterTextoDaOpcaoSelecionada() {
		return ICombo.obterTextoDaOpcaoSelecionada(by);
	}

}
