package com.brq.pages.somadesktop;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliOrientacaoDeDanosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Campos;
import com.brq.interfaces.Combos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;
import com.brq.steps.StepsMaster;

public class SDOrientacaoDeDanosPage extends DesktopPage implements Campos, Combos {

	Screen s = new Screen();

	@Override
	public void fecharJanela(String janela) {
		BRQLogger.logMethod(janela);

		switch (janela) {
		case "Orientação de Danos":
			try {
				s.click(SikuliOrientacaoDeDanosElementos.getBtnFecharJanela());
				StepsMaster.setPaginaAtual(new SDVistoriaPecasPage());
			} catch (FindFailed e) {
				throw new ErroSistema(e, "O botão de fechar a janela não pode ser encontrado.");
			}
			break;

		default:
			throw new ErroAutomacao("A janela [%s] não foi definida no método [fecharJanela].", janela);
		}
	}

	@Override
	public void preencherCampo(String campo, String valor) {
		BRQLogger.logMethod(campo, valor);

		switch (campo) {
		case "Quilometragem":
			preencherCampoQuilometragem(valor);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [preencherCampo].", campo);
		}
	}

	@Override
	public void preencherCampos(Map<String, String> mapValores) {
		BRQLogger.logMethod(mapValores);

		for (Object campo : mapValores.keySet()) {
			preencherCampo((String) campo, (String) mapValores.get(campo));
		}
	}

	@Override
	public void limparCampo() {
		BRQLogger.logMethod();

		s.keyDown(KeyEvent.VK_CONTROL);
		s.keyDown(KeyEvent.VK_A);
		s.keyUp();
		s.keyDown(KeyEvent.VK_BACK_SPACE);
		s.keyUp();
	}

	@Override
	public void limparCampo(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCombo() {
		BRQLogger.logMethod();

		pressionarTeclas(KeyEvent.VK_DOWN, 100);
	}

	@Override
	public void limparCombo(String combo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarDadosCombo(String textoCombo, String textoComboFinal) {

	}

	@Override
	public void selecionarCombo(String combo, String opcao) {
		BRQLogger.logMethod(combo, opcao);

		switch (combo) {
		case "Aspecto do Dano":
			selecionarComboAspectoDoDano(opcao);
			break;

		case "Impregnação":
			selecionarComboImpregnacao(opcao);
			break;

		case "Agrupamento":
			selecionarComboAgrupamento(opcao);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [preencherCampo].", opcao);
		}
	}

	@Override
	public void selecionarCombos(Map<String, String> mapValores) {
		BRQLogger.logMethod(mapValores);

		for (String combo : mapValores.keySet()) {
			selecionarCombo(combo, mapValores.get(combo));
		}
	}

	public void selecionarComboAspectoDoDano(String opcao) {
		BRQLogger.logMethod(opcao);

		try {
			s.wait(SikuliOrientacaoDeDanosElementos.getComboAspectoDoDano(), 15);
			s.click(SikuliOrientacaoDeDanosElementos.getComboAspectoDoDano());
			pressionarTeclas(KeyEvent.VK_DOWN, 5);
			esperarMilisegundos(100);

			switch (opcao) {
			case "Recente":
				pressionarTecla(KeyEvent.VK_UP);

			case "Antigo":
				pressionarTecla(KeyEvent.VK_UP);

			case "Indeterminado":
				esperarMilisegundos(250);
				s.click(SikuliOrientacaoDeDanosElementos.getTituloOrientacaoDeDanos());
				break;

			default:
				throw new ErroAutomacao("A opção [%s] não foi definida no método [selecionarComboAspectoDoDano].",
						opcao);
			}

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O combo de [Aspecto do Dano] não apareceu em tela.");
		}
	}

	public void selecionarComboImpregnacao(String opcao) {
		BRQLogger.logMethod(opcao);

		try {
			s.wait(SikuliOrientacaoDeDanosElementos.getComboImpregnacao(), 15);
			s.click(SikuliOrientacaoDeDanosElementos.getComboImpregnacao());
			esperarMilisegundos(100);
			pressionarTeclas(KeyEvent.VK_BACK_SPACE, 20);
			s.type(opcao);
			esperarMilisegundos(250);
//			s.mouseMove(SikuliOrientacaoDeDanosElementos.getTituloOrientacaoDeDanos());
//			s.click();
//			s.mouseMove(0, 20);
			s.doubleClick(Region.create(628, 414, 1, 1));
			
//			switch (opcao) {
//			case "Não identificada":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Amarela":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Azul":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Bege":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Branca":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Cinza":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Dourada":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Grena":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Laranja":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Marrom":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Prata":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Preta":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Rosa":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Roxo":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Verde":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Vermelha":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Vinho":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Violeta":
//				pressionarTecla(KeyEvent.VK_UP);
//
//			case "Inexistente":
//				esperarMilisegundos(250);
//				pressionarTecla(KeyEvent.VK_ENTER);
//				break;
//
//			default:
//				throw new ErroAutomacao("A opção [%s] não foi definida no método [selecionarComboImpregnacao].",
//						opcao);
//			}

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O combo de [Impregnação] não apareceu em tela.");
		}
	}

	public void preencherCampoQuilometragem(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.wait(SikuliOrientacaoDeDanosElementos.getInputQuilometragem(), 15);
			s.click(SikuliOrientacaoDeDanosElementos.getInputQuilometragem());
			limparCampo();
			s.type(valor);

			s.mouseMove(SikuliOrientacaoDeDanosElementos.getComboAspectoDoDano());
			s.click();
			try {
				s.wait(SikuliOrientacaoDeDanosElementos.getJanelaIncluirFotoQuilometragem(), 5);
				s.click(SikuliOrientacaoDeDanosElementos.getBtnFecharIncluirFotoQuilometragem());
			} catch (FindFailed e) {
				BRQLogger.info("A janela de [Incluir foto da quilometragem] não foi encontrada.");
			}

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo de [Quilometragem] não apareceu em tela.");
		}
	}

	public void selecionarComboAgrupamento(String opcao) {
		BRQLogger.logMethod(opcao);

		try {
			s.wait(SikuliOrientacaoDeDanosElementos.getComboAgrupamento(), 15);
			s.click(SikuliOrientacaoDeDanosElementos.getComboAgrupamento());
			pressionarTeclas(KeyEvent.VK_DOWN, 20);
			esperarMilisegundos(100);

			switch (opcao) {
			case "Moto Importada":
				pressionarTecla(KeyEvent.VK_UP);

			case "Pick-Up":
				pressionarTecla(KeyEvent.VK_UP);

			case "SUV":
				pressionarTecla(KeyEvent.VK_UP);

			case "Ônibus":
				pressionarTecla(KeyEvent.VK_UP);

			case "Rebocador":
				pressionarTecla(KeyEvent.VK_UP);

			case "Semi-Reboque":
				pressionarTecla(KeyEvent.VK_UP);

			case "Locadora":
				pressionarTecla(KeyEvent.VK_UP);

			case "Outros":
				pressionarTecla(KeyEvent.VK_UP);

			case "Perda Construtiva":
				pressionarTecla(KeyEvent.VK_UP);

			case "Caminhão":
				pressionarTecla(KeyEvent.VK_UP);

			case "TESTE GUST":
				pressionarTecla(KeyEvent.VK_UP);

			case "ddddd":
				pressionarTecla(KeyEvent.VK_UP);

			case "Moto Nacional":
				pressionarTecla(KeyEvent.VK_UP);

			case "Veiculo de Passeio Nacional TESTE":
				pressionarTecla(KeyEvent.VK_UP);

			case "Veículo de Passeio Importado":
				pressionarTecla(KeyEvent.VK_UP);

			case "Táxi":
				esperarMilisegundos(250);
				s.click(SikuliOrientacaoDeDanosElementos.getTituloOrientacaoDeDanos());
				break;

			default:
				throw new ErroAutomacao("A opção [%s] não foi definida no método [selecionarComboAgrupamento].", opcao);
			}

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O combo de [Agrupamento] não apareceu em tela.");
		}
	}

	@Override
	public void preencherCampos(String campos, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCamposDisponiveis(List<String> campos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoDisponivel(String campo) {
		// TODO Auto-generated method stub
		
	}

}
