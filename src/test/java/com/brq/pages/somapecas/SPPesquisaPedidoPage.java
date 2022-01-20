package com.brq.pages.somapecas;

import com.brq.drivers.web.DriverWeb;
import com.brq.elementos.Texto;
import com.brq.elementos.somapecas.SPPesquisaPedidoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class SPPesquisaPedidoPage extends Pagina implements Pesquisa {

    @Override
    public void clicarEm(String botao) {
        BRQLogger.logMethod(botao);

        switch (botao) {

            case "Pesquisar":
                clicarEmPesquisar();
                break;

            default:
                throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
        }
    }

    @Override
    public void pesquisar(String textoParaPesquisar) {
        BRQLogger.logMethod();

        SPPesquisaPedidoElementos.TXT_PEDIDO
                .preencher(textoParaPesquisar)
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
    }

    public void clicarEmPesquisar(){
        BRQLogger.logMethod();

        SPPesquisaPedidoElementos.BTN_PESQUISAR//
                .esperarExistir(DEFAULT_STEPS_TIMEOUT)//
                .esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)//
                .clicar();
    }

    public void pedidoPesquisado(){
        SPPesquisaPedidoElementos.TABELA_PEDIDO
                                 .esperarExistir(DEFAULT_STEPS_TIMEOUT)
                                 .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
                                 .esperarMilisegundos(200);

        StepsMaster.setPaginaAtual(new SPTarefasEncerradas());
    }

    @Override
    public void selecionarResultado(String resultado) {
        Pesquisa.super.selecionarResultado(resultado);
    }

    @Override
    public void selecionarResultado(int indice) {
        Pesquisa.super.selecionarResultado(indice);
    }

    @Override
    public void selecionarPrimeiroResultado() {
        Pesquisa.super.selecionarPrimeiroResultado();
    }

    @Override
    public void filtrarPor(Map<String, String> filtros) {
        Pesquisa.super.filtrarPor(filtros);
    }
}
