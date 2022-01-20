package com.brq.pages.somapecas;

import com.brq.elementos.Campo;
import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Menu;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.StepsMaster;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Optional;

public class SPMenuPrincipal extends Pagina implements Menu {

    @Override
    public void acessarMenu(String... ordemDeMenus) {
        BRQLogger.logMethod(ordemDeMenus);
        Optional<String> texto =  Arrays.stream(ordemDeMenus).findFirst();

        switch (texto.get()){
            case "Home":
            case "Cadastro":
                menuSuperior(texto.get());
                break;
            case "Solicitação de Mudança":
                menuPrincipal(texto.get());
                break;
            default:
                throw new ErroAutomacao();
        }
    }

    private void menuSuperior(String menu){
        BRQLogger.logMethod(menu);
        Campo cmpMenu = new Campo(By.xpath(String//
                .format("//table[contains(@class, 'rich-toolbar')]//span[@class='rich-menu-item-label' and contains(text(),'%s')]",//
                        menu)));
        cmpMenu.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicarJavascript();
        redirecionar(menu);
    }

    private void menuPrincipal(String menu){
        BRQLogger.logMethod(menu);
        Campo cmpMenu = new Campo(By.xpath(String//
                .format("//table[@class='templateLinkPanel']//span[contains(text(),'%s')]",menu.toUpperCase())));

        cmpMenu.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
                .clicarJavascript()
                .esperarMilisegundos(100);

        SPCarregamentoElementos.GIF_CARREGAMENTO.
                esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)
                .esperarMilisegundos(200);

        redirecionar(menu);
    }

    private void redirecionar(String menu){
        BRQLogger.logMethod(menu);

        switch (menu) {
            case "Home":
            case "Solicitação de Mudança":
                StepsMaster.setPaginaAtual(new SPDashBoardPage(new SPAtenderPedido()));
                break;
            case "Cadastro":
                StepsMaster.setPaginaAtual(new SPCadastrosPage());
                break;
            default:
                throw new ErroAutomacao();
        }
    }

}
