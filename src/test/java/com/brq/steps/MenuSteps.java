package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Menu;
import com.brq.interfaces.MenuLateral;
import com.brq.interfaces.MenuSuperior;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.pages.sistemascorporativos.SCHomePage;

import com.brq.pages.somapecas.focos.SPAtenderPedido;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class MenuSteps extends StepsMaster {

	SCHomePage pagina = new SCHomePage();
	
	@Given("^que (?:o usuário )?acessou o menu \"(.*?)\"$")
	@When("^acessar o menu \"(.*?)\"$")
	public void queEuAcesseOMenu(String listaDeMenus) throws Throwable {
		IEsperaWeb.esperarSegundos(20);
		if (!(getPaginaAtual() instanceof Menu))
			throw new ErroAutomacao("A página atual não é uma instância de [Menu].");
		
		((Menu) getPaginaAtual()).acessarMenu(listaDeMenus.split("\" -> \""));
	}
	
	@Given("^que (?:o usuário )?acessou o menu lateral \"(.*?)\"$")
	@When("^acessar o menu lateral \"(.*?)\"$")
	public void queEuAcesseOMenuLateral(String listaDeMenus) throws Throwable {
		IEsperaWeb.esperarSegundos(20);
		if (!(getPaginaAtual() instanceof MenuLateral))
			throw new ErroAutomacao("A página atual não é uma instância de [MenuLateral].");
		
		((MenuLateral) getPaginaAtual()).acessarMenuLateral(listaDeMenus.split("\" -> \""));
	}
	
	@Given("^que (?:o usuário )?acessou o menu superior \"(.*?)\"$")
	@When("^acessar o menu superior \"(.*?)\"$")
	public void queEuAcesseOMenuSuperior(String listaDeMenus) throws Throwable {
		IEsperaWeb.esperarSegundos(20);
		if (!(getPaginaAtual() instanceof MenuSuperior))
			throw new ErroAutomacao("A página atual não é uma instância de [MenuSuperior].");
		
		((MenuSuperior) getPaginaAtual()).acessarMenuSuperior(listaDeMenus.split("\" -> \""));
	}

	@When("^opto por preencher o campo \"(.*?)\" no menu lateral \"(.*?)\"$")
	public void acessarMenuLateral(String pedido, String nomeMenu) throws Throwable {
		if (!(getPaginaAtual() instanceof Pesquisa))
			throw new ErroAutomacao("A página atual não é uma instância de [MenuSuperior].");
		((Pesquisa) getPaginaAtual()).pesquisar(SPAtenderPedido.NUMERO_PEDIDO);
	}

	@When("^clico no menu superior \"(.*?)\"$")
	public void clicoNoMenuSuperior(String menu) {
		if (!(getPaginaAtual() instanceof Menu))
			throw new ErroAutomacao("A página atual não é uma instância de [Menu].");

		((Menu) getPaginaAtual()).acessarMenu(menu);
	}

	@When("^opto por selecionar o menu principal \"(.*?)\"$")
	public void selecionarMenuPrincipal(String menu) {
		if (!(getPaginaAtual() instanceof Menu))
			throw new ErroAutomacao("A página atual não é uma instância de [Menu].");

		((Menu) getPaginaAtual()).acessarMenu(menu);
	}

}
