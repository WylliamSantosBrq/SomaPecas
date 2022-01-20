package com.brq.steps;

import java.util.List;
import java.util.Map;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Tabelas;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TabelasSteps extends StepsMaster {

	@Given("^que (?:o usuário )?preencheu a tabela \"(.*?)\":$")
	@When("^(?:o usuário )?preencher a tabela \"(.*?)\":$")
	public void preencherATabela(String tabela, List<Map<String, Object>> valoresTabela) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).preencherLinhas(tabela, valoresTabela);
	}

	@Given("^que (?:o usuário )?preencheu a tabela:$")
	@When("^(?:o usuário )?preencher a tabela:$")
	public void preencherATabela(List<Map<String, Object>> valoresTabela) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).preencherLinhas(null, valoresTabela);
	}

	@Given("^que (?:o usuário )?desmarcou a célula \"(.*?)\" do item \"(.*?)\" da tabela \"(.*?)\"$")
	@When("^(?:o usuário )?desmarcar a célula \"(.*?)\" do item \"(.*?)\" da tabela \"(.*?)\"$")
	public void desmarcarATabela(String coluna, String linha, String tabela) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).preencherCelula(tabela, linha, coluna, new Boolean(false));
	}

	@Given("^que (?:o usuário )?desmarcou a célula \"(.*?)\" do item \"(.*?)\"$")
	@When("^(?:o usuário )?desmarcar a célula \"(.*?)\" do item \"(.*?)\"$")
	public void desmarcarATabela(String coluna, String linha) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).preencherCelula(null, linha, coluna, new Boolean(false));
	}

	@Given("^que (?:o usuário )?marcou a célula \"(.*?)\" do item \"(.*?)\" da tabela \"(.*?)\"$")
	@When("^(?:o usuário )?marcar a célula \"(.*?)\" do item \"(.*?)\" da tabela \"(.*?)\"$")
	public void marcarATabela(String coluna, String linha, String tabela) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).preencherCelula(tabela, linha, coluna, new Boolean(true));
	}

	@Given("^que (?:o usuário )?marcou a célula \"(.*?)\" do item \"(.*?)\"$")
	@When("^(?:o usuário )?marcar a célula \"(.*?)\" do item \"(.*?)\"$")
	public void marcarATabela(String coluna, String linha) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).preencherCelula(null, linha, coluna, new Boolean(true));
	}

	@Given("^que (?:o usuário )?clicou na célula \"(.*?)\" do item \"(.*?)\" da tabela \"(.*?)\"$")
	@When("^(?:o usuário )?clicar na célula \"(.*?)\" do item \"(.*?)\" da tabela \"(.*?)\"$")
	public void clicarATabela(String coluna, String linha, String tabela) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).clicarCelula(tabela, linha, coluna);
	}

	@Given("^que (?:o usuário )?clicou na célula \"(.*?)\" do item \"(.*?)\"$")
	@When("^(?:o usuário )?clicar na célula \"(.*?)\" do item \"(.*?)\"$")
	public void clicarATabela(String coluna, String linha) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		((Tabelas) getPaginaAtual()).clicarCelula(null, linha, coluna);
	}

	@Then("^o sistema apresentará os seguintes campos na tabela \"(.*?)\":$")
	public void oSistemaApresentaraOsSeguintesCamposNaTabela(String tabela, DataTable dt) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		if (dt.topCells().size() == 2)
			((Tabelas) getPaginaAtual()).validarCelulas(tabela, dt.asMap(String.class, String.class));
		else
			((Tabelas) getPaginaAtual()).validarCelulas(tabela, dt.asList(String.class));

	}

	@Then("^o sistema apresentará os seguintes campos preenchidos na tabela \"(.*?)\":$")
	public void oSistemaApresentaraOsSeguintesCamposPreenchidosNaTabela(String tabela, DataTable dt) {
		if (!(getPaginaAtual() instanceof Tabelas))
			throw new ErroAutomacao("A página [%s] não é uma instância de [%s].", getPaginaAtual().getClass(),
					Tabelas.class);

		if (dt.topCells().size() == 2) {
//			((Tabelas) getPaginaAtual()).validarCamposPreenchidos(tabela, dt.asMap(String.class, String.class));
		}
		else
			((Tabelas) getPaginaAtual()).validarCamposPreenchidos(tabela, dt.asList(String.class));

	}

}
