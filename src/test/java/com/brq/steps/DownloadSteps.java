package com.brq.steps;

import cucumber.api.java.en.Then;

public class DownloadSteps extends StepsMaster {

		@Then("^o arquivo \"(.*?)\" será baixado$")
		public static void validarDownload(String arquivo) {
			getPaginaAtual().esperarSegundos(15);
		}
	
}
