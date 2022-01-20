package com.brq.steps;

import java.io.IOException;
import java.util.List;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.Pesquisa;
import com.brq.pages.Pagina;
import com.brq.pages.somapecas.SPDashBoardPage;
import com.brq.pages.somapecas.SPTarefasEncerradas;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidacoesSteps extends StepsMaster {

	@When("^(?:o sistema )?exibir \"(.*?)\"$")
	@Then("^(?:o sistema )?exibirá \"(.*?)\"$")
	public static void oSistemaApresentara(String objeto) throws IOException {
		try {
			getPaginaAtual().esperarExibicao(objeto);
			Reporter.addStepLog(String.format("O sistema exibiu \"%s\".", objeto));
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, String.format("Validação da exibição de \"%s\".", objeto));
		}
	}

	@Then("^o botão \"(.*?)\" estará disponível$")
	public static void oBotaoEstaraDisponivel(String botao) throws IOException {
		try {
			getPaginaAtual().validarBotaoDisponivel(botao);
			Reporter.addStepLog(String.format("O botão \"%s\" está disponível.", botao));
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, String.format("Validação do botão \"%s\" disponível.", botao));
		}
	}

	@Then("^(?:o sistema )?apresentará a caixa de \"?(.*?)\"?$")
	public void apresentaraACaixaDe(String tituloCaixa) throws IOException {
		try {
			getPaginaAtual().validarCaixaDe(tituloCaixa);
		}finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, String.format("Validação da caixa \"%s\" disponível.", tituloCaixa));
		}
	}

	@Then("^(?:o sistema )?apresentará os seguintes campos preenchidos:$")
	public void apresentaraOsSeguintesCamposPreenchidos(List<String> campos) throws IOException {
		try {
			getPaginaAtual().validarDadosEmTela(campos);
		}finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath,"Validação os campos disponível.");
		}
	}

	@Then("^o sistema apresenta a opção \"?(.*?)\"$")
    public void oSistemaApresenta(String mensagem) throws IOException {
		try {
			if (!(getPaginaAtual() instanceof Mensagens))
				throw new ErroAutomacao("A página atual não é uma instâncida de [Mensagens].");

			((Mensagens) getPaginaAtual()).validarMensagem(mensagem);
		}finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath,String.format("O sistema apresentou a mensagem \"%s\".", mensagem));
		}

    }

	@Then("^o sistema apresenta o status da peça \"?(.*?)\"$")
	public void oSistemaApresentaOStatusDaPeça(String mensagem) throws IOException {
		try {
			if (!(getPaginaAtual() instanceof SPTarefasEncerradas))
				throw new ErroAutomacao("A página atual não é uma instâncida de [SPTarefasEncerradas].");

			((SPTarefasEncerradas) getPaginaAtual()).validarPecasConfirmadas(mensagem);
		}finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath,String.format("O sistema apresentou o status da peça que é \"%s\".", mensagem));
		}

	}

	@Then("^(?:o sistema )?apresenta o cadastro do fornecedor pesquisado \"?(.*?)\"$")
	public void oSistemaApresentaOCadastroPesquisado(String texto) throws IOException {
		try {
			if (!(getPaginaAtual() instanceof Pesquisa))
				throw new ErroAutomacao("A página atual não é uma instâncida de [SPTarefasEncerradas].");

			((Pesquisa) getPaginaAtual()).pesquisar(texto);
		}finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath,String.format("O sistema apresentou o nome do fornecedor \"%s\".", texto));
		}
	}

	@Then("^o sistema apresenta a mensagem \"?(.*?)\"$")
	public void oSistemaApresentaAMensagem(String texto) throws IOException  {
		try {
			if (!(getPaginaAtual() instanceof Mensagens))
				throw new ErroAutomacao("A página atual não é uma instâncida de [SPTarefasEncerradas].");

			((Mensagens) getPaginaAtual()).validarMensagem(texto);
		}finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath,String.format("O sistema apresentou a mensagem \"%s\".", texto));
		}
	}

	@Then("^valido o status da peça como \"?(.*?)\"$")
	public void validoOStatusDaPeçaComo(String opcao) {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instâncida de [Pagina].");

		((SPTarefasEncerradas)getPaginaAtual()).abaFornecedor();
	}

	@Then("^(?:o sistema )?não permitirá alteração de \"?(.*?)\"$")
	public void alteracaoMudanca(String texto) {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instâncida de [Pagina].");

		((Pagina)getPaginaAtual()).validarDadoEmTela(texto);
	}

	@Then("^o sistema apresenta abertura da tarefa \"?(.*?)\"$")
	public void oSistemaApresentaAberturaDaTarefa(String mensagem) {
	}

}
