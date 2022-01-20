package com.brq.util.geradores;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.brq.interfaces.log.BRQLogger;

public class GeradorEmail {
	static Random random = new Random();
	private String[] dominios = { "@hotmail.com", "@gmail.com", "@yahoo.com.br", "@bol.com.br", "@outlook.com" };
	private List<String> emails = new ArrayList<>();

	boolean emailValidar = false;

	List<String> nomeGerado = new ArrayList<>();

	public String gerarEmail() {
		BRQLogger.logMethod();

		int indexDominio = random.nextInt(dominios.length);
		String nome = GeradorNome.gerarNome();
		String emailGerado;

		emailGerado = nome + dominios[indexDominio];
		emails.add(removerAcentos(emailGerado));

		return emailGerado;
	}

	public String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}