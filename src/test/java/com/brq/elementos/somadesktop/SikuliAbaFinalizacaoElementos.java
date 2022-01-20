package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliAbaFinalizacaoElementos {

	private SikuliAbaFinalizacaoElementos() {}
	
	private static final @Getter(lazy = true) Pattern btnSalvarETransmitir = new Pattern("btn_salvar_e_transmitir.png").similar(0.9);
	
}
