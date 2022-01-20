package com.brq.elementos.somapecas;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Elemento;
import org.openqa.selenium.By;

public class SPPesquisaPedidoElementos {

    public static final Campo TXT_PEDIDO = new Campo(By.//
            cssSelector("table[id='formFornecimento:panel-pesquisa'] input[id='formFornecimento:filtro-codigo-pedido']"));

    public static final Botao BTN_PESQUISAR = new Botao(By//
            .cssSelector("table[id='formFornecimento:panel-pesquisa'] input[id='formFornecimento:btn_pesquisa_pedidos']"));

    public static final Elemento TABELA_PEDIDO = new Elemento(By//
            .cssSelector("table.background_detalhes_sinistro_right_top_side"));

}
