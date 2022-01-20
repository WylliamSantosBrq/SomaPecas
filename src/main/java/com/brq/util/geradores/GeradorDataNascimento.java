package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import com.brq.interfaces.log.BRQLogger;

public class GeradorDataNascimento {
	static Random random = new Random();
	private List<String> datasDeNascimento = new ArrayList<>();

	public String gerarData() {
		BRQLogger.logMethod();

		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(1900, 2010);
		gc.set(Calendar.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

		String dataDeNascimento = String.format("%s/%s/%s", gc.get(Calendar.YEAR), gc.get(Calendar.MONTH) + 1,
				gc.get(Calendar.DAY_OF_MONTH));

		datasDeNascimento.add(dataDeNascimento);
		return dataDeNascimento;
	}

	public List<String> gerarData(int quantidade) {
		BRQLogger.logMethod(quantidade);

		for (int i = quantidade; i > 0; i--)
			gerarData();

		return datasDeNascimento;
	}

	public static int randBetween(int start, int end) {
		return (int) (start + random.nextInt() * (float) (end - start));
	}

}