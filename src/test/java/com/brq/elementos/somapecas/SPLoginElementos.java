package com.brq.elementos.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Elemento;

public class SPLoginElementos {
	
	private SPLoginElementos() {}

	public static final Campo INPUT_CPF = new Campo(By.id("inputCPF"));
	public static final Campo INPUT_SENHA = new Campo(By.id("inputPassword"));
	public static final Botao BTN_LOGIN = new Botao(By.xpath("//input[@value='ENTRAR']"));
	public static final Elemento VALIDACAO_TELA_LOGIN = new Elemento(By.xpath("//img[@src='images/loginLogo.png']"));

}
