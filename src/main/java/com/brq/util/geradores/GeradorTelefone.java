package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.brq.interfaces.log.BRQLogger;

public class GeradorTelefone {
	Random random = new Random();
	private List<String> telefonesFixos = new ArrayList<>();
	private List<String> telefonesCelular = new ArrayList<>();

	public String gerarTelefoneFixo() {
		BRQLogger.logMethod();

		int contador = 0;
		String telefone;

		StringBuilder sb = new StringBuilder();

		while (contador++ < 10) {
			sb.append(1 + random.nextInt() * 9);
		}

		telefone = sb.toString();
		telefonesFixos.add(telefone);

		return telefone;
	}

	public String gerarTelefoneCelular() {
		BRQLogger.logMethod();

		int contador = 0;
		String telefone;

		StringBuilder sb = new StringBuilder();

		while (contador++ < 10) {
			sb.append(1 + random.nextInt() * 9);
			if (contador == 2)
				sb.append(9);
		}

		telefone = sb.toString();
		telefonesCelular.add(telefone);

		return telefone;
	}
}