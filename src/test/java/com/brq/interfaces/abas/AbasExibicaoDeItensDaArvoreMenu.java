package com.brq.interfaces.abas;

import com.brq.elementos.abas.AbasExibicaoDeItensDaArvoreElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Menu;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.abas.AbasGeracaoDeCartasEmPdfPage;
import com.brq.pages.abas.AbasNotaPadronizadaPage;
import com.brq.steps.StepsMaster;

public interface AbasExibicaoDeItensDaArvoreMenu extends Menu {

	@Override
	default void acessarMenu(String... ordemDeMenus) {
		BRQLogger.logMethod((Object[]) ordemDeMenus);

		int profundidade = ordemDeMenus.length;

		if (profundidade == 0)
			throw new ErroAutomacao("A lista de ordem dos menus não pode ficar vazia.");

		switch (ordemDeMenus[0]) {
		case "CARTAS":
			AbasExibicaoDeItensDaArvoreElementos.MENU_CARTAS.clicar();

			if (profundidade == 1)
				return;

			switch (ordemDeMenus[1]) {
			case "ANÁLISE":
				AbasExibicaoDeItensDaArvoreElementos.MENU_ANALISE.clicar();

				if (profundidade == 2)
					return;

				switch (ordemDeMenus[2]) {
				case "Carta Recusa":
					AbasExibicaoDeItensDaArvoreElementos.MENU_CARTA_RECUSA.clicar();

					if (profundidade == 3)
						return;

					switch (ordemDeMenus[3]) {
					case "CG 30":
						AbasExibicaoDeItensDaArvoreElementos.MENU_CG_30.clicar();

						if (profundidade == 4)
							return;

						switch (ordemDeMenus[4]) {
						case "Indenização Integral":
							AbasExibicaoDeItensDaArvoreElementos.MENU_INDENIZACAO_INTEGRAL.clicar();

							if (profundidade == 5)
								return;

							switch (ordemDeMenus[5]) {
							case "Agravamento":
								AbasExibicaoDeItensDaArvoreElementos.BTN_AGRAVAMENTO.clicarJavascript();
								StepsMaster.setPaginaAtual(new AbasGeracaoDeCartasEmPdfPage());
								return;

							default:
								throw new ErroAutomacao("O 5º sub-menu [%s] não foi definido no método [acessarMenu].",
										ordemDeMenus[5]);
							}

						default:
							throw new ErroAutomacao("O 4º sub-menu [%s] não foi definido no método [acessarMenu].",
									ordemDeMenus[4]);

						}

					default:
						throw new ErroAutomacao("O 3º sub-menu [%s] não foi definido no método [acessarMenu].",
								ordemDeMenus[3]);

					}

				default:
					throw new ErroAutomacao("O 2º sub-menu [%s] não foi definido no método [acessarMenu].",
							ordemDeMenus[2]);

				}

			case "LIQUIDAÇÃO":
				AbasExibicaoDeItensDaArvoreElementos.MENU_LIQUIDACAO.clicar();

				if (profundidade == 2)
					return;

				switch (ordemDeMenus[2]) {

				case "INDENIZAÇÃO INTEGRAL":
					AbasExibicaoDeItensDaArvoreElementos.MENU_I_I.clicar();

					if (profundidade == 3)
						return;

					switch (ordemDeMenus[3]) {
					case "PROGRAMAÇÃO DE PAGAMENTO I.I. / RF":
						AbasExibicaoDeItensDaArvoreElementos.MENU_PROGRAMACAO_DE_PAGAMENTO_II_RF.clicar();

						if (profundidade == 4)
							return;

						switch (ordemDeMenus[4]) {
						case "Programação Reembolso (Guincho/2aVia DUT/Outros)":
							AbasExibicaoDeItensDaArvoreElementos.BTN_PROGRAMACAO_REEMBOLSO_GUINCHO_2AVIA_DUT_OUTROS
									.clicar();
							StepsMaster.setPaginaAtual(new AbasNotaPadronizadaPage());
							return;

						default:
							throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].",
									ordemDeMenus[4]);
						}

					default:
						throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[2]);
					}

				default:
					throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[1]);
				}

			}

		default:
			throw new ErroAutomacao("Submenu [%s] não definido no método [acessarMenu].", ordemDeMenus[0]);

		}
	}
}
