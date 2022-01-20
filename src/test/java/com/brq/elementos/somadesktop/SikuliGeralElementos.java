package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import com.brq.interfaces.log.BRQLogger;

import lombok.Getter;

public class SikuliGeralElementos {

	private static final @Getter(lazy = true) Pattern btnFecharJanela = new Pattern("btn_fechar_janela.png").similar(0.9);
	
	private static final @Getter(lazy = true) Pattern tituloAbrirAnexo = new Pattern("titulo_abrir_anexo").similar(0.85);
	private static final @Getter(lazy = true) Pattern inputAbrirAnexo = fInputAbrirAnexo();
	private static final @Getter(lazy = true) Pattern arquivo1AbrirAnexo = fArquivo1AbrirAnexo();
	private static final @Getter(lazy = true) Pattern btnAbrirAbrirAnexo = fBtnAbrirAbrirAnexo();
	
	private static final Pattern fInputAbrirAnexo() {
		BRQLogger.logMethod();
		
		return getTituloAbrirAnexo().targetOffset(360, 33);
	}
	
	private static final Pattern fArquivo1AbrirAnexo() {
		BRQLogger.logMethod();
		
		return getTituloAbrirAnexo().targetOffset(200, 100);
	}
	
	private static final Pattern fBtnAbrirAbrirAnexo() {
		BRQLogger.logMethod();
		
		return getTituloAbrirAnexo().targetOffset(475, 435);
	}
	
}
