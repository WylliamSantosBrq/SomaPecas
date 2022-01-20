package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Elemento;
import com.brq.elementos.Frame;
import com.brq.elementos.Tabela;

public class AbasPesquisaSinistroPorNumeroElementos {

	private AbasPesquisaSinistroPorNumeroElementos() {
	}
	
	public static final Frame FRAME_PRINCIPAL = new Frame(By.id("framecentral"));

	public static final Campo INPUT_RAMO = new Campo(By.name("codigoRamoSinistro"));
	public static final Campo INPUT_ANO_SINISTRO = new Campo(By.name("anoSinistro"));
	public static final Campo INPUT_NUMERO_DO_SINISTRO = new Campo(By.name("numeroSinistro"));
	public static final Campo INPUT_ITEM_SINISTRO = new Campo(By.id("item"));
	public static final Botao BTN_PESQUISAR = new Botao(By.xpath("//area[@onclick='pesquisaNumeroSinistro();']"));
	
	public static final Tabela TABLE_RESULTADOS = new Tabela("//table[@class='tabela' and .//span[1][text()='Aviso']]//tr[.//a[1][number(text())>0]]");
	
	public static final Elemento ERRO_NENHUM_AVISO_ENCONTRADO = new Elemento(By.xpath("//span[text()='Não foi encontrado nenhum aviso neste filtro.']"));
	
}
