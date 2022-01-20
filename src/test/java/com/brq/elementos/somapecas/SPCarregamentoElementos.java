package com.brq.elementos.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Elemento;

public class SPCarregamentoElementos {

	private SPCarregamentoElementos() {
	}
	
	public static final Elemento GIF_CARREGAMENTO = new Elemento(By.xpath("//img[@src='/fornecimentopecasme/images/template/ajax-loader.gif"));

}
