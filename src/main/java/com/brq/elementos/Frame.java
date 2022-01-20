package com.brq.elementos;

import org.openqa.selenium.By;

import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IFrame;

public class Frame extends Elemento implements IFrame, AutoCloseable {
	
	public Frame(By by) {
		super(by);
	}
	
	public Frame entrar() {
		BRQLogger.logMethod();
		
		IFrame.entrarFrame(by);
		
		return this;
	}
	
	public void sair() {
		BRQLogger.logMethod();
		
		IFrame.sairFrame();
	}

	@Override
	public void close() throws Exception {
		BRQLogger.logMethod();
		
		sair();
	}

	@Override
	public Frame esperarSerVisivel(int tempoEmSegundos) {
		return (Frame) super.esperarSerVisivel(tempoEmSegundos);
	}

	@Override
	public Frame mover() {
		return (Frame) super.mover();
	}

	@Override
	public Frame moverJavascript() {
		return (Frame) super.moverJavascript();
	}

	@Override
	public Frame esperarMilisegundos(int tempoEmMilisegundos) {
		return (Frame) super.esperarMilisegundos(tempoEmMilisegundos);
	}

	@Override
	public Frame esperarSegundos(int tempoEmSegundos) {
		return (Frame) super.esperarSegundos(tempoEmSegundos);
	}

	@Override
	public Frame esperarExistir(int tempoEmSegundos) {
		return (Frame) super.esperarExistir(tempoEmSegundos);
	}

	@Override
	public Frame esperarSerInvisivel(int tempoEmSegundos) {
		return (Frame) super.esperarSerInvisivel(tempoEmSegundos);
	}

}
