package com.brq.interfaces.somadesktop;

import java.util.List;
import java.util.Map;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliTabelaOrcamentoPecas;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Tabelas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somadesktop.SDJustificativaFornecimentoPage;
import com.brq.steps.StepsMaster;

public interface SDTabelaOrcamentoPecas extends Tabelas {

	Screen s = new Screen();

	default void preencherCampoJustificativa(String valor) {
		BRQLogger.logMethod(valor);

		if (s.has(SikuliTabelaOrcamentoPecas.getTituloJustificativa()))
			try {
				s.click(SikuliTabelaOrcamentoPecas.getInputJustificativa());
				s.type(valor);
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O campo de [Justificativa] não foi encontrado em tela.");
			}
		else
			BRQLogger.info("A janela de [Justificativa] não apareceu em tela.");
	}

	default void validarPecaNaTabela() {
		BRQLogger.logMethod();

		try {
			s.wait(SikuliTabelaOrcamentoPecas.getTextoPeca1(), 5);
			BRQLogger.info("A peça foi encontrada em tela.");
		} catch (FindFailed e) {
			throw new ErroSistema(e, "Não foi possível encontrar a peça na tabela de orçamento.");
		}
	}

	@Override
	default void preencherCelula(String tabela, int linha, String coluna, Object valor) {
		// TODO Auto-generated method stub

	}

	@Override
	default void preencherCelula(String tabela, String linha, String coluna, Object valor) {
		BRQLogger.logMethod(tabela, linha, coluna, valor);

		switch (coluna) {
		case "Trocar":
			if ((Boolean) valor)
				marcarCelulaMD(linha);
			else
				desmarcarCelulaTrocar(linha);
			break;

		case "Recup/Restaurar":
			if ((Boolean) valor)
				marcarCelulaRecupRestaurar(linha);
			else
				desmarcarCelulaRecupRestaurar(linha);
			break;

		case "M/D":
			if ((Boolean) valor)
				marcarCelulaMD(linha);
			else
				desmarcarCelulaMD(linha);
			break;

		case "Ref":
			preencherCelulaRef(linha, valor);
			break;

		case "Código da Peça":
			preencherCelulaCodigoDaPeca(linha, valor);
			break;

		case "Descrição da Peça":
			preencherCelulaDescricaoDaPeca(linha, valor);
			break;

		case "Qtde":
			preencherCelulaQtde(linha, valor);
			break;

		case "Valor Bruto":
			preencherCelulaValorBruto(linha, valor);
			break;

		case "Desc.":
			preencherCelulaDesc(linha, valor);
			break;

		case "Valor Líquido":
			preencherCelulaValorLiquido(linha, valor);
			break;

		case "M.O (h)":
			preencherCelulaMO(linha, valor);
			break;

		case "Pintura (h)":
			preencherCelulaPintura(linha, valor);
			break;

		case "Overlap":
			preencherCelulaOverlap(linha, valor);
			break;

		case "Fornec.":
			if ((Boolean) valor)
				marcarCelulaFornec(linha);
			else
				desmarcarCelulaFornec(linha);
			break;

		default:
			throw new ErroAutomacao("A coluna [%s] não foi definida no método [preencherCelula].", coluna);
		}
	}

	default void marcarCelulaMD(String linha) {
	}

	default void desmarcarCelulaMD(String linha) {
	}

	default void desmarcarCelulaTrocar(String linha) {
	}

	default void marcarCelulaRecupRestaurar(String linha) {
	}

	default void desmarcarCelulaRecupRestaurar(String linha) {
	}

	default void preencherCelulaMD(String linha, Object valor) {
	}

	default void preencherCelulaRef(String linha, Object valor) {
	}

	default void preencherCelulaCodigoDaPeca(String linha, Object valor) {
	}

	default void preencherCelulaDescricaoDaPeca(String linha, Object valor) {
	}

	default void preencherCelulaQtde(String linha, Object valor) {
	}

	default void preencherCelulaValorBruto(String linha, Object valor) {
	}

	default void preencherCelulaDesc(String linha, Object valor) {
	}

	default void preencherCelulaValorLiquido(String linha, Object valor) {
	}

	default void preencherCelulaMO(String linha, Object valor) {
	}

	default void preencherCelulaPintura(String linha, Object valor) {
	}

	default void preencherCelulaOverlap(String linha, Object valor) {
	}

	default void marcarCelulaFornec(String linha) {
		BRQLogger.logMethod(linha);

		if (s.has(SikuliTabelaOrcamentoPecas.getCheckboxDesmarcado()))
			try {
				s.click(SikuliTabelaOrcamentoPecas.getCheckboxDesmarcado());
			} catch (FindFailed e) {
				throw new ErroInesperado(e, "Não foi possível encontrar o elemento de checkbox desmarcado.");
			}
	}

	default void desmarcarCelulaFornec(String linha) {
		BRQLogger.logMethod(linha);

		try {
			List<Match> matches = s.findAllList(SikuliTabelaOrcamentoPecas.getCheckboxMarcado());

			Region regiaoDescricao = s.find(SikuliTabelaOrcamentoPecas.getHeaderDescricaoDaPeca()).below(82);

			for (char c = 'a'; c <= 'z'; c++)
				try {
					regiaoDescricao.findText(String.valueOf(c));
					BRQLogger.info("Foi encontrado: %c", c);
				} catch (FindFailed e) {
					BRQLogger.info("Não foi encontrado: %c.", c);
				}

			for (char c = 'A'; c <= 'Z'; c++)
				try {
					regiaoDescricao.findText(String.valueOf(c));
					BRQLogger.info("Foi encontrado: %c", c);
				} catch (FindFailed e) {
					BRQLogger.info("Não foi encontrado: %c.", c);
				}

			switch (linha) {
			case "peca 1":
//				s.wait(SikuliTabelaOrcamentoPecas.getTextoPeca1(), 15);
				s.wait("GUIA CJ-CO(GUIA DE COBERT. P/CHOQUE LD) - Val. 2003/2003", 15);
				int yPeca1 = regiaoDescricao.find(SikuliTabelaOrcamentoPecas.getTextoPeca1()).y;
				BRQLogger.info("y - peca 1: %d", yPeca1);

				for (Match m : matches) {
					BRQLogger.info("y - checkbox marcado: %d", m.y);
					if (yPeca1 == m.y) {
						s.click(m);
						StepsMaster.setPaginaAtual(new SDJustificativaFornecimentoPage());
						return;
					}
				}
			}

		} catch (FindFailed e) {
			throw new ErroAutomacao(e, "Não foi possível encontrar o elemento em tela.");
		}

//		if (s.has(SikuliTabelaOrcamentoPecas.getCheckboxMarcado())) {
//			try {
//				s.click(SikuliTabelaOrcamentoPecas.getCheckboxMarcado());
//			} catch (FindFailed e) {
//				throw new ErroInesperado(e, "Não foi possível encontrar o elemento de checkbox marcado.");
//			}
//
//			try {
//				s.wait(SikuliTabelaOrcamentoPecas.getTituloJustificativa(), 5);
//				StepsMaster.setPaginaAtual(new SDJustificativaFornecimentoPage());
//			} catch (FindFailed e) {
//				BRQLogger.info("A janela de [Justificativa] não apareceu em tela.");
//			}
//		} else
//			BRQLogger.info("O checkbox [Fornec.] já está desmarcado.");
	}

	default void clicarCelulaDeletar(String linha) {
	}

	@Override
	default void clicarCelula(String tabela, int linha, String coluna) {
		// TODO Auto-generated method stub
	}

	@Override
	default void clicarCelula(String tabela, String linha, String coluna) {
		BRQLogger.logMethod(tabela, linha, coluna);

		switch (coluna) {
		case "Deletar":
			clicarCelulaDeletar(linha);
			break;
		}
	}

	@Override
	default void preencherColuna(String tabela, String coluna, List<Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	default void preencherLinha(String tabela, String linha, Map<String, Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	default void preencherLinha(String tabela, int linha, Map<String, Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	default void preencherLinhas(String tabela, List<Map<String, Object>> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	default void validarCelula(String tabela, int linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	@Override
	default void validarCelula(String tabela, String linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	@Override
	default void validarColuna(String tabela, String coluna, List<Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	default void validarLinha(String tabela, String linha, Map<String, Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	default void validarLinha(String tabela, int linha, Map<String, Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	default void validarLinhas(String tabela, List<Map<String, Object>> valoresEsperados) {
		// TODO Auto-generated method stub

	}

}
