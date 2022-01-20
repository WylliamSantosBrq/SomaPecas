package com.brq.interfaces.sistemascorporativos;

import com.brq.elementos.Frame;
import com.brq.elementos.sistemascorporativos.SCMenuElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Menu;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.abas.AbasHomePage;
import com.brq.pages.abas.AbasU10HomePage;
import com.brq.steps.StepsMaster;

public interface SCMenu extends Menu {

	@Override
	default void acessarMenu(String... ordemDeMenus) {
		BRQLogger.logMethod((Object[]) ordemDeMenus);

		int profundidade = ordemDeMenus.length;

		if (profundidade == 0)
			throw new ErroAutomacao("A lista de ordem dos menus não pode ficar vazia.");

		try (Frame frame = SCMenuElementos.FRAME_PRINCIPAL.entrar()) {

			switch (ordemDeMenus[0]) {
			case "Central de Documentos":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Chat Central de Serviços":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Macro sistema - Informatica":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Porto Seguro Cartoes":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "REdesenho - Menu Sinistro":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Recursos Humanos":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Sinistros de Porto Aluguel":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Sinistros de Ramos Elementares":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Sistema Automovel":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Sistema Portoseg CFI":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Sistema de Aceitacao":
//			TODO Clicar

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
//			TODO Mapear os submenus desse menu.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			case "Sistema de sinistro":
				SCMenuElementos.BTN_SISTEMA_DE_SINISTRO.esperarSerVisivel(15).mover().clicar();

				if (profundidade == 1) {
					return;
				}

				switch (ordemDeMenus[1]) {
				case "Novo Sinistro Auto":
					SCMenuElementos.BTN_SS_NOVO_SINISTRO_AUTO.esperarSerVisivel(15).esperarMilisegundos(500).clicar();

					StepsMaster.setPaginaAtual(new AbasHomePage());

					return;
					
				case "U10":
					SCMenuElementos.BTN_SS_U10.esperarSerVisivel(15).esperarMilisegundos(500).clicar();

					StepsMaster.setPaginaAtual(new AbasU10HomePage());

					return;

//			TODO Mapear o resto dos submenus do perfil.

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			default:
				throw new ErroAutomacao("Menu [%s] não definido no método [acessarMenu].", ordemDeMenus[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
