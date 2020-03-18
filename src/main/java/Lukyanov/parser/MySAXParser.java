package Lukyanov.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXParser extends DefaultHandler {
    private StringBuffer result;

    public MySAXParser(){
        result = new StringBuffer();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) {

//имя тега
        result.append("<"+ qName +">");

//атрибуты тега
        for (int i = 0; i < atts.getLength(); i++){
            result.append("Attribute name = '" +
                    atts.getQName(i) + "'; Attribute value = '" + atts.getValue(i)+"'\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = "";

//содержимое тега
        for (int i = start; i < start+length; i++){
            value += ch[i];
        }

        if (value.length() != 0) {
            result.append(value);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {

//закрытие тега
        result.append("</" + qName + ">");
    }

    public String getResult(){
        return result.toString();
    }
}
