package com.brq.utils.xml;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.mongodb.util.JSON;

public class XmlHelper {

    private ConverteXml xml;
    
    public XmlHelper() {
    	xml = new ConverteXml();
    }
    
    public XmlHelper(JSON entrada) {
    	xml = new ConverteXml(entrada);
    }
    
    private int MAX_TIMEOUT = 60000; //1 minuto
    private static final String URL = "http://li937/fornecimentopecasmeWS/FornecimentoPecaWebService";

    public void enviarXmlSoap() {
    	
        SOAPConnection connection = null;
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            connection = soapConnectionFactory.createConnection();
            SOAPMessage response = connection.call(xml.populaXml(),  responseTimeout(URL));

            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                response.writeTo(out);
                xml.validaRetornoXML(out.toString(), "descricaoRetorno", "Sucesso");
            }

        } catch (UnsupportedOperationException | SOAPException | JAXBException | IOException e) {
            e.printStackTrace();
        	throw new ErroSistema();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private URL responseTimeout(String endpoint) throws MalformedURLException {
        URL url = new URL(null, endpoint, new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL url) throws IOException {
                HttpURLConnection urlconnection = null;
                try {
                    URL clone_url = new URL(url.toString());
                    urlconnection = (HttpURLConnection) clone_url.openConnection();
                    // Timeout
                    urlconnection.setConnectTimeout(MAX_TIMEOUT);
                    urlconnection.setReadTimeout(MAX_TIMEOUT);
                } catch (SocketTimeoutException e) {
                    long minutos = MAX_TIMEOUT;
                    String lineSeparator = System.lineSeparator();
                    throw new ErroAutomacao("Solicitar Fornecimento Peca Response excedeu o limite de "+minutos+" minuto(s). "
                            +lineSeparator+ e.getMessage());
                }
                return (urlconnection);
            }
        });
        BRQLogger.info(url.toString());
        return url;
    }


}
