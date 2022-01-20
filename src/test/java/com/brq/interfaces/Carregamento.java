package com.brq.interfaces;

/**
 * Interface para métodos de espera do carregamento do sistema.
 * 
 * @author ymnoda
 *
 */
public interface Carregamento {

	abstract void esperarCarregamentoTerminar(int timeout);

}
