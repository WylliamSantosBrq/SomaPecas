package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.TimeoutException;

import com.brq.elementos.Combo;
import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasLiberacaoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroMassaDeDados;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Formulario;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.abas.AbasCarregamento;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasLiberacao extends Foco implements Formulario, AbasCarregamento, Mensagens {

	public AbasLiberacao() {
		BRQLogger.logMethod();

		esperarCarregamentoTerminar(45);
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Concluir análise":
			clicarEmConcluirAnalise();
			break;
			
		case "Liberar Sinistro":
			clicarEmLiberarSinistro();
			break;

		default:
			throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmConcluirAnalise() {
		BRQLogger.logMethod();

		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).esperarMilisegundos(500)).entrar();
		
		AbasLiberacaoElementos.BTN_CONCLUIR_ANALISE.esperarSerVisivel(15).clicar();

		esperarAlertaPresente(30);
//		aceitarAlerta();
	}
	
	private void clicarEmLiberarSinistro() {
		BRQLogger.logMethod();
		
		try (Frame frame = ((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).esperarMilisegundos(500)).entrar()){
			AbasLiberacaoElementos.BTN_LIBERAR_SINISTRO.esperarSerVisivel(15).clicar();
			
		} catch (Exception e) {
			throw new ErroInesperado(e);
		}
	}

	@Override
	public void preencherOsCamposObrigatorios() {
		BRQLogger.logMethod();
	}

	@Override
	public void selecionarCombo(String combo, String opcao) {
		BRQLogger.logMethod(combo, opcao);

		try (Frame frame = ((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).esperarMilisegundos(500)).entrar()){
			switch (combo) {
			case "Próxima ação":
				((Combo) AbasLiberacaoElementos.COMBO_PROXIMA_ACAO.esperarExistir(45).mover()).selecionarPorTexto(opcao);
				break;

			case "Razão de liberação":
			case "Razão da liberação":
				((Combo) AbasLiberacaoElementos.COMBO_RAZAO_DA_LIBERACAO.esperarExistir(30).mover())
						.selecionarPorTexto(opcao);
				break;
				
			case "Restrição":
				((Combo) AbasLiberacaoElementos.COMBO_RESTRICAO.esperarExistir(45).mover()).selecionarPorTexto(opcao);
				break;

			default:
				throw new ErroAutomacao("O combo [%s] não foi definido no método [selecionarNoCombo].", combo);
			}
		} catch (ErroAutomacao e) {
			throw e;
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro ao interagir com o frame.");
		}
	}

	@Override
	public void preencherCampo(String campo, String opcao) {
		BRQLogger.logMethod(campo, opcao);

	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		BRQLogger.logMethod(mensagemEsperada);
		
		try {
			esperarAlertaPresente(30);
		} catch (TimeoutException e) {
			throw new ErroSistema(e, "A mensagem esperada não foi encontrada.");
		}
		
		String textoDoAlerta = obterTextoDoAlerta();
		
		if (textoDoAlerta.equals("Erro ao executar a liberação do processo - documento SAP"))
			throw new ErroMassaDeDados("Não é possível prosseguir com a liberação desse sinistro.");
		
		if (!textoDoAlerta.contains(mensagemEsperada))
			throw new ErroInesperado("O alerta não contém a mensagem esperada.");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
		case "Valor a liberar":
			validarValorALiberar();
			break;			
		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampoPreenchido].", campo);
		}	
	}

	private void validarValorALiberar() {
		
		esperarSegundos(20);
		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30)).entrar();
		
		String valor = AbasLiberacaoElementos.OUTPUT_VALOR_A_LIBERAR.obterValorPreenchido();
		
		if (valor == null || valor.isEmpty() || valor == "0")
			throw new ErroInesperado("O campo não está preenchido ou retornou vazio.");
		
		BRQLogger.info("Valor a liberar: %s", valor);
		
		AbasAbaElementos.FRAME_PRINCIPAL.sair();
		
	}

	@Override
	public void validarBotaoDisponivel(String botao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarListaDeMensagens() {
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
