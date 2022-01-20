package com.brq.pages.abas;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasMensagemCartaPage extends Pagina implements Mensagens {

	@Override
	public void validarMensagem(String mensagemEsperada) {
		BRQLogger.logMethod(mensagemEsperada);

		switch (mensagemEsperada) {
		case "Carta e Email registrados com sucesso.":
			validarMensagemCartaEEmailRegistradosComSucesso();
			break;

		default:
			throw new ErroAutomacao("A mensagem [%s] não foi definida no método [validarMensagem].", mensagemEsperada);
		}
	}

	public void validarMensagemCartaEEmailRegistradosComSucesso() {
		BRQLogger.logMethod();

		if (alertaPresente()) {
			String texto = obterTextoDoAlerta();
			aceitarAlerta();

			if (!texto.equals("Carta e Email registrados com sucesso."))
				throw new ErroValidacao("A mensagem exibida é diferente da esperada.");
		} else
			throw new ErroSistema("O sistema não exibiu um alerta.");
	}

	@Override
	public void validarListaDeMensagens() {
		// TODO Auto-generated method stub

	}

}
