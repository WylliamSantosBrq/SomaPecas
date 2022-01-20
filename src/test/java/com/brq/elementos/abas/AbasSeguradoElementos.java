package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Radio;

public class AbasSeguradoElementos {

	private AbasSeguradoElementos() {}
	
	public static final Radio SEGURO_REPARA_VEICULO = new Radio(By.xpath("//*[@name='abaSeguradoVO.flagSeguradoUtilizaraSeguro' and @checked]"));

}