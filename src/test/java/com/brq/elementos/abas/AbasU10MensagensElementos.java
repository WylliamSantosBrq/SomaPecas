package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Texto;

public class AbasU10MensagensElementos {

	private AbasU10MensagensElementos() {}
	
	public static final Texto TEXTO_NAO_HA_MENSAGEM = new Texto(By.xpath("//td[normalize-space(text())='Não há mensagem']"));
	
	public static final Botao BTN_FECHAR = new Botao(By.xpath("//a[contains(@class,'fancybox-close')]"));
	
}
