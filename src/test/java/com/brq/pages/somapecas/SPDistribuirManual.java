package com.brq.pages.somapecas;

import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPDistribuirManualElementos;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class SPDistribuirManual extends Pagina implements Pesquisa{

	@Override
	public void pesquisar(String nSinistro) {
		BRQLogger.logMethod(String.format("Localizando Pedido Nº: %s", nSinistro));
		try {
	        SPCarregamentoElementos.GIF_CARREGAMENTO//
	                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
	                .esperarMilisegundos(300);
	
	        SPDistribuirManualElementos.LISTA_DISTRIBUIR//
	                .getLinha(0)//
	                .get(String.format("//td[@class= 'dashboardTarefasColumn1']/table/tbody/tr[2]/td/span[text() = '%s']", nSinistro))
	                .esperarExistir(DEFAULT_STEPS_TIMEOUT);
	        
		} catch (Exception e) {
	        	throw new ErroValidacao (String.format("Não Encontrado pedido com Numero de Sinistro %s ", nSinistro));	
		  }
	}

}
