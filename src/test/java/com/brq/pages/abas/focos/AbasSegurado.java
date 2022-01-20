package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasSeguradoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Formulario;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasSegurado extends Foco implements Formulario {

	public AbasSegurado() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validarPerguntaResposta(String pergunta, String resposta) {
		BRQLogger.logMethod(pergunta, resposta);
		
		switch (pergunta) {
		case "Segurado vai utilizar o seguro para reparar seu veículo?":
			validarSeguroVaiRepararVeiculo(resposta);
			break;
		default:
			throw new ErroAutomacao("A pergunta [%s] não foi definida no método [validarPerguntaResposta].", pergunta);
		}
	}

	private void validarSeguroVaiRepararVeiculo(String resposta) {
		BRQLogger.logMethod(resposta);		

		String respostaObtida;
				
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).entrar()) {
			respostaObtida = AbasSeguradoElementos.SEGURO_REPARA_VEICULO.obterAtributo("value");	
			
			if (resposta.equals("Sim")) {				
				validarIguais("S", respostaObtida);		
			} else if (resposta.equals("Não")) {
				validarIguais("N", respostaObtida);	
			} else if (resposta.equals("Não Sabe")) {
				validarIguais(null, respostaObtida);	
			}
			
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
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
