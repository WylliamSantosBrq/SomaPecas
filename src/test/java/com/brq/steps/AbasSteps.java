package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.abas.AbasItemTarefa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.abas.AbasRegistrarSinistroPage;
import com.brq.pages.abas.focos.AbasNotas;
import com.brq.pages.abas.focos.AbasSiasiOnline;
import com.brq.pages.abas.focos.AbasTarefas;
import com.brq.pages.somapecas.SPTarefasEncerradas;
import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AbasSteps extends StepsMaster {

	public AbasSteps() {
	}

	@Then("^o sistema abrirá o sinistro na aba \"(.*?)\"$")
	public static void oSistemaAbriraOSinistroNaAba(String abaAtual) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instância de [AbasRegistrarSinistroPage].");

		try {
			((AbasRegistrarSinistroPage) getPaginaAtual()).validarAbaAtual(abaAtual);
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da aba atual.");
		}
	}
	
	@Then("^o sistema abrirá o sinistro na modal \"([^\"]*)\"$")
	public void oSistemaAbriráOSinistroNaModal(String abaAtual) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instância de [AbasRegistrarSinistroPage].");
		
		try {
			((AbasRegistrarSinistroPage) getPaginaAtual()).validarModalAtual(abaAtual);
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da aba atual.");
		}
	}

	@Then("^o sistema apresentará o resultado da análise$")
	public static void oSistemaApresentaraOResultadoDaAnalise() throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instância de [AbasRegistrarSinistroPage].");

		try {
			((AbasSiasiOnline) getPaginaAtual().getFocoAtual()).validarResultadoDaAnalise();
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação do resultado da análise.");
		}
	}

	@Then("^o sistema apresentará a tarefa \"(.*?)\"$")
	public static void oSistemaApresentaraATarefa(String tarefaEsperada) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instâncida de [AbasRegistrarSinistroPage].");

		try {
			((AbasTarefas) getPaginaAtual().getFocoAtual()).oSistemaExibiraATarefa(tarefaEsperada);
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da tarefa apresentada.");
		}
	}

	@Given("^que (?:o usuário )?finalizou a tarefa \"(.*?)\"$")
	@When("^finalizar a tarefa \"(.*?)\"$")
	public static void abrirATarefa(String tarefa) {
		if (!(getPaginaAtual().getFocoAtual() instanceof AbasItemTarefa))
			throw new ErroAutomacao("A página atual não é uma instâncida de [AbasItemTarefa].");

		((AbasTarefas) getPaginaAtual().getFocoAtual()).finalizarTarefa(tarefa);
	}

	@When("^o sistema apresentar \"([^\"]*)\"$")
	public void oSistemaApresentar(String arg1) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instâncida de [AbasRegistrarSinistroPage].");

		try {
			((AbasNotas) getPaginaAtual().getFocoAtual()).oSistemaApresentara(arg1);
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação do que foi apresentado.");
		}
	}

	@When("^validar o registro \"([^\"]*)\"$")
	public void validarRegistroGenerico(String registro) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instâncida de [AbasRegistrarSinistroPage].");

		try {
			((AbasNotas) getPaginaAtual().getFocoAtual()).validarRegistro(registro);
		} catch (ErroAutomacao e) {
			BRQLogger.info("O Foco atual da página não tem um método para validar o registro [%s].", registro);
		}
	}

	@When("^validar tarefa \"(.*?)\" informando:$")
	public static void validarTarefaInformando(String tarefa, DataTable dt) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instâncida de [AbasRegistrarSinistroPage].");

		try {

			if (dt.topCells().size() == 2)
				((AbasTarefas) getPaginaAtual().getFocoAtual()).validarDadosDaTarefa(tarefa,
						dt.asMap(String.class, String.class));
			else
				((AbasTarefas) getPaginaAtual().getFocoAtual()).validarDadosDaTarefa(tarefa, dt.asList(String.class));
		} catch (ErroAutomacao e) {
			BRQLogger.info("O Foco atual da página não tem um método para validar os dados [%s] da tarefa [%s].",
					dt.toString(), tarefa);
		}
	}

	@Then("^o sistema exibe a tela de Aviso de Sinistro com a \"(.*?)\"$")
	public static void validaTela(String abaAtual) throws Throwable {
		if (!(getPaginaAtual() instanceof AbasRegistrarSinistroPage))
			throw new ErroAutomacao("A página atual não é uma instância de [AbasRegistrarSinistroPage].");

		try {
			((AbasRegistrarSinistroPage) getPaginaAtual()).modalDadosBasicos();
		} finally {
			String printPath = getPaginaAtual().printAndSave(getCurrentScenario());
			Reporter.addScreenCaptureFromPath(printPath, "Validação da aba atual.");
		}
	}

	@When("^(?:o sistema )?abre uma aba com o nome do fornecedor$")
    public void oSistemaAbreUmaAbaComONomeDoFornecedor() {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instâncida de [AbasRegistrarSinistroPage].");

		((SPTarefasEncerradas) getPaginaAtual()).abaFornecedor();
	}

}
