package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliMenuLateralElementos {
	private final static @Getter(lazy=true) Pattern btnObterVistorias = new Pattern("btn_obter_vistorias.png").similar(0.90);
}
