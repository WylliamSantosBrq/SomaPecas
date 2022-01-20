package com.brq.steps;

import java.util.Map;

import com.brq.dados.DadosSinistro;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Pesquisa;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PesquisaSteps extends StepsMaster {

	@Given("^que (?:o usuário )?pesquisou \"(.*?)\"$")
	@When("^pesquisar \"(.*?)\"$")
	public void queEuPesquise(String textoParaPesquisar) throws Throwable {
		if (!(getPaginaAtual() instanceof Pesquisa))
			throw new ErroAutomacao("A página atual não é uma instância de [Pesquisa].");

		((Pesquisa) getPaginaAtual()).pesquisar(textoParaPesquisar);
	}

	@Given("^que (?:o usuário )?selecionou o primeiro resultado$")
	@When("^selecionar o primeiro resultado$")
	public void queEuSelecioneOPrimeiroResultado() throws Throwable {
		if (!(getPaginaAtual() instanceof Pesquisa))
			throw new ErroAutomacao("A página atual não é uma instância de [Pesquisa].");

		((Pesquisa) getPaginaAtual()).selecionarPrimeiroResultado();
	}

	@Given("^que (?:o usuário )?pesquisou o sinistro$")
	@When("^pesquisar o sinistro$")
	public void pesquisarOSinistro() throws Throwable {
		if (!(getPaginaAtual() instanceof Pesquisa))
			throw new ErroAutomacao("A página atual não é uma instância de [Pesquisa].");

		((Pesquisa) getPaginaAtual()).pesquisar(DadosSinistro.getSinistroCompleto());
	}

	@Given("^que (?:o usuário )?filtrou por:$")
	@When("^filtrar por:$")
	public void filtrarPor(Map<String, String> filtros) {
		if (!(getPaginaAtual() instanceof Pesquisa))
			throw new ErroAutomacao("A página atual não é uma instância de [Pesquisa].");

		((Pesquisa) getPaginaAtual()).filtrarPor(filtros);
	}

}
