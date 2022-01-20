package com.brq.pages.abas;

import com.brq.elementos.abas.AbasU10ReagendarVistoriaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasU10RemarcarVistoriaPage extends Pagina {

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);
		
		switch(objeto) {
		case "Reagendamento vistoria de sinistro":
			esperarExibicaoReagendamentoVistoriaDeSinistro(DEFAULT_STEPS_TIMEOUT);
			break;
			
		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	public void esperarExibicaoReagendamentoVistoriaDeSinistro(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);
		
		AbasU10ReagendarVistoriaElementos.TEXTO_REAGENDAR_VISTORIA.esperarSerVisivel(tempoEmSegundos);
	}

}