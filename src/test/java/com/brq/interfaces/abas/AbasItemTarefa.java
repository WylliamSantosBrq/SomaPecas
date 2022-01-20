package com.brq.interfaces.abas;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasItemTarefaElementos;
import com.brq.elementos.abas.AbasTarefasElementos;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;

public interface AbasItemTarefa {

	default void finalizarTarefa(String tarefa) {
		BRQLogger.logMethod(tarefa);

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			String atributoTarefa = String.format("td[span[a[text()='%s']]]", tarefa);
			if (!AbasTarefasElementos.TAREFAS.getLinha(atributoTarefa).getTexto("/td[3]//a").existe())
				throw new ErroSistema("Não foi possível encontrar a tarefa esperada.");

			switch (tarefa) {
			case "Abertura de Laudo":

				AbasItemTarefaElementos.getBtnFinalizarTarefa(tarefa).esperarExistir(60).moverJavascript().clicar();

				Pagina paginaAtual = StepsMaster.getPaginaAtual();
				paginaAtual.esperarAlertaPresente(20);
				if (paginaAtual.obterTextoDoAlerta().contains("A tarefa selecionada está finalizada"))
					throw new ErroInesperado("A tarefa já foi finalizada.");
				paginaAtual.aceitarAlerta();
				break;

			default:
				throw new ErroSistema("A tarefa [%s] não foi definida no método [finalizarTarefa].");
			}
		} catch (Exception e) {
			throw new ErroInesperado(e,
					"Ocorreu algum erro inesperado ao tentar encontrar o elemento dentro do iframe.");
		}
	}

}
