package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Campo;

public class AbasMovimentosElementos {

	private AbasMovimentosElementos() {}

	public static final Campo OUTPUT_SALDO = new Campo(By.xpath("//*[@id='corpo_movimentos']//td[contains(., 'Saldo')]/following::td[1]"));
	
}
