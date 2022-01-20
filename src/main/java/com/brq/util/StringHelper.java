package com.brq.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.Loggable;

public class StringHelper implements Loggable {

	private StringHelper() {
	}

	/**
	 * Remove os acentos de uma string.
	 * 
	 * @param texto
	 * @return a string sem acentos
	 */
	public static String removerAcentos(String texto) {
		BRQLogger.logMethod(texto);

		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static boolean igualIgnoraTudo(String texto1, String texto2) {
		BRQLogger.logMethod(texto1, texto2);

		texto1 = StringHelper.removerAcentos(texto1);
		texto2 = StringHelper.removerAcentos(texto2);

		int diferenca = texto1.compareToIgnoreCase(texto2);

		return diferenca == 0;
	}

	public static boolean igualIgnoraTudo(String texto1, String texto2, int margemDeErro) {
		BRQLogger.logMethod(texto1, texto2, margemDeErro);

		texto1 = StringHelper.removerAcentos(texto1);
		texto2 = StringHelper.removerAcentos(texto2);

		int diferenca = texto1.compareToIgnoreCase(texto2);

		return -margemDeErro <= diferenca && diferenca <= margemDeErro;
	}

	public static void validarVazio(String string) {
		BRQLogger.logMethod(string);

		if (string != null && !string.isEmpty())
			throw new ErroValidacao("A string \"%s\" não está vazia.", string);
	}

	public static void validarNaoVazio(String string) {
		BRQLogger.logMethod(string);

		if (string == null || string.isEmpty())
			throw new ErroValidacao("A string \"%s\" está vazia.", string);
	}

	public static void validarIgual(String string1, String string2) {
		BRQLogger.logMethod(string1, string2);

		if (!string1.equalsIgnoreCase(string2))
			throw new ErroValidacao("As strings não são iguais:/n/t%s/n/t%s", string1, string2);
	}

	public static void validarVazioOuIgual(String stringASerValidada, String string2) {
		BRQLogger.logMethod(stringASerValidada, string2);

		if (stringASerValidada != null && !stringASerValidada.isEmpty()
				&& !stringASerValidada.equalsIgnoreCase(string2))
			throw new ErroValidacao("A string \"%s\" não está vazia e nem é igual à \"%s\".", stringASerValidada,
					string2);
	}

	public static boolean compararNumeros(String strNumeroMenor, String strNumeroMaior) {
		BRQLogger.logMethod(strNumeroMenor, strNumeroMaior);

		strNumeroMenor = strNumeroMenor.replace(".", "").replace(",", ".").trim();
		strNumeroMaior = strNumeroMaior.replace(".", "").replace(",", ".").trim();
		Double numeroMenor = Double.valueOf(strNumeroMenor);
		Double numeroMaior = Double.valueOf(strNumeroMaior);
		return numeroMaior >= numeroMenor;
	}

	public static boolean compararOrdemAlfabetica(String palavraAnterior, String palavraPosterior) {
		BRQLogger.logMethod(palavraAnterior, palavraPosterior);

		return palavraAnterior.compareToIgnoreCase(palavraPosterior) <= 0;
	}

	public static String getMatch(String string, String regex) {
		BRQLogger.logMethod(string, regex);

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		matcher.find();
		return matcher.group();
	}

	/**
	 * Transforma o StackTrace do Throwable em String.
	 * 
	 * @param t
	 * @return
	 */
	public static String throwableStackTrace(Throwable t) {
		BRQLogger.logMethod(t);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	/**
	 * Transforma o StackTrace da Exception em String.
	 * 
	 * @param e
	 * @return
	 */
	public static String exceptionStackTrace(Exception e) {
		BRQLogger.logMethod(e);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	public static String methodLocation(Class<?> clazz, String methodName, Class<?>... args) {
		BRQLogger.logMethod(clazz, methodName, args);

		Method metodo;
		String string;
		List<String> argsToString = new ArrayList<>();

		for (Class<?> arg : args) {
			argsToString.add(arg.getSimpleName());
		}

		try {
			metodo = clazz.getMethod(methodName, args);
			string = String.format("%s(%s.java:%s)", metodo.getName(), metodo.getDeclaringClass().getSimpleName(),
					String.join(", ", argsToString));
		} catch (Exception e) {
			string = "metodoNaoEncontrado";
		}

		return string;
	}

	public static Boolean getBoolean(String valor) {
		BRQLogger.logMethod(valor);

		switch (valor.toLowerCase()) {
		case "x":
		case "1":
		case "true":
		case "yes":
		case "sim":
		case "verdade":
			return true;

		case "":
		case "0":
		case "false":
		case "no":
		case "não":
		case "nao":
		case "falso":
			return false;

		default:
			throw new ErroAutomacao("O valor [%s] não foi definido para verdadeiro ou falso em [getBoolean].", valor);
		}
	}

	public static Integer getZeroBasedOrdinal(String strOrdinal) {
		BRQLogger.logMethod(strOrdinal);

		switch (strOrdinal.toLowerCase()) {
		case "primeira":
		case "primeiro":
			return 0;

		case "segunda":
		case "segundo":
			return 1;

		case "terceira":
		case "terceiro":
			return 2;

		case "quarta":
		case "quarto":
			return 3;

		case "quinta":
		case "quinto":
			return 4;

		case "sexta":
		case "sexto":
			return 5;

		case "sétima":
		case "setima":
		case "sétimo":
		case "setimo":
			return 6;

		case "oitava":
		case "oitavo":
			return 7;

		case "nona":
		case "nono":
			return 8;

		case "décima":
		case "decima":
		case "décimo":
		case "decimo":
//			TODO Implementar lógica para tratamento de números maiores que 10.
			return 9;

		case "última":
		case "ultima":
		case "último":
		case "ultimo":
			return -1;

		case "penúltima":
		case "penultima":
		case "penúltimo":
		case "penultimo":
			return -2;

		case "antepenúltima":
		case "antepenultima":
		case "antepenúltimo":
		case "antepenultimo":
			return -3;

		default:
			throw new ErroInesperado("O número ordinal [%s] não foi definido no método [getZeroBasedOrdinal].",
					strOrdinal);
		}
	}

	public static List<String> getGroup(String texto, String regex) {
		BRQLogger.logMethod(texto, regex);

		List<String> retorno = new ArrayList<>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(texto);

		if (m.find()) {
			for (int i = 0; i < m.groupCount(); i++)
				retorno.add(m.group(i + 1));

		} else
			throw new ErroInesperado("Não foi possível encontrar o grupo esperado [%s] no texto [%s].", regex, texto);

		return retorno;
	}
}
