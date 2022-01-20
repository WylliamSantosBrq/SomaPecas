package com.brq.utils.erros;

import org.openqa.selenium.By;

/**
 * Enum com localizadores de erro e a mensagem a ser apresentada caso o elemento
 * seja encontrado no método
 * {@link com.brq.utils.erros.ErrorHelper#checarErrosSistema()}
 * 
 * @author ymnoda
 *
 */
public enum ElementoErro {

	A_TECHNICAL_ERROR_OCCURRED(By.xpath(
			"//div[@id='serviceErrorMessageBox']//span[text()='Sorry, a technical error occurred! Please try again later.']"),
			"Ocorreu um erro técnico."),
	NAO_FOI_POSSIVEL_ABRIR_A_APLICACAO(
			By.xpath("//div[@role='alertdialog']//span[contains(text(), 'Não foi possível abrir a aplicação')]"),
			"Não foi possível abrir a aplicação.");

	public final By by;
	public final String mensagem;

	private ElementoErro(By by, String mensagem) {
		this.by = by;
		this.mensagem = mensagem;
	}
}
