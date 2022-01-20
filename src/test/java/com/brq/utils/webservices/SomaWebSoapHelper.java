package com.brq.utils.webservices;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import com.brq.erros.ErroInesperado;
import com.brq.interfaces.log.BRQLogger;

public class SomaWebSoapHelper extends SoapHelper {

	private static final String ENDPOINT = "https://washmlsoma:443/somaWS/SegurancaWebService";
	private static final String ACTION = "http://client.ws.soma.sinistro.porto.com/obterApenasToken";

	public String getToken() {
		BRQLogger.logMethod();

		SOAPMessage response = callSoapWebService(ENDPOINT, ACTION);

		try {
			return getValue(response.getSOAPBody(), "textoToken");

		} catch (SOAPException e) {
			throw new ErroInesperado(e);
		}
	}

	@Override
	public void createSoapEnvelope(SOAPMessage mensagem, Object... args) throws SOAPException {
		BRQLogger.logMethod(mensagem);

		SOAPPart soapPart = mensagem.getSOAPPart();

		String namespace = "cli";
		String namespaceURI = "http://client.ws.soma.sinistro.porto.com/";

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(namespace, namespaceURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("obterApenasToken", namespace);
		SOAPElement soapCpf = soapBodyElem.addChildElement("cpf");
		soapCpf.addTextNode("21441816836");
		SOAPElement soapSenha = soapBodyElem.addChildElement("senha");
		soapSenha.addTextNode("9H8pYV6T3u4I6RTl55TyWw==");
	}

}
