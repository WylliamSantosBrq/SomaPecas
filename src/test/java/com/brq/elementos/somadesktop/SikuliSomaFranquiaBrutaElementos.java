package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliSomaFranquiaBrutaElementos {

	private SikuliSomaFranquiaBrutaElementos() {

	}

	private static final @Getter(lazy = true) Pattern tituloSomaFranquiaBruta = new Pattern(
			"titulo_soma_franquia_bruta.png").similar(0.9);

	private static final @Getter(lazy = true) Pattern btnOk = fBtnOk();

	private static final Pattern fBtnOk() {
		return getTituloSomaFranquiaBruta().targetOffset(-508, -253);
	}

}
