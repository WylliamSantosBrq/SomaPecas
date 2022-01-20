package com.brq.steps.somapecas;
//package com.brq.steps.somapecas;
//
//import com.brq.erros.ErroAutomacao;
//import com.brq.interfaces.Login;
//import com.brq.interfaces.somapecas.SomaPecasLogin;
//import com.brq.pages.Pagina;
//import com.brq.pages.somapecas.SomaPecasDashBoardPage;
//import com.brq.steps.StepsMaster;
//
//import cucumber.api.java.en.Given;
//
//public class SomaPecasLoginSteps extends StepsMaster {
//
//	public SomaPecasLoginSteps() {
//	}
//
//	@Given("^que (?:o usuário )?esteja logado no Soma Peças como (.*?)$")
//	public void queEuEstejaLogadoNoSomaPecasComo(String persona) throws Throwable {
//		if (!((Login) getPaginaAtual()).logado()) {
//			Pagina paginaRetornada;
//			
//			switch (persona) {
//			case "analista":
//				paginaRetornada = ((SomaPecasLogin) getPaginaAtual()).realizarLogin("371.889.838-10",
//						"seguro10");
//				break;
//
//			default:
//				throw new ErroAutomacao("Persona não definida no método [queEuEstejaLogadoNoSomaPecasComo]");
//			}
//			setPaginaAtual(paginaRetornada);
//			
//		} else {
//			setPaginaAtual(new SomaPecasDashBoardPage());
//		}
//	}
//
//}
