package com.brq.pages.abas;

import com.brq.elementos.Frame;
import com.brq.elementos.Linha;
import com.brq.elementos.Texto;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasSolicitacaoDeVistoriaElementos;
import com.brq.elementos.abas.AbasTarefasElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroTimeout;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.abas.AbasMenuAvisoLateral;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasSolicitacaoDeVistoriaPage extends Pagina implements AbasMenuAvisoLateral {
	
	public AbasSolicitacaoDeVistoriaPage() {
		BRQLogger.logMethod();

	}
	
	public void oSistemaExibiraAVistoria(String vistoriaEsperada) {
		BRQLogger.logMethod(vistoriaEsperada);

		String atributoVistoria = String.format("td[contains(text(), '%s')]", vistoriaEsperada);

		try (Frame frame = ((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(45)).entrar()) {
			Texto textoVistoria = AbasTarefasElementos.TAREFAS.getLinha(atributoVistoria).getTexto("/td[3]//a");
			textoVistoria.esperarExistir(60);
			BRQLogger.info("A vistoria [%s] foi exibida.", vistoriaEsperada);
			
		} catch (ErroTimeout e) {
			throw new ErroSistema(e, "Não foi possível encontrar a vistoria [%s].", vistoriaEsperada);
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro ao acessar o frame principal.");
		}
	}

	public void validarStatusVistoria(String statusEsperado) {
		BRQLogger.logMethod(statusEsperado);
		
		String status;
		
		switch (statusEsperado) {
		case "em andamento":
			status = "/marcacaodevistoria/visual/images/carregada.gif";
			validarVistoria(status, statusEsperado);
			break;

		case "concluída":
			status = "/marcacaodevistoria/visual/images/terminada.gif";
			validarVistoria(status, statusEsperado);
			break;
		case "cancelada":
			status = "/marcacaodevistoria/visual/images/cancelada.gif";
			validarVistoria(status, statusEsperado);
			break;
		default:
			throw new ErroAutomacao("O status [%s] não foi definido no método [validarStatusVistoria].", statusEsperado);
		}
		
	}

	private void validarVistoria(String status, String statusEsperado) {
		String atributoStatusVistoria = String.format("//td[@class='tabela_celula']//img[contains(@src,'%s')]", status);
		
		try (Frame frame = ((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(45)).entrar()) {
			Linha linha = AbasSolicitacaoDeVistoriaElementos.VISTORIAS.getLinha(atributoStatusVistoria);
			if(!linha.existeImagem(atributoStatusVistoria))
				throw new ErroValidacao("O status da vistoria não é [%s]", statusEsperado);
			
		} catch (ErroTimeout e) {
			throw new ErroSistema(e, "O status da vistoria não é [%s].", statusEsperado);
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro ao acessar o frame principal.");
		}
		
	}
	
}
