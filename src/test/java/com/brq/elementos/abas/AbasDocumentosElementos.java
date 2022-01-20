package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Combo;

public class AbasDocumentosElementos {

	private AbasDocumentosElementos() {
	}

	public static final Botao BTN_NOVA_SOLICITACAO_DE_DOCUMENTOS = new Botao(By.id("botaoNovaSolicitacao"));
	
	public static final Combo COMBO_DE_DOCUMENTOS = new Combo(By.id("comboOperacao"));
	
	public static final Botao BTN_CONCLUIR_SOLICITACAO_DE_DOCUMENTOS = new Botao(By.xpath("//button[span[text()='Concluir solicitação de documentos']]"));
	
	public static final Botao BTN_SOLICITAR_TAREFAS = new Botao(By.id("tarefaAutomatica"));
	
}
