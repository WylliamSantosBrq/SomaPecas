package com.brq.interfaces.somadesktop;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliAbaPecasElementos;
import com.brq.elementos.somadesktop.SikuliVistoriaAbaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Abas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somadesktop.SDIndiceDescontoMaoDeObraPage;
import com.brq.pages.somadesktop.SDVistoriaFinalizacaoPage;
import com.brq.pages.somadesktop.SDVistoriaFotosPage;
import com.brq.pages.somadesktop.SDVistoriaPecasPage;
import com.brq.steps.StepsMaster;

public interface SDVistoriaAbas extends Abas {

	Screen s = new Screen();

	@Override
	default void mudarAba(String nomeDaAba) {
		BRQLogger.logMethod(nomeDaAba);

		switch (nomeDaAba) {
		case "Fotos":
			try {
				s.wait(SikuliVistoriaAbaElementos.getAbaFotos(), 30);
				StepsMaster.getPaginaAtual().esperarMilisegundos(3500);
				s.click(SikuliVistoriaAbaElementos.getAbaFotos());
				StepsMaster.setPaginaAtual(new SDVistoriaFotosPage());
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão da aba [Fotos] não foi encontrado.");
			}
			break;

		case "Peças":
			try {
				s.wait(SikuliVistoriaAbaElementos.getAbaPecas(), 30);
				StepsMaster.getPaginaAtual().esperarMilisegundos(500);
				s.click(SikuliVistoriaAbaElementos.getAbaPecas());
				SDVistoriaPecasPage temp = new SDVistoriaPecasPage();
				s.wait(SikuliAbaPecasElementos.getBtnOutrasAcoes(), 5);
				if (s.has(SikuliAbaPecasElementos.getTituloInfo()))
					s.click(SikuliAbaPecasElementos.getBtnInfoOk());
				if (temp.janelaIndiceDescontoMaoDeObraPresente())
					StepsMaster.setPaginaAtual(new SDIndiceDescontoMaoDeObraPage());
				else
					StepsMaster.setPaginaAtual(temp);
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão da aba [Peças] não foi encontrado.");
			}
			break;

		case "Finalização":
			try {
				s.wait(SikuliVistoriaAbaElementos.getAbaFinalizacao(), 30);
				StepsMaster.getPaginaAtual().esperarMilisegundos(500);
				s.click(SikuliVistoriaAbaElementos.getAbaFinalizacao());
				StepsMaster.setPaginaAtual(new SDVistoriaFinalizacaoPage());
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão da aba [Peças] não foi encontrado.");
			}
			break;

		default:
			throw new ErroAutomacao("A aba [%s] não foi definida no método [mudarAba].");
		}
	}

	@Override
	default String getAbaAtual() {
		// TODO Auto-generated method stub
		return null;
	}

}
