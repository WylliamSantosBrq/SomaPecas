package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliVistoriaAbaElementos {

	private static final @Getter(lazy = true) Pattern textoCamposInvalidos = new Pattern("texto_campos_invalidos.png")
			.similar(0.9);

	private static final @Getter(lazy = true) Pattern abaFotos = new Pattern("aba_fotos.png").similar(0.8);
	private static final @Getter(lazy = true) Pattern abaPecas = new Pattern("aba_pecas.png").similar(0.8);
	private static final @Getter(lazy = true) Pattern abaFinalizacao = new Pattern("aba_finalizacao.png").similar(0.8);

	private static final @Getter(lazy = true) Pattern abaFotosAtiva = new Pattern("aba_fotos_ativa.png").similar(0.8);
	private static final @Getter(lazy = true) Pattern abaPecasAtiva = new Pattern("aba_pecas_ativa.png").similar(0.8);
	
	private static final @Getter(lazy = true) Pattern tituloOficina = new Pattern("titulo_oficina.png").similar(0.9);
}
