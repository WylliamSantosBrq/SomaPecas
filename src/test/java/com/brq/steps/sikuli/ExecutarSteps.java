package com.brq.steps.sikuli;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import com.brq.interfaces.Login;
import com.brq.pages.somadesktop.SDLoginPage;
import com.brq.steps.StepsMaster;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ExecutarSteps extends StepsMaster {

	Screen s = new Screen();

	@Given("^que (?:o usuário )?executou SOMA Desktop$")
	@When("^executar SOMA Desktop$")
	public void queExecutouSomaDesktop() throws IOException {
		try {
			String line;
			Process p = Runtime.getRuntime().exec("cmd /c cd C:/SOMA && start start.bat && exit");
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			BufferedReader er = new BufferedReader(new InputStreamReader(p.getErrorStream()));

//			while ((line = in.readLine()) != null)
//				System.out.println(">>>" + line);
//
//			System.out.println("-------------------------");
//
//			while ((line = er.readLine()) != null)
//				System.out.println(">>>" + line);

		} catch (Exception err) {
			err.printStackTrace();
		}
		ImagePath.add("src/test/resources/images.sikuli");
		ImagePath.add("src/test/resources/images.sikuli/tabela_orcamento_pecas");

		setPaginaAtual(new SDLoginPage());

//		System.setProperty("http.proxyHost", "localhost");
//		System.setProperty("http.proxyPort", "8085");
//		System.setProperty("https.proxyHost", "localhost");
//		System.setProperty("https.proxyPort", "8085");
//		System.setProperty("ftp.proxyHost", "localhost");
//		System.setProperty("ftp.proxyPort", "8085");
//		System.setProperty("socksProxyHost", "localhost");
//		System.setProperty("socksProxyPort", "8085");
	}

	@Given("^que fez login no SOMA Desktop$")
	@When("^fazer login no SOMA Desktop$")
	public void queFezLoginNoSomaDesktop() throws InterruptedException, IOException, FindFailed {
		((Login) getPaginaAtual()).realizarLogin();
	}

}
