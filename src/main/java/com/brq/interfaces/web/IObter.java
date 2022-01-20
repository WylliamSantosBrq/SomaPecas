package com.brq.interfaces.web;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos de obtenção de com.brq.dados presentes em tela.
 */
public interface IObter {

	/**
	 * Obtém o texto visível do elemento localizado pelo by definido.
	 * 
	 * @param by O by do elemento a ser obtido o texto.
	 * @return O texto visível do elemento.
	 */
	static String obterTexto(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		return elemento.getText();
	}

	/**
	 * Obtém o texto visível do elemento definido.
	 * 
	 * @param elemento O elemento a ser obtido o texto.
	 * @return O texto visível do elemento.
	 */
	static String obterTexto(WebElement elemento) {
		BRQLogger.logMethod(elemento);

		return elemento.getText();
	}

	/**
	 * Obtém o texto visível de todos os com.brq.elementos localizados pelo by
	 * definido.
	 * 
	 * @param by O by usado para localizar os com.brq.elementos.
	 * @return Uma lista com os textos obtidos.
	 */
	static List<String> obterTextoDosElementos(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);
		List<String> listaDeTextos = new ArrayList<>();

		for (WebElement elemento : elementos) {
			listaDeTextos.add(elemento.getText());
		}

		return listaDeTextos;
	}

	/**
	 * Obtém o valor CSS do elemento localizado pelo by definido.
	 * 
	 * @param by          O by usado para localizar o elemento.
	 * @param propriedade A propriedade a ser obtida.
	 * @return O valor CSS da propriedade.
	 */
	static String obterValorCss(By by, String propriedade) {
		BRQLogger.logMethod(by, propriedade);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		return elemento.getCssValue(propriedade);
	}

	/**
	 * Obtém o valor CSS do elemento definido.
	 * 
	 * @param elemento    O elemento de onde a propriedade será obtida.
	 * @param propriedade A propriedade a ser obtida.
	 * @return O valor CSS da propriedade.
	 */
	static String obterValorCss(WebElement elemento, String propriedade) {
		BRQLogger.logMethod(elemento, propriedade);

		return elemento.getCssValue(propriedade);
	}

	/**
	 * Obtém o valor de um atributo do elemento localizado pelo by definido.
	 * 
	 * @param by       O by usado para localizar o elemento.
	 * @param atributo O atributo a ser obtido.
	 * @return O valor do atributo.
	 */
	static String obterValorDeUmAtributoDoElemento(By by, String atributo) {
		BRQLogger.logMethod(by, atributo);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		return elemento.getAttribute(atributo);
	}

	/**
	 * Obtém o valor de um atributo do elemento definido.
	 * 
	 * @param elemento O elemento de onde o atributo será obtida.
	 * @param atributo O atributo a ser obtido.
	 * @return O valor do atributo.
	 */
	static String obterValorDeUmAtributoDoElemento(WebElement elemento, String atributo) {
		BRQLogger.logMethod(elemento, atributo);

		return elemento.getAttribute(atributo);
	}

	/**
	 * Obtém a quantidade de janelas aberta no driver atualmente.
	 * 
	 * @return A quantidade de janelas abertas.
	 */
	static int obterQuantidadeDeJanelasAberta() {
		BRQLogger.logMethod();

		WebDriver driver = DriverWeb.getDriver();

		return driver.getWindowHandles().size();
	}

	/**
	 * Obtém a quantidade de com.brq.elementos localizados pelo by definido.
	 * 
	 * @param by O by usado para localizar os com.brq.elementos.
	 * @return A quantidade de com.brq.elementos localizados.
	 */
	static int obterQuantidadeDeElementos(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();

		return driver.findElements(by).size();
	}

	/**
	 * Obtém o valor CSS da cor do elemento localizado pelo by definido.
	 * 
	 * @param by      O by usado para localizar o elemento.
	 * @param tipoCor O tipo de cor do elemento.
	 * @return O valor RGB da cor do elemento.
	 */
	static String obterCorDoElementoCssColor(By by, String tipoCor) {
		BRQLogger.logMethod(by, tipoCor);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);
		String corRgb = elemento.getCssValue("color");
		String[] numbers = corRgb.replace(tipoCor + "(", "").replace(")", "").split(",");

		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());

		return "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
	}

	/**
	 * Obtém o texto oculto de um elemento localizado pelo by definido.
	 * 
	 * @param by O by usado para localizar o elemento.
	 * @return O texto oculto do elemento.
	 */
	static String obterTextoHidden(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		return elemento.getAttribute("innerText");
	}

	/**
	 * Obtém o texto oculto de todos os com.brq.elementos localizados pelo by
	 * definido.
	 * 
	 * @param by O by usado para localizar os com.brq.elementos.
	 * @return Uma lista com os textos ocultos dos com.brq.elementos.
	 */
	static List<String> obterTextoHiddenDosElementos(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);
		List<String> listaDeTextos = new ArrayList<>();

		for (WebElement elemento : elementos) {
			listaDeTextos.add(elemento.getAttribute("innerText"));
		}
		return listaDeTextos;
	}

	static Point obterLocal(By by) {
		BRQLogger.logMethod(by);
		WebDriver driver = DriverWeb.getDriver();
		WebElement element = driver.findElement(by);
		Point p = element.getLocation();
		return p;
	}

	static Rectangle obterArea(By by) {
		BRQLogger.logMethod(by);
		WebDriver driver = DriverWeb.getDriver();
		WebElement element = driver.findElement(by);
		Rectangle r = element.getRect();
		return r;
	}
}