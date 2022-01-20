package com.brq.steps;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Combos;
import com.brq.pages.somapecas.SPDashBoardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CombosSteps extends StepsMaster {
    @When("^opto por alterar o combobox \"([^\"]*)\" para \"([^\"]*)\"$")
    public void alteroOTipoDoFornecedorPara(String comboBox, String textoCombo) {
        if (!(getPaginaAtual() instanceof Combos))
            throw new ErroAutomacao("A página atual não é uma instâncida de [Combos].");

        ((Combos) getPaginaAtual()).selecionarCombo(comboBox, textoCombo);
    }

    @Then("^selecionar a opção \"([^\"]*)\" no combo Ação da \"([^\"]*)\" peça$")
    public void selecionarAOpçãoNoComboAçãoDaPeça(String opcao, String indicePeca) {
        if (!(getPaginaAtual() instanceof Combos))
            throw new ErroAutomacao("A página atual não é uma instâncida de [Combos].");

        ((Combos) getPaginaAtual()).selecionarCombo(indicePeca, opcao);
    }

    @Then("^seleciono uma justificativa$")
    public void selecionoUmaJustificativa() {
        if (!(getPaginaAtual() instanceof Combos))
            throw new ErroAutomacao("A página atual não é uma instâncida de [Combos].");

        ((Combos) getPaginaAtual()).selecionarCombo("Justificativa", "'");
    }

    @When("^opto por solicitar mudança de \"([^\"]*)\"$")
    public void optoPorSolicitarMudançaDe(String opcao) {
        if (!(getPaginaAtual() instanceof SPDashBoardPage))
            throw new ErroAutomacao("A página atual não é uma instâncida de [SPDashBoardPage].");

        ((SPDashBoardPage) getPaginaAtual()).alterarValorMudanca(opcao);
    }

    @When("^seleciono uma justificativa na lista de justificativas de alteração$")
    public void optoSelecionarJustificativa() {
        if (!(getPaginaAtual() instanceof SPDashBoardPage))
            throw new ErroAutomacao("A página atual não é uma instâncida de [SPDashBoardPage].");

        ((SPDashBoardPage) getPaginaAtual()).alterarJustificativa();
    }

    @When("^seleciono a opção \"([^\"]*)\" na peça alterada$")
    public void aprovarPecaAlterada(String comboBox) {
        if (!(getPaginaAtual() instanceof Combos))
            throw new ErroAutomacao("A página atual não é uma instâncida de [Combos].");

        ((Combos) getPaginaAtual()).selecionarCombo("Peça Alterada", comboBox);
    }
    
}
