package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliPesquisaVistoriasElementos {
	private static final @Getter(lazy = true) Pattern btnFiltrarPor = new Pattern("btn_filtrar_por.png").similar(0.45);

	private static final @Getter(lazy = true) Pattern janelaPesquisaVistoria = new Pattern(
			"titulo_filtro_de_vistorias.png").similar(0.9);

	private static final @Getter(lazy = true) Pattern checkboxNSinistro = fCheckboxNSinistro();
	private static final @Getter(lazy = true) Pattern checkboxOficina = fCheckboxOficina();
	private static final @Getter(lazy = true) Pattern checkboxVeiculo = fCheckboxVeiculo();
	private static final @Getter(lazy = true) Pattern checkboxPlaca = fCheckboxPlaca();
	private static final @Getter(lazy = true) Pattern checkboxData = fCheckboxData();
	private static final @Getter(lazy = true) Pattern checkboxEmpresa = fCheckboxEmpresa();
	private static final @Getter(lazy = true) Pattern checkboxStatus = fCheckboxStatus();

	private static final @Getter(lazy = true) Pattern inputNSinistro = fInputNSinistro();
	private static final @Getter(lazy = true) Pattern inputOficina = fInputOficina();
	private static final @Getter(lazy = true) Pattern inputVeiculo = fInputVeiculo();
	private static final @Getter(lazy = true) Pattern inputPlaca = fInputPlaca();
	private static final @Getter(lazy = true) Pattern inputData = fInputData();
	private static final @Getter(lazy = true) Pattern inputEmpresa = fInputEmpresa();
	private static final @Getter(lazy = true) Pattern inputStatus = fInputStatus();

	private static final @Getter(lazy = true) Pattern btnPesquisar = fBtnPesquisar();

	private static final @Getter(lazy = true) Pattern itemPrimeiraVistoria = fItemPrimeiraVistoria();
	
	private static final @Getter(lazy = true) Pattern iconeSinistroNaoUsado = new Pattern("icone_sinistro_nao_aberto.png").similar(0.99);

	private static final Pattern fCheckboxNSinistro() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 25);
	}

	private static final Pattern fCheckboxOficina() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 48);
	}

	private static final Pattern fCheckboxVeiculo() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 71);
	}

	private static final Pattern fCheckboxPlaca() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 94);
	}

	private static final Pattern fCheckboxData() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 117);
	}

	private static final Pattern fCheckboxEmpresa() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 140);
	}

	private static final Pattern fCheckboxStatus() {
		return getJanelaPesquisaVistoria().targetOffset(-38, 163);
	}

	private static final Pattern fInputNSinistro() {
		return getJanelaPesquisaVistoria().targetOffset(100, 25);
	}

	private static final Pattern fInputOficina() {
		return getJanelaPesquisaVistoria().targetOffset(100, 48);
	}

	private static final Pattern fInputVeiculo() {
		return getJanelaPesquisaVistoria().targetOffset(100, 71);
	}

	private static final Pattern fInputPlaca() {
		return getJanelaPesquisaVistoria().targetOffset(100, 94);
	}

	private static final Pattern fInputData() {
		return getJanelaPesquisaVistoria().targetOffset(100, 117);
	}

	private static final Pattern fInputEmpresa() {
		return getJanelaPesquisaVistoria().targetOffset(100, 140);
	}

	private static final Pattern fInputStatus() {
		return getJanelaPesquisaVistoria().targetOffset(100, 163);
	}

	private static final Pattern fBtnPesquisar() {
		return getJanelaPesquisaVistoria().targetOffset(75, 198);
	}

	private static final Pattern fItemPrimeiraVistoria() {
		return getBtnFiltrarPor().targetOffset(500, 0);
	}

}
