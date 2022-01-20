package com.brq.pages.somapecas;

import com.brq.drivers.web.DriverWeb;
import com.brq.elementos.somapecas.SPCadastrosElementos;
import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPConsultaFornecedoresElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Combos;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.ICliqueJS;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.brq.interfaces.web.IEsperaWeb.esperarElementoSerVisivel;

import java.util.List;
import java.util.Map;


public class SPCadastrosPage extends Pagina implements Combos, Mensagens {

    @Override
    public void clicarEm(String botao) {
        BRQLogger.logMethod(botao);
        switch (botao) {
            case "CONSULTA DE FORNECEDORES":
                consultaForncedor();
                break;
            case "Editar":
                editarFornecedor();
                break;
            case "Salvar":
                salvarFornecedor();
                break;
            default:
                throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].");
        }
    }

    private void consultaForncedor(){
        BRQLogger.logMethod();

        SPCadastrosElementos.BTN_CAD_FORNECEDORES//
                .esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)//
                .mover()//
                .clicarJavascript()//
                .esperarMilisegundos(200);

        StepsMaster.setPaginaAtual(new SPConsultaPage());
    }

    private void editarFornecedor(){
        BRQLogger.logMethod();

        SPConsultaFornecedoresElementos.TBL_LISTA_FORNECEDOR//
                .getLinha(0)//
                .get("//a[contains(@id,'formFornecimento:listFornecedores')]")
                .clicar();

        SPCarregamentoElementos.GIF_CARREGAMENTO//
                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT);
    }

    private void salvarFornecedor(){
        BRQLogger.logMethod();

        SPCadastrosElementos.BTN_SALVAR.clicarJavascript();

        SPCarregamentoElementos.GIF_CARREGAMENTO//
                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
                .esperarSegundos(10);
    }

    @Override
    public void selecionarCombo(String combo, String opcao) {
        BRQLogger.logMethod(combo);
        switch (combo) {
            case "tipo fornecedor":
                selecionar(opcao);
                break;
            default:
                throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].");
        }

    }

    private void selecionar(String texto){
        BRQLogger.logMethod(texto);

        SPCadastrosElementos.CBX_TIPO_FORNECEDOR.selecionarPorTexto(texto);
    }

    @Override
    public void validarMensagem(String mensagemEsperada) {
        BRQLogger.logMethod(mensagemEsperada);
        //Ajustar o elemento depois.
        List<WebElement> TXT_MENSAGEM = DriverWeb.getDriver().findElements((By//
                .xpath("//div[contains(@id,'dlgShowMessagesOverModalCDiv')]//span[@class='rich-messages-label']")));
        esperarElementoSerVisivel(TXT_MENSAGEM.get(1), DEFAULT_STEPS_TIMEOUT);
        Assert.assertEquals(mensagemEsperada, TXT_MENSAGEM.get(1).getText());
        confirmarCadastros();
    }

    private void confirmarCadastros(){
        BRQLogger.logMethod();
        List<WebElement> BTN_OK = DriverWeb.getDriver().findElements((By//
                .xpath("//div[contains(@id,'dlgShowMessagesOverModalContentDiv')]//input[@value='OK']")));

        ICliqueJS.clicarJavascript(BTN_OK.get(1));
        SPCarregamentoElementos.GIF_CARREGAMENTO//
                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
                .esperarMilisegundos(500);

        StepsMaster.setPaginaAtual(new SPLoginPage());
    }

    @Override
    public void selecionarCombos(Map<String, String> mapValores) {

    }

    @Override
    public void limparCombo() {

    }

    @Override
    public void limparCombo(String combo) {

    }

    @Override
    public void validarDadosCombo(String textoCombo, String textoComboFinal) {

    }

    @Override
    public void validarListaDeMensagens() {

    }
}
