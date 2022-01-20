package com.brq.elementos.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Texto;

public class SPHistoricoPedidoElementos {

	public static final Botao BTN_PEDIDO = new Botao(
			By.xpath("//a[contains(@id,'formFornecimento:atenderPedidoList')]"));


    //Historico de Pedido
    public static final Texto TXT_DATA = new Texto(By.xpath("//th//span[text()='Data']//ancestor-or-self::tbody//td/span[contains(text(),'/')]"));
    public static final Texto TXT_FLUXO = new Texto(By.xpath("//th//span[text()='Fluxo']//ancestor-or-self::tbody//td[2]/span"));
    public static final Texto TXT_RESPONSAVEL = new Texto(By.xpath("//th//span[text()='Responsável']//ancestor-or-self::tbody//td[3]/span"));
    public static final Texto TXT_DETALHE = new Texto(By.xpath("//th//span[text()='Detalhe']"));

    //Historico Peça
    public static final Texto TXT_DATA_PECA = new Texto(By.xpath("//table[@id='historicoPecaModalContentTable']//th//span[text()='Data']//ancestor-or-self::tbody//td/span[contains(text(),'/') ]"));
    public static final Texto TXT_DESCRICAO_PECA = new Texto(By.xpath("//th//span[text()='Descrição']//ancestor-or-self::tbody//td[2]/span"));
    public static final Texto TXT_DETALHES_PECA = new Texto(By.xpath("//table[@id='historicoPecaModalContentTable']//th//span[text()='Detalhe']"));
    public static final Texto TXT_MOTIVO_PECA = new Texto(By.xpath("//table[@id='historicoPecaModalContentTable']//th//span[text()='Motivo']"));
    public static final Texto TXT_RESPONSAVEL_PECA = new Texto(By.xpath("//table[@id='historicoPecaModalContentTable']//th//span[text()='Responsável']"));
}
