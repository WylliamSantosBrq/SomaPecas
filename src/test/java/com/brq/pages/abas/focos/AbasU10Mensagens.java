package com.brq.pages.abas.focos;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasU10MensagensElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasU10Mensagens extends Foco implements Mensagens {

	@Override
	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		switch (caixa.toLowerCase()) {
		case "mensagens":
			fecharCaixaMensagens();
			break;

		default:
			throw new ErroAutomacao("A caixa [%s] não foi definida no método [fecharCaixa].", caixa);
		}
	}

	private void fecharCaixaMensagens() {
		BRQLogger.logMethod();
		
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()){
			AbasU10MensagensElementos.BTN_FECHAR.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
			
		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarListaDeMensagens() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()) {
			if (AbasU10MensagensElementos.TEXTO_NAO_HA_MENSAGEM.existe()) {
				BRQLogger.info("Não existe nenhuma mensagem na lista de mensagens.");
				return;
			}

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

}
