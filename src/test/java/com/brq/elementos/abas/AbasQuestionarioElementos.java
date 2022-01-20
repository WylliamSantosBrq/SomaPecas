package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Radio;

public class AbasQuestionarioElementos {

	private AbasQuestionarioElementos() {}
	
	public static final Radio VEICULO_ALIENADO = new Radio(By.xpath("//*[@id='flagVeiculoAlienado' and @checked]"));
	public static final Radio VEICULO_RASTREADO = new Radio(By.xpath("//*[@id='flagVeiculoPossuiRastreador' and @checked]"));
	public static final Radio REGISTROU_BO = new Radio(By.xpath("//*[@id='flagRegistrouOcorrenciaSinistro' and @checked]"));
	public static final Radio POSSUI_FOTOS = new Radio(By.xpath("//*[@id='flagTirouFotoOcorrencia' and @checked]"));
		
}