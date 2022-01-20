package com.brq.elementos.somadesktop;

import org.sikuli.script.Pattern;

import lombok.Getter;

public class SikuliLoginElementos {
	private final static @Getter(lazy=true) Pattern inputCpf = new Pattern("input_cpf.png").similar(0.90);
	private final static @Getter(lazy=true) Pattern inputSenha = new Pattern("input_senha.png").similar(0.90);
	private final static @Getter(lazy=true) Pattern btnLogin = new Pattern("btn_login.png").similar(0.90);
}