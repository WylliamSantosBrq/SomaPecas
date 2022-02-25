package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;

public class AbasMenuAvisoLateralElementos {

	private AbasMenuAvisoLateralElementos() {
	}

	public static final Botao BTN_AVISO_DE_SINISTRO = new Botao(By.xpath("//a[text()=' AVISO DE SINISTRO']"));
	public static final Botao BTN_AVISO_DE_SINISTRO2 = new Botao(By.xpath("//a//u[text()='AVISO DE SINISTRO']"));

	public static final Botao BTN_MARCACAO_DE_VISTORIA = new Botao(By.xpath("//a[text()='MARCAÇÃO DE VISTORIA']"));
	public static final Botao BTN_U10 = new Botao(By.xpath("//a[text()='U10']"));
	public static final Botao DIV_LOADING = new Botao(By.xpath("//div[@id='te']//img"));

}
