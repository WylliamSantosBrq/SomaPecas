package com.brq.utils.date;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.brq.erros.ErroMassaDeDados;
import com.brq.interfaces.log.BRQLogger;

/**
 * Classe com métodos para facilitar a geração de data com base em regras
 * definidas pelo usuário.
 * 
 * @author ymnoda
 * @see com.brq.utils.date.Regra
 */
public class DateHelper {

	/**
	 * Começando por amanhã, validar dia a dia se alguma data satisfaz todas as
	 * regras estabelecidas.
	 * 
	 * @param regras A lista de regras definidas para validar a data.
	 * @return A primeira data que cumpra todas as regras definidas.
	 * @throws ErroMassaDeDados Caso não encontre uma data no período de cinco anos
	 *                          que cumpra todas as regras.
	 */
	@SafeVarargs
	public static LocalDate gerarDataComRegras(Regra<LocalDate>... regras) {
		BRQLogger.logMethod(regras);

		LocalDate dataSobValidacao = LocalDate.now();

		buscarDataValida: while (true) {
			if (dataSobValidacao.isAfter(LocalDate.now().plusYears(5)))
				throw new ErroMassaDeDados(
						"Não foi possível encontrar uma data que satisfaça todas as regras no período de 5 anos.");

			dataSobValidacao = dataSobValidacao.plusDays(1);
			for (Regra<LocalDate> regra : regras) {
				if (regra == null)
					continue;

				if (!regra.validarRegra(dataSobValidacao)) {
					continue buscarDataValida;
				}
			}

			return dataSobValidacao;
		}
	}

	/**
	 * Começando pela data seguinte à data mínima, validar dia a dia se alguma data
	 * cumpre todas as regras estabelecidas.
	 * 
	 * @param regras A lista de regras definidas para validar a data.
	 * @return A primeira data que cumpra todas as regras definidas.
	 * @throws ErroMassaDeDados Caso não encontre uma data no período de cinco anos
	 *                          que cumpra todas as regras.
	 */
	@SafeVarargs
	public static LocalDate gerarDataComRegrasDepoisDe(LocalDate dataMinima, Regra<LocalDate>... regras) {
		BRQLogger.logMethod(dataMinima, regras);

		LocalDate dataSobValidacao = dataMinima;

		buscarDataValida: while (true) {
			if (dataSobValidacao.isAfter(dataMinima.plusYears(5)))
				throw new ErroMassaDeDados(
						"Não foi possível encontrar uma data que satisfaça todas as regras no período de 5 anos.");

			dataSobValidacao = dataSobValidacao.plusDays(1);
			for (Regra<LocalDate> regra : regras) {
				if (regra == null)
					continue;

				if (!regra.validarRegra(dataSobValidacao)) {
					continue buscarDataValida;
				}
			}

			return dataSobValidacao;
		}
	}

	public static String dataPorExtenso(LocalDate data) {
		BRQLogger.logMethod(data);

		Map<Integer, String> meses = new HashMap<>();
		String dataString = "";

		meses.put(1, "janeiro");
		meses.put(2, "fevereiro");
		meses.put(3, "março");
		meses.put(4, "abril");
		meses.put(5, "maio");
		meses.put(6, "junho");
		meses.put(7, "julho");
		meses.put(8, "agosto");
		meses.put(9, "setembro");
		meses.put(10, "outubro");
		meses.put(11, "novembro");
		meses.put(12, "dezembro");

		dataString = String.format("%d de %s de %d", data.getDayOfMonth(), meses.get(data.getMonthValue()),
				data.getYear());

		return dataString;
	}
	
	public static LocalDate getDataAtual() {
		return LocalDate.now();
	}
	
	public static int getDiaAtual() {
		return getDataAtual().getDayOfMonth();
	}
	
	public static int getMesAtual() {
		return getDataAtual().getMonthValue();
	}
	
	public static int getAnoAtual() {
		return getDataAtual().getYear();
	}
	
}
