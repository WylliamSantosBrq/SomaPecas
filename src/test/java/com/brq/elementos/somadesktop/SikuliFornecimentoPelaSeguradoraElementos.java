package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliFornecimentoPelaSeguradoraElementos {

	private SikuliFornecimentoPelaSeguradoraElementos() {}
	
	private static final @Getter(lazy=true) Pattern tituloFornecimentoPelaSeguradora = new Pattern("titulo_marcacao_de_pecas_de_fornecimento_pela_seguradora.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern inputJustificativa = fInputJustificativa();
	private static final @Getter(lazy=true) Pattern checkboxManterJustificativa = fCheckboxManterJustificativa();
	private static final @Getter(lazy=true) Pattern btnSalvar = fBtnSalvar();
	private static final @Getter(lazy=true) Pattern btnCancelar = fBtnCancelar();
	
	private static final Pattern fInputJustificativa() {
		return getTituloFornecimentoPelaSeguradora().targetOffset(0,200);
	}
	
	private static final Pattern fCheckboxManterJustificativa() {
		return getTituloFornecimentoPelaSeguradora().targetOffset(446-591, 460-204);
	}
	
	private static final Pattern fBtnSalvar() {
		return getTituloFornecimentoPelaSeguradora().targetOffset(467-591, 501-204);
	}
	
	private static final Pattern fBtnCancelar() {
		return getTituloFornecimentoPelaSeguradora().targetOffset(534-591, 500-204);
	}
	
}
