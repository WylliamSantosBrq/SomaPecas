package com.brq.steps;

import java.util.List;
import java.util.Map;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Campos;
import com.brq.interfaces.Combos;
import com.brq.interfaces.Formulario;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;
import com.brq.pages.Pagina;
import com.brq.pages.abas.AbasRegistrarSinistroPage;

import com.brq.pages.somapecas.SPDashBoardPage;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CamposSteps extends StepsMaster {

	@Given("^que (?:o usuário )?preencheu os campos obrigatórios$")
	@When("^preencher os campos obrigatórios$")
	public void preencherOsCamposObrigatoriosStep() throws Throwable {
		if (!(getPaginaAtual() instanceof Formulario))
			throw new ErroAutomacao("A página atual não é uma instância de [Formulario].");

		((Formulario) getPaginaAtual()).preencherOsCamposObrigatorios();
	}

	@Given("^que (?:o usuário )?preencheu os campos de \"(.*?)\" com \"(.*?)\"$")
	@When("^preencher os campos de \"(.*?)\" com \"(.*?)\"$")
	public void preencherOsCamposDe(String labelDosCampos, String valor) throws Throwable {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Campos].",
					getPaginaAtual().getClass());

		((Campos) getPaginaAtual()).preencherCampos(labelDosCampos, valor);
	}

	@Given("^que (?:o usuário )?preencheu o campo \"(.*?)\" com \"(.*?)\"$")
	@When("^preencher o campo \"(.*?)\" com \"(.*?)\"$")
	public void preencherOCampo(String labelDoCampo, String valor) throws Throwable {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Campos].",
					getPaginaAtual().getClass());

		((Campos) getPaginaAtual()).preencherCampo(labelDoCampo, valor);
	}

	@Given("^que (?:o usuário )?preencheu os campos:$")
	@When("^(?:o usuário )?preencher os campos:$")
	public void preencherOsCamposDe(Map<String, String> valores) throws Throwable {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual não é uma instância de [Campos].");

		((Campos) getPaginaAtual()).preencherCampos(valores);
	}

	@Then("^apresentará os campos:$")
	public void validarOsCampos(DataTable dt) throws Throwable {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual não é uma instância de [Campos].");

		if (dt.topCells().size() == 2)
			((Campos) getPaginaAtual()).validarCampos(dt.asMap(String.class, Object.class));
		else
			((Campos) getPaginaAtual()).validarCamposPreenchidos(dt.asList(String.class));
	}

	@Given("^que (?:o usuário )?selecionou nos combos:$")
	@When("^selecionar nos combos:$")
	public void preencherOsCombosDe(Map<String, String> valores) throws Throwable {
		if (!(getPaginaAtual() instanceof Combos))
			throw new ErroAutomacao("A página atual não é uma instância de [Combos].");

		((Combos) getPaginaAtual()).selecionarCombos(valores);
	}

	@Given("^que (?:o usuário )?selecionou a opção \"(.*?)\" no combo \"(.*?)\"$")
	@When("^selecionar a opção \"(.*?)\" no combo \"(.*?)\"$")
	public static void selecionarAOpcaoNoCombo(String opcao, String combo) {

		if (getPaginaAtual().getFocoAtual() != null) {
			if (!(getPaginaAtual().getFocoAtual() instanceof Combos))
				throw new ErroAutomacao("O foco da página atual não é uma instância de [Combos].");

			try {
				((Combos) getPaginaAtual().getFocoAtual()).selecionarCombo(combo, opcao);
				return;
			} catch (ErroAutomacao e) {
				BRQLogger.info("O Foco atual da página não tem um método para selecionar no combo [%s].", combo);
			}
		}

		if (!(getPaginaAtual() instanceof Combos))
			throw new ErroAutomacao("A página atual não é uma instância de [Combos].");

		((Combos) getPaginaAtual()).selecionarCombo(combo, opcao);
	}

	@Then("^apresentar o campo \"([^\"]*)\" preenchido$")
	public void apresentarOCampoPreenchido(String campo) throws Throwable {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual não é uma instância de [Campos].");

		((Campos) getPaginaAtual()).validarCampoPreenchido(campo);
	}

	@Then("^validar se possui dados do veículo causador$")
	public void validarSePossuiDadosDoVeículoCausador() throws Throwable {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual não é uma instância de [Campos].");

		((AbasRegistrarSinistroPage) getPaginaAtual()).validarDadosCausador();
	}

	@Then("^os seguintes campos estarão disponíveis para preenchimento:$")
	public void osSeguintesCamposEstaraoDisponiveisParaPreenchimento(List<String> campos) {
		if (!(getPaginaAtual() instanceof Campos))
			throw new ErroAutomacao("A página atual não é uma instância de [Campos].");

		((Campos) getPaginaAtual()).validarCamposDisponiveis(campos);
	}

	@Then("^(?:o usuário )selecionar a opção \"(.*?)\" no combo \"(.*?)\" da \"(.*?)\"$")
	public static void selecionarAOpcaoNoComboPecas(String opcao, String combo, String peca) {

		if (!(getPaginaAtual() instanceof Combos))
			throw new ErroAutomacao("A página atual não é uma instância de [Combos].");

		((SPDashBoardPage) getPaginaAtual()).validarDadosCombo(opcao, combo);
	}

	@Then("^(?:o sistema )?o combo \"(.*?)\" terá a opção \"(.*?)\" selecionada em cada uma das peças$")
	public void oComboTeráAOpçãoSelecionadaEmCadaUmaDasPeças(String textoCombo, String textoComboFinal) throws Throwable {
		if (!(getPaginaAtual() instanceof Combos))
			throw new ErroAutomacao("A página atual não é uma instância de [Combos].");
		((SPDashBoardPage) getPaginaAtual()).validarDadosCombo(textoCombo, textoComboFinal);
	}

	@Then("^opto por selecionar ação \"(.*?)\" em atender pedido$")
	public void selecionarComboPedido(String textoCombo) throws Throwable {
		if (!(getPaginaAtual() instanceof Combos))
			throw new ErroAutomacao("A página atual não é uma instância de [Combos].");
		((SPDashBoardPage) getPaginaAtual()).selecionarPedido(textoCombo);
	}

	@When("^clico no botão \"(.*?)\"$")
	public void clicarEm(String campo) throws Throwable {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instância de [Pagina].");
		((Pagina) getPaginaAtual()).clicarEm(campo);
	}

	@When("^opto por expandir o menu \"(.*?)\"$")
    public void optoPorExpandirOMenu(String campo) {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instância de [Pagina].");

		((Pagina) getPaginaAtual()).clicarEm(campo);
    }

	@When("^altero o valor para \"([^\"]*)\"$")
	public void optoPorAlterarValor(String valor) {
		if (!(getPaginaAtual() instanceof SPDashBoardPage))
			throw new ErroAutomacao("A página atual não é uma instâncida de [SPDashBoardPage].");

		((SPDashBoardPage) getPaginaAtual()).preencherValor(valor);
	}

	@When("^preencho o motivo da alteração do valor$")
	public void preeenchoMotivoAlteracao() {
		if (!(getPaginaAtual() instanceof SPDashBoardPage))
			throw new ErroAutomacao("A página atual não é uma instâncida de [SPDashBoardPage].");

		((SPDashBoardPage) getPaginaAtual()).preencherMotivoAlteracao("Automação de testes brq");
	}

	@When("^preencho o motivo da peça alterada$")
	public void preencherMotivoPecaAlterada() {

	}

}
