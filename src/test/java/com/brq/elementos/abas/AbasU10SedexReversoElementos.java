package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Combo;
import com.brq.elementos.Frame;
import com.brq.elementos.Texto;

public class AbasU10SedexReversoElementos {

	private AbasU10SedexReversoElementos() {}

	public static final Frame FRAME_SEDEX_REVERSO = new Frame(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
	
	public static final Texto TEXTO_SOLICITACAO_AUTORIZACAO = new Texto(By.xpath("//h2[normalize-space(text())='Solicitação de Autorização de Postagem em Agência']"));
	
	public static final Campo INPUT_CEP_DO_REMETENTE = new Campo(By.id("cep1"));
	public static final Campo INPUT_DIGITO_DO_REMETENTE = new Campo(By.id("cep2"));
	public static final Campo INPUT_LOGRADOURO = new Campo(By.id("logradouro"));
	public static final Campo INPUT_NUMERO = new Campo(By.id("numero"));
	public static final Campo INPUT_BAIRRO = new Campo(By.id("bairroLogradouro"));
	public static final Combo COMBO_ESTADO = new Combo(By.id("ufLogradouro"));
	public static final Campo INPUT_COMPLEMENTO = new Campo(By.id("complemento"));
	public static final Campo INPUT_REFERENCIA = new Campo(By.id("referencia"));
	public static final Campo INPUT_CIDADE = new Campo(By.id("cidadeLogradouro"));
	
	public static final Botao BTN_PROSSEGUIR = new Botao(By.xpath("//input[@value='Prosseguir »']"));
	
	public static final Botao BTN_FECHAR = new Botao(By.xpath("//a[contains(@class,'fancybox-close')]"));
	
}
