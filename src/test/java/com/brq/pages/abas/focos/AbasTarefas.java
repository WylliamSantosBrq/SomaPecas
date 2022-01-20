package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedCondition;

import com.brq.elementos.Frame;
import com.brq.elementos.Texto;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasTarefasElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroTimeout;
import com.brq.interfaces.abas.AbasItemTarefa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasTarefas extends Foco implements AbasItemTarefa {

	public AbasTarefas() {
		BRQLogger.logMethod();
	}

	public void oSistemaExibiraATarefa(String tarefaEsperada) {
		BRQLogger.logMethod(tarefaEsperada);

		String atributoTarefa = String.format("td[span[a[text()='%s']]]", tarefaEsperada);

		try (Frame frame = ((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(45)).entrar()) {
			Texto textoTarefa = AbasTarefasElementos.TAREFAS.getLinha(atributoTarefa).getTexto("/td[3]//a");
			esperarTarefaAtualizada(textoTarefa, 60);
			BRQLogger.info("A tarefa [%s] foi exibida.", tarefaEsperada);
		} catch (ErroTimeout e) {
			throw new ErroSistema(e, "Não foi possível encontrar a tarefa esperada.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "A tarefa esperada não foi encontrada.");
		}
	}

	public void esperarTarefaAtualizada(Texto textoTarefa, int tempoEmSegundos) {
		BRQLogger.logMethod(textoTarefa, tempoEmSegundos);

		ExpectedCondition<Boolean> tarefasAtualizadas = webDriver -> {
			try {
				textoTarefa.esperarSerVisivel(30);
				return true;
			} catch (Throwable t) {
				AbasTarefasElementos.BTN_ATUALIZAR.esperarExistir(30).moverJavascript().clicar();
				return false;
			}
		};

		esperarCondicao(tarefasAtualizadas, tempoEmSegundos);
	}

	public void validarDadosDaTarefa(String tarefa, Map<String, String> valoresEsperados) {
		BRQLogger.logMethod(tarefa, valoresEsperados);

		switch (tarefa) {
		case "Aprovação Carta Recusa Comprova - PP":
			validarDadosAprovacaoCartaRecusaComprovaPP(valoresEsperados);
			break;

		default:
			throw new ErroAutomacao();
		}
	}

	public void validarDadosAprovacaoCartaRecusaComprovaPP(Map<String, String> valoresEsperados) {
		BRQLogger.logMethod(valoresEsperados);
		
		for (String campoEsperado: valoresEsperados.keySet()) {
			validarDadoAprovacaoCartaRecusaComprovaPP(campoEsperado, valoresEsperados.get(campoEsperado));
		}
	}

	public void validarDadoAprovacaoCartaRecusaComprovaPP(String campoEsperado, String valorEsperado) {
		BRQLogger.logMethod(campoEsperado, valorEsperado);
		
		switch(campoEsperado) {
		case "Início":
			validarInicioAprovacaoCartaRecusaComprovaPP(valorEsperado);
			break;
		case "Fim":
			validarFimAprovacaoCartaRecusaComprovaPP(valorEsperado);
			break;
			
		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarDadoAprovacaoCartaRecusaComprovaPP].", campoEsperado);
			}
		}
	
	public void validarInicioAprovacaoCartaRecusaComprovaPP(String valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
	
		
	}

	public void validarFimAprovacaoCartaRecusaComprovaPP(String valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
	}
	
	public void validarDadosDaTarefa(String tarefa, List<String> camposEsperados) {

	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Atualizar":
			clicarEmAtualizar();
			break;

		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmAtualizar() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			AbasTarefasElementos.BTN_ATUALIZAR.esperarExistir(30).moverJavascript().clicar();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro ao clicar no botão [Atualizar].");
		}
	}

}
