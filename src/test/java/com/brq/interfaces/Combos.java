package com.brq.interfaces;

import java.util.Map;

public interface Combos {

	abstract void selecionarCombo(String combo, String opcao);

	abstract void selecionarCombos(Map<String, String> mapValores);

	abstract void limparCombo();

	abstract void limparCombo(String combo);

	abstract void validarDadosCombo(String textoCombo, String textoComboFinal);

}
