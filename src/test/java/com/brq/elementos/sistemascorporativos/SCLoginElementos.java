package com.brq.elementos.sistemascorporativos;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Frame;

public class SCLoginElementos {

	private SCLoginElementos() {}

	public static final Frame FRAME_LOGIN = new Frame(By.name("login"));
	public static final Campo INPUT_USUARIO = new Campo(By.id("usuario"));
	public static final Campo INPUT_SENHA = new Campo(By.id("senha"));
	public static final Botao BTN_ENTRAR = new Botao(By.id("button"));

}
