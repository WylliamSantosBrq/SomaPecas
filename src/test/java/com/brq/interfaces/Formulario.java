package com.brq.interfaces;

/**
 * Interface para interações com campos obrigatórios do sistema.
 * 
 * @author ymnoda
 *
 */
public interface Formulario extends Campos, Combos, Radios, Botoes {

	abstract void preencherOsCamposObrigatorios();

}
