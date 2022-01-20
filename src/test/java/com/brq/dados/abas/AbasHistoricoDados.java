package com.brq.dados.abas;

import com.brq.interfaces.dados.Resetable;
import com.brq.interfaces.log.Loggable;

import lombok.Getter;
import lombok.Setter;

public class AbasHistoricoDados implements Resetable, Loggable {

	private static @Getter @Setter String data = null;
	private static @Getter @Setter String hora = null;
	private static @Getter @Setter String tipoHistorico = null;
	private static @Getter @Setter String tipoInformante = null;
	private static @Getter @Setter String nomeInformante = null;
	private static @Getter @Setter String atendenteAnalista = null;
	private static @Getter @Setter String canalAbertura = null;

}
