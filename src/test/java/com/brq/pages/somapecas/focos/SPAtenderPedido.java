package com.brq.pages.somapecas.focos;

import com.brq.drivers.web.DriverWeb;
import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Combo;
import com.brq.elementos.Tabela;
import com.brq.elementos.somapecas.SPAtenderPedidoElementos;
import com.brq.elementos.somapecas.SPCarregamentoElementos;
import com.brq.elementos.somapecas.SPDashBoardElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Combos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.somapecas.SPCarregamento;
import com.brq.interfaces.web.IRolarJS;
import com.brq.pages.Foco;
import com.brq.pages.PdfPage;
import com.brq.pages.somapecas.*;
import com.brq.steps.StepsMaster;
import com.brq.util.StringHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SPAtenderPedido extends Foco implements Combos{

	public static String NUMERO_PEDIDO;
	public static String NUMERO_SINISTRO;

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		if (botao.startsWith("ícone de foto")) {
			clicarNoIconeDeFoto(StringHelper.getGroup(botao, "ícone de foto do (.*?) pedido").get(0));
			return;
		}

		switch (botao) {
			case "Informações Oficina":
				clicarEmInformacoesOficina();
				break;

			case "Histórico do Pedido":
				StepsMaster.setPaginaAtual(new SPHistoricoPedido());
				getPaginaAtual().clicarEm(botao);
				break;

			case "Confirmar":
				confirmar();
				break;

			case "Abrir Tarefa":
				abrirTarefa();
				break;

		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	public void clicarEmInformacoesOficina() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.BTN_INFORMACOES_OFICINA.clicar();
	}

	public void clicarNoIconeDeFoto(String indexPedido) {
		BRQLogger.logMethod(indexPedido);

		Integer indice = StringHelper.getZeroBasedOrdinal(indexPedido);
		String subXpath = "//input[@src='/fornecimentopecasme/images/template/photos.png']";

		SPCarregamentoElementos.GIF_CARREGAMENTO.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT);
		SPAtenderPedidoElementos.LISTA_PEDIDOS_AGUARDANDO_ATENDIMENTO.getLinha(indice).get(subXpath).moverJavascript();
		SPAtenderPedidoElementos.LISTA_PEDIDOS_AGUARDANDO_ATENDIMENTO.getLinha(indice).get(subXpath).clicarJavascript();

		StepsMaster.setPaginaAtual(new SPAPFotoPage());
	}

	public void validarListaDePedidosAguardandoAtendimento() {
		BRQLogger.logMethod();

		try {
			SPAtenderPedidoElementos.LISTA_PEDIDOS_AGUARDANDO_ATENDIMENTO//
					.esperarExistir(DEFAULT_STEPS_TIMEOUT);

			SPCarregamentoElementos.GIF_CARREGAMENTO
					.esperarSerInvisivel(DEFAULT_STEPS_TIMEOUT)
					.esperarMilisegundos(500);

		} catch (Exception e) {
			throw new ErroValidacao("A lista de pedidos aguardando atendimento não está presente em tela.");
		}
	}

	@Override
	public void moverCursorSobre(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "criticidade":
			moverCursorSobreCriticidade();
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [moverCursorSobre].", objeto);
		}
	}

	private void abrirTarefa(){
		BRQLogger.logMethod();
		List<WebElement> abrirTarefas = DriverWeb.getDriver()
				.findElements(By.xpath("//table[contains(@id,':panelTarefas') and position()=1]//span[contains(text(),'ABRIR TAREFA')]"));

		abrirTarefas.get(0).click();
	}

	public void moverCursorSobreCriticidade() {
		BRQLogger.logMethod();
		SPAtenderPedidoElementos.CRITICIDADE.mover();
	}

	public void validarCriticidadePopUp() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_INICIO_TAREFA.esperarExistir(DEFAULT_STEPS_TIMEOUT);
		SPAtenderPedidoElementos.TXT_PREVISAO_FINAL_TAREFA.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	@Override
	public void validarDadoEmTela(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
			case "Número do Sinistro":
				validarNumeroDoSinistro();
				break;

			case "Data da Solicitação":
				validarDataDaSolicitacao();
				break;

			case "Número do pedido":
				validarNumeroDoPedido();
				break;

			case "Data do pedido":
				validarDataDoPedido();
				break;

			case "Marca":
				validarMarca();
				break;

			case "Veículo":
				validarVeiculo();
				break;

			case "Modelo":
				validarModelo();
				break;

			case "Placa":
				validarPlaca();
				break;

			case "Chassi":
				validarChassi();
				break;

			case "Ano":
				validarAno();
				break;

			case "CNPJ":
				validarCnpj();
				break;

			case "Razão Social":
				validarRazaoSocial();
				break;

			case "Tipo de Oficina":
				validarTipoOficina();
				break;

			case "Endereço":
				validarEndereco();
				break;

			case "Tipo Veículo Atendimento":
				validarTipoVeiculo();
				break;

			case "Telefone Comercial":
				validarTelefoneComercial();
				break;

			case "Telefone Fax":
				validarTelefoneFax();
				break;

			case "Email":
				validarEmail();
				break;

			case "Horário de Atendimento":
				validarHorarioAtendimento();
				break;

			case "Observações":
				validarObservacao();
				break;

			case "Solicitação de Mudança":
				solicitacaoMudancaoInativo();
				break;
			default:
				throw new ErroAutomacao();
		}
	}

	public void validarNumeroDoSinistro() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_NUMERO_SINISTRO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarDataDaSolicitacao() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_DATA_SOLICITACAO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarNumeroDoPedido() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_NUMERO_PEDIDO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarDataDoPedido() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_DATA_PEDIDO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarMarca() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_MARCA.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarVeiculo() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_VEICULO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarModelo() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_MODELO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarPlaca() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_PLACA.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarChassi() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_CHASSI.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarAno() {
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_ANO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarCnpj(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_CNPJ.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarRazaoSocial(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_RAZAO_SOCIAL.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarTipoOficina(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_TIPO_OFICINA.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarEndereco(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_ENDERECO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarTipoVeiculo(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_TIPO_VEICULO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarTelefoneComercial(){
		BRQLogger.logMethod();
		try {
			SPAtenderPedidoElementos.TXT_TEL_COMERCIAL.esperarExistir(DEFAULT_STEPS_TIMEOUT);
		}catch (TimeoutException ex){}

	}

	public void validarTelefoneFax(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_TEL_FAX.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarEmail(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_EMAIL.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarHorarioAtendimento(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_HORARIO_ATEND.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void validarObservacao(){
		BRQLogger.logMethod();

		SPAtenderPedidoElementos.TXT_OBSERVACAO.esperarExistir(DEFAULT_STEPS_TIMEOUT);
	}

	public void clicarNoBotaoDoPedidoPorIndice(String botao, String indicePedido) {
		BRQLogger.logMethod(botao, indicePedido);

		switch (botao) {
		case "Abrir Tarefa":
			clicarEmAbrirTarefa(indicePedido);
			break;

		case "PDF":
			clicarEmPdf(indicePedido);
			break;

		default:
			throw new ErroAutomacao();
		}
	}

	public void clicarEmPdf(String indicePedido) {
		BRQLogger.logMethod(indicePedido);

		Integer indice = StringHelper.getZeroBasedOrdinal(indicePedido);
		Botao btn = SPAtenderPedidoElementos.BTN_PDF;
		btn.esperarExistir(DEFAULT_STEPS_TIMEOUT);
		btn.clicar(indice);

		StepsMaster.setPaginaAtual(new PdfPage());
	}

	public void clicarEmAbrirTarefa(String indicePedido) {
		BRQLogger.logMethod(indicePedido);
		Botao btn = SPAtenderPedidoElementos.BTN_ABRIR_TAREFA;
		Integer indice = StringHelper.getZeroBasedOrdinal(indicePedido);
		btn.moverJavascript();
		btn.clicarJavascript(indice);
	}

	public void confirmar(){
		BRQLogger.logMethod();
		SPAtenderPedidoElementos.BTN_CONFIRMAR//
				.esperarExistir(DEFAULT_STEPS_TIMEOUT)//
				.esperarSerClicavel(DEFAULT_STEPS_TIMEOUT)//
				.clicar();

		NUMERO_PEDIDO = SPAtenderPedidoElementos.TXT_NUMERO_PEDIDO_PECA.obterTexto();
		NUMERO_SINISTRO = SPAtenderPedidoElementos.TXT_NUMERO_SINISTRO.obterTexto();

		StepsMaster.setPaginaAtual(new SPAvisoPedidoPage());
	}

	public void validarInformacoesDoPedido(String indicePedido) {
		BRQLogger.logMethod(indicePedido);

		Tabela table = new Tabela("//table[contains(@id,'panelTarefaPedido')]");
		table.esperarExistir(DEFAULT_STEPS_TIMEOUT);

		esperarMilisegundos(500);
		List<WebElement> campos = DriverWeb.getDriver()//
											.findElements(By.xpath("//table[contains(@id,'panelTarefaPedido')]//span"));

		campos.forEach(cmp -> Assert.assertNotNull(cmp.getText()));
	}

	private void solicitacaoMudancaoInativo(){
		Campo statusPecas = new Campo(By.xpath("//select[contains(@id,'formFornecimento:solicitacaoMudancaList:')]/option"));
		Assert.assertEquals("disable", statusPecas.mover().obterAtributo("disable"));
		StepsMaster.setPaginaAtual(new SPLoginPage());
	}

	@Override
	public void selecionarCombo(String combo, String opcao) {


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
}
