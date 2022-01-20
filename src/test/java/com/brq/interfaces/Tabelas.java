package com.brq.interfaces;

import java.util.List;
import java.util.Map;

import com.brq.interfaces.log.BRQLogger;

public interface Tabelas {

	abstract void clicarCelula(String tabela, int linha, String coluna);
	
	abstract void clicarCelula(String tabela, String linha, String coluna);

	abstract void preencherCelula(String tabela, int linha, String coluna, Object valor);
	
	abstract void preencherCelula(String tabela, String linha, String coluna, Object valor);
	
	abstract void preencherColuna(String tabela, String coluna, List<Object> valores);
	
	abstract void preencherLinha(String tabela, String linha, Map<String, Object> valores);
	
	abstract void preencherLinha(String tabela, int linha, Map<String, Object> valores);
	
	abstract void preencherLinhas(String tabela, List<Map<String, Object>> valores);

	abstract void validarCelula(String tabela, int linha, String coluna, Object valorEsperado);
	
	abstract void validarCelula(String tabela, String linha, String coluna, Object valorEsperado);
	
	abstract void validarCampo(String tabela, String campo);

	default void validarCamposPreenchidos(String tabela, List<String> celulasEsperadas) {
		BRQLogger.logMethod(tabela, celulasEsperadas);
		
		for (String campo: celulasEsperadas) {
			validarCampoPreenchido(tabela, campo);
		}
	}
	
	abstract void validarCampoPreenchido(String tabela, String campo);
	
	default void validarCelulas(String tabela, List<String> celulasEsperadas) {
		BRQLogger.logMethod(tabela, celulasEsperadas);
		
		for (String campo: celulasEsperadas) {
			validarCampo(tabela, campo);
		}
	}
	
	default void validarCelulas(String tabela, Map<String, String> mapsValoresEsperados) {
		BRQLogger.logMethod(tabela, mapsValoresEsperados);
		
		for (String campo: mapsValoresEsperados.keySet()) {
			validarCelula(tabela, 0, campo, mapsValoresEsperados.get(campo));
		}
	}
	
	abstract void validarColuna(String tabela, String coluna, List<Object> valoresEsperados);
	
	abstract void validarLinha(String tabela, String linha, Map<String, Object> valoresEsperados);
	
	abstract void validarLinha(String tabela, int linha, Map<String, Object> valoresEsperados);
	
	abstract void validarLinhas(String tabela, List<Map<String, Object>> valoresEsperados);
	
}
