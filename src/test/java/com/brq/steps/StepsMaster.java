package com.brq.steps;

import com.brq.pages.Pagina;

import cucumber.api.Scenario;

/**
 * Classe que todas as outras que são referentes à declaração de com.brq.steps devem
 * extender. Contém a única instância de Pagina que deve estar sendo usada durante
 * a execução de testes.
 * 
 * @author ymnoda
 *
 */
public class StepsMaster {
	/**
	 * A única instância de Pagina que deve ser usada nos testes web. Use o retorno
	 * dos métodos para mudar qual o sub-tipo de Pagina que essa variável representa.
	 * <dl>
	 * <dt>Exemplo:</dt>
	 * <dd>{@code paginaAtual = paginaAtual.acessarUrl("https://portal.brq.com");}</dd>
	 * </dl>
	 */
	private static Pagina paginaAtual = new Pagina();

	/**
	 * O cenário que está sendo executado no momento, deve ser definido no
	 * {@link com.brq.executar.ExecuteBefore#before(Scenario)}
	 */
	private static Scenario currentScenario;

	public static Pagina getPaginaAtual() {
		return paginaAtual;
	}

	public static void setPaginaAtual(Pagina paginaAtual) {
		StepsMaster.paginaAtual = paginaAtual;
	}

	public static Scenario getCurrentScenario() {
		return currentScenario;
	}

	public static void setCurrentScenario(Scenario currentScenario) {
		StepsMaster.currentScenario = currentScenario;
	}
	
}
