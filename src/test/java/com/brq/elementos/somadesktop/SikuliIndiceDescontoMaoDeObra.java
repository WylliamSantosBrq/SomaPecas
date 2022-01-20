package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliIndiceDescontoMaoDeObra {

	private SikuliIndiceDescontoMaoDeObra() {
	}

	private static final @Getter(lazy = true) Pattern msgCadastroIndiceDescontoSalvo = new Pattern(
			"msg_cadastro_de_indice_de_desconto_salvo_com_sucesso.png").similar(0.9);
	private static final @Getter(lazy = true) Pattern btnOkMsgCadastroIndiceDescontoSalvo = fBtnOkMsgCadastroIndiceDescontoSalvo();

	private static final @Getter(lazy = true) Pattern tituloIndiceDeDescontoEMaoDeObra = new Pattern(
			"titulo_indice_de_desconto_e_mao_de_obra.png").similar(0.9);

	private static final @Getter(lazy = true) Pattern btnSalvar = new Pattern("btn_salvar.png").similar(0.9);

	private static final @Getter(lazy = true) Pattern inputIDPFunilaria = fInputIDPFunilaria();
	private static final @Getter(lazy = true) Pattern inputIDPMecanica = fInputIDPMecanica();
	private static final @Getter(lazy = true) Pattern inputIDPTapecaria = fInputIDPTapecaria();
	private static final @Getter(lazy = true) Pattern inputIDPAcabamento = fInputIDPAcabamento();
	private static final @Getter(lazy = true) Pattern inputIDPEletrica = fInputIDPEletrica();

	private static final @Getter(lazy = true) Pattern inputVMOFunilariaT = fInputVMOFunilariaT();
	private static final @Getter(lazy = true) Pattern inputVMOMecanicaT = fInputVMOMecanicaT();
	private static final @Getter(lazy = true) Pattern inputVMOTapecariaT = fInputVMOTapecariaT();
	private static final @Getter(lazy = true) Pattern inputVMOAcabamentoT = fInputVMOAcabamentoT();
	private static final @Getter(lazy = true) Pattern inputVMOEletricaT = fInputVMOEletricaT();
	private static final @Getter(lazy = true) Pattern inputVMOPinturaT = fInputVMOPinturaT();

	private static final @Getter(lazy = true) Pattern inputVMOFunilariaM = fInputVMOFunilariaM();
	private static final @Getter(lazy = true) Pattern inputVMOMecanicaM = fInputVMOMecanicaM();
	private static final @Getter(lazy = true) Pattern inputVMOTapecariaM = fInputVMOTapecariaM();
	private static final @Getter(lazy = true) Pattern inputVMOAcabamentoM = fInputVMOAcabamentoM();
	private static final @Getter(lazy = true) Pattern inputVMOEletricaM = fInputVMOEletricaM();

	private static final @Getter(lazy = true) Pattern inputVMOFunilariaR = fInputVMOFunilariaR();
	private static final @Getter(lazy = true) Pattern inputVMOMecanicaR = fInputVMOMecanicaR();
	private static final @Getter(lazy = true) Pattern inputVMOTapecariaR = fInputVMOTapecariaR();
	private static final @Getter(lazy = true) Pattern inputVMOAcabamentoR = fInputVMOAcabamentoR();
	private static final @Getter(lazy = true) Pattern inputVMOEletricaR = fInputVMOEletricaR();

	private static final @Getter(lazy = true) Pattern tituloJustifiqueIndiceDesconto = new Pattern(
			"titulo_justifique_alteracao_indice_desconto.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern btnOkJustifiqueIndiceDesconto = fBtnOkJustifiqueIndiceDesconto();
	
	private static final @Getter(lazy=true) Pattern tituloJustifiqueAAlteracao = new Pattern("titulo_justifique_a_alteracao.png").similar(0.9);
	private static final @Getter(lazy=true) Pattern btnContinuarJustifiqueAAlteracao = fBtnContinuarJustifiqueAAlteracao();

	private static Pattern fInputIDPFunilaria() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(52, 91);
	}

	private static Pattern fInputIDPMecanica() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(52, 116);
	}

	private static Pattern fInputIDPTapecaria() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(52, 141);
	}

	private static Pattern fInputIDPAcabamento() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(52, 166);
	}

	private static Pattern fInputIDPEletrica() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(52, 191);
	}

	private static Pattern fInputVMOFunilariaT() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(384, 114);
	}

	private static Pattern fInputVMOMecanicaT() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(384, 143);
	}

	private static Pattern fInputVMOTapecariaT() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(384, 172);
	}

	private static Pattern fInputVMOAcabamentoT() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(384, 201);
	}

	private static Pattern fInputVMOEletricaT() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(384, 230);
	}

	private static Pattern fInputVMOPinturaT() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(384, 259);
	}

	private static Pattern fInputVMOFunilariaR() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(494, 114);
	}

	private static Pattern fInputVMOMecanicaR() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(494, 143);
	}

	private static Pattern fInputVMOTapecariaR() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(494, 172);
	}

	private static Pattern fInputVMOAcabamentoR() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(494, 201);
	}

	private static Pattern fInputVMOEletricaR() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(494, 230);
	}

	private static Pattern fInputVMOFunilariaM() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(604, 114);
	}

	private static Pattern fInputVMOMecanicaM() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(604, 143);
	}

	private static Pattern fInputVMOTapecariaM() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(604, 172);
	}

	private static Pattern fInputVMOAcabamentoM() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(604, 201);
	}

	private static Pattern fInputVMOEletricaM() {
		return getTituloIndiceDeDescontoEMaoDeObra().targetOffset(604, 230);
	}

	private static Pattern fBtnOkMsgCadastroIndiceDescontoSalvo() {
		return getMsgCadastroIndiceDescontoSalvo().targetOffset(0, 25);
	}
	
	private static Pattern fBtnOkJustifiqueIndiceDesconto() {
		return getTituloJustifiqueIndiceDesconto().targetOffset(683-612, 391-320);
	}

	private static Pattern fBtnContinuarJustifiqueAAlteracao() {
		return getTituloJustifiqueAAlteracao().targetOffset(685-525, 464-252);
	}
	
}
