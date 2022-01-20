package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliCroquiPecasElementos {

	private SikuliCroquiPecasElementos() {
	};

	private static final @Getter(lazy = true) Pattern croquiCapuzMotor = fCroquiCapuzMotor();
	private static final @Getter(lazy = true) Pattern croquiConfiguracoes = fCroquiConfiguracoes();

	private static final Pattern fCroquiCapuzMotor() {
		return SikuliAbaPecasElementos.getBtnOutrasAcoes().targetOffset(122, 130);
	}
	
	private static final Pattern fCroquiConfiguracoes() {
		return SikuliAbaPecasElementos.getBtnOutrasAcoes().targetOffset(174, 35);
	}

}
