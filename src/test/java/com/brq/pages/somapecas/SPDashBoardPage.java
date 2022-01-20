package com.brq.pages.somapecas;

import com.brq.drivers.web.DriverWeb;
import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Combo;
import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPDashBoardElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Combos;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.somapecas.SPCarregamento;
import com.brq.interfaces.somapecas.SPMenuSuperior;
import com.brq.interfaces.somapecas.SPPesquisa;
import com.brq.pages.Foco;
import com.brq.pages.Pagina;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.StepsMaster;
import com.brq.util.StringHelper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SPDashBoardPage extends Pagina implements SPMenuSuperior, SPPesquisa, SPCarregamento, Mensagens, Combos {

	public SPDashBoardPage() {
		BRQLogger.logMethod();
	}

	public SPDashBoardPage(Foco foco) {
		BRQLogger.logMethod(foco);
		setFocoAtual(foco);
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		esperarCarregamentoTerminar(15);

		switch (botao) {
			case "Atender Pedido":
				clicarEmAtenderPedido();
				break;

			case "PAGAMENTO MANUAL":
				clicarEmPagamentoManual();
				break;
				
			case "Peça Cancelada":
				clicarEmPecaCancelada();
				break;
				
			case "Entregar peça na oficina":
				clicarEmEntregaOficina();
				break;
				
			case "Distribuir Manual":
				clicarEmDistribuirManual();
				break;
			
			case "Lupa":
			case "Informações Oficina":
				getFocoAtual().clicarEm(botao);
				break;

			case "Confirmar":
				setFocoAtual(new SPAtenderPedido());
				getFocoAtual().clicarEm(botao);
				break;

			case "Home":
				irParaHome();
				break;

			case "Solicitação de Mudança":
				solicitacaoDeMudanca();
				break;

			default:
				throw new ErroAutomacao("Botão [%s] não definido no método [clicarEm].");
		}
	}

	private void clicarEmDistribuirManual() {
		BRQLogger.logMethod("Clicando em Distribuir Manual");

		SPDashBoardElementos.BTN_DISTRIBUIR_MANUAL//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
				.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)
				.clicar();

		SPCarregamentoElementos.GIF_CARREGAMENTO//
				.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT);
		
		StepsMaster.setPaginaAtual(new SPDistribuirManual());
	}

	private void clicarEmEntregaOficina() {
		BRQLogger.logMethod();

		SPDashBoardElementos.BTN_ENTREGAR_PECA_OFICINA//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
				.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)
				.clicar();

		SPCarregamentoElementos.GIF_CARREGAMENTO//
				.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT);
		
		StepsMaster.setPaginaAtual(new SPEntregaPecaOficina());
		
	}

	private void clicarEmPecaCancelada() {
		BRQLogger.logMethod();

		SPDashBoardElementos.BTN_PECA_CANCELADA//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
				.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)
				.clicar();

		SPCarregamentoElementos.GIF_CARREGAMENTO//
				.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT);
		
		StepsMaster.setPaginaAtual(new SPPecaCancelada());
		
	}

	private void clicarEmAtenderPedido() {
		BRQLogger.logMethod();

		SPDashBoardElementos.BTN_ATENDER_PEDIDO//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT)
				.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)
				.clicar();

		SPCarregamentoElementos.GIF_CARREGAMENTO//
				.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT);
		this.setFocoAtual(new SPAtenderPedido());
	}

	private void clicarEmPagamentoManual() {
		BRQLogger.logMethod();

		SPDashBoardElementos.BTN_PAGAMENTO_MANUAL.clicar();
//		this.setFocoAtual(new SPPagamentoManual());
	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		BRQLogger.logMethod(mensagemEsperada);

		switch (mensagemEsperada) {
		case "Bem-vindo":
			validarMensagemBemVindo();
			break;

		default:
			throw new ErroAutomacao();
		}
	}

	private void validarMensagemBemVindo() {
		BRQLogger.logMethod();

		try {
			SPDashBoardElementos.TXT_BEM_VINDO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
		} catch (Exception e) {
			throw new ErroValidacao("A mensagem de boas vindas não está presente.");
		}
	}

	@Override
	public void validarListaDeMensagens() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		switch (caixa) {
			case "Fotos":
				getFocoAtual().fecharCaixa(caixa);
				break;

			case "Informações Oficina":
				fecharInfomacoes();
				break;

		default:
			throw new ErroAutomacao("A caixa [%s] não foi definida no método [fecharCaixa].", caixa);
		}
	}

	@Override
	public void moverCursorSobre(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
			case "Fotos":
				getFocoAtual().moverCursorSobre(objeto);
				break;
			case "criticidade":
				((SPAtenderPedido) getFocoAtual()).moverCursorSobre(objeto);
				break;
			default:
				throw new ErroAutomacao("O objeto [%s] não foi definido no método [moverCursorSobre].", objeto);
		}
	}

	@Override
	public void validarDadoEmTela(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
			case "Número do Sinistro":
			case "Data da Solicitação":
			case "Número do pedido":
			case "Data do pedido":
			case "Marca":
			case "Veículo":
			case "Modelo":
			case "Placa":
			case "Chassi":
			case "Ano":
			case "CNPJ":
			case "Razão Social":
			case "Tipo de Oficina":
			case "Endereço":
			case "Tipo Veículo Atendimento":
			case "Telefone Comercial":
			case "Telefone Fax":
			case "Email":
			case "Horário de Atendimento":
			case "Observações":
				getFocoAtual().validarDadoEmTela(campo);
				break;

			case "Solicitar mudança de":
				comboMudanca();
				break;

			case "solicitação de mudança":
				solicitacaoMudancaAlteracao();
				break;

			default:
				throw new ErroAutomacao("O campo [%s] não foi definida no método [validarDadoEmTela].");
		}
	}

	public void clicarNoBotaoDoPedidoPorIndice(String botao, String indicePedido) {
		BRQLogger.logMethod(botao, indicePedido);

		switch (botao) {
		case "Abrir Tarefa":
		case "PDF":
			((SPAtenderPedido) getFocoAtual()).clicarNoBotaoDoPedidoPorIndice(botao, indicePedido);
		}
	}

	public void fecharInfomacoes(){
		BRQLogger.logMethod();
		SPDashBoardElementos.BTN_FECHAR_INFO.clicarJavascript();
	}

	@Override
	public void selecionarCombo(String combo, String opcao) {
		BRQLogger.logMethod(combo);

		switch (combo){
			case "Ação":
				selecionarPedido(opcao);
				break;

			case "Ação da primeira peça":
			case "Ação da segunda peça":
			case "Ação da terceira peça":
			case "primeira":
			case "segunda":
			case "terceira":
				selecionarPeca(combo, opcao);
				break;
			case "Justificativa":
				selecionarJustificativa();
				break;
			case "Peça Alterada":
				break;
			default:
				throw new ErroAutomacao();
		}
	}

	public void selecionarPedido(String opcao){
		BRQLogger.logMethod(opcao);
		SPDashBoardElementos.CBX_ACAO.selecionarPorTexto(opcao);

		SPCarregamentoElementos.GIF_CARREGAMENTO//
				.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
				.esperarSegundos(2);
	}

	private void selecionarPeca(String combo, String opcao){
		BRQLogger.logMethod(opcao);
		String indice = combo.replace("Ação da ", "").replace(" peça", "");

		Combo cbx = new Combo(By.xpath(String.//
				format("//select[contains(@name,'formFornecimento:atenderPedidoList') and contains(@name,'listPecas:%d')]", StringHelper.getZeroBasedOrdinal(indice))));
		cbx.selecionarPorTexto(opcao);


		SPCarregamentoElementos.GIF_CARREGAMENTO//
				.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)//
				.esperarSegundos(1);
	}

	private void selecionarJustificativa(){
		BRQLogger.logMethod();
		SPDashBoardElementos.CBX_JUSTIFICATIVA.selecionarPorIndice(1);
		setFocoAtual(new SPAtenderPedido());
	}

	@Override
	public void validarDadosCombo(String textoCombo, String textoComboFinal) {
		BRQLogger.logMethod(textoCombo);
		List<WebElement> cbxs = DriverWeb.getDriver().//
				findElements(By.xpath("//select[contains(@name,'formFornecimento:atenderPedidoList')]/option[@selected]"));
		cbxs.forEach(cbx -> Assert.assertEquals(textoComboFinal, cbx.getText()));
	}

	public void validarDadosComboPecas(String textoCombo, String textoComboFinal, String indice) {
		BRQLogger.logMethod(textoCombo);

		Combo cbx = new Combo(By.xpath(String.//
				format("//select[contains(@name,'formFornecimento:atenderPedidoList') and contains(@name,'listPecas:%d')]/option[@selected]", StringHelper.getZeroBasedOrdinal(indice))));
		Assert.assertNotNull(cbx.obterAtributo("value"));
	}

	public void validarNovoCombo(String campo){
		BRQLogger.logMethod(campo);
		switch (campo){
			case "Justificativa":
				comboJustificativa();
				break;
			default:
				throw new ErroAutomacao();
		}
	}

	private void comboMudanca(){
		BRQLogger.logMethod();

		SPDashBoardElementos.CBX_MUDANCA//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	private void comboJustificativa(){
		BRQLogger.logMethod();

		SPDashBoardElementos.CBX_JUSTIFICATIVA//
				.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}


	public void alterarValorMudanca(String opcao){
		BRQLogger.logMethod();

		SPDashBoardElementos.CBX_MUDANCA.selecionarPorTexto(opcao).esperarMilisegundos(200);
	}

	public void alterarJustificativa(){
		BRQLogger.logMethod();

		Combo LISTA_JUSTIFICATIVA = new Combo(By.xpath("//select[contains(@id,':justificativa')]"));
		LISTA_JUSTIFICATIVA.selecionarPorIndice(1).esperarMilisegundos(200);
	}

	public void preencherValor(String valor){
		BRQLogger.logMethod(valor);

		Campo TXT_VALOR = new Campo(By.xpath("//input[contains(@id,':valor-para')]"));
		TXT_VALOR.preencher(valor).esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	public void preencherMotivoAlteracao(String texto){
		BRQLogger.logMethod(texto);

		Campo TXT_MOTIVO = new Campo(By.xpath("//textarea[contains(@id,':motivo-de-para')]"));
		TXT_MOTIVO.preencher(texto).esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
	}

	///Alterar para a a classe SPMENUPRINCIPAL
	@Override
	public void acessarMenu(String... ordemDeMenus) {
		BRQLogger.logMethod(ordemDeMenus);
		Optional<String> texto =  Arrays.stream(ordemDeMenus).findFirst();
		Campo cmpMenu = new Campo(By.xpath(String//
				.format("//table[contains(@class, 'rich-toolbar')]//span[@class='rich-menu-item-label' and contains(text(),'%s')]",//
						texto.get())));

		cmpMenu.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).clicarJavascript();
		if (!texto.get().equals("Cadastro"))
			StepsMaster.setPaginaAtual(new SPDashBoardPage(new SPAtenderPedido()));

		StepsMaster.setPaginaAtual(new SPCadastrosPage());
	}
	
	public void irParaHome(){
		BRQLogger.logMethod();
		SPDashBoardElementos.BTN_HOME//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)//
				.clicar();

		StepsMaster.setPaginaAtual(new SPMenuPrincipal());
	}

	private void solicitacaoMudancaAlteracao() {
		BRQLogger.logMethod();
		SPDashBoardElementos.PECAS_ALTERADA.esperarExistir(DEFAULT_STEPS_TIMEOUT).moverJavascript();
		String isDisable = SPDashBoardElementos.BTN_CONFIRMA_ALTERACAO.esperarExistir(DEFAULT_STEPS_TIMEOUT)
							.mover()
							.obterAtributo("disabled");

		Assertions.assertTrue(Boolean.valueOf(isDisable));
		StepsMaster.setPaginaAtual(new SPLoginPage());
	}

	private void solicitacaoDeMudanca(){
		Botao solicitacao = new Botao(By.xpath("//span[contains(text(),'SOLICITAÇÃO DE MUDANÇA')]"));
		solicitacao.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).moverJavascript().clicarJavascript();
		StepsMaster.setPaginaAtual(new SPDashBoardPage(new SPAtenderPedido()));
	}

	@Override
	public void selecionarCombos(Map<String, String> mapValores) {}

	@Override
	public void limparCombo() {}

	@Override
	public void limparCombo(String combo) {}
}
