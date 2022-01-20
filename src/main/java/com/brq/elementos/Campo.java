package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.web.IEscrever;
import com.brq.interfaces.web.IEscreverJS;
import com.brq.interfaces.web.ILimpar;
import com.brq.interfaces.web.IValidacoesWeb;

public class Campo extends Elemento implements IEscrever, IEscreverJS, ILimpar {

	public Campo(By by) {
		super(by);
	}

	public boolean estaDisponivel() {
		return IValidacoesWeb.elementoDisponivel(by);
	}

	public Elemento preencher(String texto) {
		IEscrever.escrever(by, texto);

		return this;
	}

	public String obterValorPreenchido() {
		return obterAtributo("value");
	}

}
