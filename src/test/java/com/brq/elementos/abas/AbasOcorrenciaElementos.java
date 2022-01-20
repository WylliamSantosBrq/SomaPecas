package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Campo;

public class AbasOcorrenciaElementos {
	
	private AbasOcorrenciaElementos() {}
	
	public static final Campo CAMPO_PLACA = new Campo(By.xpath("//tr[td/span[normalize-space(text())='Placa']]//following::tr/td[5]"));

}
