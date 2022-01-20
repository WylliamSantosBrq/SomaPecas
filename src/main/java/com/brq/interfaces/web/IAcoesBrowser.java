package com.brq.interfaces.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface para simular ações do navegador.
 */
public interface IAcoesBrowser {

	/**
	 * Acessa a URL
	 * 
	 * @param url
	 */
	default void abrirUrl(String url) {
		BRQLogger.logMethod(url);

		DriverWeb.getDriver().get(url);
	}

	/**
	 * Abre uma nova guia no navegador usando o comando CTRL + T.
	 */
	default void abrirNovaGuiaDoNavegador() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		By page = By.cssSelector("body");
		driver.findElement(page).sendKeys(Keys.CONTROL + "t");
	}

	/**
	 * Muda para a janela que foi aberta após a atual.
	 */
	default void trocarProximaJanela() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());

		int indiceDaJanelaAtual = handles.indexOf(DriverWeb.getDriver().getWindowHandle());

		driver.switchTo().window(handles.get(indiceDaJanelaAtual + 1));
	}

	/**
	 * Muda o foco para a janela com o índice definido.
	 * 
	 * @param indice
	 */
	default void trocarJanelaPorIndice(Integer indice) {
		BRQLogger.logMethod(indice);

		WebDriver driver = DriverWeb.getDriver();
		ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(indice));
	}

	/**
	 * Muda o foco para a janela com o handle definido.
	 * 
	 * @param handle
	 */
	default void trocarJanelaPorHandle(String handle) {
		BRQLogger.logMethod(handle);

		DriverWeb.getDriver().switchTo().window(handle);
	}

	default void trocarJanelaPorTitulo(String titulo) {
		BRQLogger.logMethod(titulo);

		WebDriver driver = DriverWeb.getDriver();

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(titulo))
				return;
		}

		throw new ErroInesperado("Não foi possível encontrar a janela com título [%s].", titulo);
	}

	default void trocarJanelaPorTituloContains(String titulo) {
		BRQLogger.logMethod(titulo);

		WebDriver driver = DriverWeb.getDriver();

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			String tituloLabel = driver.getTitle();
			if (driver.getTitle().contains(titulo))
				return;
		}

		throw new ErroInesperado("Não foi possível encontrar a janela com título [%s].", titulo);
	}

	default void trocarJanelaPorUrlContains(String url) {
		BRQLogger.logMethod(url);

		WebDriver driver = DriverWeb.getDriver();

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(url))
				return;
		}

		throw new ErroInesperado("Não foi possível encontrar a janela com título [%s].", url);
	}

	/**
	 * Muda o foco para a última janela aberta.
	 */
	default void trocarParaUltimaJanela() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		int quantidadeDeJanelas = driver.getWindowHandles().size();
		trocarJanelaPorIndice(quantidadeDeJanelas - 1);
	}

	/**
	 * Duplica a aba atual.
	 */
	default void duplicarAba() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		String url = driver.getCurrentUrl();

		abrirNovaGuiaDoNavegador();
		trocarParaUltimaJanela();
		abrirUrl(url);
	}

	/**
	 * Fecha a aba com o índice definido.
	 * 
	 * @param indice
	 */
	default void fecharAba(int indice) {
		BRQLogger.logMethod(indice);

		WebDriver driver = DriverWeb.getDriver();
		String handleDaJanelaASerFechada = new ArrayList<String>(driver.getWindowHandles()).get(indice);
		driver.switchTo().window(handleDaJanelaASerFechada).close();
	}

	/**
	 * Fecha a aba com o handle definido.
	 * 
	 * @param handle
	 */
	default void fecharAba(String handle) {
		BRQLogger.logMethod(handle);

		DriverWeb.getDriver().switchTo().window(handle).close();
	}

	/**
	 * Fecha a aba atual do navegador.
	 */
	default void fecharAba() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		Set<String> handles = driver.getWindowHandles();

		driver.close();
		driver.switchTo().window((String) handles.toArray()[0]);
	}

	/**
	 * Atualiza a página atual.
	 */
	default void atualizarPagina() {
		BRQLogger.logMethod();

		DriverWeb.getDriver().navigate().refresh();
	}

	/**
	 * Obtém o log do console do navegador.
	 * 
	 * @return
	 */
	default List<String> getConsoleLogs() {
		BRQLogger.logMethod();

		ArrayList<String> out = new ArrayList<>();
		LogEntries entries = DriverWeb.getDriver().manage().logs().get(LogType.BROWSER);

		for (LogEntry entry : entries) {
			String log = String.format("[%5s] %s - %s", entry.getLevel().getName(), entry.getTimestamp(),
					entry.getMessage());
			out.add(log);
		}

		return out;
	}

	default String getCodigoFonte() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();

		return driver.getPageSource();
	}

	default String titulo() {
		BRQLogger.logMethod();
		WebDriver driver = DriverWeb.getDriver();
		return driver.getTitle();
	}

	default String url() {
		BRQLogger.logMethod();
		WebDriver driver = DriverWeb.getDriver();
		return driver.getCurrentUrl();
	}

}