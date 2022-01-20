package com.brq.pages.somapecas;

import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPConsultaFornecedoresElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Pesquisa;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.steps.StepsMaster;


public class SPConsultaPage extends Pagina implements Pesquisa {

    @Override
    public void clicarEm(String botao) {
        BRQLogger.logMethod(botao);

        switch (botao) {
            case "Buscar":
                buscarFornecedor();
                break;
            default:
                throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].");
        }
    }

    public void pesquisaFornecedor(String campo, String texto){
        BRQLogger.logMethod(campo);
        switch (campo){
            case "razão social":
                preencherRazaoSocial(texto);
                break;
            default:
                throw new ErroAutomacao();
        }
    }

    private void preencherRazaoSocial(String texto){
        BRQLogger.logMethod(texto);

        SPCarregamentoElementos.GIF_CARREGAMENTO//
                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
                .esperarMilisegundos(300);

        SPConsultaFornecedoresElementos.TXT_RAZAO_SOCIAL.preencher(texto);
    }

    private void buscarFornecedor(){
        BRQLogger.logMethod();

        SPConsultaFornecedoresElementos.BTN_BUSCAR//
                .esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)
                .mover()//
                .clicarJavascript()//
                .esperarMilisegundos(300);

    }

    @Override
    public void pesquisar(String textoParaPesquisar) {
        BRQLogger.logMethod(textoParaPesquisar);

        SPCarregamentoElementos.GIF_CARREGAMENTO//
                .esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
                .esperarMilisegundos(300);

        SPConsultaFornecedoresElementos.TBL_LISTA_FORNECEDOR//
                .getLinha(0)//
                .get(String.format("//td[text()='%s']", textoParaPesquisar))
                .esperarExistir(DEFAULT_STEPS_TIMEOUT);

        StepsMaster.setPaginaAtual(new SPCadastrosPage());
    }

    @Override
    public void selecionarResultado(String resultado) {
        Pesquisa.super.selecionarResultado(resultado);
    }
}
