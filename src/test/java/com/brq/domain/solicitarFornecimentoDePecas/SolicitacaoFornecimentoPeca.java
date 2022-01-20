package com.brq.domain.solicitarFornecimentoDePecas;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SolicitacaoFornecimentoPeca {
    private String cpfCnpjSolicitante;
    private OficinaSolicitacaoFornecimento oficinaSolicitacaoFornecimento;
    private ProcessoSolicitacaoFornecimento processoSolicitacaoFornecimento;
    private LocalSolicitacaoFornecimento localSolicitacaoFornecimento;
    private VeiculoSolicitacaoFornecimento veiculoSolicitacaoFornecimento;
    private List<PecaSolicitacaoFornecimento> pecaSolicitacaoFornecimento;
}
