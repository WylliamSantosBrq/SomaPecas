package com.brq.domain.solicitarFornecimentoDePecas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VeiculoSolicitacaoFornecimento {
    private String anoFabricacaoVeiculo;
    private String descricaoVeiculo;
    private String anoModeloVeiculo;
    private String codigoChassiVeiculo;
    private String codigoCategoriaTarifaVeiculo;
    private String codigoModeloVeiculo;
    private String codigoLicencaVeiculo;
}
