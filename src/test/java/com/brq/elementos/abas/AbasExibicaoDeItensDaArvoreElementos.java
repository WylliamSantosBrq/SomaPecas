package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Texto;

public class AbasExibicaoDeItensDaArvoreElementos {

	private AbasExibicaoDeItensDaArvoreElementos() {
	}

	public static final Texto TEXTO_EXIBICAO_DE_ITENS_DA_ARVORE = new Texto(By.xpath("//span[text()='Exibição de Itens da Árvore']"));
	
	public static final Botao MENU_CARTAS = new Botao(By.xpath("//a[text()='CARTAS']"));
	public static final Botao MENU_ANALISE = new Botao(By.xpath("//a[text()='ANÁLISE']"));
	public static final Botao MENU_CARTA_RECUSA = new Botao(By.xpath("//a[text()='Carta Recusa']"));
	public static final Botao MENU_CG_30 = new Botao(By.xpath("//a[starts-with(text(), 'CG 30')]"));
	public static final Botao MENU_INDENIZACAO_INTEGRAL = new Botao(By.xpath("//a[text()='Indenização Integral']"));
	public static final Botao BTN_AGRAVAMENTO = new Botao(By.id("sexibirArvore10"));
	
	public static final Botao MENU_LIQUIDACAO = new Botao(By.xpath("//a[text()='LIQUIDAÇÃO']"));
	public static final Botao MENU_I_I = new Botao(By.xpath("//a[text()='INDENIZAÇÃO INTEGRAL']"));
	public static final Botao MENU_PROGRAMACAO_DE_PAGAMENTO_II_RF = new Botao(By.xpath("//a[text()='PROGRAMAÇÃO DE PAGAMENTO I.I. / RF']"));
	public static final Botao BTN_PROGRAMACAO_REEMBOLSO_GUINCHO_2AVIA_DUT_OUTROS = new Botao(By.xpath("//a[text()='Programação Reembolso (Guincho/2aVia DUT/Outros)']"));

}
