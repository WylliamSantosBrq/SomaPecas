package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliSituacoesVistoriaElementos {

	private SikuliSituacoesVistoriaElementos() {
	}

	private static final @Getter(lazy = true) Pattern tituloSituacoesVistoria = new Pattern(
			"titulo_situacoes_vistoria.png").similar(0.9);
	
	private static final @Getter(lazy = true) Pattern btnSim = fBtnSim();
	private static final @Getter(lazy = true) Pattern btnNao = fBtnNao();

	private static final Pattern fBtnSim() {
		return getTituloSituacoesVistoria().targetOffset(655-427, 287-219);
	}

	private static final Pattern fBtnNao() {
		return getTituloSituacoesVistoria().targetOffset(708-427, 287-219);
	}

}
