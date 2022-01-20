package com.brq.interfaces;

import java.util.Map;

/**
 * Interface para interações de pesquisa no sistema.
 * 
 * @author ymnoda
 *
 */
public interface Pesquisa {

	abstract void pesquisar(String textoParaPesquisar);

	default void selecionarResultado(String resultado) {
	}

	default void selecionarResultado(int indice) {
	}

	default void selecionarPrimeiroResultado() {
	}

	default void filtrarPor(Map<String, String> filtros) {

	}

}
