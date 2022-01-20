package com.brq.domain.excel;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class AtributosMassa {
	private String id_local;
	private String id_oficina;
	private String id_peca;
	private String id_processo;
	private String id_veiculo;
	private String id_telefone;
//////////////////////////////////////
	
	private String cpfCnpjSolicitante = "61198164000160";
	
	private String codigoTipoLocalSolicitacao = "1";
	private String nomeLogradouro = "O JARAGUA";
	private String numeroLogradouro = "992";
	private String nomeBairro = "VILA ALPINA";
	private String numeroCep = "23243000";
	private String siglaUnidadeFederacao = "SP";
	private String nomeCidade = "SÃO PAULO";
	
	private String codigoTelefone = "11";
	private String numeroTelefone = "983778476";
	
	private String latitude = "22.938446";
	private String longitude= "73.928374";
	
	private String numeroCnpjCpfOficina = "63377448303";
	private String codigoTipoPessoa = "J";
	private String nomeRazaoSocialOficina = "Mega Cars Ltda";
	private String nomeFantasiaOficina = "Mega Cars Ltda";
	private String nomeEnderecoEmailOficina = "luciana32@gmail.com";
	private String codigoTipoOficinaAtendimento = "1";
	
	private String codigoPeca = "XS51/  16A044/AA";
	private String codigoMarcaVeiculo = "310";
	private String nomePecaSolicitacao = "XS51/  16A044/AA";
	private String codigoTipoUsoPeca = "E";
	private String quantidadePeca = "1";
	private String flagPecaManual = "N";
	private String valorPrecoPeca = "100";
	
	private String codigoChaveProcessoSinistro = "BRQ1319414491";
	private String codigoProcessoSinistro = "BRQ1319414491";
	private String numeroOrcamentoVistoria = "73432";
	private String numeroVersaoOrcamentoVistoria = "1";
	private String dataRecebidoVistoria = "2021-06-18";
	private String statusLiberacaoVistoria = "S";
	private String nomeSeguradoApoliceSinistro = "Automacao BRQ";
	private String codigoNumeroApoliceSinistro = "02193101011593";
	private String codigoNaturezaSinistro = "10";
	
	private String codigoLicencaVeiculo = "PPJ6926";
	private String codigoChassiVeiculo = "9BFZH55LXG8285405";
	private String anoModeloVeiculo = "2012";
	private String descricaoVeiculo = "CHEVROLET CRUZE HATCH SPORT LT 1.8 16V FLEX";
	private String codigoModeloVeiculo = "1352";
	private String codigoCategoriaTarifaVeiculo = "10";
	private String anoFabricacaoVeiculo = "2015";
	
//////////////////////////////////////
	private String nomeEnderecoEmail;
    private String content;
	private String dddTelefone;
}
