package com.brq.pages.abas;

import com.brq.elementos.abas.AbasNotaPadronizadaElementos;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;

public class AbasNotaPadronizadaPage extends Pagina implements Mensagens {

	public AbasNotaPadronizadaPage() {
		BRQLogger.logMethod();

		esperarPaginaAbrir("Novo Sinistro Auto - Modelo de Nota Padronizada", 45);
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Salvar":
			clicarEmSalvar();
			break;
		}
	}

	public void clicarEmSalvar() {
		BRQLogger.logMethod();

		AbasNotaPadronizadaElementos.BTN_SALVAR.esperarSerVisivel(30).mover().clicar();
	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		BRQLogger.logMethod(mensagemEsperada);
		
		switch (mensagemEsperada) {
		case "Nota e E-mail registrados com sucesso!":
			validarIguais(mensagemEsperada, obterTextoDoAlerta());
			aceitarAlerta();
			break;
		}
	}

	@Override
	public void validarListaDeMensagens() {
		// TODO Auto-generated method stub
		
	}
	
}
