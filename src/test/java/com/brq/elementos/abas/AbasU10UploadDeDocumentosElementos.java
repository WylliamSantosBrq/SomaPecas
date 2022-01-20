package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Anexo;
import com.brq.elementos.Botao;

public class AbasU10UploadDeDocumentosElementos {

	private AbasU10UploadDeDocumentosElementos() {}
	
	public static final Anexo ANEXO_PROCURAR = new Anexo(By.xpath("//input[@id='envioDocsFileUpload']"));
	
	public static final Botao BTN_ENVIAR_DOCUMENTO = new Botao(By.id("btnSubmit"));
	public static final Botao BTN_FECHAR = new Botao(By.xpath("//input[@name='btoClose']"));
	
}
