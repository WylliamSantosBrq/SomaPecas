package com.brq.interfaces.log;

import com.brq.erros.ErroAutomacao;

/**
 * Enum com os TimeLabels definidos. Cada TimeLabel tem sua própria contagem de
 * tempo, agindo como um cronômetro para cada ação que o TimeLabel representa.
 * 
 * @author ymnoda
 * @see com.brq.interfaces.log.TimeLogger
 */
public enum TimeLabel {
	TESTE, CARREGAMENTO, MASSA_DE_DADOS;

	boolean counting = false;
	Long startTime;
	Long totalTime = 0L;

	/**
	 * Inicia o cronômetro desta instância.
	 */
	public void start() {
		if (this.counting)
			throw new ErroAutomacao("O tempo já está contando para o TimeLabel atual.");

		this.startTime = System.currentTimeMillis();

		this.counting = true;
	}

	/**
	 * Pausa o cronômetro desta instância.
	 */
	public void stop() {
		if (!this.counting)
			throw new ErroAutomacao("O tempo não está sendo contado para o TimeLabel atual.");

		this.totalTime += System.currentTimeMillis() - startTime;
		this.startTime = null;

		this.counting = false;
	}

	/**
	 * Reseta todos os com.brq.dados dessa instância para o padrão.
	 */
	public void reset() {
		this.counting = false;
		this.startTime = null;
		this.totalTime = 0L;
	}
}
