package lukyanov.parser;


import lukyanov.Plant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlantParser {
    private List<Plant> plants;

    public List<Plant> parseToList(String file) {
        try {
            File xmlFile = new File(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("PLANT");
            List<Plant> plants = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                plants.add(getPlant(nodeList.item(i)));
            }
            return plants;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Node getPlant(Document document, Plant plant) {
        Element node = document.createElement("PLANT");
        node.appendChild(getField(document, "COMMON", plant.getCommon()));
        node.appendChild(getField(document, "BOTANICAL", plant.getBotanical()));
        node.appendChild(getField(document, "ZONE", plant.getZone()));
        node.appendChild(getField(document, "LIGHT", plant.getLight()));
        node.appendChild(getField(document, "PRICE", plant.getPrice()));
        node.appendChild(getField(document, "AVAILABILITY", plant.getAvailability()));
        return node;
    }

    private Node getField(Document document, String field, String value) {
        Element node = document.createElement(field);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    private Plant getPlant(Node node) {
        Plant plant = new Plant();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            plant.setCommon(getValue("COMMON", element));
            plant.setBotanical(getValue("BOTANICAL", element));
            plant.setZone(getValue("ZONE", element));
            plant.setLight(getValue("LIGHT", element));
            plant.setPrice(getValue("PRICE", element));
            plant.setAvailability(getValue("AVAILABILITY", element));
        }
        return plant;
    }

    private String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public void createXml(String outputFile, List<Plant> plants) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            StreamResult file = new StreamResult(new File(outputFile));
            Element rootElement = document.createElementNS("", "CATALOG");
            for (Plant plant : plants) {
                rootElement.appendChild(getPlant(document, plant));
            }
            document.appendChild(rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}