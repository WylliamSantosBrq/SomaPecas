package com.brq.interfaces.web;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos para simular interações com select no navegador.
 */
public interface ICombo extends IEsperaWeb {

	/**
	 * Seleciona a opção do select que contém o texto definido.
	 * 
	 * @param by    O by que define o select.
	 * @param texto O texto da opção a ser selecionada.
	 */
	static void selecionarComboPorTexto(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		combo.selectByVisibleText(texto);
	}

	/**
	 * Seleciona a opção do select que contém o texto definido.
	 * 
	 * @param elemento O elemento de select.
	 * @param texto    O texto da opção a ser selecionada.
	 */
	static void selecionarComboPorTexto(WebElement elemento, String texto) {
		BRQLogger.logMethod(elemento, texto);

		Select combo = new Select(elemento);

		combo.selectByVisibleText(texto);
	}

	/**
	 * Seleciona a opção do select que contém o valor definido.
	 * 
	 * @param by    O by que define o select.
	 * @param valor O valor da opção a ser selecionada.
	 */
	static void selecionarComboPorValor(By by, String valor) {
		BRQLogger.logMethod(by, valor);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		combo.selectByValue(valor);
	}

	/**
	 * Seleciona a opção do select que contém o valor definido.
	 * 
	 * @param elemento O elemento do select.
	 * @param valor    O valor da opção a ser selecionada.
	 */
	static void selecionarComboPorValor(WebElement elemento, String valor) {
		BRQLogger.logMethod(elemento, valor);

		Select combo = new Select(elemento);

		combo.selectByValue(valor);
	}

	/**
	 * Seleciona a opção do select com a posição definida.
	 * 
	 * @param by     O by que define o select.
	 * @param indice A posição da opção.
	 */
	static void selecionarComboPorIndice(By by, int indice) {
		BRQLogger.logMethod(by, indice);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		combo.selectByIndex(indice);
	}

	/**
	 * Seleciona a opção do select com a posição definida.
	 * 
	 * @param elemento O elemento do select.
	 * @param indice   A posição da opção.
	 */
	static void selecionarComboPorIndice(WebElement elemento, int indice) {
		BRQLogger.logMethod(elemento, indice);

		Select combo = new Select(elemento);

		combo.selectByIndex(indice);
	}

	/**
	 * Obtém o texto da opção do select com a posição definida.
	 * 
	 * @param by     O by que define o select.
	 * @param indice A posição da opção a ser obtido o texto.
	 * @return O texto da opção.
	 */
	static String obterTextoDoComboPorIndice(By by, int indice) {
		BRQLogger.logMethod(by, indice);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		return combo.getOptions().get(indice).getText();
	}

	/**
	 * Retorna a quantidade de opções presente no select definido.
	 * 
	 * @param by O by que define o select.
	 * @return A quantidade de opções do select.
	 */
	static int obterQuantidadeOpcoesCombo(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		return combo.getOptions().size();
	}

	/**
	 * Verifica se existe o texto em alguma das opções do select.
	 * 
	 * @param by    O by que define o select.
	 * @param texto O texto a ser verificado no select.
	 * @return Se o texto existe no select.
	 */
	static boolean verificarSeExisteOTextoNoCombo(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		for (WebElement option : combo.getOptions()) {
			if (option.getText().equals(texto)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Desmarca a opção do select que contém o texto definido.
	 * 
	 * @param by    O by que define o select.
	 * @param texto O texto da opção a ser desmarcada.
	 */
	static void desmarcarComboPorTextoVisivel(By by, String texto) {
		BRQLogger.logMethod(by, texto);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		combo.deselectByVisibleText(texto);
	}

	/**
	 * Obtém a lista de opções que existe no select.
	 * 
	 * @param by O by que define o select.
	 * @return Uma lista com todos os textos das opções do select.
	 */
	static List<String> obterTextosDoCombo(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		List<String> listaDeTexto = new ArrayList<>();
		for (WebElement opção : combo.getOptions()) {
			listaDeTexto.add(opção.getText());
		}

		return listaDeTexto;
	}

	/**
	 * Obtém a lista de opções que existe no select.
	 * 
	 * @param elemento O elemento do select.
	 * @return Uma lista com todos os textos das opções do select.
	 */
	static List<String> obterTextosDoCombo(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		Select combo = new Select(elemento);

		List<String> listaDeTexto = new ArrayList<>();
		for (WebElement opção : combo.getOptions()) {
			listaDeTexto.add(opção.getText());
		}

		return listaDeTexto;
	}
	
	static String obterTextoDaOpcaoSelecionada(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);
		
		return combo.getFirstSelectedOption().getText();
	}

	/**
	 * Obtém a lista de opções que estão selecionadas no select.
	 * 
	 * @param by O by que define o select.
	 * @return A lista de opções selecionadas.
	 */
	static List<String> obterTextoDasOpcoesSelecionadasDoCombo(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		Select combo = new Select(elemento);

		List<String> listaDeTexto = new ArrayList<>();
		for (WebElement opção : combo.getAllSelectedOptions()) {
			listaDeTexto.add(opção.getText());
		}

		return listaDeTexto;
	}

}
