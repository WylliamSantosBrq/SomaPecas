package com.brq.elementos.abas;

import com.brq.elementos.Tabela;

public class AbasSolicitacaoDeVistoriaElementos {

	private AbasSolicitacaoDeVistoriaElementos () {}
	
	public static final Tabela VISTORIAS = new Tabela("//td[contains(text(), 'Solicitação de Vistoria de Sinistro de Automóvel')]/following::table[.//td[@class='fundo']//span[contains(text(), 'Vistorias Agendadas')]]//tr[td[@class='tabela_celula']]");
	
}
