package com.brq.interfaces.dados;

import java.lang.reflect.Field;

import com.brq.erros.ErroInesperado;

/**
 * Interface que permite que a classe que implemente ela possa resetar suas
 * variáveis.
 * 
 * @implSpec Todas as váriaveis da classe devem ser sub-tipos de Object,
 *           apresentando erro ao tentar manipular primitivos.
 * 
 * @author ymnoda
 */
public interface Resetable {

	/**
	 * Define todas as variáveis da classe para {@code null}.
	 */
	default void reset() {
		for (Field field : getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				field.set(null, null);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new ErroInesperado(e, "Ocorreu um erro ao resetar os com.brq.dados de evidências.");
			} finally {
				field.setAccessible(false);
			}
		}
	}

}
