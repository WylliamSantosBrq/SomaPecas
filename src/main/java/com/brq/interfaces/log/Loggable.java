package com.brq.interfaces.log;

import java.lang.reflect.Field;

import com.brq.erros.ErroInesperado;

/**
 * Interface para documentar no log todos os campos de uma classe.
 * 
 * @author ymnoda
 *
 */
public interface Loggable {
	default void logAllFields() {

		for (Field variavel : getClass().getDeclaredFields()) {
			try {
				String name = variavel.getName();
				Object value = variavel.get(null);

				BRQLogger.info(String.format("%s: %s;", name, value));

			} catch (IllegalArgumentException e) {
				throw new ErroInesperado("Objeto ilegal usado para obter valor da variável [%s].", variavel.getName());

			} catch (IllegalAccessException e) {
				try {
					variavel.setAccessible(true);

					String name = variavel.getName();
					Object value = variavel.get(null);

					BRQLogger.info(String.format("%s: %s;", name, value));
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					String.format("Argumento ilegal à variável [%s].", variavel.getName());
				} finally {
					variavel.setAccessible(false);
				}
			} catch (NullPointerException e) {
				BRQLogger.info(String.format("%s: null;", variavel.getName()));
			}
		}
	}
}
