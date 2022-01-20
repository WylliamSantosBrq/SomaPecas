package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Elemento;
import com.brq.elementos.Texto;

public class AbasNotasElementos {

	private AbasNotasElementos() {
	}
	
	public static final Botao BTN_REGISTRAR_NOTA_AUTOMATICA = new Botao(By.id("btnRegistrarNotaPadrao"));
	
	public static final Botao BTN_EXPANDIR_TODAS = new Botao(By.id("sinalGeral"));
	public static final Botao BTN_MODELO_DE_CARTAS = new Botao(By.id("btnCartas"));
	
	public static final Texto TEXTO_APOLICE = new Texto(By.xpath("//strong[text()='Apolice']/following::span[1]"));
	public static final Texto TEXTO_CONVENIO = new Texto(By.xpath("//strong[text()='Convênio']/following::span[1]"));
	public static final Texto TEXTO_VEICULO = new Texto(By.xpath("//strong[text()='Veiculo']/following::span[1]"));
	public static final Texto TEXTO_PLACA = new Texto(By.xpath("//strong[text()='Placa']/following::span[1]"));
	public static final Texto TEXTO_SEGURADO = new Texto(By.xpath("//strong[text()='Segurado']/following::span[1]"));
	public static final Texto TEXTO_CHASSI = new Texto(By.xpath("//strong[text()='Chassi']/following::span[1]"));
	public static final Texto TEXTO_MARCA = new Texto(By.xpath("//strong[text()='Marca']/following::span[1]"));
		
	public static final Elemento DIV_REGISTRO_AUTOMATICO = new Elemento(By.id("subAssuntos_0"));
	public static final Elemento REGISTRO_EMISSAO_LAUDO = new Elemento(By.xpath("//*[@id='subAssuntos_0']//span[contains(text(), 'Emissão do laudo')]"));
	public static final Elemento REGISTRO_PERDA_PARCIAL = new Elemento(By.xpath("//*[@id='subAssuntos_0']//span[@class='textocine14'][contains(., 'Sugestão de Perda Parcial')]"));
	public static final Elemento REGISTRO_PERDA_INTEGRAL = new Elemento(By.xpath("//*[@id='subAssuntos_0']//span[@class='textocine14'][contains(., 'Sugestão de Perda Integral')]"));
	
	
}
