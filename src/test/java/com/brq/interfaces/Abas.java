package com.brq.interfaces;

/**
 * Interface para interação com abas.
 * 
 * @author ymnoda
 *
 */
public interface Abas {

	abstract void mudarAba(String nomeDaAba) throws Exception;
	
	abstract String getAbaAtual();

}
