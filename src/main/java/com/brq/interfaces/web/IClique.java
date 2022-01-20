package com.brq.interfaces.web;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroTimeout;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos para simular cliques do mouse.
 */
public interface IClique {
	Random random = new Random();

	/**
	 * Clica uma vez em cada elemento da lista definida.
	 * 
	 * @param bys Lista de com.brq.elementos a ser clicada.
	 */
	static void clicarElementos(List<By> bys) {
		BRQLogger.logMethod(bys);

		WebDriver driver = DriverWeb.getDriver();

		for (By by : bys) {
			driver.findElement(by).click();
		}
	}

	/**
	 * Clica uma vez em todos os com.brq.elementos que sejam localizados pelo by
	 * definido.
	 * 
	 * @param by O by dos com.brq.elementos a serem clicados.
	 */
	static void clicarElementos(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();

		List<WebElement> elementos = driver.findElements(by);

		for (WebElement element : elementos) {
			element.click();
		}
	}

	/**
	 * Clica uma vez em cada elemento da lista.
	 * 
	 * @param com.brq.elementos A lista de com.brq.elementos a serem clicados.
	 */
	static void clicarWebElementos(List<WebElement> elementos) {
		BRQLogger.logMethod(elementos);

		for (WebElement elemento : elementos) {
			elemento.click();
		}
	}

	/**
	 * Clica no elemento que contenha o texto definido.
	 * 
	 * @param texto O texto que o elemento a ser clicado deve conter.
	 */
	static void clicarElementoPorTextoVisivel(String texto) {
		BRQLogger.logMethod(texto);

		WebDriver driver = DriverWeb.getDriver();
		By by = By.xpath(String.format("//*[text()='%s']", texto));

		driver.findElement(by).click();
	}

	/**
	 * Clica no elemento definido pelo by.
	 * 
	 * @param by O by que define o elemento a ser clicado.
	 */
	static void clicar(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();

		driver.findElement(by).click();
	}

	/**
	 * Clica no nª elemento definido pelo by.
	 * 
	 * @param by     O by que define o elemento a ser clicado.
	 * @param indice O índice do elemento.
	 */
	static void clicar(By by, Integer indice) {
		BRQLogger.logMethod(by, indice);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElements(by).get(indice);

		elemento.click();
	}

	/**
	 * Clica no elemento definido.
	 * 
	 * @param elemento O elemento a ser clicado.
	 */
	static void clicar(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		elemento.click();
	}

	/**
	 * Clica duas vezes consecutivas no elemento definido pelo by.
	 * 
	 * @param by O by que define o elemento a receber o clique.
	 */
	static void duploClique(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		Actions action = new Actions(driver);

		action.doubleClick(driver.findElement(by)).perform();
	}

	/**
	 * Clica duas vezes consecutivas no elemento definido.
	 * 
	 * @param elemento O elemento a receber o clique.
	 */
	static void duploClique(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		WebDriver driver = DriverWeb.getDriver();
		Actions action = new Actions(driver);

		action.doubleClick(elemento).perform();
	}

	/**
	 * Envia o formulário correspondente ao elemento.
	 * 
	 * @param by O by que define o elemento do formulário.
	 */
	static void submeterFormulario(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		driver.findElement(by).submit();
	}

	/**
	 * Envia o formulário correspondente ao elemento.
	 * 
	 * @param elemento O elemento do formulário.
	 */
	static void submeterFormulario(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		elemento.submit();
	}

	/**
	 * Clica duas vezes consecutivas onde quer que esteja o cursor do mouse.
	 */
	static void duploCliqueOndeEstiverOFocoDoMouse() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();
		Actions action = new Actions(driver);

		action.doubleClick().perform();
	}

	/**
	 * Clica aleatóriamente em um dos com.brq.elementos definidos pelo by.
	 * 
	 * @param by O by que define todos os com.brq.elementos que podem receber o
	 *           clique.
	 */
	static void clicarAleatoriamente(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elements = driver.findElements(by);
		int numero = random.nextInt(elements.size());

		elements.get(numero).click();
	}

	/**
	 * Clica em um elemento até que um segundo esteja visível em tela.
	 * 
	 * @param clique              Onde o clique será feito.
	 * @param validacao           O elemento que deve aparecer após o(s) clique(s).
	 * @param quantidadeDeCliques
	 */
	static void clicarAteSerVisivel(By clique, By validacao, int quantidadeDeCliques) {
		BRQLogger.logMethod(clique, validacao, quantidadeDeCliques);

		for (int tentativas = quantidadeDeCliques; tentativas > 0; tentativas--) {
			IEsperaWeb.esperarElementoSerClicavel(clique, 5);
			clicarQuandoNaoForInterceptado(clique, 5);
			IEsperaWeb.esperarMilisegundos(1500);

			try {
				IEsperaWeb.esperarElementoSerVisivel(validacao, 5);
				return;

			} catch (Exception e) {
				BRQLogger.info(Arrays.toString(e.getStackTrace()));
			}
		}

		throw new ErroTimeout("Não foi possível localizar o elemento [%s] ao clicar no elemento [%s].", clique,
				validacao);
	}

	/**
	 * Clica em um elemento até que um segundo esteja invisível em tela.
	 * 
	 * @param clique              Onde o clique será feito.
	 * @param validacao           O elemento que deve se tornar invisível após o(s)
	 *                            clique(s).
	 * @param quantidadeDeCliques
	 */
	static void clicarAteSerInvisivel(By clique, By validacao, int quantidadeDeCliques) {
		BRQLogger.logMethod(clique, validacao, quantidadeDeCliques);

		for (int tentativas = quantidadeDeCliques; tentativas > 0; tentativas--) {
			IEsperaWeb.esperarElementoSerClicavel(clique, 5);
			clicarQuandoNaoForInterceptado(clique, 5);
			IEsperaWeb.esperarMilisegundos(1500);

			try {
				IEsperaWeb.esperarElementoSerInvisivel(validacao, 5);
				return;

			} catch (Exception e) {
				BRQLogger.info(Arrays.toString(e.getStackTrace()));
			}
		}

		throw new ErroTimeout("Não foi possível esperar o elemento [%s] ser invisível ao clicar no elemento [%s].",
				clique, validacao);
	}

	/**
	 * Clica no primeiro elemento até que a quantidade de com.brq.elementos definido
	 * pelo segundo by seja o esperado.
	 * 
	 * @param clique                Onde o clique será feito.
	 * @param validacao             O by do elemento do qual será validado a
	 *                              quantidade.
	 * @param quantidadeDeElementos A quantidade de com.brq.elementos esperada após
	 *                              o(s) clique(s).
	 * @param quantidadeDeCliques   A quantidade de cliques antes de apresentar
	 *                              erro.
	 */
	static void clicarAteNumeroDeElementosSer(By clique, By validacao, int quantidadeDeElementos,
			int quantidadeDeCliques) {
		BRQLogger.logMethod(clique, validacao, quantidadeDeElementos, quantidadeDeCliques);

		clicarAteNumeroDeElementosSer(clique, validacao, quantidadeDeElementos, quantidadeDeCliques, 30);
	}

	/**
	 * Clica no primeiro elemento até que a quantidade de com.brq.elementos definido
	 * pelo segundo by seja o esperado.
	 * 
	 * @param clique                Onde o clique será feito.
	 * @param validacao             O by do elemento do qual será validado a
	 *                              quantidade.
	 * @param quantidadeDeElementos A quantidade de com.brq.elementos esperada após
	 *                              o(s) clique(s).
	 * @param quantidadeDeCliques   A quantidade de cliques antes de apresentar
	 *                              erro.
	 * @param timeoutDoClique       Tempo esperado em cada clique antes de
	 *                              apresentar um erro.
	 */
	static void clicarAteNumeroDeElementosSer(By clique, By validacao, int quantidadeDeElementos,
			int quantidadeDeCliques, int timeoutDoClique) {
		BRQLogger.logMethod(clique, validacao, quantidadeDeElementos, quantidadeDeCliques, timeoutDoClique);

		for (int tentativas = quantidadeDeCliques; tentativas > 0; tentativas--) {

			try {
				IEsperaWeb.esperarNumeroDeElementosSer(validacao, quantidadeDeElementos, 10);
				return;

			} catch (Exception e) {
				BRQLogger.info(Arrays.toString(e.getStackTrace()));

				clicarQuandoNaoForInterceptado(clique, timeoutDoClique);
			}
		}

		throw new ErroTimeout("Quantidade de cliques excedido para a quantidade de com.brq.elementos [%s] ser %d.",
				validacao, quantidadeDeElementos);
	}

	/**
	 * Clica no elemento assim que o clique não retornar
	 * {@link ElementClickInterceptedException}.
	 * 
	 * @param by      O by que define o elemento a receber o clique.
	 * @param timeout O tempo esperado para o clique não ser interceptado.
	 */
	static void clicarQuandoNaoForInterceptado(By by, long timeout) {
		BRQLogger.logMethod(by);

		LocalTime limite = LocalTime.now().plusSeconds(timeout);

		do {
			try {
				IMoverJS.moverParaElementoJavascript(by);
				clicar(by);
				return;

			} catch (ElementClickInterceptedException e) {
				IEsperaWeb.esperarMilisegundos(250);
			}

		} while (LocalTime.now().isBefore(limite));
		throw new ErroTimeout("O clique no elemento [%s] não pôde ser realizado pois ainda está sendo interceptado.",
				by);
	}
}