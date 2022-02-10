package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Elemento;
import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasNotasElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroTimeout;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;
import com.brq.pages.abas.AbasExibicaoDeItensDaArvorePage;
import com.brq.steps.StepsMaster;

public class AbasNotas extends Foco implements Campos {

	public AbasNotas() {
		BRQLogger.logMethod();
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Registrar notas automaticas":
			clicarEmRegistrarNotasAutomaticas();
			break;

		case "Expandir todas":
		case "Expandir Todas":
			clicarEmExpandirTodas();
			break;

		case "Modelo de Cartas":
			clicarEmModeloDeCartas();
			break;
			
		default:
			throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].", botao);
		}

	}

	public void clicarEmModeloDeCartas() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(10).entrar()) {
			AbasNotasElementos.BTN_MODELO_DE_CARTAS.esperarSerVisivel(15).clicar();
			StepsMaster.setPaginaAtual(new AbasExibicaoDeItensDaArvorePage());

		} catch (Exception e) {
			throw new ErroInesperado(e);
		}
	}

	public void clicarEmExpandirTodas() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(10).entrar()) {
			AbasNotasElementos.BTN_EXPANDIR_TODAS.esperarSerVisivel(15).clicar();

		} catch (Exception e) {
			throw new ErroInesperado(e);
		}
	}

	public void clicarEmRegistrarNotasAutomaticas() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(10).entrar()) {
			AbasNotasElementos.BTN_REGISTRAR_NOTA_AUTOMATICA.esperarSerVisivel(5).clicar();
			StepsMaster.setPaginaAtual(new AbasExibicaoDeItensDaArvorePage());

		} catch (Exception e) {
			throw new ErroInesperado(e);
		}

	}

	@Override
	public void preencherCampo(String campo, String valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCampos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCampo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCampo(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCampos(String campos, String valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		BRQLogger.logMethod(campo, valorEsperado);

		switch (campo) {
		case "Apólice":
			validarCampoApolice(valorEsperado);
			break;

		case "Convênio":
			validarCampoConvenio(valorEsperado);
			break;

		case "Veículo":
			validarCampoVeiculo(valorEsperado);
			break;

		case "Placa":
			validarCampoPlaca(valorEsperado);
			break;

		case "Segurado":
			validarCampoSegurado(valorEsperado);
			break;

		case "Chassi":
			validarCampoChassi(valorEsperado);
			break;

		case "Marca":
			validarCampoMarca(valorEsperado);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}

	public void validarCampoApolice(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_APOLICE.esperarSerVisivel(60).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	public void validarCampoConvenio(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_CONVENIO.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	public void validarCampoVeiculo(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_VEICULO.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	public void validarCampoPlaca(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_PLACA.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	private void validarCampoSegurado(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_SEGURADO.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	private void validarCampoChassi(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_CHASSI.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	private void validarCampoMarca(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_MARCA.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarIguais(valorObtido, (String) valorEsperado);
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
		case "Apólice":
			validarCampoApolicePreenchido();
			break;

		case "Convênio":
			validarCampoConvenioPreenchido();
			break;

		case "Veículo":
			validarCampoVeiculoPreenchido();
			break;

		case "Placa":
			validarCampoPlacaPreenchido();
			break;

		case "Segurado":
			validarCampoSeguradoPreenchido();
			break;

		case "Chassi":
			validarCampoChassiPreenchido();
			break;

		case "Marca":
			validarCampoMarcaPreenchido();
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}

	public void validarCampoApolicePreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_APOLICE.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	public void validarCampoConvenioPreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_CONVENIO.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	public void validarCampoVeiculoPreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_VEICULO.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	public void validarCampoPlacaPreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_PLACA.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	private void validarCampoSeguradoPreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_SEGURADO.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	private void validarCampoChassiPreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_CHASSI.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	private void validarCampoMarcaPreenchido() {
		BRQLogger.logMethod();

		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasNotasElementos.TEXTO_MARCA.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}

		validarNaoVazio(valorObtido);
	}

	public void oSistemaApresentara(String arg1) {
		BRQLogger.logMethod(arg1);

		switch (arg1) {
		case "Assunto: Registro Automático do Sistema":
			validaRegistroAutomaticoDoSistemaPresente(arg1);
			break;
		default:
			throw new ErroAutomacao("O registro [%s] não foi definido no método [oSistemaApresentara.", arg1);
		}

	}

	private void validaRegistroAutomaticoDoSistemaPresente(String arg1) {
		try (Frame frame = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(45).entrar()) {
			AbasNotasElementos.DIV_REGISTRO_AUTOMATICO.existe();
			BRQLogger.info("[%s] foi exibido.", arg1);
		} catch (ErroTimeout e) {
			throw new ErroSistema(e, "Não foi possível encontrar registro esperado.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "O registro esperado não foi encontrado.");
		}
	}

	public void validarRegistro(String registro) {
		BRQLogger.logMethod(registro);

		switch (registro) {
		case "Emissão do laudo":
			validarNota(registro, AbasNotasElementos.REGISTRO_EMISSAO_LAUDO);
			break;
		case "Sugestão de Perda Parcial":
			validarNota(registro, AbasNotasElementos.REGISTRO_PERDA_PARCIAL);
			break;
		case "Sugestão de Perda Integral":
			validarNota(registro, AbasNotasElementos.REGISTRO_PERDA_INTEGRAL);
			break;
		default:
			throw new ErroAutomacao("O registro [%s] não foi definido no método [validaRegistro].", registro);
		}
	}

	private void validarNota(String registro, Elemento elemento) {
		BRQLogger.logMethod(registro, elemento);

		try (Frame frame = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(45).entrar()) {
			String elementoTexto = elemento.obterTexto();

			if (!elementoTexto.contains(registro))
				throw new ErroInesperado("A nota esperada não foi encontrada");
		} catch (ErroTimeout e) {
			throw new ErroSistema(e, "Não foi possível encontrar registro esperado.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "O registro esperado não foi encontrado.");
		}


		BRQLogger.info("Nota [%s] encontrada com sucesso.", registro);
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
