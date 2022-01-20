package com.brq.interfaces.somadesktop;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliAbaPecasElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Menu;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somadesktop.SDAdicaoDePecasPage;
import com.brq.steps.StepsMaster;

public interface SDOutrasAcoesMenu extends Menu {

	Screen s = new Screen();

	@Override
	default void acessarMenu(String... ordemDeMenus) {
		BRQLogger.logMethod((Object[]) ordemDeMenus);

		int profundidade = ordemDeMenus.length;

		if (profundidade == 0)
			throw new ErroAutomacao("A lista de ordem dos menus não pode ficar vazia.");

		switch (ordemDeMenus[0]) {
		case "OUTRAS AÇÕES":
			try {
				s.wait(SikuliAbaPecasElementos.getBtnOutrasAcoes(), 15);
				s.hover(SikuliAbaPecasElementos.getBtnOutrasAcoes());
				s.click(SikuliAbaPecasElementos.getBtnOutrasAcoes().targetOffset(0, 0));
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão de [OUTRAS AÇÕES] não foi encontrado em tela.");
			}

			if (profundidade == 1)
				break;

			switch (ordemDeMenus[1]) {
			case "Peças Manuais":
				try {
					s.wait(SikuliAbaPecasElementos.getMenuPecasManuais());
					s.click(SikuliAbaPecasElementos.getMenuPecasManuais());
					StepsMaster.setPaginaAtual(new SDAdicaoDePecasPage());
				} catch (FindFailed e) {
					throw new ErroSistema(e, "O menu de [Peças Manuais] não foi encontrado em tela.");
				}

				if (profundidade == 2)
					break;

			default:
				throw new ErroAutomacao("O submenu [%s] não foi definido no método [acessarMenu].", ordemDeMenus[1]);
			}
			break;

		default:
			throw new ErroAutomacao("O menu [%s] não foi definido no método [acessarMenu].", ordemDeMenus[0]);
		}
	}

}
