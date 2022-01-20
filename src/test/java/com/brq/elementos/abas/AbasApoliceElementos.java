package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Texto;

public class AbasApoliceElementos {

	public static final Texto TEXTO_TIPO_COBERTURA = new Texto(By.xpath("//span[@class='titulobranco' and text()='Cobertura']/following::span[2]"));
	public static final Texto TEXTO_LICENCA = new Texto(By.xpath("//span[@class='titulobranco' and text()='Veiculo']/following::span[15]"));

}
