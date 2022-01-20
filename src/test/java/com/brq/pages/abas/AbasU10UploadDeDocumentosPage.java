package com.brq.pages.abas;

import com.brq.elementos.abas.AbasU10UploadDeDocumentosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Anexos;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.util.FileHelper;

public class AbasU10UploadDeDocumentosPage extends Pagina implements Anexos, Mensagens {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		switch(botao) {
		case "Enviar documento":
			clicarEmEnviarDocumento();
			break;
			
		case "Fechar":
			clicarEmFechar();
			break;
			
			default:
				throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmEnviarDocumento() {
		BRQLogger.logMethod();
		
		AbasU10UploadDeDocumentosElementos.BTN_ENVIAR_DOCUMENTO.esperarExistir(5).clicar();
	}

	public void clicarEmFechar() {
		BRQLogger.logMethod();
		
		AbasU10UploadDeDocumentosElementos.BTN_FECHAR.esperarExistir(5).clicar();
	}

	@Override
	public void anexarArquivo(String arquivo) {
		BRQLogger.logMethod(arquivo);
		
		switch(arquivo) {
		case "o PDF salvo":
			anexarOPDFSalvo();
			break;
			
			default:
				throw new ErroAutomacao("O arquivo [%s] não foi definido no método [anexarArquivo].", arquivo);
		}
	}

	public void anexarOPDFSalvo() {
		BRQLogger.logMethod();
		
		String caminhoDoArquivo = FileHelper.projectFile("src", "test" , "resources", "anexos", "pdf.pdf");
		
		AbasU10UploadDeDocumentosElementos.ANEXO_PROCURAR.anexarArquivo(caminhoDoArquivo);
	}

	@Override
	public void anexarArquivos(String... arquivos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anexarArquivos(int quantidadeDeArquivos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarListaDeMensagens() {
		// TODO Auto-generated method stub
		
	}
	
}
