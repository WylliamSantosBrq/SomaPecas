package com.brq.enums;

public enum CodigoDeEstadoHTTP {

	STATUS100("Continuar"), STATUS101("Mudando protocolos"), STATUS102("Processamento (WebDAV) (RFC 2518)"),
	STATUS122(" Pedido-URI muito longo"), STATUS200(" OK"), STATUS201(" Criado"), STATUS202(" Aceito"),
	STATUS203(" nao-autorizado (desde HTTP/1.1)"), STATUS204(" Nenhum conteudo"), STATUS205(" Reset"),
	STATUS206(" Conteudo parcial"), STATUS207("STATUS Multi (WebDAV) (RFC 4918)"), STATUS300("Multipla escolha"),
	STATUS301(" Movido"), STATUS302("Encontrado"), STATUS303("Consulte Outros"), STATUS304("Nao modificado"),
	STATUS305("Use Proxy (desde HTTP/1.1)"), STATUS306("Proxy Switch"),
	STATUS307("Redirecionamento temporario (desde HTTP/1.1)"), STATUS308("Redirecionamento permanente (RFC 7538[2])"),
	STATUS400("Requisicao invalida"), STATUS401("Nao autorizado"), STATUS402("Pagamento necessario"),
	STATUS403("Proibido"), STATUS404("Nao encontrado"), STATUS405("Metodo nao permitido"), STATUS406("Nao Aceitavel"),
	STATUS407("Autenticacao de proxy necessaria"), STATUS408("Tempo de requisicao esgotou (Timeout)"),
	STATUS409("Conflito"), STATUS410("Gone"), STATUS411("comprimento necessario"), STATUS412("Pre-condicao falhou"),
	STATUS413("Entidade de solicitacao muito grande"), STATUS414("Pedido-URI Too Long"),
	STATUS415("Tipo de midia nao suportado"), STATUS416("Solicitada de Faixa Nao Satisfatoria"),
	STATUS417("Falha na expectativa"), STATUS418("Eu sou um bule de cha"),
	STATUS422("Entidade improcessavel (WebDAV) (RFC 4918)"), STATUS423("Fechado (WebDAV) (RFC 491"),
	STATUS424("Falha de Dependencia (WebDAV) (RFC 4918)"), STATUS425("colecao nao ordenada (RFC 3648)"),
	STATUS426("Upgrade Obrigatorio (RFC 2817)"), STATUS450("bloqueados pelo Controle de Pais do Windows"),
	STATUS499("cliente fechou Pedido (utilizado em ERPs/VPSA)"),
	STATUS500("Erro interno do servidor (Internal Server Error)"), STATUS501("Nao implementado (Not implemented)"),
	STATUS502("Bad Gateway"), STATUS503("Servico indisponivel (Service Unavailable)"), STATUS504("Gateway Time-Out"),
	STATUS505("HTTP Version not supported");

	private final String valor;

	private CodigoDeEstadoHTTP(String valorOpcao) {
		valor = valorOpcao;
	}

	public String getValor() {
		return valor;
	}

}