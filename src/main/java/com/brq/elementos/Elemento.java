package com.brq.elementos;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TimeoutException;

import com.brq.erros.ErroTimeout;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IClique;
import com.brq.interfaces.web.ICliqueJS;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.interfaces.web.IMover;
import com.brq.interfaces.web.IMoverJS;
import com.brq.interfaces.web.IObter;
import com.brq.interfaces.web.IObterJS;
import com.brq.interfaces.web.IValidacoesWeb;

public class Elemento implements IClique, ICliqueJS, IEsperaWeb, IObter, IObterJS, IMover, IMoverJS, IValidacoesWeb {

	protected By by;

	public Elemento(By by) {
		this.by = by;
	}

	public Elemento clicar() {
		BRQLogger.logMethod();

		IClique.clicar(by);

		return this;
	}

	public Elemento clicar(Integer indice) {
		BRQLogger.logMethod();

		IClique.clicar(by, indice);

		return this;
	}

	public Elemento clicarJavascript() {
		BRQLogger.logMethod();

		ICliqueJS.clicarJavascript(by);

		return this;
	}

	public Elemento clicarJavascript(Integer indice) {
		BRQLogger.logMethod();

		ICliqueJS.clicarJavascript(by, indice);

		return this;
	}

	public Boolean existe() {
		BRQLogger.logMethod();

		return IValidacoesWeb.elementoExiste(by);
	}

	public Elemento mover() {
		BRQLogger.logMethod();

		IMover.moverParaElemento(by);

		return this;
	}

	public Elemento moverJavascript() {
		BRQLogger.logMethod();

		IMoverJS.moverParaElementoJavascript(by);

		return this;
	}

	public String obterTexto() {
		BRQLogger.logMethod();

		return IObter.obterTexto(by);
	}

	public String obterTextoHidden() {
		BRQLogger.logMethod();

		return IObter.obterTextoHidden(by);
	}

	public String obterAtributo(String atributo) {
		BRQLogger.logMethod(atributo);

		return IObter.obterValorDeUmAtributoDoElemento(by, atributo);
	}

	public Elemento esperarMilisegundos(int tempoEmMilisegundos) {
		BRQLogger.logMethod(tempoEmMilisegundos);

		IEsperaWeb.esperarMilisegundos(tempoEmMilisegundos);

		return this;
	}

	public Elemento esperarSegundos(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		IEsperaWeb.esperarSegundos(tempoEmSegundos);

		return this;
	}

	public Elemento esperarExistir(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		try {
			IEsperaWeb.esperarElementoExistir(by, tempoEmSegundos);
		} catch (TimeoutException e) {
			throw new ErroTimeout(e, "Tempo excedido para elemento existir.");
		}

		return this;
	}

	public Elemento esperarSerVisivel(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		try {
			IEsperaWeb.esperarElementoSerVisivel(by, tempoEmSegundos);
		} catch (TimeoutException e) {
			throw new ErroTimeout(e, "Tempo excedido para elemento ser visível.");
		}
		return this;
	}

	public Elemento esperarSerInvisivel(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		try {
			IEsperaWeb.esperarElementoSerInvisivel(by, tempoEmSegundos);
		} catch (TimeoutException e) {
			throw new ErroTimeout(e, "Tempo excedido para elemento ser invisível.");
		}

		return this;
	}

	public Elemento esperarSerClicavel(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		try {
			IEsperaWeb.esperarElementoSerClicavel(by, tempoEmSegundos);
		} catch (TimeoutException e) {
			throw new ErroTimeout(e, "Tempo excedido para o elemento se tornar clicavel");
		}

		return this;
	}

	public By getBy() {
		return by;
	}

	public Point location() {
		return IObter.obterLocal(by);
	}
	
	public Rectangle area()
	{
		return IObter.obterArea(by);
	}

}
