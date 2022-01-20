package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliAbaFotosElementos {

	private SikuliAbaFotosElementos() {}

	private static final @Getter(lazy = true) Pattern btnAdicionarFoto = new Pattern("btn_adicionar_foto.png").similar(0.9);
	private static final @Getter(lazy = true) Pattern textoFotosEnvolvidos = new Pattern("texto_fotos_envolvidos.png").similar(0.9);
	private static final @Getter(lazy = true) Pattern tituloUploadFotos = new Pattern("titulo_upload_de_fotos.png").similar(0.9);
	
}
