package com.brq.interfaces.log;

import org.apache.log4j.Logger;

import cucumber.api.Scenario;

/**
 * Classe para documentação do tempo gasto em cada {@link TimeLabel}.
 * 
 * @author ymnoda
 * @see com.brq.interfaces.log.TimeLabel
 */
public class TimeLogger {

	private TimeLogger() {
	}

	/*
	 * O logger usado para geração de arquivo log.
	 */
	static Logger logger = Logger.getLogger("TimeLogger");

	/**
	 * Inicia o cronômetro do {@link TimeLabel} definido.
	 * 
	 * @param label O label a ser documentado.
	 */
	public static void start(TimeLabel label) {
		label.start();
		logger.debug(String.format("Temporizador de %s iniciado.", label));
	}

	/**
	 * Pausa o cronômetro do {@link TimeLabel} definido.
	 * 
	 * @param label O label a ser documentado.
	 */
	public static void stop(TimeLabel label) {
		label.stop();
		logger.debug(String.format("Temporizador de %s pausado, %d milissegundos no total.", label, label.totalTime));
	}

	/**
	 * Passa para o log o status final dos tempos, mostrando a porcentagem de tempo
	 * gasto com carregamento.
	 * 
	 * @param cenario O cenario atual, para incluir no log final.
	 */
	public static void logAll(Scenario cenario) {
		double carregamentoSegundos = (double) TimeLabel.CARREGAMENTO.totalTime / 1000;
		double porcentagemCarregando = ((double) TimeLabel.CARREGAMENTO.totalTime / TimeLabel.TESTE.totalTime) * 100;

		logger.info(String.format("Tempos para cada label do cenario [%s]:", cenario.getName()));

		for (TimeLabel label : TimeLabel.values()) {
			logger.info(String.format("%s - %dms", label, label.totalTime));
			label.reset();
		}

		logger.info(String.format("%f segundos (%.1f%%) do tempo de execução do teste foi gasto com carregamento.%n",
				carregamentoSegundos, porcentagemCarregando));
	}

}
