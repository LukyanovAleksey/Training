package Lukyanov.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public static boolean validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            File xml = new File(xmlFile);
            File xsd = new File(schemaFile);
            if (!xml.exists()) {
                System.out.println("Не найден XML " + xmlFile);
            }

            if (!xsd.exists()) {
                System.out.println("Не найден XSD " + schemaFile);
            }

            Schema schema = schemaFactory.newSchema(xsd);

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}