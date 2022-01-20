package com.brq.utils.date;

/**
 * Interface usada em lambdas para criação de data.
 * 
 * @author ymnoda
 *
 * @param <T> O tipo de argumento que sera usado para criação de datas.
 *
 * @see com.brq.utils.date.DateHelper
 */
public interface Regra<T> {

	/**
	 * Aplica as validações definidas no lambda, retornando true se a regra foi
	 * cumprida.
	 * 
	 * @param t O argumento usado para validar a regra.
	 * @return O boolean representando o resultado da validação.
	 */
	public boolean validarRegra(T t);
}
