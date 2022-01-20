package com.brq.steps;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TesteSteps extends StepsMaster {
	String str;

	public TesteSteps() {
	}

	@When("^colocar a docstring:$")
	public void euColocoAString(String docstring) {
		str = docstring;
	}
	
	@Then("^estará salvo na variavel str$")
	public void estaraSalvoNaVariavelStr() {
		System.out.println("--------------------");
		System.out.println(str);
	}
	
	@Then("^dará certo$")
	public void daraCerto() {
		BRQLogger.info("Deu certo");
	}
	
	@When("^ler o que existe em tela$")
	public void lerOQueExisteEmTela() {
		Screen s = new Screen();
		
		try {
			s.findText("GUIA CJ-CO");
			s.click("EMBLEMA");
		} catch (FindFailed e) {
			throw new ErroAutomacao(e);
		}
	}
	
}
