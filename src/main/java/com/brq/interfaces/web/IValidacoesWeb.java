package com.brq.interfaces.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.brq.drivers.web.DriverWeb;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.log.BRQLogger;

/**
 * Interface com métodos para validações.
 */
public interface IValidacoesWeb {

	/**
	 * Retorna true se o elemento existe em tela.
	 * 
	 * @param by O by usado para tentar localizar o elemento.
	 * @return True se o elemento estiver presente, caso contrário retorna false.
	 */
	static boolean elementoExiste(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();

		return !driver.findElements(by).isEmpty();
	}

	/**
	 * Retorna true se o elemento está visível em tela.
	 * 
	 * @param by O by usado para tentar localizar o elemento.
	 * @return True se o elemento estiver visível, caso contrário retorna false.
	 */
	static boolean elementoVisivel(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento;
		
		try {
			elemento = driver.findElement(by);
		} catch (NoSuchElementException e) {
			return false;
		}

		return elemento.isDisplayed();
	}
	
	static boolean elementoSelecionado(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento;
		
		try {
			elemento = driver.findElement(by);
		} catch (NoSuchElementException e) {
			return false;
		}

		if (elemento.getAttribute("checked").isEmpty()) 
			return elemento.isSelected();
			
		else
			return true;
	}
	
	static boolean elementoDisponivel(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento;
		
		try {
			elemento = driver.findElement(by);
		} catch (NoSuchElementException e) {
			return false;
		}

		return elemento.isEnabled();
	}
	
	/**
	 * Retorna true se o número de com.brq.elementos em tela corresponde ao esperado.
	 * 
	 * @param by O by usado para tentar localizar o(s) elemento(s).
	 * @return True se o número de com.brq.elementos estiver for igual ao esperado, caso
	 *         contrário retorna false.
	 */
	static boolean numeroDeElementos(By by, int numeroDeElementos) {
		BRQLogger.logMethod(by, numeroDeElementos);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);

		return elementos.size() == numeroDeElementos;
	}

	/**
	 * Retorna true se o número de com.brq.elementos em tela for maior que o esperado.
	 * 
	 * @param by O by usado para tentar localizar o(s) elemento(s).
	 * @return True se o número de com.brq.elementos estiver for maior que o esperado, caso
	 *         contrário retorna false.
	 */
	static boolean numeroDeElementosMaiorQue(By by, int numeroDeElementos) {
		BRQLogger.logMethod(by, numeroDeElementos);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);

		return elementos.size() > numeroDeElementos;
	}

	/**
	 * Retorna true se o número de com.brq.elementos em tela for menor que o esperado.
	 * 
	 * @param by O by usado para tentar localizar o(s) elemento(s).
	 * @return True se o número de com.brq.elementos estiver for menor que o esperado, caso
	 *         contrário retorna false.
	 */
	static boolean numeroDeElementosMenorQue(By by, int numeroDeElementos) {
		BRQLogger.logMethod(by, numeroDeElementos);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);

		return elementos.size() < numeroDeElementos;
	}

	/**
	 * Retorna true se o texto do elemento localizado pelo by definido for igual ao
	 * texto esperado.
	 * 
	 * @param by            O by usado para localizar o elemento.
	 * @param textoOriginal O texto que é esperado conter no elemento.
	 */
	static void validarMensagem(By by, String textoOriginal) {
		BRQLogger.logMethod(by, textoOriginal);

		String textoDeComparacao = IObter.obterTexto(by);

		if (!textoOriginal.equalsIgnoreCase(textoDeComparacao))
			throw new ErroValidacao(by, "Mensagem diferente!\n%s\n%s", textoOriginal, textoDeComparacao);
	}

	/**
	 * Retorna true se o texto do elemento definido for igual ao texto esperado.
	 * 
	 * @param elemento      O elemento a ser validado.
	 * @param textoOriginal O texto que é esperado conter no elemento.
	 */
	static void validarMensagem(WebElement elemento, String textoOriginal) {
		BRQLogger.logMethod(elemento, textoOriginal);

		String textoDeComparacao = IObter.obterTexto(elemento);

		if (!textoOriginal.equalsIgnoreCase(textoDeComparacao))
			throw new ErroValidacao(elemento, "Mensagem diferente!\n%s\n%s", textoOriginal, textoDeComparacao);
	}

	/**
	 * Retorna true se o texto do elemento localizado pelo by contém o texto
	 * esperado.
	 * 
	 * @param by            O by usado para localizar o elemento.
	 * @param textoOriginal O texto que é esperado conter no elemento.
	 */
	static void validarContemMensagem(By by, String textoOriginal) {
		BRQLogger.logMethod(by, textoOriginal);

		String textoDeComparacao = IObter.obterTexto(by);

		if (!textoOriginal.contains(textoDeComparacao))
			throw new ErroValidacao(by, "Mensagem diferente!\n%s\n%s", textoOriginal, textoDeComparacao);
	}

	/**
	 * Retorna true se o texto do elemento localizado pelo by contém o texto
	 * esperado.
	 * 
	 * @param elemento      O elemento a ser validado.
	 * @param textoOriginal O texto que é esperado conter no elemento.
	 */
	static void validarContemMensagem(WebElement elemento, String textoOriginal) {
		BRQLogger.logMethod(elemento, textoOriginal);

		String textoDeComparacao = IObter.obterTexto(elemento);

		if (!textoOriginal.contains(textoDeComparacao))
			throw new ErroValidacao(elemento, "Mensagem diferente!\n%s\n%s", textoOriginal, textoDeComparacao);
	}

	/**
	 * Retorna true se o value do elemento localizado pelo by for igual o texto
	 * esperado.
	 * 
	 * @param by            O by usado para localizar o elemento.
	 * @param textoOriginal O texto que é esperado conter no value do elemento.
	 */
	static void validarValue(By by, String textoOriginal) {
		BRQLogger.logMethod(by, textoOriginal);

		String textoDeComparacao = IObter.obterValorDeUmAtributoDoElemento(by, "value").replaceAll("[,.]", "");
		textoOriginal = textoOriginal.replaceAll("[,.]", "");

		if (!textoDeComparacao.equals(textoOriginal))
			throw new ErroValidacao(by, "Mensagem diferente!\n%s\n%s", textoOriginal, textoDeComparacao);
	}

	/**
	 * Retorna true se o texto do elemento localizado pelo by for diferente do texto
	 * esperado.
	 * 
	 * @param by            O by usado para localizar o elemento.
	 * @param textoOriginal O texto que é esperado não conter no elemento.
	 */
	static void validarValueDiferente(By by, String textoOriginal) {
		BRQLogger.logMethod(by, textoOriginal);

		String textoDeComparacao = IObter.obterValorDeUmAtributoDoElemento(by, "value").replaceAll("[,.]", "");
		textoOriginal = textoOriginal.replaceAll("[,.]", "");

		if (textoDeComparacao.equals(textoOriginal))
			throw new ErroValidacao(by, "Mensagem igual!\n%s\n%s", textoOriginal, textoDeComparacao);
	}

	/**
	 * Valida se o elemento localizado pelo by definido está visível.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarSeElementoEstaVisivel(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		if (!elemento.isDisplayed())
			throw new ErroValidacao(by, "O elemento não está visível.");
	}

	/**
	 * Valida se o elemento localizado pelo by definido está disponível.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarSeElementoEstaHabilitado(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		if (!elemento.isEnabled())
			throw new ErroValidacao(by, "O elemento não está habilitado.");
	}

	/**
	 * Valida se o elemento localizado pelo by definido está selecionado.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarSeElementoEstaSelecionado(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		WebElement elemento = driver.findElement(by);

		if (!elemento.isSelected())
			throw new ErroValidacao(by, "O elemento não está selecionado.");
	}

	/**
	 * Valida se o elemento localizado pelo by definido existe.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarSeElementoExiste(By by) {
		BRQLogger.logMethod(by);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);

		if (elementos.isEmpty())
			throw new ErroValidacao(by, "O elemento não existe.");
	}

	/**
	 * Valida se a quantidade de caractéres em um campo de CPF com máscara é igual à
	 * 14.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarQtdCaracteresCampoCpfComMascara(By by) {
		BRQLogger.logMethod(by);

		String cpf = IObter.obterTexto(by);

		if (cpf.length() != 14)
			throw new ErroValidacao(by, "O CPF obtido [%s] não tem 14 caracteres.", cpf);
	}

	/**
	 * Valida se a quantidade de caractéres em um campo de CPF sem máscara é igual à
	 * 11.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarQtdCaracteresCampoCpfSemMascara(By by) {
		BRQLogger.logMethod(by);

		String cpf = IObter.obterTexto(by);

		if (cpf.length() != 11)
			throw new ErroValidacao(by, "O CPF obtido [%s] não tem 11 caracteres.", cpf);
	}

	/**
	 * Valida se a quantidade de caractéres em um campo de CNPJ com máscara é igual
	 * à 18.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarQtdCaracteresCampoCnpjComMascara(By by) {
		BRQLogger.logMethod(by);

		String cnpj = IObter.obterTexto(by);

		if (cnpj.length() != 18)
			throw new ErroValidacao(by, "O CNPJ obtido [%s] não tem 18 caracteres.", cnpj);
	}

	/**
	 * Valida se a quantidade de caractéres em um campo de CNPJ sem máscara é igual
	 * à 14.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarQtdCaracteresCampoCnpjSemMascara(By by) {
		BRQLogger.logMethod(by);

		String cnpj = IObter.obterTexto(by);

		if (cnpj.length() != 14)
			throw new ErroValidacao(by, "O CNPJ obtido [%s] não tem 18 caracteres.", cnpj);
	}

	/**
	 * Valida se um campo de CPF não contém letras.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarCaracteresCampoCpf(By by) {
		BRQLogger.logMethod(by);

		String cpf = IObter.obterTexto(by);

		for (char caractere : cpf.toCharArray()) {
			if (Character.isLetter(caractere))
				throw new ErroValidacao("O campo de CPF aceita letras!\n%s", cpf);
		}
	}

	/**
	 * Valida se um campo de CNPJ não contém letras.
	 * 
	 * @param by O by usado para localizar o elemento.
	 */
	static void validarCaracteresCampoCnpj(By by) {
		BRQLogger.logMethod(by);

		String cnpj = IObter.obterTexto(by);

		for (char caractere : cnpj.toCharArray()) {
			if (Character.isLetter(caractere))
				throw new ErroValidacao("O campo de CNPJ aceita letras!\n%s", cnpj);
		}
	}

	/**
	 * Valida se um campo de data está no formato esperado.
	 * 
	 * @param by         O by usado para localizar o elemento.
	 * @param dateFormat O formato esperado conter no campo.
	 */
	static void validarCampoData(By by, String dateFormat) {
		BRQLogger.logMethod(by, dateFormat);

		String data = IObter.obterTexto(by);
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		format.setLenient(false);

		try {
			format.parse(data);
		} catch (ParseException e) {
			throw new ErroValidacao(e, by, "O campo de data está em um formato diferente do esperado [%s].",
					dateFormat);
		}
	}

	/**
	 * Valida se o texto definido está presente na lista de com.brq.elementos localizados
	 * pelo by definido.
	 * 
	 * @param by            O by usado para localizar o elemento.
	 * @param textoEsperado O texto esperado conter em pelo menos um dos com.brq.elementos.
	 */
	static void validarElementoNaTabela(By by, String textoEsperado) {
		BRQLogger.logMethod(by, textoEsperado);

		WebDriver driver = DriverWeb.getDriver();
		List<WebElement> elementos = driver.findElements(by);

		for (WebElement elemento : elementos) {
			String textoOriginal = elemento.getText().trim();
			if (textoOriginal.equalsIgnoreCase(textoEsperado.trim())) {
				return;
			}
		}

		throw new ErroValidacao(by, "O texto [%s] não foi encontrado na lista de com.brq.elementos.", textoEsperado);

	}

	/**
	 * Valida se os textos definidos são diferentes.
	 * 
	 * @param texto1
	 * @param texto2
	 */
	default void validarDiferentes(String texto1, String texto2) {
		BRQLogger.logMethod(texto1, texto2);

		if (texto1.equalsIgnoreCase(texto2))
			throw new ErroValidacao("Mensagem igual!\n%s\n%s", texto1, texto2);
	}

	/**
	 * Valida se os inteiros definidos são diferentes.
	 * 
	 * @param int1
	 * @param int2
	 */
	default void validarDiferentes(int int1, int int2) {
		BRQLogger.logMethod(int1, int2);

		if (int1 == int2)
			throw new ErroValidacao("Valor igual!\n%d\n%d", int1, int2);
	}

	/**
	 * Valida se os textos definidos são iguais.
	 * 
	 * @param texto1
	 * @param texto2
	 */
	default void validarIguais(String texto1, String texto2) {
		BRQLogger.logMethod(texto1, texto2);

		if (!texto1.equalsIgnoreCase(texto2))
			throw new ErroValidacao("Mensagem Diferente!\n%s\n%s", texto1, texto2);
	}

	/**
	 * Valida se os inteiros definidos são iguais.
	 * 
	 * @param int1
	 * @param int2
	 */
	default void validarIguais(int int1, int int2) {
		BRQLogger.logMethod(int1, int2);

		if (int1 != int2)
			throw new ErroValidacao("Valor diferente!\n%d\n%d", int1, int2);
	}

	/**
	 * Valida se o status não é null ou false.
	 * 
	 * @param status
	 */
	default void validarOK(boolean status) {
		BRQLogger.logMethod(status);

		if (!status)
			throw new ErroValidacao("O resultado foi %s!", status);
	}

}