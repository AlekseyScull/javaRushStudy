package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws ParserConfigurationException, JAXBException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, doc);
        NodeList list = doc.getElementsByTagName(tagName);
        for (int i = 0; i < list.getLength(); i++) {
            list.item(i).getParentNode().insertBefore(doc.createComment(comment + "\n"), list.item(i));
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer tr = tf.newTransformer();
        tr.setOutputProperty(OutputKeys.STANDALONE, "no");
        tr.transform(new DOMSource(doc), new StreamResult(sw));

        return sw.toString();
    }

    public static void main(String[] args) {

    }
}
