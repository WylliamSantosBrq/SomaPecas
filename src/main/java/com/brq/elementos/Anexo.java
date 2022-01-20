package com.brq.elementos;

import com.brq.drivers.web.DriverWeb;
import org.openqa.selenium.By;

import com.brq.interfaces.web.IEscrever;
import com.brq.interfaces.web.IEscreverJS;
import org.openqa.selenium.WebElement;

public class Anexo extends Elemento implements IEscrever, IEscreverJS {

	public Anexo(By by) {
		super(by);
	}

	public Anexo anexarArquivo(String caminhoDoArquivo) {
		WebElement input = DriverWeb.getDriver().findElement(by);
		input.sendKeys(caminhoDoArquivo);
		return this;
	}

}
