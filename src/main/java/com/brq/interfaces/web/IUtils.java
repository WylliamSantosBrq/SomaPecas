package com.brq.interfaces.web;

import java.io.File;

import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos utilitários.
 */
public interface IUtils {

	/**
	 * Cria a pasta no diretário se não existir.
	 * 
	 * @param pasta
	 */
	default void diretorioExiste(String pasta) {
		BRQLogger.logMethod(pasta);

		File file = new File(pasta);
		if (!file.exists()) {
			file.mkdir();
		}
	}
}
