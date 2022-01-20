package com.brq.elementos.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Elemento;
import com.brq.elementos.Tabela;
import com.brq.elementos.Texto;

public class SPAtenderPedidoElementos {

	private SPAtenderPedidoElementos() {
	}

	public static final Tabela LISTA_PEDIDOS_AGUARDANDO_ATENDIMENTO = new Tabela(
			"//tr[td[contains(@class, 'dashboardPaddingTarefas')]]");

	public static final Elemento CRITICIDADE = new Elemento(By.xpath("//span[contains(@id, 'criticidade')]"));
	public static final Texto TXT_INICIO_TAREFA = new Texto(
			By.xpath("//span[text()='Tarefa Iniciada em:']/following::span[1][text()]"));
	public static final Texto TXT_PREVISAO_FINAL_TAREFA = new Texto(
			By.xpath("//span[text()='Prazo Max para conclusão:']/following::span[1][text()]"));

	public static final Texto TXT_NUMERO_SINISTRO = new Texto(
			By.xpath("//span[text()='Número Sinistro']/following::span[1][text()]"));
	public static final Texto TXT_DATA_SOLICITACAO = new Texto(
			By.xpath("//span[text()='Data da Solicitação']/following::span[1][text()]"));
	public static final Texto TXT_NUMERO_PEDIDO = new Texto(
			By.xpath("//span[text()='Número do Pedido']/following::span[1][text()]"));
	public static final Texto TXT_DATA_PEDIDO = new Texto(
			By.xpath("//span[text()='Data do Pedido']/following::span[1][text()]"));
	public static final Texto TXT_MARCA = new Texto(By.xpath("//span[text()='Marca']/following::span[1][text()]"));
	public static final Texto TXT_VEICULO = new Texto(By.xpath("//span[text()='Veículo']/following::span[1][text()]"));
	public static final Texto TXT_MODELO = new Texto(By.xpath("//span[text()='Modelo']/following::span[1][text()]"));
	public static final Texto TXT_PLACA = new Texto(By.xpath("//span[text()='Placa']/following::span[1][text()]"));
	public static final Texto TXT_CHASSI = new Texto(By.xpath("//span[text()='Chassi']/following::span[1][text()]"));
	public static final Texto TXT_ANO = new Texto(By.xpath("//span[text()='Ano']/following::span[1][text()]"));

	public static final Botao BTN_ABRIR_TAREFA = new Botao(By.xpath("//a[contains(@id, 'toggle-button')]"));
	public static final Botao BTN_PDF = new Botao(By.xpath("//a[img[contains(@src, 'pdf_btn.png')]]"));

	public static final Botao BTN_INFORMACOES_OFICINA = new Botao(By.xpath("//input[contains(@id, 'j_id418')]"));

	//new - L.A
	public static final Texto TXT_CNPJ = new Texto(By.xpath("//span[text()='CNPJ: ']/following::span[1][text()]"));
	public static final Texto TXT_RAZAO_SOCIAL = new Texto(By.xpath("//span[text()='Razão Social: ']/following::span[1][text()]"));
	public static final Texto TXT_TIPO_OFICINA = new Texto(By.xpath("//span[text()='Tipo de Oficina: ']/following::span[1]"));
	public static final Texto TXT_ENDERECO = new Texto(By.xpath("//span[text()='Endereço: ']/following::span[1][text()]"));
	public static final Texto TXT_TIPO_VEICULO = new Texto(By.xpath("//span[text()='Tipo Veículo Atendimento: ']/following::span[1][text()]"));
	public static final Texto TXT_TEL_COMERCIAL = new Texto(By.xpath("//span[text()='Telefone Comercial: ']/following::span[1][text()]"));
	public static final Texto TXT_TEL_FAX = new Texto(By.xpath("//span[text()='Telefone Fax: ']/following::span[1][text()]"));
	public static final Texto TXT_EMAIL = new Texto(By.xpath("//span[text()='Email: ']/following::span[1][text()]"));
	public static final Texto TXT_HORARIO_ATEND = new Texto(By.xpath("//span[text()='Horário Atendimento: ']/following::span[1][text()]"));
	public static final Texto TXT_OBSERVACAO = new Texto(By.xpath("//span[text()='Observações: ']/following::span[1]"));


	//
	public static final Botao BTN_CONFIRMAR = new Botao(By.xpath("//input[contains(@id,'formFornecimento:atenderPedidoList') and contains(@name,'confirmDlg')]"));
	public static final Texto TXT_NUMERO_PEDIDO_PECA = new Texto(By.xpath("//table[contains(@id,'panel-pedido')]//span[@class='text_common']"));

}