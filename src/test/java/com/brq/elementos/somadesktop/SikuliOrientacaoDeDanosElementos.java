package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliOrientacaoDeDanosElementos {

	private SikuliOrientacaoDeDanosElementos() {
	}

	private static final @Getter(lazy = true) Pattern tituloOrientacaoDeDanos = new Pattern(
			"titulo_orientacao_de_danos.png").similar(0.9);

	private static final @Getter(lazy = true) Pattern comboAspectoDoDano = fComboAspectoDoDano();
	private static final @Getter(lazy = true) Pattern comboImpregnacao = fComboImpregnacao();
	private static final @Getter(lazy = true) Pattern inputQuilometragem = fInputQuilometragem();
	private static final @Getter(lazy = true) Pattern comboAgrupamento = fComboAgrupamento();
	private static final @Getter(lazy = true) Pattern btnFecharJanela = fBtnFecharJanela();

	private static final @Getter(lazy = true) Pattern janelaIncluirFotoQuilometragem = new Pattern(
			"janela_incluir_foto_quilometragem.png").similar(0.75);

	private static final @Getter(lazy = true) Pattern btnFecharIncluirFotoQuilometragem = fBtnFecharIncluirFotoQuilometragem();
	private static final @Getter(lazy = true) Pattern btnIncluirFotoQuilometragem = fBtnIncluirFotoQuilometragem();

	private static final Pattern fComboAspectoDoDano() {
		return getTituloOrientacaoDeDanos().targetOffset(63, 304);
	}

	private static final Pattern fComboImpregnacao() {
//		78, 354
		return getTituloOrientacaoDeDanos().targetOffset(68, 354);
	}

	private static final Pattern fInputQuilometragem() {
		return getTituloOrientacaoDeDanos().targetOffset(200, 537);
	}

	private static final Pattern fComboAgrupamento() {
		return getTituloOrientacaoDeDanos().targetOffset(167, 590);
	}

	private static final Pattern fBtnFecharJanela() {
		return getTituloOrientacaoDeDanos().targetOffset(313, 0);
	}

	private static final Pattern fBtnFecharIncluirFotoQuilometragem() {
		return getJanelaIncluirFotoQuilometragem().targetOffset(122, -67);
	}

	private static final Pattern fBtnIncluirFotoQuilometragem() {
		return getJanelaIncluirFotoQuilometragem().targetOffset(-19, -12);
	}

}
