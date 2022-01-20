package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasLocalElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Campos;
import com.brq.interfaces.Radios;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasLocal extends Foco implements Campos, Radios {

	public AbasLocal() {
		BRQLogger.logMethod();
	}

	@Override
	public void clicarNoRadio(String label, String radio) {
		// TODO Auto-generated method stub

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
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
		BRQLogger.logMethod(mapValoresEsperados);

		for (String campo : mapValoresEsperados.keySet()) {
			validarCampo(campo, mapValoresEsperados.get(campo));
		}
	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		BRQLogger.logMethod(campo, valorEsperado);

		switch (campo) {
		case "CEP":
			validarCampoCEP(valorEsperado);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}

	public void validarCampoCEP(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			String cep = AbasLocalElementos.INPUT_CEP.obterValorPreenchido();
			validarIguais(cep, (String) valorEsperado);

		} catch (Exception e) {
			throw new ErroSistema(e, "Ocorreu um erro ao acessar o iframe principal.");
		}
	}

	@Override
	public void validarPerguntaResposta(String pergunta, String resposta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCampoPreenchido(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
		case "CEP":
			validarCampoCEPPreenchido();
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampoPreenchido].", campo);
		}
	}

	public void validarCampoCEPPreenchido() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			String cep = AbasLocalElementos.INPUT_CEP.obterValorPreenchido();
			validarNaoVazio(cep);

		} catch (Exception e) {
			throw new ErroSistema(e, "Ocorreu um erro ao acessar o iframe principal.");
		}
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
