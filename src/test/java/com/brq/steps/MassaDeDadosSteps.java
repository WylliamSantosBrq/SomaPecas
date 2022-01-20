package com.brq.steps;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

import com.brq.dados.DadosUsuarioDesligamento;
import com.brq.domain.excel.AtributosMassa;
import com.brq.erros.ErroMassaDeDados;
import com.brq.interfaces.log.TimeLabel;
import com.brq.interfaces.log.TimeLogger;
import com.brq.utils.xml.XmlHelper;
import com.brq.utils_excel.ExcelHelper;
import com.cucumber.listener.Reporter;
import com.mongodb.util.JSON;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class MassaDeDadosSteps extends StepsMaster {
	
	@Given("^que (?:o usuário )?carregou os dados da linha (.*?) e da aba \"(.*?)\"$")
	public void queEuCarregueTodosOsDadosDaPlanilha(int linha, String nomeDaAba) {
		TimeLogger.start(TimeLabel.MASSA_DE_DADOS);

		try {
			AtributosMassa atributos = new AtributosMassa();
			
			ExcelHelper.carregarPlanilha();
			ExcelHelper.carregarAba(nomeDaAba);
			ExcelHelper.carregarDadosDaLinha(linha);
			
			ExcelHelper.carregarAba("LocalFornecimento");
			ExcelHelper.carregarDadosDaLinha(Integer.parseInt(atributos.getId_local()));
			
			ExcelHelper.carregarAba("TelefoneSolicitacao");
			ExcelHelper.carregarDadosDaLinha(Integer.parseInt(atributos.getId_telefone()));
			
			ExcelHelper.carregarAba("OficinaSolicitacao");
			ExcelHelper.carregarDadosDaLinha(Integer.parseInt(atributos.getId_oficina()));
			
			ExcelHelper.carregarAba("PecaSolicitacao");
			ExcelHelper.carregarDadosDaLinha(Integer.parseInt(atributos.getId_peca()));
			
			ExcelHelper.carregarAba("ProcessoSolicitacao");
			ExcelHelper.carregarDadosDaLinha(Integer.parseInt(atributos.getId_processo()));
			
			ExcelHelper.carregarAba("VeiculoSolicitacao");
			ExcelHelper.carregarDadosDaLinha(Integer.parseInt(atributos.getId_veiculo()));
			
		} catch (InvalidOperationException e) {
			throw new ErroMassaDeDados(e, "A planilha MassaDeDadosExcel provavelmente está corrompida.");
		} finally {
			TimeLogger.stop(TimeLabel.MASSA_DE_DADOS);

			String cenario = DadosUsuarioDesligamento.getCenariosRelacionados() != null
					? String.format("Cenário: %s%n", DadosUsuarioDesligamento.getCenariosRelacionados())
					: "";
			Reporter.addScenarioLog(cenario);
		}
	}

	@And("^enviar XML$")
	public void enviarXML() {
		new XmlHelper().enviarXmlSoap();		
	}
	
	@And("^enviar XML com JSON$")
	public void enviarXMLJson() {
		new XmlHelper(new JSON()).enviarXmlSoap();		
	}
	
//	@Then("^todos os dados de usuário estarão salvos na memória$")
//	public void todosOsDadosEstaraoSalvosNaMemoria() {
//		new DadosUsuarioDesligamento().logAllFields();
//	}
//	
//	@Given("^que (?:o usuário )?salvou todos os dados do \"(.*?)\"$")
//	@When("^(?:o usuário )?salvar todos os dados do \"(.*?)\"$")
//	public static void salvarTodosOsDadosDo(String dadosASeremSalvos) {
//		getPaginaAtual().salvarDados(dadosASeremSalvos);
//	}

}
