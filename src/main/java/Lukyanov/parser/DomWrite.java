package Lukyanov.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Random;

public class DomWrite {
    public void createBookXml(int number) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult file = new StreamResult(new File("src/main/resources/book.xml"));
            fillBooks(document, number);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document fillBooks(Document document, int number) {
        Element root = document.createElementNS("", "Books");
        root.setAttribute("xmlns:xs", "http://www.w3.org/2001/XMLSchema-instance");
        root.setAttribute("xs:noNamespaceSchemaLocation", "src/main/resources/book.xsd");
        document.appendChild(root);
        for (int i = 0; i < number; i++) {
            Element book = document.createElement("Book");
            book.appendChild(createAuthor(document));
            book.appendChild(createField(document, "numberOfPages", Integer.toString((int) (Math.random() * 1000))));
            book.appendChild(createField(document, "title", stringGenerator()));
            book.appendChild(createField(document, "publisher", stringGenerator()));
            root.appendChild(book);
        }
        return document;
    }

    private Node createAuthor(Document document) {
        Element author = document.createElement("Author");
        author.appendChild(createField(document, "firstname", stringGenerator()));
        author.appendChild(createField(document, "lastname", stringGenerator()));
        author.appendChild(createField(document, "secondname", stringGenerator()));
        return author;
    }

    private Node createField(Document document, String field, String value) {
        Element node = document.createElement(field);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    private String stringGenerator() {
        Random rnd = new Random();
        String eng = "abcdefghijklmnopqrstuvwxyz";
        String sum = eng + eng.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rnd.nextInt(10) + 2; i++) {
            result.append(sum.charAt(rnd.nextInt(sum.length())));
        }
        return result.toString();
    }
}