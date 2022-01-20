package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Tabela;

public class AbasTarefasElementos {

	private AbasTarefasElementos() {
	}
	
	public static final Tabela TAREFAS = new Tabela("//tbody[tr/td[3][span[text()='Tarefa']]]/tr[td[@class='tabela_celula']]");
	public static final Botao BTN_ATUALIZAR = new Botao(By.id("bt_recarregarAbasTarefas"));
	
}
