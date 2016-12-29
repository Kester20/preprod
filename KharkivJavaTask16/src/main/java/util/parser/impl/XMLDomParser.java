package util.parser.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.parser.Parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 */
public class XMLDomParser implements Parser<String, List> {

    private String path;

    public XMLDomParser(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new XMLDomParser("security.xml").parse());
    }

    @Override
    public Map<String, List> parse() throws Exception {
        Map<String, List> result = new HashMap<>();
        File inputFile = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);

        NodeList nodeList1 = document.getElementsByTagName("constraint");
        for (int i = 0; i < nodeList1.getLength(); i++) {

            Node node = nodeList1.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                String url =  eElement.getElementsByTagName("url-pattern").item(0).getTextContent();
                NodeList nodeList = eElement.getElementsByTagName("role");

                List<String> list = new ArrayList<>();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node innerNode = nodeList.item(j);
                    list.add(innerNode.getTextContent());
                }
                result.put(url, list);
            }
        }
        return result;
    }

    public String getPath() {
        return path;
    }
}
