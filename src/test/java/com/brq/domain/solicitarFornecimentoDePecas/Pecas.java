package com.brq.domain.solicitarFornecimentoDePecas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Pecas {
    private List<PecaSolicitacaoFornecimento> pecaSolicitacaoFornecimento = new ArrayList<>();
}
