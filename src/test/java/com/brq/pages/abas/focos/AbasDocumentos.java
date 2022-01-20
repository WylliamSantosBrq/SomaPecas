package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasDocumentosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Formulario;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasDocumentos extends Foco implements Formulario {

	public AbasDocumentos() {
		BRQLogger.logMethod();
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).esperarMilisegundos(500)).entrar();

		switch (botao) {
		case "Nova solicitação de documentos":
			clicarEmNovaSolicitacaoDeDocumentos();
			break;

		case "Concluir solicitação de documentos":
			clicarEmConcluirSolicitacaoDeDocumentos();
			break;
			
		default:
			throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].", botao);
		}

		AbasAbaElementos.FRAME_PRINCIPAL.sair();
	}

	public void clicarEmNovaSolicitacaoDeDocumentos() {
		BRQLogger.logMethod();

		AbasDocumentosElementos.BTN_NOVA_SOLICITACAO_DE_DOCUMENTOS.esperarSerVisivel(30).clicar();
	}
	
	public void clicarEmConcluirSolicitacaoDeDocumentos() {
		BRQLogger.logMethod();

		AbasDocumentosElementos.BTN_CONCLUIR_SOLICITACAO_DE_DOCUMENTOS.esperarSerVisivel(30).clicar();
	}

	@Override
	public void preencherOsCamposObrigatorios() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selecionarCombo(String combo, String opcao) {
		BRQLogger.logMethod(combo, opcao);

		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).esperarMilisegundos(500)).entrar();

		switch (combo) {
		case "Combo de documentos":
			AbasDocumentosElementos.COMBO_DE_DOCUMENTOS.selecionarPorTexto(opcao);
			break;

		default:
			throw new ErroAutomacao("Combo [%s] não definido no método [selecionarNoCombo].", combo);
		}

		AbasAbaElementos.FRAME_PRINCIPAL.sair();
	}

	@Override
	public void preencherCampo(String campo, String opcao) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarBotaoDisponivel(String botao) {
		BRQLogger.logMethod(botao);

		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30).esperarMilisegundos(500)).entrar();

		switch (botao) {
		case "Solicitar Tarefas":
			validarBotaoSolicitarTarefas();
			break;
			
		default:
			throw new ErroAutomacao("Botão [%s] não definido no método [validarBotaoDisponivel].", botao);
		}

		AbasAbaElementos.FRAME_PRINCIPAL.sair();
		
	}
	
	public void validarBotaoSolicitarTarefas() {
		BRQLogger.logMethod();

		if(!AbasDocumentosElementos.BTN_SOLICITAR_TAREFAS.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).existe())
			throw new ErroInesperado("O botão não foi encontrado.");
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
