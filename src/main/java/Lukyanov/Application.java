package Lukyanov;

import Lukyanov.Exceptions.HumanServiceException;
import Lukyanov.Human.HumanDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Application.class);
        log.info("The program has been started");

        Random random = new Random();
        HumanService service = new HumanService();
        HumanDTO humanDTO = null;
        try {
            humanDTO = service.getEntity(random.nextLong());
        } catch (HumanServiceException e) {
            e.printStackTrace();
        }
        List<HumanDTO> listOfHumanDTO = service.getAllEntities();
        service.saveEntity(humanDTO);
        service.saveAllEntities(listOfHumanDTO);
        log.info("All tasks have been finished!");

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
