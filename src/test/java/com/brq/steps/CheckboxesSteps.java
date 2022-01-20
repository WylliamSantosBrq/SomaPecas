package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Checkboxes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CheckboxesSteps extends StepsMaster {

	@Given("^que (?:o usuário )?tenha marcado o item \"(.*?)\"$")
	@When("^(?:o usuário )?marcar o item \"(.*?)\"$")
	public void marcarOItem(String checkbox) {
		if (!(getPaginaAtual() instanceof Checkboxes))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Checkboxes].", getPaginaAtual().getClass());
		
		((Checkboxes) getPaginaAtual()).marcar(checkbox);
	}

	@Given("^que (?:o usuário )?tenha desmarcado o item \"(.*?)\"$")
	@When("^(?:o usuário )?desmarcar o item \"(.*?)\"$")
	public void desmarcarOItem(String checkbox) {
		if (!(getPaginaAtual() instanceof Checkboxes))
			throw new ErroAutomacao("A página atual [%s] não é uma instância de [Checkboxes].", getPaginaAtual().getClass());
		
		((Checkboxes) getPaginaAtual()).desmarcar(checkbox);
	}
	
}
