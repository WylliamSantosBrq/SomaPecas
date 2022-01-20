package com.brq.domain.solicitarFornecimentoDePecas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocalSolicitacaoFornecimento {
    private String nomeLogradouro;
    private String codigoTipoLocalSolicitacao;
    private String nomeBairro;
    private String nomeCidade;
    private TelefoneLocalSolicitacaoFornecimento telefoneLocalSolicitacaoFornecimento;
    private String latitude;
    private String siglaUnidadeFederacao;
    private String numeroCep;
    private String nomeEnderecoEmail;
    private String numeroLogradouro;
    private String longitude;
}
