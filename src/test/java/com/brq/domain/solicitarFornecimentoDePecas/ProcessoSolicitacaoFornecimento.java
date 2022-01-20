package com.brq.domain.solicitarFornecimentoDePecas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProcessoSolicitacaoFornecimento {
    private String dataRecebidoVistoria;
    private String codigoProcessoSinistro;
    private String codigoNumeroApoliceSinistro;
    private String nomeSeguradoApoliceSinistro;
    private String numeroVersaoOrcamentoVistoria;
    private String statusLiberacaoVistoria;
    private String codigoChaveProcessoSinistro;
    private String content;
    private String numeroOrcamentoVistoria;
    private String codigoNaturezaSinistro;
}
