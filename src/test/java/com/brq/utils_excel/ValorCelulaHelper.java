package com.brq.utils_excel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.brq.erros.ErroMassaDeDados;

/**
 * Classe estática que contém as lambdas de ValorCelula usadas para captura de
 * dados da planilha.
 * 
 * @author ymnoda
 * @see utils.excel.ValorCelula
 */
public class ValorCelulaHelper {

	private ValorCelulaHelper() throws Throwable {
	}

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * String da célula, e se esse valor jogar uma exceção, retorna o valor bruto da
	 * mesma.
	 */
	public static ValorCelula<String> valorString = c -> {
		if (c == null || c.getRawValue() == null)
			return null;
		else
			try {
				return c.getStringCellValue();
			} catch (Exception e) {
				return c.getRawValue();
			}
	};

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * Integer da célula.
	 * 
	 * @throws erros.ErroMassaDeDados Caso a célula não seja do tipo numérico.
	 */
	public static ValorCelula<Integer> valorInt = c -> {
		if (c == null || c.getRawValue() == null)
			return null;
		else
			try {
				return (int) c.getNumericCellValue();
			} catch (Exception e) {
				throw new ErroMassaDeDados(e, "A célula [%s] não é do tipo numérico.", c.getAddress());
			}
	};

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * LocalDate da célula.
	 * 
	 * @throws erros.ErroMassaDeDados Caso a célula não seja do tipo data.
	 */
	public static ValorCelula<LocalDate> valorDate = c -> {
		if (c == null || c.getRawValue() == null)
			return null;
		else
			try {
				return c.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			} catch (IllegalStateException e) {
				throw new ErroMassaDeDados(e, "Não foi possível obter uma data da célula [%s].", c.getAddress());
			}
	};

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * Boolean da célula.
	 * 
	 * @throws erros.ErroMassaDeDados Caso o valor obtido da célula não esteja
	 *                                definido no switch do método.
	 */
	public static ValorCelula<Boolean> valorBoolean = c -> {
		if (c == null || c.getRawValue() == null)
			return false;
		else
			switch (c.getStringCellValue().toLowerCase()) {
			case "sim":
			case "true":
			case "1":
				return true;

			case "não":
			case "nao":
			case "false":
			case "0":
				return false;

			default:
				throw new ErroMassaDeDados("O valor [%s] não foi definido no ValorCelula<Boolean> valorBoolean.",
						c.getRawValue());
			}
	};

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * Integer da célula.
	 * 
	 * @throws erros.ErroMassaDeDados Caso a célula esteja vazia.
	 */
	public static ValorCelula<Integer> valorIdade = c -> {
		if (c == null || c.getRawValue() == null)
			throw new ErroMassaDeDados("A idade não foi definida para esse colaborador.");
		else
			return Integer.valueOf(c.getStringCellValue().replaceAll(" anos", ""));
	};

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * LocalDate[2] da célula.
	 * 
	 * @throws erros.ErroMassaDeDados Caso o texto da célula não esteja no formato
	 *                                dd/MM/yyyy.
	 */
	public static ValorCelula<LocalDate[]> valorFeriasProgramadas = c -> {
		LocalDate[] feriasProgramadas = new LocalDate[2];

		if (c == null || c.getRawValue() == null) {
			return feriasProgramadas;
		}

		String stringFeriasProgramadas = c.getStringCellValue();

		if (stringFeriasProgramadas.length() > 13) {
			try {
				String[] datasInicioFim = stringFeriasProgramadas.split(" a ");
				String inicio = datasInicioFim[0].trim();
				String fim = datasInicioFim[1].trim();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				feriasProgramadas[0] = LocalDate.parse(inicio.trim(), formatter);
				feriasProgramadas[1] = LocalDate.parse(fim.trim(), formatter);
			} catch (Exception e) {
				throw new ErroMassaDeDados(e,
						"O valor de férias programadas [%s] não está no formato esperado [dd/MM/yyyy a dd/MM/yyyy].");
			}
		}

		return feriasProgramadas;
	};

	/**
	 * Retorna nulo se a célula também for, caso contrário irá retornar o valor
	 * String[] da célula, separando o texto nos ';' caso seja mais de uma mensagem
	 * de alerta.
	 */
	public static ValorCelula<String[]> valorMensagensDeAlerta = c -> {
		return (c == null || c.getRawValue() == null) ? null : c.getStringCellValue().split(";");
	};

}
