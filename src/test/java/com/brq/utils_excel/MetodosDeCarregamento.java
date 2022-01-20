package com.brq.utils_excel;

import org.apache.log4j.Logger;

import com.brq.domain.excel.AtributosMassa;
import com.brq.interfaces.log.LogWeb;
import com.cucumber.listener.Reporter;
//import utils.AtributosAnaliseCadastro;

public class MetodosDeCarregamento {
	
//	static Logger logger = LogWeb.getLogger(MetodosDeCarregamento.class);
	static Logger portoLogger = Logger.getLogger("PortoLogger");
	static AtributosMassa atributos = new AtributosMassa();
	private static ValorCelula<String> valorString = ValorCelulaHelper.valorString;

	private MetodosDeCarregamento() {
	}

	
	public static final CarregamentoDeDados carregamentoSolicitacao = row -> {

//		logger.info(row);
//		logger.info(row.toString());
        String cpfCnpjSolicitante = valorString.getValue(row.getCell(0));
		String id_local = valorString.getValue(row.getCell(1));
		String id_oficina = valorString.getValue(row.getCell(2));
		String id_peca = valorString.getValue(row.getCell(3));
		String id_processo = valorString.getValue(row.getCell(4));
		String id_veiculo = valorString.getValue(row.getCell(5));
		
		atributos.setCpfCnpjSolicitante(cpfCnpjSolicitante);
		atributos.setId_local(id_local);
		atributos.setId_oficina(id_oficina);
		atributos.setId_peca(id_peca);
		atributos.setId_processo(id_processo);
		atributos.setId_veiculo(id_veiculo);

		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tCPF/CNPJ: %s\n" + //
				"\tID_Local: %s\n" + //
				"\tID_Oficina: %s\n" + //
				"\tID_Peca: %s\n" + //
				"\tID_Processo: %s\n" + //
				"\tID_Veiculo: %s\n";

		portoLogger.info(obs + String.format(info,cpfCnpjSolicitante,id_local,id_oficina,id_peca,id_processo,id_veiculo));
        Reporter.addStepLog(obs + String.format(info,cpfCnpjSolicitante,id_local,id_oficina,id_peca,id_processo,id_veiculo));
	};
	
	public static final CarregamentoDeDados carregamentoLocal = row -> {

//		logger.info(row);
//		logger.info(row.toString());)
		String nomeLogradouro = valorString.getValue(row.getCell(2));
		String codigoTipoLocalSolicitacao = valorString.getValue(row.getCell(1));
		String numeroLogradouro = valorString.getValue(row.getCell(3));
		String nomeBairro = valorString.getValue(row.getCell(4));
		String numeroCep = valorString.getValue(row.getCell(5));
		String siglaUnidadeFederacao = valorString.getValue(row.getCell(6));
		String nomeCidade = valorString.getValue(row.getCell(7));
		String id_telefone = valorString.getValue(row.getCell(8));
		String latitude = valorString.getValue(row.getCell(9));
		String longitude = valorString.getValue(row.getCell(10));
			
		atributos.setCodigoTipoLocalSolicitacao(codigoTipoLocalSolicitacao);
		atributos.setNomeLogradouro(nomeLogradouro);
		atributos.setNumeroLogradouro(numeroLogradouro);
		atributos.setNomeBairro(nomeBairro);
		atributos.setNumeroCep(numeroCep);
		atributos.setSiglaUnidadeFederacao(siglaUnidadeFederacao);
		atributos.setNomeCidade(nomeCidade);
		atributos.setId_telefone(id_telefone);
		atributos.setLatitude(latitude);
		atributos.setLongitude(longitude);
		
		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tTipo Logradouro: %s\n" + //
				"\tLogradouro: %s\n" + //
				"\tNum Logradouro: %s\n" + //
				"\tBairro: %s\n" + //
				"\tCEP: %s\n" + //
				"\tUF: %s\n" + //
				"\tCidade: %s\n" + //
				"\tID_Telefone: %s\n" + //
				"\tLatitude: %s\n" + //
				"\tLongitude: %s\n";

		portoLogger.info(obs + String.format(info,codigoTipoLocalSolicitacao,nomeLogradouro,numeroLogradouro,nomeBairro,numeroCep,siglaUnidadeFederacao,nomeCidade,id_telefone,latitude,longitude));
        Reporter.addStepLog(obs + String.format(info,codigoTipoLocalSolicitacao,nomeLogradouro,numeroLogradouro,nomeBairro,numeroCep,siglaUnidadeFederacao,nomeCidade,id_telefone,latitude,longitude));
	};
	
	public static final CarregamentoDeDados carregamentoTelefone = row -> {

//		logger.info(row);
//		logger.info(row.toString());
		String codigoTelefone = valorString.getValue(row.getCell(1));
		String dddTelefone = valorString.getValue(row.getCell(2));
		String numeroTelefone = valorString.getValue(row.getCell(3));
			
		atributos.setCodigoTelefone(codigoTelefone);
		atributos.setDddTelefone(dddTelefone);
		atributos.setNumeroTelefone(numeroTelefone);
		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tCodigo Telefone: %s\n" + //
				"\tDDD: %s\n" + //
				"\tTelefone: %s\n";

		portoLogger.info(obs + String.format(info,codigoTelefone,dddTelefone,numeroTelefone));
        Reporter.addStepLog(obs + String.format(info,codigoTelefone,dddTelefone,numeroTelefone));
	};
	
	public static final CarregamentoDeDados carregamentoOficina = row -> {

//		logger.info(row);
//		logger.info(row.toString());
		String numeroCnpjCpfOficina = valorString.getValue(row.getCell(1));
		String nomeRazaoSocialOficina = valorString.getValue(row.getCell(2));
		String nomeFantasiaOficina = valorString.getValue(row.getCell(3));
		String codigoTipoPessoa = valorString.getValue(row.getCell(4));
		String codigoTipoOficinaAtendimento = valorString.getValue(row.getCell(5));
		String nomeEnderecoEmailOficina = valorString.getValue(row.getCell(6));
		
		atributos.setNumeroCnpjCpfOficina(numeroCnpjCpfOficina);
		atributos.setNomeRazaoSocialOficina(nomeRazaoSocialOficina);
		atributos.setNomeFantasiaOficina(nomeFantasiaOficina);
		atributos.setCodigoTipoPessoa(codigoTipoPessoa);
		atributos.setCodigoTipoOficinaAtendimento(codigoTipoOficinaAtendimento);
		atributos.setNomeEnderecoEmailOficina(nomeEnderecoEmailOficina);
		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tCPF/CNPJ: %s\n" + //
				"\tRazao Social: %s\n" + //
				"\tFantasia Oficina: %s\n" + //
				"\tCodigo Tipo Pessoa: %s\n" + //
				"\tCodigo Tipo Oficina: %s\n" + //
				"\tNome/Endereço/Email Oficina: %s\n";
		
		portoLogger.info(obs + String.format(info,numeroCnpjCpfOficina,nomeRazaoSocialOficina,nomeFantasiaOficina,codigoTipoPessoa,codigoTipoOficinaAtendimento,nomeEnderecoEmailOficina));
        Reporter.addStepLog(obs + String.format(info,numeroCnpjCpfOficina,nomeRazaoSocialOficina,nomeFantasiaOficina,codigoTipoPessoa,codigoTipoOficinaAtendimento,nomeEnderecoEmailOficina));
	};
	
	public static final CarregamentoDeDados carregamentoPeca = row -> {

//		logger.info(row);
//		logger.info(row.toString());
		String valorPrecoPeca = valorString.getValue(row.getCell(1));
		String codigoPeca = valorString.getValue(row.getCell(2));
		String quantidadePeca = valorString.getValue(row.getCell(3));
		String flagPecaManual = valorString.getValue(row.getCell(4));
		String nomePecaSolicitacao = valorString.getValue(row.getCell(5));
		String codigoMarcaVeiculo = valorString.getValue(row.getCell(6));
		String codigoTipoUsoPeca = valorString.getValue(row.getCell(7));
		
		atributos.setValorPrecoPeca(valorPrecoPeca);
		atributos.setCodigoPeca(codigoPeca);
		atributos.setQuantidadePeca(quantidadePeca);
		atributos.setFlagPecaManual(flagPecaManual);
		atributos.setNomePecaSolicitacao(nomePecaSolicitacao);
		atributos.setCodigoMarcaVeiculo(codigoMarcaVeiculo);
		atributos.setCodigoTipoUsoPeca(codigoTipoUsoPeca);
		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tValor Peça: %s\n" + //
				"\tCodigo Peça: %s\n" + //
				"\tQuantidade Peça: %s\n" + //
				"\tFlag Peça Manual: %s\n" + //
				"\tNome Peça: %s\n" + //
				"\tCodigo Marca Veiculo: %s\n" + //
				"\tCodigo Tipo Uso Peça: %s\n";

		portoLogger.info(obs + String.format(info,valorPrecoPeca,codigoPeca,quantidadePeca,flagPecaManual,nomePecaSolicitacao,codigoMarcaVeiculo,codigoTipoUsoPeca));
        Reporter.addStepLog(obs + String.format(info,valorPrecoPeca,codigoPeca,quantidadePeca,flagPecaManual,nomePecaSolicitacao,codigoMarcaVeiculo,codigoTipoUsoPeca));
	};
	
	public static final CarregamentoDeDados carregamentoProcesso = row -> {

//		logger.info(row);
//		logger.info(row.toString());
		String numeroOrcamentoVistoria = valorString.getValue(row.getCell(1));
		String numeroVersaoOrcamentoVistoria = valorString.getValue(row.getCell(2));
		String dataRecebidoVistoria = valorString.getValue(row.getCell(3));
		String statusLiberacaoVistoria = valorString.getValue(row.getCell(4));
		String codigoNumeroApoliceSinistro = valorString.getValue(row.getCell(5));
		String nomeSeguradoApoliceSinistro = valorString.getValue(row.getCell(6));
		String codigoNaturezaSinistro = valorString.getValue(row.getCell(7));
		
		atributos.setNumeroOrcamentoVistoria(numeroOrcamentoVistoria);
		atributos.setNumeroVersaoOrcamentoVistoria(numeroVersaoOrcamentoVistoria);
		atributos.setDataRecebidoVistoria(dataRecebidoVistoria);
		atributos.setStatusLiberacaoVistoria(statusLiberacaoVistoria);
		atributos.setCodigoNumeroApoliceSinistro(codigoNumeroApoliceSinistro);
		atributos.setNomeSeguradoApoliceSinistro(nomeSeguradoApoliceSinistro);
		atributos.setCodigoNaturezaSinistro(codigoNaturezaSinistro);
		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tNumero Orçamento Vistoria: %s\n" + //
				"\tNumero Versão Orçamento: %s\n" + //
				"\tData Recebido Vistoria: %s\n" + //
				"\tStatus Liberação: %s\n" + //
				"\tCodigo Numero Apólice: %s\n" + //
				"\tNome Segurado Apólice: %s\n" + //
				"\tCódigo Natureza Sinistro: %s\n";

		portoLogger.info(obs + String.format(info,numeroOrcamentoVistoria,numeroVersaoOrcamentoVistoria,dataRecebidoVistoria,statusLiberacaoVistoria,codigoNumeroApoliceSinistro,nomeSeguradoApoliceSinistro,codigoNaturezaSinistro));
        Reporter.addStepLog(obs + String.format(info,numeroOrcamentoVistoria,numeroVersaoOrcamentoVistoria,dataRecebidoVistoria,statusLiberacaoVistoria,codigoNumeroApoliceSinistro,nomeSeguradoApoliceSinistro,codigoNaturezaSinistro));
	};
	
	public static final CarregamentoDeDados carregamentoVeiculo = row -> {

//		logger.info(row);
//		logger.info(row.toString());
		String codigoLicencaVeiculo = valorString.getValue(row.getCell(1));
		String codigoChassiVeiculo = valorString.getValue(row.getCell(2));
		String anoModeloVeiculo = valorString.getValue(row.getCell(3));
		String descricaoVeiculo = valorString.getValue(row.getCell(4));
		String codigoModeloVeiculo = valorString.getValue(row.getCell(5));
		String codigoCategoriaTarifaVeiculo = valorString.getValue(row.getCell(6));
		String anoFabricacaoVeiculo = valorString.getValue(row.getCell(7));
		
		atributos.setCodigoLicencaVeiculo(codigoLicencaVeiculo);
		atributos.setCodigoChassiVeiculo(codigoChassiVeiculo);
		atributos.setAnoModeloVeiculo(anoModeloVeiculo);
		atributos.setDescricaoVeiculo(descricaoVeiculo);
		atributos.setCodigoModeloVeiculo(codigoModeloVeiculo);
		atributos.setCodigoCategoriaTarifaVeiculo(codigoCategoriaTarifaVeiculo);
		atributos.setAnoFabricacaoVeiculo(anoFabricacaoVeiculo);
		
		String obs = "DADOS CARREGADOS";
		String info = "\n" + //
				"\tLicença: %s\n" + //
				"\tChassi: %s\n" + //
				"\tAno Modelo: %s\n" + //
				"\tDescrição Veiculo: %s\n" + //
				"\tCodigo Modelo: %s\n" + //
				"\tCodigo Categoria Tarifa: %s\n" + //
				"\tAno Fabricação: %s\n";

		portoLogger.info(obs + String.format(info,codigoLicencaVeiculo,codigoChassiVeiculo,anoModeloVeiculo,descricaoVeiculo,codigoModeloVeiculo,codigoCategoriaTarifaVeiculo,anoFabricacaoVeiculo));
        Reporter.addStepLog(obs + String.format(info,codigoLicencaVeiculo,codigoChassiVeiculo,anoModeloVeiculo,descricaoVeiculo,codigoModeloVeiculo,codigoCategoriaTarifaVeiculo,anoFabricacaoVeiculo));
	};
}
