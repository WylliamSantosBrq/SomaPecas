package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Combo;
import com.brq.elementos.Texto;

public class AbasU10HomeElementos {

	private AbasU10HomeElementos() {}
	
	public static final Botao BTN_DOWNLOAD_RESUMO_AVISO = new Botao(By.xpath("//a[text()='Download do resumo do Aviso']"));
	public static final Botao BTN_MENSAGENS = new Botao(By.xpath("//a[normalize-space(text())='Mensagens (']"));
	public static final Botao BTN_SEDEX_REVERSO = new Botao(By.id("linkSedexReverso"));
	public static final Botao BTN_ATENDIMENTO_ONLINE = new Botao(By.id("linkChat"));
	public static final Combo COMBO_OUTROS_DOCUMENTOS = new Combo(By.id("documentoExtra"));
	public static final Botao BTN_ENVIAR = new Botao(By.id("btEnviarArquivo"));
	public static final Botao BTN_ORCAMENTO_REPARO = new Botao(By.id("btOrcamento"));
	public static final Texto TEXTO_RELATORIO_VERSAO_ORCAMENTO = new Texto(By.xpath("//span[contains(text(),'ORÇAMENTO DETALHADO')]"));
	public static final Botao BTN_REAGENDAR_VISTORIA = new Botao(By.xpath("//input[@value='Reagendar vistoria de sinistro']"));
	public static final Botao BTN_CONSULTA_AVISO = new Botao(By.xpath("//a[contains(text(),'Consultar Aviso')]"));

}
