package com.brq.pages.abas.focos;

import org.openqa.selenium.NoSuchElementException;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasSiasiOnlineElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.abas.AbasCarregamento;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasSiasiOnline extends Foco implements AbasCarregamento {

	public AbasSiasiOnline() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30)).entrar();
		
		switch (botao) {
		case "Obter Informações Atualizadas":
			clicarEmObterInformacoesAtualizadas();
			break;
			
		default:
			throw new ErroAutomacao("Botão não definido no método [clicarEm].");
		}
		
		AbasAbaElementos.FRAME_PRINCIPAL.sair();
	}
	
	public void clicarEmObterInformacoesAtualizadas() {
		BRQLogger.logMethod();
		
		AbasSiasiOnlineElementos.LABEL_MENSAGENS.esperarSerVisivel(240);
		AbasSiasiOnlineElementos.BTN_OBTER_INFORMACOES_ATUALIZADAS.moverJavascript().clicarJavascript();
		AbasSiasiOnlineElementos.LOADING_INFORMACOES_ATUALIZADAS.esperarSerVisivel(30).esperarSerInvisivel(240);
	}
	
	public void validarResultadoDaAnalise() {
		BRQLogger.logMethod();
		
		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30)).entrar();
		
		try {
			String resultadoDaAnalise = AbasSiasiOnlineElementos.TXT_RESULTADO_DA_ANALISE.obterTexto();
			BRQLogger.info(resultadoDaAnalise);
			
		} catch (NoSuchElementException e) {
			throw new ErroSistema(e, "Não foi possível encontrar o resultado da análise.");
		} finally {
			AbasAbaElementos.FRAME_PRINCIPAL.sair();
		}
	}

}