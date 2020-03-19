package Lukyanov;


import Lukyanov.parser.DomWrite;
import Lukyanov.parser.MySAXParser;
import Lukyanov.parser.PlantParser;
import Lukyanov.validator.XmlValidator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class Application {
    private final static String CATALOG = "src/main/resources/plant_catalog.xml";
    private final static String CATALOG_MODIFIED = "src/main/resources/plant_catalog_modified.xml";

    public static void main(String[] args) {

        try {
            File input = new File(CATALOG);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MySAXParser mySaxParser = new MySAXParser();
            parser.parse(input, mySaxParser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DomWrite domWrite = new DomWrite();
        domWrite.createBookXml(3);
        //xml validation
        System.out.println("Result of XML validation: " + XmlValidator.validate("src/main/resources/book.xml",
                "src/main/resources/book.xsd"));

        PlantParser plantParser = new PlantParser();
        List<Plant> plants = plantParser.parseToList(CATALOG);
        plants.add(new Plant(
                "commonField",
                "botanicalField",
                "zoneField",
                "lightField",
                "priceField",
                "availabilityField"));
        plantParser.createXml(CATALOG_MODIFIED, plants);
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