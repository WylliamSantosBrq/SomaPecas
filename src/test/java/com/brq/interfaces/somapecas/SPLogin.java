package com.brq.interfaces.somapecas;

import com.brq.elementos.somapecas.SPLoginElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Login;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.somapecas.SPDashBoardPage;
import com.brq.steps.StepsMaster;
import org.openqa.selenium.Keys;

public interface SPLogin extends Login {

	@Override
	default void realizarLogin(String usuario, String senha) {
		BRQLogger.logMethod(usuario, senha);

		SPLoginElementos.VALIDACAO_TELA_LOGIN.esperarExistir(10);

		preencherCpf(usuario);
		preencherSenha(senha);
		SPLoginElementos.BTN_LOGIN.esperarSegundos(1).clicar();

		StepsMaster.setPaginaAtual(new SPDashBoardPage());
	}

	@Override
	default void realizarLogin() {
		BRQLogger.logMethod();

		realizarLogin("371.889.838-10", "seguro10");
	}

	@Override
	default boolean logado() {
		BRQLogger.logMethod();

		return !SPLoginElementos.VALIDACAO_TELA_LOGIN.existe();
	}

	default void preencherCpf(String cpf) {
		BRQLogger.logMethod(cpf);

		SPLoginElementos.INPUT_CPF.preencher(Keys.HOME + cpf);
	}

	default void preencherSenha(String senha) {
		BRQLogger.logMethod(senha);

		SPLoginElementos.INPUT_SENHA.preencher(senha);
	}

	@Override
	default void validarTelaDeLogin() {
		BRQLogger.logMethod();

		if (logado())
			throw new ErroAutomacao("A automação já está logada no sistema.");
	}

	@Override
	default void realizarLoginComo(String perfil) {
		BRQLogger.logMethod(perfil);

		switch (perfil) {
		case "Analista":
			logarComoAnalista();
			break;

		case "Fornecedor":
			logarComoFornecedor();
			break;

		default:
			throw new ErroAutomacao("O perfil [%s] não foi definido no método [realizarLoginComo].", perfil);
		}
	}

	default void logarComoAnalista() {
		BRQLogger.logMethod();

		realizarLogin("371.889.838-10", "seguro10");
	}

	default void logarComoFornecedor() {
		BRQLogger.logMethod();

//		realizarLogin("929.420.310-77", "seguro12");
		realizarLogin("353.001.340-40", "seguro13");
	}

}
