package com.brq.interfaces.abas;

import com.brq.elementos.abas.AbasMenuElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.MenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.abas.AbasAvisoDeSinistroConsultaPage;
import com.brq.steps.StepsMaster;

public interface AbasMenuSuperior extends MenuSuperior {

	@Override
	default void acessarMenuSuperior(String... ordemDeMenus) {
		BRQLogger.logMethod((Object[]) ordemDeMenus);

		int profundidade = ordemDeMenus.length;

		if (profundidade == 0)
			throw new ErroAutomacao("A lista de ordem dos menus não pode ficar vazia.");

		switch (ordemDeMenus[0]) {
		case "Atendimentos Pendentes":
//				TODO Clicar

			if (profundidade == 1) {
				return;
			}

			switch (ordemDeMenus[1]) {
//				TODO Mapear os submenus desse menu.

			default:
				throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
			}

		case "Tarefas":
//				TODO Clicar

			if (profundidade == 1) {
				return;
			}

			switch (ordemDeMenus[1]) {
//				TODO Mapear os submenus desse menu.

			default:
				throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
			}

		case "Aviso de Sinistro":
			AbasMenuElementos.BTN_AVISO_DE_SINISTRO.esperarExistir(15).mover().clicar();

			if (profundidade == 1) {
				return;
			}

			switch (ordemDeMenus[1]) {
			case "Registrar Aviso":
				return;
				
			case "Consultas":
				AbasMenuElementos.BTN_AS_CONSULTAS.esperarExistir(15).esperarMilisegundos(500).clicar();

				if (profundidade == 2) {
					return;
				}
				
				switch (ordemDeMenus[2]) {
				case "Número do Sinistro":
					AbasMenuElementos.BTN_AS_CONS_NUMERO_DO_SINISTRO.esperarExistir(15).esperarMilisegundos(500).clicar();
					StepsMaster.setPaginaAtual(new AbasAvisoDeSinistroConsultaPage());
					
					return;

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[2]);
				}

			default:
				throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
			}

		default:
			throw new ErroAutomacao("Menu [%s] não definido no método [acessarMenu].", ordemDeMenus[0]);
		}
	}

}
