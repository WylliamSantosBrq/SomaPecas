package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Elemento;
import com.brq.elementos.Texto;

public class AbasSiasiOnlineElementos {

	private AbasSiasiOnlineElementos() {
	}

	public static final Texto LABEL_RESULTADO_DA_ANALISE = new Texto(By.xpath("//h2[text()='Resultado da Análise']"));
	public static final Texto LABEL_MENSAGENS = new Texto(By.xpath("//h2[text()='Mensagens']"));
	public static final Texto TXT_RESULTADO_DA_ANALISE = new Texto(By.xpath("//div[@id='table_termometro']/span"));
	
	public static final Botao BTN_OBTER_INFORMACOES_ATUALIZADAS = new Botao(By.id("btNovaAnalise"));
	
	public static final Elemento LOADING_INFORMACOES_ATUALIZADAS = new Elemento(By.xpath("//img[@src='visual/images/loading.gif']/following::span[text()='Executando nova análise de risco...']"));

}
