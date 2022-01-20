package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.brq.interfaces.log.BRQLogger;

public class GeradorRg {
	Random random = new Random();
	private List<String> listaDeRg = new ArrayList<>();

	public String gerarRg() {
		BRQLogger.logMethod();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++)
			builder.append(random.nextInt(10));
		listaDeRg.add(builder.toString());
		return builder.toString();
	}
}