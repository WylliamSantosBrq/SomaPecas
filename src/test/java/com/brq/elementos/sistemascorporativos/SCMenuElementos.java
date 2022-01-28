package com.brq.elementos.sistemascorporativos;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Frame;

public class SCMenuElementos {

	private SCMenuElementos() {
	}

	public static final Frame FRAME_PRINCIPAL = new Frame(By.xpath("//iframe[@name='login']"));
	
	public static final Botao BTN_SISTEMA_DE_SINISTRO = new Botao(By.xpath("//a[contains(text(), 'Sistema de sinistro')]"));
	public static final Botao BTN_SS_NOVO_SINISTRO_AUTO = new Botao(By.xpath("//a[contains(text(), 'Sistema de sinistro')]/following::div[1]//a[normalize-space(text())='Novo Sinistro Auto']"));
	public static final Botao BTN_SS_U10 = new Botao(By.xpath("//a[contains(text(), 'Sistema de sinistro')]/following::div[1]//a[normalize-space(text())='U10']"));
	
}
