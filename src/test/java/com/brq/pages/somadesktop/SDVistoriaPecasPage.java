package com.brq.pages.somadesktop;

import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliAbaPecasElementos;
import com.brq.elementos.somadesktop.SikuliIndiceDescontoMaoDeObra;
import com.brq.elementos.somadesktop.SikuliTabelaOrcamentoPecas;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroTimeout;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.somadesktop.SDOutrasAcoesMenu;
import com.brq.interfaces.somadesktop.SDTabelaOrcamentoPecas;
import com.brq.interfaces.somadesktop.SDVistoriaAbas;
import com.brq.pages.Pagina;
import com.brq.pages.somadesktop.foco.SDCroquiPecas;

public class SDVistoriaPecasPage extends Pagina implements SDOutrasAcoesMenu, SDTabelaOrcamentoPecas, SDVistoriaAbas {

	Screen s = new Screen();

	public SDVistoriaPecasPage() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliAbaPecasElementos.getBtnOutrasAcoes(), 15);
			esperarMilisegundos(500);
		} catch (FindFailed e) {
			throw new ErroTimeout(e,
					"Tempo excedido para o elemento que define a página [SDVistoriaPecasPage] apareça em tela.");
		}
	}

	public boolean janelaIndiceDescontoMaoDeObraPresente() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliIndiceDescontoMaoDeObra.getTituloIndiceDeDescontoEMaoDeObra(), 5);
			return true;

		} catch (FindFailed e) {
			BRQLogger.info("A janela de [Índice de Desconto e Mão de Obra] não foi encontrada.");
			return false;
		}
	}

	@Override
	public void focar(String foco) {
		BRQLogger.logMethod(foco);

		switch (foco) {
		case "o croqui":
			setFocoAtual(new SDCroquiPecas());
			break;

		default:
			throw new ErroAutomacao("O foco [%s] não foi definido no método [focar].", foco);
		}
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		switch(botao) {
		case "Salvar":
			clicarEmSalvar();
			break;
			
			default:
				
		}
	}

	private void clicarEmSalvar() {
		BRQLogger.logMethod();
		
		if (s.has(SikuliTabelaOrcamentoPecas.getBtnSalvar()))
			try {
				s.click(SikuliTabelaOrcamentoPecas.getBtnSalvar());
				
				
				
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão de [Salvar] não foi encontrado em tela.");
			}
		else
			BRQLogger.info("A janela de [Justificativa] não apareceu em tela.");
	}

	@Override
	public void validarCelulas(String tabela, List<String> celulasEsperadas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampo(String tabela, String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoPreenchido(String tabela, String campo) {
		// TODO Auto-generated method stub
		
	}

}
