package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IValidacoesWeb;

public class Linha {

	String byXpath;
	
	public Linha(String byXpath) {
		this.byXpath = byXpath;
	}

	public Elemento get(String subXpath) {
		BRQLogger.logMethod(subXpath);
		
		String byXpathElemento = String.format("%s%s", byXpath, subXpath);
		
		return new Elemento(By.xpath(byXpathElemento));
	}

	public Texto getTexto(String subXpath) {
		BRQLogger.logMethod(subXpath);
		
		String byXpathElemento = String.format("%s%s", byXpath, subXpath);
		
		return new Texto(By.xpath(byXpathElemento));
	}

	public boolean existeImagem(String subXpath) {
		BRQLogger.logMethod(subXpath);
		
		String byXpathElemento = String.format("%s%s", byXpath, subXpath);
		
		return IValidacoesWeb.elementoDisponivel(By.xpath(byXpathElemento));
				
	}
	
}
