package com.brq.utils.webservices;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.brq.erros.ErroInesperado;
import com.brq.interfaces.log.BRQLogger;

public abstract class SoapHelper {

	abstract void createSoapEnvelope(SOAPMessage message, Object... args) throws SOAPException;

	public SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, Object...args) {
		BRQLogger.logMethod(soapEndpointUrl, soapAction);
		
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			SOAPMessage soapRequest = createSoapRequest(soapAction);
			SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);

			soapResponse.writeTo(System.out);
			System.out.println();

			soapConnection.close();

			return soapResponse;
		} catch (Exception e) {
			throw new ErroInesperado(e);
		}
	}

	public SOAPMessage createSoapRequest(String soapAction, Object...args) throws SOAPException, IOException {
		BRQLogger.logMethod(soapAction);

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();

		createSoapEnvelope(soapMessage);

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);

		soapMessage.saveChanges();

		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}

	public static String getValue(SOAPBody body, String tagName) {
		BRQLogger.logMethod(body, tagName);

		NodeList nodes = body.getElementsByTagName(tagName);
		BRQLogger.info(nodes.getClass().getName());
		Node node = nodes.item(0);
		String value = node != null ? node.getTextContent() : "";
		BRQLogger.info("Valor da tag <%s>: %s.", tagName, value);
		
		return value;
	}

}
