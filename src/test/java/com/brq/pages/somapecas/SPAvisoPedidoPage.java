package com.brq.pages.somapecas;

import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPModalElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;
import org.junit.Assert;

public class SPAvisoPedidoPage extends Pagina implements Mensagens {

    @Override
    public void clicarEm(String botao) {
        BRQLogger.logMethod(botao);
        switch (botao) {
            case "OK":
                botaoAviso();
                break;

            default:
                throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].");
        }
    }


    @Override
    public void validarMensagem(String mensagemEsperada) {
        BRQLogger.logMethod(mensagemEsperada);
        SPModalElementos.MODAL_AVISO.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
        Assert.assertEquals(mensagemEsperada, SPModalElementos.LBL_MENSAGEM.
                                        esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto());

    }

    private void botaoAviso(){
        SPModalElementos.BTN_OK.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicar();
        SPCarregamentoElementos.GIF_CARREGAMENTO//
                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
                .esperarSegundos(1);

        StepsMaster.setPaginaAtual(new SPPesquisaPedidoPage());
    }

    @Override
    public void validarListaDeMensagens() {

    }
}
