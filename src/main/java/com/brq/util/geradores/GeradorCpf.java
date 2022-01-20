package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.brq.interfaces.log.BRQLogger;

public class GeradorCpf {
	Random random = new Random();
	private List<String> listaDeCpf = new ArrayList<>();

	/**
	 * Gera uma quantidade de CPF, adicionar na listaDeCpf e retorna essa lista.
	 * 
	 * @param quantidade
	 * @return
	 */
	public List<String> gerarCpf(int quantidade) {
		BRQLogger.logMethod(quantidade);

		for (int i = quantidade; i > 0; i--)
			listaDeCpf.add(gerarCpf());

		return listaDeCpf;
	}

	/**
	 * Gera um CPF válido e formatado.
	 * 
	 * @return
	 */
	public String gerarCpf() {
		BRQLogger.logMethod();

		String cpfSemDigito = geraCpfSemDigito();
		String digito = calcularDigito(cpfSemDigito);
		return formatarCpf(cpfSemDigito + digito);
	}

	/**
	 * Calcula o dígito do CPF com os 9 primeiros dígitos.
	 * 
	 * @param cpfSemDigito
	 * @return string cpf com digito verificador
	 */
	private String calcularDigito(String cpfSemDigito) {
		BRQLogger.logMethod(cpfSemDigito);

		int soma = 0;
		int peso = 10;
		int primeiroDigito;
		int segundoDigito;

		for (int i = 0; i < cpfSemDigito.length(); i++)
			soma += Integer.parseInt(cpfSemDigito.substring(i, i + 1)) * peso--;
		if (soma % 11 == 0 || soma % 11 == 1)
			primeiroDigito = 0;
		else
			primeiroDigito = 11 - (soma % 11);

		soma = 0;
		peso = 11;
		for (int i = 0; i < cpfSemDigito.length(); i++)
			soma += Integer.parseInt(cpfSemDigito.substring(i, i + 1)) * peso--;

		soma += primeiroDigito * 2;

		if (soma % 11 == 0 || soma % 11 == 1)
			segundoDigito = 0;
		else
			segundoDigito = 11 - (soma % 11);

		return "" + primeiroDigito + segundoDigito;
	}

	/**
	 * Gera 9 dígitos aleatórios.
	 * 
	 * @return string cpf
	 */
	private String geraCpfSemDigito() {
		BRQLogger.logMethod();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			builder.append(random.nextInt(10));
		}
		return builder.toString();
	}

	/**
	 * Valida se o CPF inserido é válido.
	 * 
	 * @param cpf
	 * @return digito válido
	 */
	public boolean validaCpf(String cpf) {
		BRQLogger.logMethod(cpf);

		if (cpf.length() != 11 && StringUtils.countMatches(cpf, cpf.charAt(0)) == 11)
			return false;
		String digito = cpf.substring(9, 11);
		return calcularDigito(digito).equals(cpf.substring(9, 11));
	}

	/**
	 * Formata o CPF, inserindo . e -
	 * 
	 * @param cpf 12345678900
	 * @return 123.456.789-00
	 */
	public String formatarCpf(String cpf) {
		BRQLogger.logMethod(cpf);

		return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
	}

}
