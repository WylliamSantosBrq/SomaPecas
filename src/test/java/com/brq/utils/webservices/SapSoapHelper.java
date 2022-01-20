package com.brq.utils.webservices;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import com.brq.erros.ErroInesperado;
import com.brq.interfaces.log.BRQLogger;

public class SapSoapHelper extends SoapHelper {

	private static final String ENDPOINT = "http://washmlservicosauto/autofinanceiroWS/AutofinanceiroConsultasWS";
	private static final String ACTION = "http://client.ws.soma.sinistro.porto.com/obterVariaveisMotorProposta";

	public boolean cadastradoNoSap(String origem, String proposta, String sucursal, String numeroDaApolice,
			String endosso) {
		BRQLogger.logMethod(origem, proposta, sucursal, numeroDaApolice, endosso);

		SOAPMessage response = callSoapWebService(ENDPOINT, ACTION, origem, proposta, sucursal, numeroDaApolice,
				endosso);

		try {
			response.writeTo(System.out);
			System.out.println();
			return getValue(response.getSOAPBody(), "textoToken") != null;

		} catch (SOAPException | IOException e) {
			throw new ErroInesperado(e);
		}
	}

	@Override
	public SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, Object... args) {
		BRQLogger.logMethod(soapEndpointUrl, soapAction, args);

		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			SOAPMessage soapRequest = createSoapRequest(soapAction, args);
			SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);

			soapResponse.writeTo(System.out);
			System.out.println();

			soapConnection.close();

			return soapResponse;
		} catch (Exception e) {
			throw new ErroInesperado(e);
		}
	}

	@Override
	public SOAPMessage createSoapRequest(String soapAction, Object... args) throws SOAPException, IOException {
		BRQLogger.logMethod(soapAction, args);

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();

		createSoapEnvelope(soapMessage, args);

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);

		soapMessage.saveChanges();

		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}

	/**
	 * args = origem, proposta, sucursal, num apolice, endosso
	 */
	@Override
	public void createSoapEnvelope(SOAPMessage mensagem, Object... args) throws SOAPException {
		BRQLogger.logMethod(mensagem, args);

		SOAPPart soapPart = mensagem.getSOAPPart();

		String namespace = "aut";
		String namespaceURI = "http://washmlservicosauto/autofinanceiroWS/AutofinanceiroConsultasWS";

		String origem = args[0] != null ? (String) args[0] : "";
		String proposta = args[1] != null ? (String) args[1] : "";
		String sucursal = args[2] != null ? (String) args[2] : "";
		String apolice = args[3] != null ? (String) args[3] : "";
		String endosso = args[4] != null ? (String) args[4] : "";

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(namespace, namespaceURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("obterVariaveisMotorProposta", namespace);
		SOAPElement soapOrigemProposta = soapBodyElem.addChildElement("origemProposta");
		soapOrigemProposta.addTextNode(origem);
		SOAPElement soapNumeroProposta = soapBodyElem.addChildElement("numeroProposta");
		soapNumeroProposta.addTextNode(proposta);
		SOAPElement soapCodigoPlanoParcelamento = soapBodyElem.addChildElement("codigoPlanoParcelamento");
		soapCodigoPlanoParcelamento.addTextNode("");
		SOAPElement soapQuantidadeParcelas = soapBodyElem.addChildElement("quantidadeParcelas");
		soapQuantidadeParcelas.addTextNode("");
		SOAPElement soapFlagEndossoCancelamento = soapBodyElem.addChildElement("flagEndossoCancelamento");
		soapFlagEndossoCancelamento.addTextNode("N");
		SOAPElement soapCodigoSucursalReferencia = soapBodyElem.addChildElement("codigoSucursalReferencia");
		soapCodigoSucursalReferencia.addTextNode(sucursal);
		SOAPElement soapNumeroApoliceReferencia = soapBodyElem.addChildElement("numeroApoliceReferencia");
		soapNumeroApoliceReferencia.addTextNode(apolice);
		SOAPElement soapNumeroEndossoReferencia = soapBodyElem.addChildElement("numeroEndossoReferencia");
		soapNumeroEndossoReferencia.addTextNode(endosso);
	}

}
