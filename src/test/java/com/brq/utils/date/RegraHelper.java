package com.brq.utils.date;

import java.time.LocalDate;

/**
 * Classe estática para facilitar a geração de regras mais comuns.
 * 
 * @author ymnoda
 * @see com.brq.utils.date.Regra
 */
public class RegraHelper {

	private RegraHelper() {
	}

	/**
	 * Valida se a data definida está fora do período de d1 à d2.
	 * 
	 * @param d1
	 * @param d2
	 * @return Retorna true caso a data d esteja fora do periodo que vai de d1 à d2.
	 */
	public static Regra<LocalDate> foraDoPeriodo(LocalDate d1, LocalDate d2) {
		Regra<LocalDate> foraDoPeriodo;
		if (d1.isBefore(d2))
			foraDoPeriodo = d -> d.isBefore(d1) || d.isAfter(d2);
		else
			foraDoPeriodo = d -> d.isBefore(d2) || d.isAfter(d1);
		return foraDoPeriodo;
	}

	/**
	 * Valida se a data definida está dentro do período de d1 à d2 (inclusivo).
	 * 
	 * @param d1
	 * @param d2
	 * @return Retorna true caso a data d esteja dentro do período que vai de d1 à
	 *         d2.
	 */
	public static Regra<LocalDate> durantePeriodo(LocalDate d1, LocalDate d2) {
		Regra<LocalDate> durantePeriodo;
		if (d1.isBefore(d2))
			durantePeriodo = d -> d.isAfter(d1.minusDays(1)) && d.isBefore(d2.plusDays(1));
		else
			durantePeriodo = d -> d.isAfter(d2.minusDays(1)) && d.isBefore(d1.plusDays(1));
		return durantePeriodo;
	}

	/**
	 * Valida se o dia e mês das datas definida são iguais.
	 * 
	 * @param d1
	 * @return Retorna true caso o dia e mês sejam os mesmos em ambas as datas.
	 */
	public static Regra<LocalDate> mesmoDiaDoAno(LocalDate d1) {
		Regra<LocalDate> mesmoDiaDoAno = d -> d.getDayOfMonth() == d1.getDayOfMonth() && d.getMonth() == d1.getMonth();
		return mesmoDiaDoAno;
	}

	/**
	 * Valida se o dia e mês das datas definida são iguais.
	 * 
	 * @param d1
	 * @return Retorna true caso o dia e mês sejam os mesmos em ambas as datas.
	 */
	public static Regra<LocalDate> outroDiaDoAno(LocalDate d1) {
		Regra<LocalDate> outroDiaDoAno = d -> d.getDayOfMonth() != d1.getDayOfMonth() || d.getMonth() != d1.getMonth();
		return outroDiaDoAno;
	}

	/**
	 * Qualquer data irá satisfazer essa regra.
	 * 
	 * @return true.
	 */
	public static Regra<LocalDate> qualquerDia() {
		Regra<LocalDate> qualquerDia = d -> true;
		return qualquerDia;
	}

	/**
	 * Nenhuma data irá satisfazer essa regra.
	 * 
	 * @return false.
	 */
	public static Regra<LocalDate> nenhumDia() {
		Regra<LocalDate> nenhumDia = d -> false;
		return nenhumDia;
	}

}
