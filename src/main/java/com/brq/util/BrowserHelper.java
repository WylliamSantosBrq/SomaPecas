package com.brq.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroInesperado;

/**
 * Classe para facilitar em métodos que envolvem apenas o navegador.
 * 
 * @author ymnoda
 *
 */
public class BrowserHelper {

	private BrowserHelper() {
	}

	/**
	 * Mantém a quantidade definida de janelas abertas, fechando todo o resto.
	 * 
	 * @param quantidadeDeJanelasRestantes
	 */
	public static void manterJanelasAbertas(int quantidadeDeJanelasRestantes) {
		WebDriver driver = DriverWeb.getDriver();
		Set<String> windowHandles = driver.getWindowHandles();
		int i = windowHandles.size();

		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (i-- > quantidadeDeJanelasRestantes)
				driver.close();

			else
				return;
		}
	}

	/**
	 * Salva o HTML da página atual na pasta de evidências.
	 */
	public static void salvarHtml() {
		WebDriver driver = DriverWeb.getDriver();

		WebElement htmlElement = driver.findElement(By.tagName("html"));
		String html = htmlElement.getAttribute("innerHTML");
		String path = FileHelper.projectFile("Evidencias", "endState.html");

		try (Writer writer = new FileWriter(path)) {
			writer.write(html);
			writer.flush();

		} catch (IOException e) {
			throw new ErroInesperado(e, "Ocorreu um erro ao tentar salvar o HTML da página atual.");
		}
	}
	
}
