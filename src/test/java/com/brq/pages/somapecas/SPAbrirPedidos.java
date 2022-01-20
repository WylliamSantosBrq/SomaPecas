package com.brq.pages.somapecas;

import com.brq.drivers.web.DriverWeb;
import com.brq.elementos.Botao;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;
import com.brq.util.StringHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SPAbrirPedidos extends Pagina {
    @Override
    public void clicarEm(String botao) {
        BRQLogger.logMethod(botao);

        switch (botao) {

            case "Abrir Pedidos":
                abrirPedidos();
                break;
            case "Fornecedor":
                expadirForncedor();
                break;
            default:
                throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
        }
    }

    @Override
    public void esperarExibicao(String objeto){

        List<WebElement> titulosFornecedor = DriverWeb//
                .getDriver().findElements(By//
                        .xpath("//table[contains(@id,'detalhesSinistroPedidosPecas')]//span[@class='text_template_link_bold']"));

        titulosFornecedor.forEach(forncedor -> Assert.assertNotNull(forncedor.getText()));
    }

    private void abrirPedidos(){
        Botao abrirPedido = new Botao(By//
                .xpath("//table[contains(@id,'detalhes-sinistro')]//span[text()='ABRIR PEDIDOS']"));

        abrirPedido.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
                .clicarJavascript()
                .esperarMilisegundos(300);
    }


    private void expadirForncedor(){
        Botao abrirFornecedor = new Botao(By//
                .xpath("//table[@class='templateLinkPanel templateLinkPanel']//span[@class='text_template_link_bold']"));

        abrirFornecedor.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
                        .clicarJavascript()
                        .esperarMilisegundos(300);
    }

    public void validarInfoFornecedor(){
        List<WebElement> INFO_FORNCEDORES = DriverWeb.getDriver()
                .findElements(By.xpath("//table[@class='templateLinkPanel']//span[@class='text_template_link_bold']"));

        INFO_FORNCEDORES.forEach(info -> Assert.assertNotNull(info.getText()));
        StepsMaster.setPaginaAtual(new SPTarefasEncerradas());
    }
}
