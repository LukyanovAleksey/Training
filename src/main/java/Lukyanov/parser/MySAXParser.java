package Lukyanov.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXParser extends DefaultHandler {
    private Logger log = LoggerFactory.getLogger(MySAXParser.class);
    private StringBuffer result;

    public MySAXParser() {
        result = new StringBuffer();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        result.append("<" + qName + ">");
        log.info("<" + qName + ">");

        for (int i = 0; i < atts.getLength(); i++) {
            result.append(atts.getQName(i) + "=\"" + atts.getValue(i) + "\"");
            log.info(atts.getQName(i) + "=\"" + atts.getValue(i) + "\"");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = "";
        for (int i = start; i < start + length; i++) {
            value += ch[i];
        }

        if (value.length() != 0) {
            result.append(value);
            log.info(value);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        result.append("</" + qName + ">");
        log.info("</" + qName + ">");
    }

    public String getResult() {
        return result.toString();
    }
}
