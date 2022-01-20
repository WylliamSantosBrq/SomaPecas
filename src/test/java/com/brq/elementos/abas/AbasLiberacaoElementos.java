package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Combo;

public class AbasLiberacaoElementos {

	private AbasLiberacaoElementos() {
	}
		
	public static final Combo COMBO_PROXIMA_ACAO = new Combo(By.xpath("//span[contains(text(), 'Próxima ação')]/following::select[1]"));
	public static final Combo COMBO_RAZAO_DA_LIBERACAO = new Combo(By.xpath("//span[contains(text(), 'Razão da liberação')]/following::select[1]"));
	public static final Combo COMBO_RESTRICAO = new Combo(By.xpath("//span[contains(text(), 'Restrição')]/following::select[1]"));

	public static final Botao BTN_CONCLUIR_ANALISE = new Botao(By.xpath("//input[@value='Concluir análise']"));
	public static final Botao BTN_LIBERAR_SINISTRO = new Botao(By.xpath("//input[@value='Liberar Sinistro']"));
	
	public static final Campo OUTPUT_VALOR_A_LIBERAR = new Campo(By.xpath("//*[@id='dadosLiberacao']//td[contains(., 'Valor a liberar')]/following::input[1]"));
}
