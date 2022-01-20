package com.brq.interfaces;

/**
 * Interface para interações de login.
 * 
 * @author ymnoda
 *
 */
public interface Login {

	abstract void validarTelaDeLogin();

	abstract void realizarLogin(String usuario, String senha);

	abstract void realizarLogin();

	abstract void realizarLoginComo(String perfil);
	
	abstract boolean logado();

}
