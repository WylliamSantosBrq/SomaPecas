package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliAdicaoDePecas {

	private SikuliAdicaoDePecas() {
	}

	private static final @Getter(lazy = true) Pattern tituloAdicaoDePecas = new Pattern("titulo_adicao_de_pecas.png")
			.similar(0.9);

	private static final @Getter(lazy = true) Pattern inputCodigo = fInputCodigo();
	private static final @Getter(lazy = true) Pattern inputDigiteUmaDescricao = fInputDigiteUmaDescricao();
	private static final @Getter(lazy = true) Pattern radioT = fRadioT();
	private static final @Getter(lazy = true) Pattern radioR = fRadioR();
	private static final @Getter(lazy = true) Pattern radioM = fRadioM();
	private static final @Getter(lazy = true) Pattern comboTipoDeUso = fComboTipoDeUso();
	private static final @Getter(lazy = true) Pattern comboTipoDePeca = fComboTipoDePeca();
	private static final @Getter(lazy = true) Pattern inputValorBruto = fInputValorBruto();
	private static final @Getter(lazy = true) Pattern inputDesconto = fInputDesconto();
	private static final @Getter(lazy = true) Pattern inputValorLiquido = fInputValorLiquido();
	private static final @Getter(lazy = true) Pattern inputMO = fInputMO();
	private static final @Getter(lazy = true) Pattern inputPintura = fInputPintura();
	
	private static final @Getter(lazy=true) Pattern btnAdicionar = fBtnAdicionar();

	private static final Pattern fInputCodigo() {
		return getTituloAdicaoDePecas().targetOffset(90, 75);
	}

	private static final Pattern fInputDigiteUmaDescricao() {
		return getTituloAdicaoDePecas().targetOffset(387, 75);
	}

	private static final Pattern fRadioT() {
		return getTituloAdicaoDePecas().targetOffset(410, 75);
	}

	private static final Pattern fRadioR() {
		return getTituloAdicaoDePecas().targetOffset(437, 75);
	}

	private static final Pattern fRadioM() {
		return getTituloAdicaoDePecas().targetOffset(462, 75);
	}

	private static final Pattern fComboTipoDeUso() {
		return getTituloAdicaoDePecas().targetOffset(598, 75);
	}

	private static final Pattern fComboTipoDePeca() {
		return getTituloAdicaoDePecas().targetOffset(727, 75);
	}

	private static final Pattern fInputValorBruto() {
		return getTituloAdicaoDePecas().targetOffset(800, 75);
	}

	private static final Pattern fInputDesconto() {
		return getTituloAdicaoDePecas().targetOffset(871, 75);
	}

	private static final Pattern fInputValorLiquido() {
		return getTituloAdicaoDePecas().targetOffset(941, 75);
	}

	private static final Pattern fInputMO() {
		return getTituloAdicaoDePecas().targetOffset(1009, 75);
	}

	private static final Pattern fInputPintura() {
		return getTituloAdicaoDePecas().targetOffset(1080, 75);
	}

	private static final Pattern fBtnAdicionar() {
		return getTituloAdicaoDePecas().targetOffset(1055, 552);
	}

}
