package com.brq.utils.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.brq.domain.fornecimentoDePecas.FornecimentoDePecas;
import com.brq.domain.solicitarFornecimentoDePecas.SolicitarFornecimentoPeca;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Conversao;
import com.mongodb.util.JSON;

public class ConverteXml implements Conversao {

    private FornecimentoDePecas pecas;
    
    public ConverteXml () {
    	pecas = new FornecimentoDePecas();
    }
    
    public ConverteXml (JSON entrada) {
    	pecas = new FornecimentoDePecas(entrada);
    }

    public SOAPMessage populaXml() throws JAXBException, SOAPException, IOException {
        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage message = mf.createMessage();
        SOAPBody body = message.getSOAPBody();

        JAXBContext jc = JAXBContext.newInstance(SolicitarFornecimentoPeca.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(pecas.solicitarFornecimentoPeca(), body);
        message.saveChanges();
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            message.writeTo(out);
            System.out.println("=================");
            System.out.println(formatarXml(new String(out.toByteArray()), 2));
            System.out.println("=================");
        }
        return message;
    }

    public void validaRetornoXML(String xml, String tagNameDoElemento, String valor) {
        DocumentBuilder docBuilder;
        Document doc;
        NodeList dadosNodeList = null;
        int numeroDeVezesEncontrado = 0;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setCoalescing(true);
        dbf.setNamespaceAware(false);

        try {
            docBuilder = dbf.newDocumentBuilder();
            System.out.println(formatarXml(xml, 2));
            doc = docBuilder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
            dadosNodeList = doc.getElementsByTagName(tagNameDoElemento);
            for (int i = 0; i < dadosNodeList.getLength(); i++) {
                if (dadosNodeList.item(i).getTextContent().equals(valor)) {
                    numeroDeVezesEncontrado = numeroDeVezesEncontrado + 1;
                }
            }
            if (numeroDeVezesEncontrado == 0) {
               throw new ErroAutomacao();
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new ErroAutomacao();
        }
    }
    
}
