package com.brq.interfaces.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos de espera.
 */
public interface IEsperaWeb {

	/**
	 * Espera o elemento ser visível e disponível para ser clicado.
	 * 
	 * @param by              O by que define o elemento a ser clicado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerClicavel(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		///driver.findElement(By.xpath("//h2[text()='Selectors']"));
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Espera o elemento ser visível e disponível para ser clicado.
	 * 
	 * @param elemento        O elemento a ser clicado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerClicavel(WebElement elemento, int tempoEmSegundos) {
		BRQLogger.logMethod(elemento, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	/**
	 * Espera o elemento ser selecionado.
	 * 
	 * @param by              O by que define o elemento a ser validado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerSelecionado(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.elementToBeSelected(by));
	}

	/**
	 * Espera o elemento ser selecionado.
	 * 
	 * @param elemento        O elemento a ser validado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerSelecionado(WebElement elemento, int tempoEmSegundos) {
		BRQLogger.logMethod(elemento, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.elementToBeSelected(elemento));
	}

	/**
	 * Espera algum elemento com o By definido existir no HTML, mesmo que invisível.
	 * 
	 * @param by              O By usado para localizar o elemento.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoExistir(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Espera o primeiro elemento encontrado pelo By ser invisível.
	 * 
	 * @param by              O By usado para localizar o elemento.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerInvisivel(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * Espera o elemento ser invisível.
	 * 
	 * @param elemento        O elemento observado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerInvisivel(WebElement elemento, int tempoEmSegundos) {
		BRQLogger.logMethod(elemento, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.invisibilityOf(elemento));
	}

	/**
	 * Espera o primeiro elemento encontrado pelo By ser visível.
	 * 
	 * @param by              O By usado para localizar o elemento.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerVisivel(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * Espera o elemento ser visível.
	 * 
	 * @param elemento        O elemento observado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoSerVisivel(WebElement elemento, int tempoEmSegundos) {
		BRQLogger.logMethod(elemento, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.visibilityOf(elemento));
	}

	/**
	 * Espera algum elemento que contenha o texto definido.
	 * 
	 * @param texto           O texto esperado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoPorTextoVisivel(String texto, int tempoEmSegundos) {
		BRQLogger.logMethod(texto, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		By by = By.xpath(String.format("//*[text()='%s']", texto));

		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Espera o primeiro campo encontrado pelo By conter algum valor.
	 * 
	 * @param by              O By usado para localizar o elemento.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarCampoConterValor(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		WebElement elemento = driver.findElement(by);

		wait.until(ExpectedConditions.attributeToBeNotEmpty(elemento, "value"));
	}

	/**
	 * Espera o campo definido conter algum valor.
	 * 
	 * @param elemento        O elemento observado.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarCampoConterValor(WebElement elemento, int tempoEmSegundos) {
		BRQLogger.logMethod(elemento, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.attributeToBeNotEmpty(elemento, "value"));
	}

	/**
	 * Espera uma quantidade de segundos antes de prosseguir a execução.
	 * 
	 * @param tempoEmSegundos Tempo de espera em segundos.
	 */
	static void esperarSegundos(int tempoEmSegundos) {
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
	static void esperarMilisegundos(long tempoEmMilisegundos) {
		BRQLogger.logMethod(tempoEmMilisegundos);

		try {
			Thread.sleep(tempoEmMilisegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Espera a quantidade de com.brq.elementos encontrados pelo By ser igual o esperado.
	 * 
	 * @param by              O By usado para localizar o(s) elemento(s).
	 * @param quantidade      A quantidade de com.brq.elementos esperada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarNumeroDeElementosSer(By by, int quantidade, int tempoEmSegundos) {
		BRQLogger.logMethod(by, quantidade, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.numberOfElementsToBe(by, quantidade));
	}

	/**
	 * Espera a quantidade de com.brq.elementos encontrados pelo By ser maior que o
	 * esperado.
	 * 
	 * @param by              O By usado para localizar o(s) elemento(s).
	 * @param quantidade      A quantidade mínima de com.brq.elementos esperada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarNumeroDeElementoSerMaiorQue(By by, int quantidade, int tempoEmSegundos) {
		BRQLogger.logMethod(by, quantidade, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, quantidade));
	}

	/**
	 * Espera a quantidade de com.brq.elementos encontrados pelo By ser menor que o
	 * esperado.
	 * 
	 * @param by              O By usado para localizar o(s) elemento(s).
	 * @param quantidade      A quantidade máxima de com.brq.elementos esperada.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarNumeroDeElementoSerMenorQue(By by, int quantidade, int tempoEmSegundos) {
		BRQLogger.logMethod(by, quantidade, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);

		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by, quantidade));
	}

	/**
	 * Espera todos os com.brq.elementos encontrados pelo By serem invisíveis.
	 * 
	 * @param by              O By usado para encontrar o(s) elemento(s).
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementosSeremInvisiveis(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		List<WebElement> elementos = driver.findElements(by);

		wait.until(ExpectedConditions.invisibilityOfAllElements(elementos));
	}

	/**
	 * Espera todos os com.brq.elementos da lista serem invisíveis.
	 * 
	 * @param bies            Lista de com.brq.elementos observados.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementosSeremInvisiveis(List<By> bies, int tempoEmSegundos) {
		BRQLogger.logMethod(bies, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		ExpectedCondition<Boolean> elementosSeremInvisiveis = webDriver -> {
			for (By by : bies) {
				try {
					esperarMilisegundos(500);
					esperarElementosSeremInvisiveis(by, 1);
				} catch (Exception e) {
					return false;
				}
			}
			return true;
		};

		wait.until(elementosSeremInvisiveis);
	}

	/**
	 * Espera o primeiro elemento encontrado pelo By conter algum texto.
	 * 
	 * @param by              O By usado para encontra o elemento.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoConterTexto(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		ExpectedCondition<Boolean> elementoConterTexto = webDriver -> {
			WebElement elemento = webDriver.findElement(by);
			String textoDoElemento = elemento.getText();
			return textoDoElemento != null && !textoDoElemento.replaceAll("\\s", "").isEmpty();
		};

		wait.until(elementoConterTexto);
	}

	/**
	 * Espera o primeiro elemento encontrado pelo By conter algum texto, mesmo que o
	 * elemento tenha o atributo {@code hidden}.
	 * 
	 * @param by              O By usado para encontrar o elemento.
	 * @param tempoEmSegundos O tempo máximo de espera antes de jogar um erro.
	 */
	static void esperarElementoConterTextoHidden(By by, int tempoEmSegundos) {
		BRQLogger.logMethod(by, tempoEmSegundos);

		WebDriver driver = DriverWeb.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, tempoEmSegundos);
		ExpectedCondition<Boolean> elementoConterTexto = webDriver -> {
			WebElement elemento = webDriver.findElement(by);
			String textoDoElemento = elemento.getAttribute("innerText");
			return textoDoElemento != null && !textoDoElemento.replaceAll("\\s", "").isEmpty();
		};

		wait.until(elementoConterTexto);
	}

}