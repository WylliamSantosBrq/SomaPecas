package com.brq.interfaces.somadesktop;

import java.util.Map;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Mouse;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.brq.drivers.desktop.Sikuli;
import com.brq.elementos.somadesktop.SikuliPesquisaVistoriasElementos;
import com.brq.elementos.somadesktop.SikuliVistoriaAbaElementos;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroMassaDeDados;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somadesktop.SDVistoriaInfoDoSinistroPage;
import com.brq.steps.StepsMaster;
import com.brq.utils.date.DateHelper;

public interface SDPesquisaVistorias extends Pesquisa {

	Screen s = Sikuli.getScreen();

	@Override
	default void pesquisar(String textoParaPesquisar) {
		// TODO Auto-generated method stub

	}

	@Override
	default void selecionarResultado(String resultado) {
		// TODO Auto-generated method stub
		Pesquisa.super.selecionarResultado(resultado);
	}

	@Override
	default void selecionarResultado(int indice) {
		// TODO Auto-generated method stub
		Pesquisa.super.selecionarResultado(indice);
	}

	@Override
	default void selecionarPrimeiroResultado() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliPesquisaVistoriasElementos.getIconeSinistroNaoUsado(), 120);
			
			StepsMaster.getPaginaAtual().esperarSegundos(1);
            
			int i = 0;
			
			while (s.findAllList(SikuliPesquisaVistoriasElementos.getIconeSinistroNaoUsado()).size() <= 1) {
//				SikuliPesquisaVistoriasElementos.getBtnFiltrarPor().targetOffset(400, 0)
				s.mouseMove(Region.create(0, 0, 1366, 768));
				s.wheel(Mouse.WHEEL_DOWN, 10);
				if (i++ > 50)
					throw new ErroMassaDeDados("Não foi encontrada um sinistro que não tenha sido usado.");
			}
				
			s.right(-1126).doubleClick(SikuliPesquisaVistoriasElementos.getIconeSinistroNaoUsado());
			s.right(-1126).waitVanish(SikuliPesquisaVistoriasElementos.getIconeSinistroNaoUsado(), 15);

			if (s.has(SikuliVistoriaAbaElementos.getTextoCamposInvalidos()))
				s.click(SikuliVistoriaAbaElementos.getTituloOficina().targetOffset(830, 0));

			StepsMaster.setPaginaAtual(new SDVistoriaInfoDoSinistroPage());
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o primeiro resultado de vistoria.");
		}
	}

	@Override
	default void filtrarPor(Map<String, String> filtros) {
		BRQLogger.logMethod(filtros);

		try {
			BRQLogger.info("Esperando botão [Filtrar Por:].");
			s.wait(SikuliPesquisaVistoriasElementos.getBtnFiltrarPor(), 120).click();
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "O botão de abrir as opções de filtro não foi encontrado.");
		}

		for (String key : filtros.keySet()) {
			try {
				switch (key) {
				case "data":
					s.wait(SikuliPesquisaVistoriasElementos.getCheckboxData(), 5);
					s.click(SikuliPesquisaVistoriasElementos.getCheckboxData());
					s.click(SikuliPesquisaVistoriasElementos.getInputData());
//					s.wait(SikuliPesquisaVistoriasElementos.getCheckboxData()).click();
					if (filtros.get(key).equalsIgnoreCase("hoje")) {
						String dataAtual = String.format("%02d%02d%04d", DateHelper.getDiaAtual(),
								DateHelper.getMesAtual(), DateHelper.getAnoAtual());
						s.delayType(100);
						s.type(dataAtual);
					}
					break;

				case "Oficina":
					s.wait(SikuliPesquisaVistoriasElementos.getCheckboxOficina(), 5);
					s.click(SikuliPesquisaVistoriasElementos.getCheckboxOficina());
					s.click(SikuliPesquisaVistoriasElementos.getInputOficina());
					s.type(filtros.get(key));
					break;

				case "Veículo":
					s.wait(SikuliPesquisaVistoriasElementos.getCheckboxVeiculo(), 5);
					s.click(SikuliPesquisaVistoriasElementos.getCheckboxVeiculo());
					s.click(SikuliPesquisaVistoriasElementos.getInputVeiculo());
					s.type(filtros.get(key));
					break;

				}

			} catch (FindFailed e) {
				throw new ErroSistema(e, "O elemento de filtragem não foi encontrado.");
			}
		}

		try {
			s.click(SikuliPesquisaVistoriasElementos.getBtnPesquisar());
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o botão de pesquisar.");
		}
	}

}
