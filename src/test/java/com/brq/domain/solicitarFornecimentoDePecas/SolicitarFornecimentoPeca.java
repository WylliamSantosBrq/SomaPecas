package com.brq.domain.solicitarFornecimentoDePecas;

import com.brq.domain.solicitarFornecimentoDePecas.SolicitacaoFornecimentoPeca;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@XmlRootElement(namespace = "http://ws.fornecimentopecasme.sinistro.porto.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SolicitarFornecimentoPeca {
    @XmlElement
    private SolicitacaoFornecimentoPeca solicitacaoFornecimentoPeca;
}
