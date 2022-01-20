package com.brq.elementos.somapecas;

import org.openqa.selenium.By;

import com.brq.elementos.Botao;
import com.brq.elementos.Elemento;

public class SPAPFotosElementos {

	private SPAPFotosElementos() {
	}

	public static final Botao BTN_MINIATURA_FOTO = new Botao(By.xpath("//img[following::input[1][@id='portal']]"));
	//public static final Botao BTN_FECHAR = new Botao(
	//		By.xpath("//input[contains(@onclick, 'Richfaces.hideModalPanel(\'fotosModal\')')]"));

	public static final Botao BTN_FECHAR = new Botao(
			By.cssSelector("div#fotosModalContentDiv > div > input[type='image']"));

	public static final Elemento JANELA_FOTOS = new Elemento(By.id("fotosModalCDiv"));

	public static final Elemento IMG_FOTO = new Elemento(By.xpath("//div[contains(@class, 'iviewer_cursor')]/img"));

	public static final Botao BTN_ZOOM_IN = new Botao(By.xpath("//img[@class='zoom-in']"));

}
