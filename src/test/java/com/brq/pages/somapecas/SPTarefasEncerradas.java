package com.brq.pages.somapecas;

import com.brq.drivers.web.DriverWeb;
import com.brq.elementos.Botao;
import com.brq.elementos.somapecas.SPTarefasEncerradasElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.Menu;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.StepsMaster;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SPTarefasEncerradas extends Pagina implements Mensagens {

    @Override
    public void clicarEm(String botao) {
        BRQLogger.logMethod(botao);

        switch (botao) {
            case "Tarefas Encerradas":
                botaoTarefasEncerradas();
                break;
            case "Pedido":
                botaoPedido();
                break;
            case "Abrir Pedidos":
                StepsMaster.setPaginaAtual(new SPAbrirPedidos());
                StepsMaster.getPaginaAtual().clicarEm(botao);
                break;
            case "Home":
                StepsMaster.setPaginaAtual(new SPDashBoardPage());
                StepsMaster.getPaginaAtual().clicarEm(botao);
                break;
            default:
                throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].");
        }
    }

    private void botaoTarefasEncerradas(){
        SPTarefasEncerradasElementos.BTN_TAREFAS//
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)//
                .clicar()//
                .esperarMilisegundos(300);
    }

    public void abaFornecedor(){
        SPTarefasEncerradasElementos.TXT_FORNECEDOR//
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);

        SPTarefasEncerradasElementos.BTN_FORNECEDOR//
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)//
                .clicarJavascript()//
                .esperarMilisegundos(300);
    }

    public void acaoAbaForncedor(){
        SPTarefasEncerradasElementos.BTN_PEDIDO//
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)//
                .clicarJavascript()//
                .esperarMilisegundos(300);
    }

    public void botaoPedido(){
        SPTarefasEncerradasElementos.BTN_ATENDER_PEDIDO_REALIZADO
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
                .clicarJavascript();
    }

    public void validarPecasConfirmadas(String mensagem){
        List<WebElement> status = DriverWeb.getDriver()
                .findElements(By.xpath("//td[contains(@id,'Fornecimento:listaSinistrosFornecimento:')]/span[contains(text(),'Peça')]"));

        status.forEach( st -> Assert.assertEquals(mensagem, st.getText()));
    }

    @Override
    public void validarMensagem(String mensagemEsperada) {
        String pedido =  SPTarefasEncerradasElementos.BTN_ATENDER_PEDIDO_REALIZADO
                .obterTexto();

        Assert.assertEquals(mensagemEsperada.toLowerCase(), pedido.toLowerCase());
    }

    @Override
    public void validarListaDeMensagens() {

    }
}
