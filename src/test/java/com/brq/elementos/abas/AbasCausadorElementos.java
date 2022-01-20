package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Elemento;

public class AbasCausadorElementos {

	private AbasCausadorElementos() {
	}

	public static final Elemento SPAN_RADIO_COD_CAUSADOR_SINISTRO = new Elemento(By.xpath("//*[@name='abaCausadorVO.codigoCausadorSinistro' and @checked]/following::span[1]"));
	public static final Elemento SPAN_POSSUI_DADOS_CAUSADOR = new Elemento(By.xpath("//*[@id='flagPossuiDadosVeiculoCausador' and @checked]/following::span[1]"));
    public static final Elemento DESCRICAO_VEICULO_CAUSADOR = new Elemento(By.id("descricaoVeiculoCausador"));		
    public static final Elemento PLACA_VEICULO_CAUSADOR = new Elemento(By.id("placaVeiculoCausador"));
    public static final Elemento CHASSI_VEICULO_CAUSADOR = new Elemento(By.id("chassiVeiculoCausador"));
}
