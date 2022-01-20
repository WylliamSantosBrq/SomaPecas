package com.brq.utils_excel;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * Interface para lambda usada para tratar dados no momento de captura da
 * planilha.
 * 
 * @author ymnoda
 *
 * @param <T> O tipo do objeto retornado pelo lambda.
 * 
 * @see utils.excel.ValorCelulaHelper
 */
public interface ValorCelula<T> {
	/**
	 * Aplica as regras para capturar os valores da célula, retornando o objeto com tipo T.
	 * 
	 * @param cell A célula da planilha que será tratada
	 * @return O valor da planilha, com tipo T, depois de ter passado pelas tratativas definidas.
	 */
	public T getValue(XSSFCell cell);
}
