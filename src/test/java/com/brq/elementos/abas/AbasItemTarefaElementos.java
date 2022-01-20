package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;

public class AbasItemTarefaElementos {

	public static final Botao getBtnFinalizarTarefa(String tarefa) {
		return new Botao(By.xpath(String.format("//tr[td[span[a[text()='%s']]]]//a[contains(@href, 'FINALIZAR')]", tarefa)));
	}
	
}
