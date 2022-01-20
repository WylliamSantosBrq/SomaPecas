package com.brq.elementos.chrome;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliChromeElementos {
	
	private static final @Getter(lazy=true) Pattern inputChromeURLBar = new Pattern("input_chrome_url_bar.png").similar(0.95);
	private static final @Getter(lazy=true) Pattern validacaoChromeAberto = new Pattern("validacao_chrome_aberto.png").similar(0.95);
}
