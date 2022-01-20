package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliAbaPecasElementos {

	private SikuliAbaPecasElementos() {

	}

	private static final @Getter(lazy = true) Pattern abaAtiva = new Pattern("").similar(0.9);
	private static final @Getter(lazy = true) Pattern miniaturaCroqui = new Pattern("miniatura_croqui.png")
			.similar(0.9);

	private static final @Getter(lazy = true) Pattern btnOutrasAcoes = new Pattern("btn_outras_acoes.png").similar(0.7);

	private static final @Getter(lazy = true) Pattern menuServicosDeTerceiros = fMenuServicosDeTerceiros();
	private static final @Getter(lazy = true) Pattern menuIndicesDeDesconto = fMenuIndicesDeDesconto();
	private static final @Getter(lazy = true) Pattern menuLaudoDeInspecao = fMenuLaudoDeInspecao();
	private static final @Getter(lazy = true) Pattern menuLCD = fMenuLCD();
	private static final @Getter(lazy = true) Pattern menuPecasManuais = fMenuPecasManuais();
	private static final @Getter(lazy = true) Pattern menuTotalizacao = fMenuTotalizacao();
	private static final @Getter(lazy = true) Pattern menuCompararOrcamentos = fMenuCompararOrcamentos();
	private static final @Getter(lazy = true) Pattern menuCopiaPecaWebSoma = fMenuCopiaPecaWebSoma();
	private static final @Getter(lazy = true) Pattern menuCopicaPecaComputador = fMenuCopiaPecaComputador();
	private static final @Getter(lazy = true) Pattern menuQuestionarioPadrao = fMenuQuestionarioPadrao();
	private static final @Getter(lazy = true) Pattern menuAlterarDescontoDaFranquia = fMenuAlterarDescontoDaFranquia();
	private static final @Getter(lazy = true) Pattern menuOrcamentoFechadoAcordo = fMenuOrcamentoFechadoAcordo();

	private static final @Getter(lazy = true) Pattern tituloInfo = new Pattern("titulo_info.png").similar(0.9);
	private static final @Getter(lazy = true) Pattern btnInfoOk = fBtnInfoOk();

	private static final Pattern fMenuServicosDeTerceiros() {
		return getBtnOutrasAcoes().targetOffset(0, 24);
	}

	private static final Pattern fMenuIndicesDeDesconto() {
		return getBtnOutrasAcoes().targetOffset(0, 48);
	}

	private static final Pattern fMenuLaudoDeInspecao() {
		return getBtnOutrasAcoes().targetOffset(0, 72);
	}

	private static final Pattern fMenuLCD() {
		return getBtnOutrasAcoes().targetOffset(0, 96);
	}

	private static final Pattern fMenuPecasManuais() {
		return getBtnOutrasAcoes().targetOffset(0, 120);
	}

	private static final Pattern fMenuTotalizacao() {
		return getBtnOutrasAcoes().targetOffset(0, 144);
	}

	private static final Pattern fMenuCompararOrcamentos() {
		return getBtnOutrasAcoes().targetOffset(0, 168);
	}

	private static final Pattern fMenuCopiaPecaWebSoma() {
		return getBtnOutrasAcoes().targetOffset(0, 192);
	}

	private static final Pattern fMenuCopiaPecaComputador() {
		return getBtnOutrasAcoes().targetOffset(0, 216);
	}

	private static final Pattern fMenuQuestionarioPadrao() {
		return getBtnOutrasAcoes().targetOffset(0, 240);
	}

	private static final Pattern fMenuAlterarDescontoDaFranquia() {
		return getBtnOutrasAcoes().targetOffset(0, 264);
	}

	private static final Pattern fMenuOrcamentoFechadoAcordo() {
		return getBtnOutrasAcoes().targetOffset(0, 288);
	}

	private static final Pattern fBtnInfoOk() {
		return getTituloInfo().targetOffset(682 - 427, 394 - 317);
	}

}
