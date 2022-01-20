package com.brq.pages.somadesktop;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

import com.brq.elementos.somadesktop.SikuliAdicaoDePecas;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Tabelas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;
import com.brq.steps.StepsMaster;

public class SDAdicaoDePecasPage extends DesktopPage implements Tabelas {

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Adicionar":
			clicarEmAdicionar();
			break;
			
		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	@Override
	public void preencherCelula(String tabela, String linha, String coluna, Object valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCelula(String tabela, int linha, String coluna, Object valor) {
		BRQLogger.logMethod(tabela, linha, coluna, valor);

		switch (coluna) {
		case "Código":
			preencherCelulaCodigo(linha, valor);
			break;

		case "Digite uma descrição":
			preencherCelulaDigiteUmaDescricao(linha, valor);
			break;

		case "T":
			selecionarT(linha, valor);
			break;

		case "R":
			selecionarR(linha, valor);
			break;

		case "M":
			selecionarM(linha, valor);
			break;

		case "Tipo de Uso":
			selecionarTipoDeUso(linha, valor);
			break;

		case "Tipo de Peça":
			selecionarTipoDePeca(linha, valor);
			break;

		case "Valor Bruto":
			preencherValorBruto(linha, valor);
			break;

		case "Desconto":
			preencherDesconto(linha, valor);
			break;

		case "Valor Líquido":
			preencherValorLiquido(linha, valor);
			break;

		case "M.O":
			preencherValorMO(linha, valor);
			break;

		case "Pintura":
			preencherValorPintura(linha, valor);
			break;

		default:
			throw new ErroAutomacao("A coluna [%s] não foi definida no método [preencherCelula].", coluna);
		}
	}

	@Override
	public void preencherColuna(String tabela, String coluna, List<Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherLinha(String tabela, String linha, Map<String, Object> valores) {

	}

	@Override
	public void preencherLinha(String tabela, int linha, Map<String, Object> valores) {
		BRQLogger.logMethod(tabela, linha, valores);

		for (String chave : valores.keySet()) {
			preencherCelula(tabela, linha, chave, valores.get(chave));
		}
	}

	@Override
	public void preencherLinhas(String tabela, List<Map<String, Object>> valores) {
		BRQLogger.logMethod(tabela, valores);

		int i = 0;

		for (Map<String, Object> valoresLinha : valores) {
			preencherLinha(tabela, i++, valoresLinha);
		}
	}

	@Override
	public void validarCelula(String tabela, String linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarColuna(String tabela, String coluna, List<Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarLinha(String tabela, String linha, Map<String, Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarLinha(String tabela, int linha, Map<String, Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarLinhas(String tabela, List<Map<String, Object>> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCelula(String tabela, int linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	public void preencherCelulaCodigo(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputCodigo();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Código] não foi encontrado em tela.");
		}
	}

	public void preencherCelulaDigiteUmaDescricao(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputDigiteUmaDescricao();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Digite uma descrição] não foi encontrado em tela.");
		}
	}

	public void selecionarT(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getRadioT();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			if (((String) valor).equalsIgnoreCase("x"))
				s.click(elemento);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O radio de [T] não foi encontrado em tela.");
		}
	}

	public void selecionarR(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getRadioR();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			if (((String) valor).equalsIgnoreCase("x"))
				s.click(elemento);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O radio de [R] não foi encontrado em tela.");
		}
	}

	public void selecionarM(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getRadioM();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			if (((String) valor).equalsIgnoreCase("x"))
				s.click(elemento);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O radio de [M] não foi encontrado em tela.");
		}
	}

	public void selecionarTipoDeUso(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getComboTipoDeUso();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			pressionarTeclas(KeyEvent.VK_DOWN, 10);

			switch ((String) valor) {
			case "FUNILARIA":
				pressionarTecla(KeyEvent.VK_UP);

			case "MECANICA":
				pressionarTecla(KeyEvent.VK_UP);

			case "TAPECARIA":
				pressionarTecla(KeyEvent.VK_UP);

			case "ACABAMENTO":
				pressionarTecla(KeyEvent.VK_UP);

			case "ELETRICA":
				s.click(elemento);
				break;

			default:
				throw new ErroAutomacao("A opção [%s] não foi definida no método [selecionarTipoDeUso].", valor);
			}

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O combo de [Tipo de Uso] não foi encontrado em tela.");
		}
	}

	public void selecionarTipoDePeca(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getComboTipoDePeca();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			pressionarTeclas(KeyEvent.VK_DOWN, 5);

			switch ((String) valor) {
			case "Genuíno":
				pressionarTecla(KeyEvent.VK_UP);

			case "Fabricante":
				s.click(elemento);
				break;

			default:
				throw new ErroAutomacao("A opção [%s] não foi definida no método [selecionarTipoDeUso].", valor);
			}

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O combo de [Tipo de Peça] não foi encontrado em tela.");
		}
	}

	public void preencherValorBruto(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputValorBruto();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Valor Bruto] não foi encontrado em tela.");
		}
	}

	public void preencherDesconto(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputDesconto();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Desconto] não foi encontrado em tela.");
		}
	}

	public void preencherValorLiquido(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputValorLiquido();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Valor Líquido] não foi encontrado em tela.");
		}
	}

	public void preencherValorMO(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputMO();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [M.O] não foi encontrado em tela.");
		}
	}

	public void preencherValorPintura(int linha, Object valor) {
		BRQLogger.logMethod(linha);

		Pattern elementoBase = SikuliAdicaoDePecas.getInputPintura();
		int dx = elementoBase.getTargetOffset().x;
		int dy = elementoBase.getTargetOffset().y + 28 * linha;
		Pattern elemento = elementoBase.targetOffset(dx, dy);

		try {
			s.wait(elemento, 5);
			s.click(elemento);
			s.type((String) valor);
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Pintura] não foi encontrado em tela.");
		}
	}

	public void clicarEmAdicionar() {
		BRQLogger.logMethod();
		
		try {
			s.wait(SikuliAdicaoDePecas.getBtnAdicionar(), 15);
			s.click(SikuliAdicaoDePecas.getBtnAdicionar());
			StepsMaster.setPaginaAtual(new SDVistoriaPecasPage());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão de adicionar não foi encontrado em tela.");
		}
	}

	@Override
	public void clicarCelula(String tabela, int linha, String coluna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clicarCelula(String tabela, String linha, String coluna) {
		// TODO Auto-generated method stub
		
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
