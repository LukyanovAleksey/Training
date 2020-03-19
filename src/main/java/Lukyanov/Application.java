package Lukyanov;


import Lukyanov.parser.MySAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Application {
    private final static String PATH = "src/main/resources/plant_catalog.xml";

    public static void main(String[] args) {
        File input = new File(PATH);

//SAX Parser
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MySAXParser mySaxParser = new MySAXParser();
            parser.parse(input, mySaxParser);
            System.out.println("SAX parser result:\n" + mySaxParser.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
Скачать пример xml файл отсюда http://okitgo.ru/misc/xml/plant_catalog.xml.
Загрузить его в память и вывести содержимое в отдельный файл при помощи логгера. См. настройки логгеров.
Использовать необходимо sl4j. Для чтения и вывода на экран используем 2 способа DOM и StAX парсер.
Руками написать xsd схему для xml файла. В ней должен быть описан сложный тип с Book.
Он должен в себе содержать: сложный тип Author, кол-во страниц, название, издатель.
Author в свою очередь должен иметь 3 поля firstName lastName secondName.
порядок элементов остается на ваше усмотрение, книг может быть сколько угодно, автор у книги 1.
Далее при помощи DOM создать xml документ который будет удовлетворять условиям нашей схемы и нужно будет
програмно его провалидировать. Для интереса можете сделать дополнительно не валидный документ и провалидировать его.
Загрузить в память документ из пункта 1 и модифицировать документ, что-то удалить, добавить или изменить и сохранить
новый документ.
 */