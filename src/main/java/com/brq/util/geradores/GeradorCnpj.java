package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.brq.interfaces.log.BRQLogger;

public class GeradorCnpj {
	Random random = new Random();
	private List<String> listaDeCnpj = new ArrayList<>();

	public String gerarCnpj() {
		BRQLogger.logMethod();

		int n1 = random.nextInt(10);
		int n2 = random.nextInt(10);
		int n3 = random.nextInt(10);
		int n4 = random.nextInt(10);
		int n5 = random.nextInt(10);
		int n6 = random.nextInt(10);
		int n7 = random.nextInt(10);
		int n8 = random.nextInt(10);
		int n9 = random.nextInt(10);
		int n10 = random.nextInt(10);
		int n11 = random.nextInt(10);
		int n12 = random.nextInt(10);

		int soma = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4
				+ n1 * 5;

		int valor = (soma / 11) * 11;
		int digito1 = soma - valor;
		int resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3
				+ n3 * 4 + n2 * 5 + n1 * 6;

		int valor2 = (soma2 / 11) * 11;
		int digito2 = soma2 - valor2;
		// Primeiro resto da divis�o por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		String baseCnpj = String.format("%d%d%d%d%d%d%d%d%d%d%d%d", n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
		String digitoCnpj = String.format("%d%d", digito1, digito2);
		String cnpjGerado = baseCnpj + digitoCnpj;

		if (validarCnpj(cnpjGerado)) {
			listaDeCnpj.add(cnpjGerado);
		}

		return cnpjGerado;
	}

	public List<String> gerarCnpj(int quantidade) {
		BRQLogger.logMethod(quantidade);

		for (int i = quantidade; i > 0; i--) {
			gerarCnpj();
		}

		return listaDeCnpj;
	}

	private static boolean validarCnpj(String cnpj) {
		BRQLogger.logMethod(cnpj);

		long longCnpj = Long.parseLong(cnpj);

		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (longCnpj % 11111111111111L == 0 || (cnpj.length() != 14))
			return false;

		return (validarPrimeiroDigito(cnpj) && validarSegundoDigito(cnpj));
	}

	public static boolean validarPrimeiroDigito(String cnpj) {
		BRQLogger.logMethod(cnpj);

		int sm = 0;
		int peso = 2;
		char dig13;
		int r;

		for (int i = 11; i >= 0; i--) {
			// converte o i-�simo caractere do CNPJ em um n�mero:
			// por exemplo, transforma o caractere '0' no inteiro 0
			// (48 eh a posi��o de '0' na tabela ASCII)
			int num = cnpj.charAt(i) - 48;
			sm += (num * peso++);
			if (peso == 10)
				peso = 2;
		}

		r = sm % 11;

		if ((r == 0) || (r == 1))
			dig13 = '0';
		else
			dig13 = (char) ((11 - r) + 48);

		return dig13 == cnpj.charAt(12);
	}

	public static boolean validarSegundoDigito(String cnpj) {
		BRQLogger.logMethod(cnpj);

		int sm = 0;
		int peso = 2;
		char dig14;
		int r;

		for (int i = 12; i >= 0; i--) {
			int num = cnpj.charAt(i) - 48;
			sm += (num * peso++);
			if (peso == 10)
				peso = 2;
		}

		r = sm % 11;

		if ((r == 0) || (r == 1))
			dig14 = '0';
		else
			dig14 = (char) ((11 - r) + 48);

		return dig14 == cnpj.charAt(13);
	}
}
