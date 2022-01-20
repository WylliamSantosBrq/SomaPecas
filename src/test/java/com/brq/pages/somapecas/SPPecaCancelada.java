package com.brq.pages.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.somapecas.SPAtenderPedidoElementos;
import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPPecaCanceladaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class SPPecaCancelada extends Pagina implements Pesquisa {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
//
//		switch (botao) {
//		
//		default:
//			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
//		}
	}
	
	@Override
	public void pesquisar(String nPedido) {
		BRQLogger.logMethod(String.format("Localizando Pedido Nº: %s", nPedido));
		try {
	        SPCarregamentoElementos.GIF_CARREGAMENTO//
	                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
	                .esperarMilisegundos(300);
	
	        SPPecaCanceladaElementos.LISTA_PECAS_CANCELADAS//
	                .getLinha(0)//
	                .get(String.format("//td[@class= 'dashboardTarefasColumn1']/table/tbody/tr[2]/td/span[text() = '%s']", nPedido))
	                .esperarExistir(DEFAULT_STEPS_TIMEOUT);
	        
		} catch (Exception e) {
	        	throw new ErroValidacao (String.format("Não Encontrado pedido com Numero de Sinistro %s ", nPedido));	
		  }
	}
	
	public void validarPecas(String nPedido) {
		BRQLogger.logMethod(String.format("Validando Peças do Pedido Nº: %s", nPedido));
		
		try {
	        SPCarregamentoElementos.GIF_CARREGAMENTO//
	                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
	                .esperarMilisegundos(300);
	
	        SPPecaCanceladaElementos.LISTA_PECAS_CANCELADAS//
	                .getLinha(0)//
	                .get(String.format("//td[@class= 'dashboardTarefasColumn1']/table/tbody/tr[2]/td/span[text() = '%s']", nPedido))
	                .esperarExistir(DEFAULT_STEPS_TIMEOUT);
	        
	        Botao btn = new Botao(By.xpath(String.format("//td[@class= 'dashboardTarefasColumn1']/table/tbody/tr[2]/td/span[text() = '%s']/../../../../../../../../../../../../../../.././tr[2]/td/a", nPedido)));
	        btn.moverJavascript();
	        btn.clicar();
	        
		} catch (Exception e) {
	        	throw new ErroValidacao (String.format("Não Encontrado pedido com Numero de Sinistro %s ", nPedido));	
		  }
		
		try {
			SPCarregamentoElementos.GIF_CARREGAMENTO//
            .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
            .esperarMilisegundos(300);
			
			SPPecaCanceladaElementos.LISTA_PEDIDOS_CANCELADOS//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT);
			
		} catch (Exception e) {
    		throw new ErroValidacao ("Não encontrado nenhum Pedido Cancelado");	
		 }

	}
}

		
