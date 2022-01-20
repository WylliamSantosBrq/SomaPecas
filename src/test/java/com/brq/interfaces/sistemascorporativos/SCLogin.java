package com.brq.interfaces.sistemascorporativos;

import com.brq.elementos.Frame;
import com.brq.elementos.sistemascorporativos.SCLoginElementos;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Login;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.sistemascorporativos.SCHomePage;
import com.brq.steps.StepsMaster;

public interface SCLogin extends Login {

	@Override
	default void validarTelaDeLogin() {
		BRQLogger.logMethod();
		
		// TODO Auto-generated method stub
	}

	@Override
	default void realizarLogin(String usuario, String senha) {
		BRQLogger.logMethod(usuario, senha);
		
		try (Frame frame = ((Frame) SCLoginElementos.FRAME_LOGIN.esperarExistir(15)).entrar()) {
			SCLoginElementos.INPUT_USUARIO.preencher(usuario);
			SCLoginElementos.INPUT_SENHA.preencher(senha);
			SCLoginElementos.BTN_ENTRAR.clicar();
			
			StepsMaster.setPaginaAtual(new SCHomePage());
			
		} catch (Exception e) {
			throw new ErroInesperado(e);
		}
		
	}

	@Override
	default void realizarLogin() {
		BRQLogger.logMethod();
		
		realizarLogin("f0120955", "seguro55");
	}

	@Override
	default boolean logado() {
		BRQLogger.logMethod();
		
		return SCLoginElementos.FRAME_LOGIN.existe();
	}

	@Override
	default void realizarLoginComo(String perfil) {
		// TODO Auto-generated method stub
		
	}

	
	
}
