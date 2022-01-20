package com.brq.interfaces;

import java.util.List;
import java.util.Map;

import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para interações com campos do sistema.
 * 
 * @author ymnoda
 *
 */
public interface Campos {

	abstract void preencherCampo(String campo, String valor);

	default void preencherCampos(Map<String, String> mapValores) {
		BRQLogger.logMethod(mapValores);
		
		for (String campo: mapValores.keySet())
			preencherCampo(campo, mapValores.get(campo));
	}

	abstract void limparCampo();
	
	abstract void limparCampo(String campo);

	abstract void preencherCampos(String campos, String valor);
	
	default void validarCampos(Map<String, Object> mapValoresEsperados) {
		BRQLogger.logMethod(mapValoresEsperados);
		
		for (String campo: mapValoresEsperados.keySet()) 
			validarCampo(campo, mapValoresEsperados.get(campo));
	}
	default void validarCamposPreenchidos(List<String> listCamposEsperados) {
		BRQLogger.logMethod(listCamposEsperados);
		
		for (String campo: listCamposEsperados)
			validarCampoPreenchido(campo);
	}
	
	abstract void validarCampo(String campo, Object valorEsperado);

	abstract void validarCampoPreenchido(String campo);

	default void validarCamposDisponiveis(List<String> campos) {
		BRQLogger.logMethod(campos);
		
		for (String campo : campos) {
			validarCampoDisponivel(campo);
		}
	}

	abstract void validarCampoDisponivel(String campo);
	
}
