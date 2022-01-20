package com.brq.domain.solicitarFornecimentoDePecas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OficinaSolicitacaoFornecimento {
    private String nomeFantasiaOficina;
    private String numeroCnpjCpfOficina;
    private TipoOficinaAtendimentoSolicitacao tipoOficinaAtendimentoSolicitacao;
    private String nomeRazaoSocialOficina;
    private String nomeEnderecoEmailOficina;
    private String codigoTipoPessoa;
}
