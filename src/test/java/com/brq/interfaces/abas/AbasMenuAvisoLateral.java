package com.brq.interfaces.abas;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasMenuAvisoLateralElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.MenuLateral;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.pages.abas.AbasSolicitacaoDeVistoriaPage;
import com.brq.pages.abas.AbasU10HomePage;
import com.brq.steps.StepsMaster;

public interface AbasMenuAvisoLateral extends MenuLateral {

	@Override
	default void acessarMenuLateral(String... ordemDeMenus) {
		BRQLogger.logMethod((Object[]) ordemDeMenus);

		int profundidade = ordemDeMenus.length;

		if (profundidade == 0)
			throw new ErroAutomacao("A lista de ordem dos menus não pode ficar vazia.");
		IEsperaWeb.esperarSegundos(20);
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()) {
			switch (ordemDeMenus[0]) {

			case "AVISO DE SINISTRO":
				AbasMenuAvisoLateralElementos.BTN_AVISO_DE_SINISTRO.esperarSerVisivel(30).clicar();
				break;

			case "MARCAÇÃO DE VISTORIA":
				AbasMenuAvisoLateralElementos.BTN_MARCACAO_DE_VISTORIA.esperarSerVisivel(30).clicar();
				StepsMaster.setPaginaAtual(new AbasSolicitacaoDeVistoriaPage());
				break;
			case "U10":
				IEsperaWeb.esperarSegundos(30);

				AbasMenuAvisoLateralElementos.BTN_U10.esperarSerVisivel(30).clicar();
				StepsMaster.setPaginaAtual(new AbasU10HomePage());
				break;

			default:
				throw new ErroAutomacao("O menu [%s] não foi definido no método [acessarMenuLateral].",
						ordemDeMenus[0]);
			}
		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

}
