package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Elemento;

public class AbasCarregamentoElementos {

	private AbasCarregamentoElementos() {
	}
	
	public static final Elemento LOADING_PADRAO = new Elemento(By.xpath("//img[@src='visual/images/loading.gif']"));

}
