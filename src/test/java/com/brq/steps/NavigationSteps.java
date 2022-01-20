package com.brq.steps;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Abas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.abas.AbasGeracaoDeCartasEmPdfPage;
import com.brq.pages.abas.AbasRegistrarSinistroPage;
import com.brq.pages.abas.AbasU10HomePage;
import com.brq.pages.sistemascorporativos.SCHomePage;
import com.brq.pages.somapecas.SPDashBoardPage;
import com.brq.pages.somapecas.SPPesquisaPedidoPage;
import com.brq.pages.somapecas.SPTarefasEncerradas;
import com.brq.pages.somapecas.focos.SPAtenderPedido;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class NavigationSteps extends StepsMaster {

	@Given("^que (?:o usuário )?acessou a URL \"(.*?)\"$")
	@When("^acessar a URL \"(.*?)\"$")
	public void queEuAcesseAURL(String url) throws Throwable {
		getPaginaAtual().acessarUrl(url);
	}

	@Given("^que (?:o usuário )?acessou o sistema (.*?)$")
	@When("^(?:o usuário )?acessar o sistema (.*?)$")
	public void acessarOSistema(String sistema) {
		getPaginaAtual().acessarSistema(sistema);
	}

	@Given("^que (?:o usuário )?clicou (?:em \"(.*?)\"|n[oa] (.*?))$")
	@When("^(?:o usuário )?clicar (?:em \"(.*?)\"|n[oa] (.*?))$")
	public void queEuCliqueEm(String botaoEm, String botaoNo) throws Throwable {
		String botao = botaoEm == null ? botaoNo : botaoEm;

		if (getPaginaAtual().getFocoAtual() != null) {
			try {
				getPaginaAtual().getFocoAtual().clicarEm(botao);
				return;
			} catch (ErroAutomacao e) {
				BRQLogger.info("O Foco atual da página não tem um método para clicar em [%s].", botao);
			}
		}

		getPaginaAtual().clicarEm(botao);
	}

	@Given("^que (?:o usuário )?tem como foco (.*?)$")
	@When("^ter como foco (.*?)$")
	public void terComoFoco(String foco) throws Throwable {
		getPaginaAtual().focar(foco);
	}

	@Given("^que (?:o usuário )?voltou para \"(.*?)\"$")
	@When("^voltar para \"(.*?)\"$")
	public void voltarPara(String pagina) throws Throwable {
//		BrowserHelper.manterJanelasAbertas(1);

		switch (pagina) {
		case "Abas":
			DriverWeb.getDriver().manage().deleteAllCookies();
			getPaginaAtual().trocarJanelaPorTituloContains("Aviso de Sinistro");
			setPaginaAtual(new AbasRegistrarSinistroPage());
			getPaginaAtual().fecharJanela("Novo Sinistro Auto");
			break;

		case "Sistemas Corporativos":
			DriverWeb.getDriver().manage().deleteAllCookies();
			getPaginaAtual().trocarJanelaPorUrlContains("http://aplwebhml.portoseguro.brasil/seweb/trs/");
			setPaginaAtual(new SCHomePage());
			break;

		case "Acompanhamento de sinistro":
			getPaginaAtual().trocarJanelaPorTituloContains("Sinistro Auto");
			setPaginaAtual(new AbasU10HomePage());
			break;

		case "Geração de Cartas em PDF":
			getPaginaAtual().trocarJanelaPorTituloContains("Novo Sinistro Auto");
			setPaginaAtual(new AbasGeracaoDeCartasEmPdfPage());
			break;

		case "Atender Pedido":
			getPaginaAtual().trocarJanelaPorUrlContains("dashboard.xhtml");
			setPaginaAtual(new SPDashBoardPage(new SPAtenderPedido()));
			break;

		default:
			throw new ErroAutomacao("Página não definida no método [voltarPara].");
		}
	}

	@Given("^que (?:o usuário )?mudou para a aba \"(.*?)\"$")
	@When("^(?:o usuário )?mudar para a aba \"(.*?)\"$")
	public void queEuMudeParaAAba(String nomeDaAba) throws Throwable {
		if (!(getPaginaAtual() instanceof Abas))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Aba].", getPaginaAtual().getClass());

		((Abas) getPaginaAtual()).mudarAba(nomeDaAba);
	}

	@Given("^que (?:o usuário )?atualizou a página$")
	@When("^atualizar a página$")
	public void atualizarNavegador() {
		getPaginaAtual().atualizarPagina();
	}

	@Given("^que (?:o usuário )?fechou a janela de (.*?)$")
	@When("^(?:o usuário )?fechar a janela de (.*?)$")
	public void fechar(String janela) {
		getPaginaAtual().fecharJanela(janela);
	}

	@Given("^que (?:o usuário )?fechou a caixa de \"(.*?)\"$")
	@When("^(?:o usuário )?fechar a caixa de \"(.*?)\"$")
	public void fecharACaixaDe(String caixa) {
		getPaginaAtual().fecharCaixa(caixa);
	}

	@Given("^que (?:o usuário )?fechou a janela atual$")
	@When("^(?:o usuário )?fechar a janela atual$")
	public void fecharAJanelaAtual() {
		getPaginaAtual().fecharAba();
	}

	@When("^(?:o usuário )?mover o cursor sobre \"(.*?)\"$")
	public void moverCursorSobre(String objeto) {
		getPaginaAtual().moverCursorSobre(objeto);
	}

	@When("^opto por clicar em Pesquisar$")
    public void optoPorClicarEmPesquisar() {
		if (!(getPaginaAtual() instanceof SPPesquisaPedidoPage))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [SPPesquisaPedidoPage].", getPaginaAtual().getClass());

		((SPPesquisaPedidoPage) getPaginaAtual()).clicarEmPesquisar();
	}

	@When("^opto por clicar na aba com o nome do fornecedor$")
	public void optoPorClicarNaAbaComONomeDoFornecedor() {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instâncida de [Pagina].");

		((SPTarefasEncerradas)getPaginaAtual()).acaoAbaForncedor();
	}

	@When("^fecho Informações Fornecedor$")
	public void fechoInformacaoFornecedor() {
		if (!(getPaginaAtual() instanceof Pagina))
			throw new ErroAutomacao("A página atual não é uma instâncida de [Pagina].");

		((SPTarefasEncerradas)getPaginaAtual()).acaoAbaForncedor();
	}

}
