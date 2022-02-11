package com.brq.interfaces.web;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroTimeout;
import com.brq.interfaces.log.BRQLogger;

public interface IEsperaBrowser {

	/**
	 * Espera a URL da página atual ser igual à definida.
	 * 
	 * @param url             A URL desejada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	default void esperarUrlSerCarregada(String url, int tempoEmSegundos) {
		BRQLogger.logMethod(url, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * Espera a página atual ser carregada usando o método
	 * {@code return document.readyState} do Javascript.
	 * 
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	default void esperarPaginaSerCarregada(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		ExpectedCondition<Boolean> pageLoadCondition = webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete");

		wait.until(pageLoadCondition);
	}

	/**
	 * Espera uma quantidade de segundos antes de prosseguir a execução.
	 * 
	 * @param tempoEmSegundos Tempo de espera em segundos.
	 */
	default void esperarSegundos(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		try {
			Thread.sleep(tempoEmSegundos * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Espera uma quantidade de milisegundos antes de prosseguir a execução.
	 * 
	 * @param tempoEmMilisegundos Tempo de espera em milisegundos.
	 */
	default void esperarMilisegundos(long tempoEmMilisegundos) {
		BRQLogger.logMethod(tempoEmMilisegundos);

		try {
			Thread.sleep(tempoEmMilisegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Espera a quantidade total de janelas ser igual o esperado.
	 * 
	 * @param quantidade      Quantidade de janelas esperada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	default void esperarNumeroDeJanelasSer(int quantidade, int tempoEmSegundos) {
		BRQLogger.logMethod(quantidade, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.numberOfWindowsToBe(quantidade));
	}

	/**
	 * Alterna por todas as abas até encontrar alguma que contenha o título
	 * esperado.
	 * 
	 * @param titulo          O título da aba esperada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	default void esperarPaginaAbrir(String titulo, int tempoEmSegundos) {
		BRQLogger.logMethod(titulo, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 1);
		LocalDateTime time = LocalDateTime.now().plusSeconds(tempoEmSegundos);

		do {
			for (String handle : driver.getWindowHandles()) {
				try {
					driver.switchTo().window(handle);
					wait.until(ExpectedConditions.titleIs(titulo));
					return;
				} catch (Exception e) {
					BRQLogger.error(e.getMessage());
				}
			}
		} while (LocalDateTime.now().isBefore(time));

		throw new ErroTimeout("Ocorreu um erro ao esperar a página [%s] abrir.", titulo);
	}

	/**
	 * Alterna por todas as abas até encontrar alguma que contenha parte do título
	 * esperado.
	 * 
	 * @param titulo          O título da aba esperada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	default void esperarPaginaAbrirContains(String titulo, int tempoEmSegundos) {
		BRQLogger.logMethod(titulo, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 1);
		LocalDateTime time = LocalDateTime.now().plusSeconds(tempoEmSegundos);

		do {
			for (String handle : driver.getWindowHandles()) {
				try {

					driver.switchTo().window(handle);
					wait.until(ExpectedConditions.titleContains(titulo));
					return;
				} catch (Exception e) {
					BRQLogger.error(e.getMessage());
				}
			}
		} while (LocalDateTime.now().isBefore(time));

		throw new ErroTimeout("Ocorreu um erro ao esperar a página [%s] abrir.", titulo);
	}

	default void esperarPaginaComElementoAbrir(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 1);
		LocalDateTime time = LocalDateTime.now().plusSeconds(tempoEmSegundos);

		do {
			for (String handle : driver.getWindowHandles()) {
				try {
					driver.switchTo().window(handle);
					wait.until(ExpectedConditions.presenceOfElementLocated(by));
					return;
				} catch (Exception e) {
					BRQLogger.error(e.getMessage());
				}
			}
		} while (LocalDateTime.now().isBefore(time));

		throw new ErroTimeout("Ocorreu um erro ao esperar a página abrir.");
	}

	default void esperarAlertaSumir(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		ExpectedCondition<Boolean> alertaNaoExiste = webDriver -> {
			String handle = driver.getWindowHandle();

			try {
				driver.switchTo().alert();
				return false;

			} catch (Exception e) {
				return true;

			} finally {
				driver.switchTo().window(handle);
			}
		};

		wait.until(alertaNaoExiste);
	}

	default void esperarAlertaPresente(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		ExpectedCondition<Boolean> alertaPresente = webDriver -> {
			String handle = driver.getWindowHandle();

			try {
				driver.switchTo().alert();
				return true;

			} catch (Exception e) {
				return false;

			} finally {
				driver.switchTo().window(handle);
			}
		};

		wait.until(alertaPresente);
	}

	default void esperarCondicao(ExpectedCondition<?> condicao, int tempoEmSegundos) {
		BRQLogger.logMethod(condicao, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		wait.until(condicao);
	}

}
