package com.brq.elementos.somapecas;

import com.brq.elementos.Combo;
import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Texto;

public class SPDashBoardElementos {

	private SPDashBoardElementos() {
	}
	public static final Botao BTN_DISTRIBUIR_MANUAL = new Botao(By.xpath("//a[@id='formFornecimento:j_id2138']"));

	public static final Botao BTN_HOME = new Botao(By.xpath("//input[@id = 'j_id4']"));
	public static final Botao BTN_ENTREGAR_PECA_OFICINA = new Botao(By.xpath("//a[@id='formFornecimento:j_id624']"));
	public static final Botao BTN_PECA_CANCELADA = new Botao(By.xpath("//a[@id='formFornecimento:j_id2374']"));
	public static final Botao BTN_PAGAMENTO_MANUAL = new Botao(By.xpath("//a[@id='formFornecimento:j_id1672']"));
	//public static final Botao BTN_ATENDER_PEDIDO = new Botao(
	//		By.xpath("//a[@id='formFornecimento:j_id274']//table[@class='templateLinkPanel']"));
	public static final Botao BTN_ATENDER_PEDIDO = new Botao(By.xpath("//table[@class='templateLinkPanel']//span[text()='ATENDER PEDIDO']"));

	public static final Texto TXT_BEM_VINDO = new Texto(By.xpath("//td/span[text()='Bem-vindo']"));
	public static final Botao BTN_FECHAR_INFO = new Botao(
			By.cssSelector("div#modalInfoLocalSolicitacaoContentDiv form > input[type='image']"));
	public static final Botao BTN_PEDIDO = new Botao(By.xpath(
			"//table[tbody[tr/td[span[contains(normalize-space(text()),'FECHAR TAREFA')]]]]//following::a[contains(@id,'formFornecimento:atenderPedidoList')][1]"//
	));
	public static final Combo CBX_ACAO = new Combo(By.xpath("//select[not(contains(@name,'list-acoes')) and contains(@name,'formFornecimento:atenderPedidoList')]"));
	public static final Combo CBX_PECAS = new Combo(By.xpath("//select[contains(@name,'formFornecimento:atenderPedidoList') and contains(@name,'listPecas:0')]"));
	public static final Combo CBX_MUDANCA = new Combo(By.xpath("//select[contains(@id,'tipo-mudanca')]"));
	public static final Combo CBX_JUSTIFICATIVA = new Combo(By.xpath("//select[contains(@name,'justificativa-recusa')]"));

	public static final Combo PECAS_ALTERADA = new Combo(By.xpath("//select[contains(@id,'formFornecimento:solicitacaoMudancaList')]"));
	public static final Botao BTN_CONFIRMA_ALTERACAO = new Botao(By.xpath("//input[contains(@id,'formFornecimento:solicitacaoMudancaList') and contains(@id,':confirmDlg')]"));
}
