package com.brq.domain.solicitarFornecimentoDePecas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PecaSolicitacaoFornecimento {
    private String valorPrecoPeca;
    private String codigoPeca;
    private String quantidadePeca;
    private String flagPecaManual;
    private String nomePecaSolicitacao;
    private String codigoMarcaVeiculo;
    private String codigoTipoUsoPeca;

}
