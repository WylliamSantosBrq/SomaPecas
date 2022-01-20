package com.brq.elementos.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Elemento;
import com.brq.elementos.Tabela;
import com.brq.elementos.Texto;

public class SPPecaCanceladaElementos {

	private SPPecaCanceladaElementos() {
	}
	
	public static final Tabela LISTA_PECAS_CANCELADAS = new Tabela("//tbody[@id = 'formFornecimento:pecaCanceladaList:tb']");
	public static final Tabela LISTA_PEDIDOS_CANCELADOS = new Tabela("//table [@id = 'formFornecimento:pecaCanceladaList:108812:listPecas1:0:peca-panel']");
}
