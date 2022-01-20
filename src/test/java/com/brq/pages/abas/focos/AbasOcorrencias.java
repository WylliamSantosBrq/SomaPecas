package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasOcorrenciaElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Tabelas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasOcorrencias extends Foco implements Tabelas {

	public AbasOcorrencias() {
		// TODO Auto-generated constructor stub
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
	public void preencherCelula(String tabela, int linha, String coluna, Object valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherCelula(String tabela, String linha, String coluna, Object valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherColuna(String tabela, String coluna, List<Object> valores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherLinha(String tabela, String linha, Map<String, Object> valores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherLinha(String tabela, int linha, Map<String, Object> valores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherLinhas(String tabela, List<Map<String, Object>> valores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCelula(String tabela, String linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCelulas(String tabela, Map<String, String> mapValoresEsperados) {
		BRQLogger.logMethod(tabela, mapValoresEsperados);

		for (String campo : mapValoresEsperados.keySet()) {
			validarCelula(tabela, 0, campo, mapValoresEsperados.get(campo));
		}
	}

	@Override
	public void validarCelula(String tabela, int linha, String campo, Object valorEsperado) {
		BRQLogger.logMethod(tabela, linha, campo, valorEsperado);

		switch (campo) {
		case "Placa":
			validarCelulaPlaca(linha, valorEsperado);
			break;

			default:
				throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}

	public void validarCelulaPlaca(int linha, Object valorEsperado) {
		BRQLogger.logMethod(linha, valorEsperado);

		String textoObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			textoObtido = AbasOcorrenciaElementos.CAMPO_PLACA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(textoObtido, (String) valorEsperado);
	}

	@Override
	public void validarCampoPreenchido(String tabela, String campo) {
		BRQLogger.logMethod(tabela, campo);

		switch (campo) {
		case "Placa":
			validarCampoPlacaPreenchido();
			break;

			default:
				throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}

	public void validarCampoPlacaPreenchido() {
		BRQLogger.logMethod();

		String textoObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			textoObtido = AbasOcorrenciaElementos.CAMPO_PLACA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarNaoVazio(textoObtido);
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
	public void validarCampo(String tabela, String campo) {
		// TODO Auto-generated method stub
		
	}

}
