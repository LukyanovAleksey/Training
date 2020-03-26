package lukyanov;

import lombok.extern.slf4j.Slf4j;
import lukyanov.exceptions.HumanServiceException;
import lukyanov.human.HumanDto;

import java.util.List;
import java.util.Random;

@Slf4j
public class Application {
    public static void main(String[] args) {

        log.info("The program has been started");

        Random random = new Random();
        HumanService service = new HumanService();
        HumanDto humanDto = null;
        try {
            humanDto = service.getEntity(random.nextLong());
        } catch (HumanServiceException e) {
            e.printStackTrace();
        }
        List<HumanDto> listOfHumanDto = service.getAllEntities();
        service.saveEntity(humanDto);
        service.saveAllEntities(listOfHumanDto);
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
