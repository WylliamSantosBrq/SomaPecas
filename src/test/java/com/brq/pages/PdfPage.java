package com.brq.pages;

import java.util.List;
import java.util.Map;

import com.brq.elementos.somapecas.SPPdfElementos;
import com.brq.erros.ErroValidacao;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.brq.interfaces.PDF;
import com.brq.interfaces.log.BRQLogger;

public class PdfPage extends Pagina implements PDF {

	public PdfPage() {
		super();
		BRQLogger.logMethod();

		esperarPaginaSerCarregada(PAGE_TIMEOUT);
//		esperarPaginaComElementoAbrir(By.tagName("embed"), PAGE_TIMEOUT);
		esperarCondicao(ExpectedConditions.not(ExpectedConditions.urlToBe("")), PAGE_TIMEOUT);
		BRQLogger.info("Título atual:[%s]", titulo());
		BRQLogger.info("URL atual:[%s]", url());

	}

	@Override
	public void validarPdfEmTela() {
		esperarMilisegundos(1000);

		if (!url().endsWith("dashboard.xhtml") )
			throw new ErroValidacao("Título diferente!");

		SPPdfElementos.viewPdf.esperarSerInvisivel(PAGE_TIMEOUT);
		SPPdfElementos.pluginPdf.esperarSerInvisivel(PAGE_TIMEOUT);
		fecharAba(1);
		trocarJanelaPorIndice(0);
	}

	@Override
	public void validarDados(List<String> dados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarDados(Map<String, String> dadosEsperados) {
		// TODO Auto-generated method stub

	}

}
