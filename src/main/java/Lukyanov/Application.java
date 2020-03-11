package Lukyanov;

import Lukyanov.Human.HumanDTO;

import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        HumanService service = new HumanService();
        HumanDTO humanDTO = service.getEntity(random.nextLong());
        List<HumanDTO> listOfHumanDTO = service.getAllEntities();
        service.saveEntity(humanDTO);
        service.saveAllEntities(listOfHumanDTO);
        System.out.println("All tasks have been finished!");
    }
}

/*
Задание:
Доработать задание с дженериками:
Создать собственные исключения
Использовать try, catch, throw, throws
Отдельные логгеры для сервиса, репозитория, конвертера
Один из них должен писать в консоль, второй в файл, третий и в консоль и в файл
Использовать разные аппендеры для разных логгеров
Использовать slf4j + logback.xml
 */
