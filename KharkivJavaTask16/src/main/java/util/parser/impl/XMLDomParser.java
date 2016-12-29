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
    private static final String CONSTRAINT = "constraint";
    private static final String URL_PATTERN = "url-pattern";
    private static final String ROLE = "role";

    public XMLDomParser(String path) {
        this.path = path;
    }

    @Override
    public Map<String, List> parse() throws Exception {
        Map<String, List> result = new HashMap<>();
        File inputFile = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);

        NodeList nodeList = document.getElementsByTagName(CONSTRAINT);
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                String url = eElement.getElementsByTagName(URL_PATTERN).item(0).getTextContent();
                NodeList innerNodeList = eElement.getElementsByTagName(ROLE);

                List<String> list = new ArrayList<>();
                for (int j = 0; j < innerNodeList.getLength(); j++) {
                    Node innerNode = innerNodeList.item(j);
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
