package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.log.BRQLogger;

public class Tabela {

	String byXpath;

	public Tabela(String byXpath) {
		this.byXpath = byXpath;
	}

	public Linha getLinha(int indice) {
		BRQLogger.logMethod(indice);

		String byXpathLinha = String.format("(%s)[%d]", byXpath, ++indice);

		return new Linha(byXpathLinha);
	}

	public Linha getLinha(String atributoXpath) {
		BRQLogger.logMethod(atributoXpath);

		String byXpathLinha = String.format("(%s)[%s]", byXpath, atributoXpath);

		return new Linha(byXpathLinha);
	}

	public Boolean existe() {
		BRQLogger.logMethod();

		Elemento temp = new Elemento(By.xpath(byXpath));

		return temp.existe();
	}

	public void esperarExistir(int tempoEmSegundos) {
		BRQLogger.logMethod();

		Elemento temp = new Elemento(By.xpath(byXpath));

		temp.esperarExistir(tempoEmSegundos);
	}

}
