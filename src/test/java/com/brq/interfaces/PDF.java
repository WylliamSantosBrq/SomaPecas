package com.brq.interfaces;

import java.util.List;
import java.util.Map;

public interface PDF {

	abstract void validarPdfEmTela();

	abstract void validarDados(List<String> dados);

	abstract void validarDados(Map<String, String> dadosEsperados);

}
