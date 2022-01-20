package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;

public class AbasMenuElementos {

	private AbasMenuElementos() {
	}
	
	public static final Botao BTN_AVISO_DE_SINISTRO = new Botao(By.xpath("//a[contains(@id, 'Menu') and text()='Aviso de Sinistro']"));
	public static final Botao BTN_AS_CONSULTAS = new Botao(By.xpath("//div[contains(@onmouseout, 'Menu2')]//a[text()='Consultas']"));
	public static final Botao BTN_AS_CONS_NUMERO_DO_SINISTRO = new Botao(By.xpath("//div[contains(@onmouseout, 'Menu2')]//tr[.//a[text()='Consultas']][1]/following::tr//a[text()='Número do Sinistro']"));

	public static final By btnLogin = By.xpath("//input[@id='login']");
	
}
