package com.brq.erros;

/**
 * Factory de com.brq.erros para facilitar ao jogar com.brq.erros quando trabalhando com uma
 * lista.
 * 
 * @author ymnoda
 *
 */
public final class ErrorFactory {

	private ErrorFactory() {
	}

	public static void throwError(String erro, String mensagem) throws AssertionError {
		switch (erro) {
		case "ErroSistema":
			throw new ErroSistema(mensagem);

		case "ErroAutomacao":
			throw new ErroAutomacao(mensagem);

		case "ErroInesperado":
			throw new ErroInesperado(mensagem);

		case "ErroInteracaoElemento":
			throw new ErroInteracaoElemento(mensagem);

		case "ErroTimeout":
			throw new ErroTimeout(mensagem);

		case "ErroMassaDeDados":
			throw new ErroMassaDeDados(mensagem);

		default:
			throw new RuntimeException(mensagem);
		}
	}

	public static void throwError(String[] itemErro) throws AssertionError {
		String erro = itemErro[0];
		String mensagem = itemErro[1];

		switch (erro) {
		case "ErroSistema":
			throw new ErroSistema(mensagem);

		case "ErroAutomacao":
			throw new ErroAutomacao(mensagem);

		case "ErroInesperado":
			throw new ErroInesperado(mensagem);

		case "ErroInteracaoElemento":
			throw new ErroInteracaoElemento(mensagem);

		case "ErroTimeout":
			throw new ErroTimeout(mensagem);

		case "ErroMassaDeDados":
			throw new ErroMassaDeDados(mensagem);

		default:
			throw new RuntimeException(mensagem);
		}
	}

}
