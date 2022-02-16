package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasQuestionarioElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Formulario;
import com.brq.interfaces.abas.AbasCarregamento;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasQuestionario extends Foco implements Formulario, AbasCarregamento {

	public AbasQuestionario() {
		BRQLogger.logMethod();
		
		esperarCarregamentoTerminar(10);
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
	public void validarPerguntaResposta(String pergunta, String resposta) {
		BRQLogger.logMethod(pergunta, resposta);
		
		switch (pergunta) {
		case "Veículo está alienado?":
			validarVeiculoAlienado(resposta);
			break;
		case "Veículo possui rastreador?":
			validarVeiculoRastreado(resposta);
			break;
		case "Registrou a ocorrência (B.O.)?":
			validarRegistrouBO(resposta);
			break;
		case "Possui foto(s) do local do acidente ou do(s) veículo(s)?":
			validarPossuiFotos(resposta);
			break;	
		default:
			throw new ErroAutomacao("A pergunta [%s] não foi definida no método [validarPerguntaResposta].", pergunta);
		}
	}

	private void validarVeiculoAlienado(String resposta) {
		BRQLogger.logMethod(resposta);		

		String respostaObtida;
		
		esperarSegundos(5);
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(DEFAULT_STEPS_TIMEOUT).esperarMilisegundos(600).entrar()) {
			respostaObtida = AbasQuestionarioElementos.VEICULO_ALIENADO.obterAtributo("value");		
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
			validarIguais(resposta, respostaObtida);		
	}
	
	private void validarVeiculoRastreado(String resposta) {
		BRQLogger.logMethod(resposta);		

		String respostaObtida;
		
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			respostaObtida = AbasQuestionarioElementos.VEICULO_RASTREADO.obterAtributo("value");		
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
			validarIguais(resposta, respostaObtida);		
	}
	
	private void validarRegistrouBO(String resposta) {
		BRQLogger.logMethod(resposta);		

		String respostaObtida;
		
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			respostaObtida = AbasQuestionarioElementos.REGISTROU_BO.obterAtributo("value");		
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
			validarIguais(resposta, respostaObtida);		
	}
	
	private void validarPossuiFotos(String resposta) {
		BRQLogger.logMethod(resposta);		
		
		String respostaObtida;
		
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			respostaObtida = AbasQuestionarioElementos.POSSUI_FOTOS.obterAtributo("value");		
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
		
			validarIguais(resposta, respostaObtida);		
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
