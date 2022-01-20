package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliSituacoesElementos {

	private SikuliSituacoesElementos() {
	}

	private static final @Getter(lazy = true) Pattern tituloSituacoes = new Pattern("titulo_situacoes.png")
			.similar(0.9);
	
}
