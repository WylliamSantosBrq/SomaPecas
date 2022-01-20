package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Anexos;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AnexoSteps extends StepsMaster {

	@Given("^que (?:o usuário )?anexou (\\d+?) (.*?)$")
	@When("^anexar (\\d+?) (.*?)$")
	public void anexarFotos(int quantidadeDeArquivos, String tipoDeArquivo) {
		if (!(getPaginaAtual() instanceof Anexos))
			throw new ErroAutomacao("A página atual não é uma instância de [Anexo].");
		
//		TODO decidir como tratar o tipoDeArquivo. 	
		
		((Anexos) getPaginaAtual()).anexarArquivos(quantidadeDeArquivos);
	}
	
	@Given("^que (?:o usuário )?anexou (.*?)$")
	@When("^(?:o usuário )?anexar (.*?)$")
	public void anexarArquivo(String arquivo) {
		if (!(getPaginaAtual() instanceof Anexos))
			throw new ErroAutomacao("A página atual não é uma instância de [Anexo].");
		
//		TODO decidir como tratar o tipoDeArquivo. 	
		
		((Anexos) getPaginaAtual()).anexarArquivo(arquivo);
	}
	
}
