package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasDadosBasicosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Formulario;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasDadosBasicos extends Foco implements Formulario {

	public AbasDadosBasicos() {
	}

	@Override
	public void preencherCampo(String campo, String opcao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarCombo(String combo, String opcao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherOsCamposObrigatorios() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clicarNoRadio(String label, String radio) {
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
	public void selecionarCombos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limparCombo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limparCombo(String combo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarDadosCombo(String textoCombo, String textoComboFinal) {

	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		BRQLogger.logMethod(campo, valorEsperado);
		
		switch (campo) {
		case "Natureza":
			validarCampoNatureza(valorEsperado);
			break;
			
		case "Código da Natureza":
			validarCampoCodigoDaNatureza(valorEsperado);
			break;
			
		case "Tipo Perda":
			validarCampoTipoPerda(valorEsperado);
			break;
			
		case "Tipo Perda Entrada":
			validarCampoTipoPerdaEntrada(valorEsperado);
			break;
		
		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampo].", campo);
		}
	}
	
	public void validarCampoNatureza(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
		
		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasDadosBasicosElementos.OUTPUT_NATUREZA.obterValorPreenchido();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(valorObtido, (String) valorEsperado);
	}
	
	public void validarCampoCodigoDaNatureza(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
		
		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasDadosBasicosElementos.OUTPUT_CODIGO_NATUREZA.obterValorPreenchido();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(valorObtido, (String) valorEsperado);
	}
	
	public void validarCampoTipoPerda(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);		
		
		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasDadosBasicosElementos.OUTPUT_TIPO_PERDA.obterValorPreenchido();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(valorObtido, (String) valorEsperado);
	}

	public void validarCampoTipoPerdaEntrada(Object valorEsperado) {
		BRQLogger.logMethod(valorEsperado);
		
		String valorObtido;
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			valorObtido = AbasDadosBasicosElementos.OUTPUT_TIPO_PERDA_ENTRADA.obterValorPreenchido();
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
		validarIguais(valorObtido, (String) valorEsperado);
	}

	@Override
	public void validarPerguntaResposta(String pergunta, String resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarBotaoDisponivel(String botao) {
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
