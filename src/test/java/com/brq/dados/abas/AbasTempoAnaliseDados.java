package com.brq.dados.abas;

import com.brq.interfaces.dados.Resetable;
import com.brq.interfaces.log.Loggable;

import lombok.Getter;
import lombok.Setter;

public class AbasTempoAnaliseDados implements Resetable, Loggable {

	private static @Getter @Setter String dataAvisoSinistro = null;
	private static @Getter @Setter String qtdeDiasEncerrado = null;
	private static @Getter @Setter String qtdeDiasAguardandoVistoria = null;
	private static @Getter @Setter String qtdeDiasAguardandoDocumento = null;
	private static @Getter @Setter String dataConclusaoSinistro = null;
	private static @Getter @Setter String tempoTotalRegulacaoSinistro = null;
	private static @Getter @Setter String tempoRestateRegulacaoSinistro = null;

}
