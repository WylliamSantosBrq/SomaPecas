package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Texto;

public class AbasGeracaoDeCartasEmPdfElementos {

	private AbasGeracaoDeCartasEmPdfElementos() {
	}

	public static final Texto TEXTO_GERACAO_DE_CARTAS_EM_PDF = new Texto(
			By.xpath("//span[text()='Geração de Cartas em PDF']"));

	public static final Campo TEXTAREA_DATA = new Campo(By.id("idInput0_10001"));
	public static final Campo TEXTAREA_APOLICE = new Campo(By.id("idInput0_10005"));
	public static final Campo TEXTAREA_ITEM = new Campo(By.id("idInput0_10006"));
	public static final Campo TEXTAREA_SUC = new Campo(By.id("idInput0_10007"));
	public static final Campo TEXTAREA_VEICULO = new Campo(By.id("idInput0_10009"));
	public static final Campo TEXTAREA_MODELO = new Campo(By.id("idInput0_10011"));
	public static final Campo TEXTAREA_SINISTRO_1 = new Campo(By.id("idInput0_10014"));
	public static final Campo TEXTAREA_SINISTRO_2 = new Campo(By.id("idInput0_10015"));
	public static final Campo TEXTAREA_SINISTRO_3 = new Campo(By.id("idInput0_10016"));
	public static final Campo TEXTAREA_CORRETORA = new Campo(By.id("idInput0_10018"));
	public static final Campo TEXTAREA_SUSEP = new Campo(By.id("idInput0_10019"));

	public static final Botao BTN_VISUALIZAR_CARTA = new Botao(By.name("btnVisualizar"));
	public static final Botao BTN_ENVIAR_PARA_APROVACAO = new Botao(By.name("btnEnviarParaAprovacao"));

}
