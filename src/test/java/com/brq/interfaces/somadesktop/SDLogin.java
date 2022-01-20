package com.brq.interfaces.somadesktop;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.drivers.desktop.Sikuli;
import com.brq.elementos.somadesktop.SikuliLoginElementos;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Login;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somadesktop.SDHomePage;
import com.brq.steps.StepsMaster;

public interface SDLogin extends Login {

	Screen s = Sikuli.getScreen();
	
	@Override
	default void validarTelaDeLogin() {
		BRQLogger.logMethod();
		
		try {
			s.exists(SikuliLoginElementos.getInputCpf(), 90);
		} catch (Exception e) {
			throw new ErroSistema(e, "O campo de CPF não apareceu em tela no tempo esperado.");
		}
	}

	@Override
	default void realizarLogin(String usuario, String senha) {
		BRQLogger.logMethod(usuario, senha);
		
		try {
			s.wait(SikuliLoginElementos.getInputCpf(), 240);
			s.click(SikuliLoginElementos.getInputCpf());
			s.type(usuario);
			s.click(SikuliLoginElementos.getInputSenha());
			s.type(senha);
			s.click(SikuliLoginElementos.getBtnLogin());
			
			StepsMaster.setPaginaAtual(new SDHomePage());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O elemento não pode ser encontrado.");
		}
		
	}

	@Override
	default void realizarLogin() {
		BRQLogger.logMethod();
		
		realizarLogin("21441816836", "seguro10");
	}

	@Override
	default boolean logado() {
		BRQLogger.logMethod();
		
		return s.exists(SikuliLoginElementos.getInputCpf()) == null;
	}

	@Override
	default void realizarLoginComo(String perfil) {
		// TODO Auto-generated method stub
		
	}

}
