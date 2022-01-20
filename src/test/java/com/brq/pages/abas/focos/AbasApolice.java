package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasApoliceElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasApolice extends Foco implements Campos {

	public AbasApolice() {
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
		
		for (String key: mapValoresEsperados.keySet()) {
			validarCampo(key, mapValoresEsperados.get(key));
		}
	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		BRQLogger.logMethod(campo, valorEsperado);
		
		switch(campo) {
		case "Tipo Cobertura":
			validarCampoTipoCobertura(valorEsperado);
			break;
			
		case "Licença":
			validarCampoLicenca(valorEsperado);
			break;
			
			default:
				throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}

	public void validarCampoTipoCobertura(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
		
		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasApoliceElementos.TEXTO_TIPO_COBERTURA.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(valorObtido, (String) valorEsperado);
	}

	public void validarCampoLicenca(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
		
		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasApoliceElementos.TEXTO_LICENCA.esperarSerVisivel(5).obterTexto();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(valorObtido, (String) valorEsperado);
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		BRQLogger.logMethod(campo);
		
		switch(campo) {
		case "Tipo Cobertura":
			validarCampoCoberturaPreenchido();
			break;
			
		case "Licença":
			validarCampoLicencaPreenchido();
			break;
			
			default:
				throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampoPreenchido].", campo);
		}
	}

	public void validarCampoCoberturaPreenchido() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			String tipoCobertura = AbasApoliceElementos.TEXTO_TIPO_COBERTURA.obterTexto();
			validarNaoVazio(tipoCobertura);

		} catch (Exception e) {
			throw new ErroSistema(e, "Ocorreu um erro ao acessar o iframe principal.");
		}
	}

	public void validarCampoLicencaPreenchido() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			String licenca = AbasApoliceElementos.TEXTO_LICENCA.obterTexto();
			validarNaoVazio(licenca);

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
