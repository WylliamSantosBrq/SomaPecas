package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Frame;
import com.brq.elementos.Texto;

public class AbasAbaElementos {

	private AbasAbaElementos() {
	}
	
	public static final Frame FRAME_PRINCIPAL = new Frame(By.id("framecentral"));
	
	public static final Texto TXT_ABA_ATUAL = new Texto(By.xpath("//td[contains(@style, 'on.gif')]/span"));

	public static final Botao ABA_TEMPO_ANALISE = new Botao(By.id("contador"));
	public static final Botao ABA_DADOS_BASICOS = new Botao(By.id("dadosbasicos"));
	public static final Botao ABA_LOCAL = new Botao(By.id("localocorrencia"));
	public static final Botao ABA_QUESTIONARIO = new Botao(By.id("questionario"));
	public static final Botao ABA_VITIMA = new Botao(By.id("vitima"));
	public static final Botao ABA_APOLICE = new Botao(By.id("apolice"));
	public static final Botao ABA_NOTAS = new Botao(By.id("notas"));
	public static final Botao ABA_HISTORICO = new Botao(By.id("historico"));
	public static final Botao ABA_TAREFAS = new Botao(By.id("tarefas"));
	public static final Botao ABA_SIASI_ONLINE = new Botao(By.id("siasi"));
	public static final Botao ABA_LOCALIZACAO = new Botao(By.id("localizacao"));
	public static final Botao ABA_DOCUMENTOS = new Botao(By.id("documentos"));
	public static final Botao ABA_MOVIMENTOS = new Botao(By.id("movimentos"));
	public static final Botao ABA_OCORRENCIAS = new Botao(By.id("ocorrencias"));
	public static final Botao ABA_LIBERACAO = new Botao(By.id("liberacao"));
	public static final Botao ABA_SEGURADO = new Botao(By.id("segurado"));
	public static final Botao ABA_CAUSADOR = new Botao(By.id("causador"));

}
