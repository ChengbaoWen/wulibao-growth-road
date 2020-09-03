package com.wulibao.provider.xpath;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XPath 解析xml
 * 
 * @author WuliBao
 * @date 2020-07-17
 */
public class XpathMain {
    private static final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";
    
    public static void main(String[] args)
        throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(PATH + "Xpath.xml");
        Element documentElement = doc.getDocumentElement();
        NodeList info = documentElement.getElementsByTagName("info");
        
        // XPathFactory xFactory = XPathFactory.newInstance();
        // XPath xpath = xFactory.newXPath();
        // XPathExpression expr = xpath.compile("//name/text()");
        // Object result = expr.evaluate(doc, XPathConstants.NODESET);
        // NodeList nodes = (NodeList)result;
        // for (int i = 0; i < nodes.getLength(); i++) {
        // System.out.println(nodes.item(i).getNodeValue());
        // }
    }
}
