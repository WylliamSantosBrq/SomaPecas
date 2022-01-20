package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliTabelaOrcamentoPecas {

	private SikuliTabelaOrcamentoPecas() {
	}

	private static final @Getter(lazy = true) Pattern checkboxDesmarcado = new Pattern(
			"checkbox_desmarcado.png").similar(0.99);
	private static final @Getter(lazy = true) Pattern checkboxMarcado = new Pattern("checkbox_marcado.png")
			.similar(0.99);

	private static final @Getter(lazy = true) Pattern tituloJustificativa = SikuliFornecimentoPelaSeguradoraElementos
			.getTituloFornecimentoPelaSeguradora();
	private static final @Getter(lazy = true) Pattern inputJustificativa = fInputJustificativa();
	private static final @Getter(lazy = true) Pattern btnSalvar = fBtnSalvar();

	private static final @Getter(lazy = true) Pattern textoPeca1 = new Pattern("texto_peca_1.png")
			.similar(0.95);

	private static final @Getter(lazy=true) Pattern headerTrocar = new Pattern("header_trocar.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerRecupRestaurar = new Pattern("header_recup_restaurar.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerMD = new Pattern("header_m_d.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerRef = new Pattern("header_ref.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerCodigoDaPeca = new Pattern("header_codigo_da_peca.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerDescricaoDaPeca = new Pattern("header_descricao_da_peca.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerQtde = new Pattern("header_qtde.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerValorBruto = new Pattern("header_valor_bruto.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerDesc = new Pattern("header_desc.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerValorLiquido = new Pattern("header_valor_liquido.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerMO = new Pattern("header_m_o.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerPintura = new Pattern("header_pintura.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerOverlap = new Pattern("header_overlap.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerFornec = new Pattern("header_fornec.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern headerDeletar = new Pattern("header_deletar.png").similar(0.9);
	
	private static final Pattern fInputJustificativa() {
//		TODO
		return getTituloJustificativa().targetOffset(0, 0);
	}

	private static final Pattern fBtnSalvar() {
//		TODO
		return getTituloJustificativa().targetOffset(0, 0);
	}

}
