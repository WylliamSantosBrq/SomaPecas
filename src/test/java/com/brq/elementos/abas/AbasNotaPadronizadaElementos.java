package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;

public class AbasNotaPadronizadaElementos {

	private AbasNotaPadronizadaElementos() {
	}
	
	public static final Botao BTN_SALVAR = new Botao(By.xpath("//img[@onclick='javascript:salvar();']"));

}
