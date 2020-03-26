package lukyanov;

import lukyanov.human.HumanDto;

import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        HumanService service = new HumanService();
        HumanDto humanDto = service.getEntity(random.nextLong());
        List<HumanDto> listOfHumanDto = service.getAllEntities();
        service.saveEntity(humanDto);
        service.saveAllEntities(listOfHumanDto);
        System.out.println("All tasks have been finished!");
    }
}

/*
Задание:
Создать доменную сущность для БД – human со следующим набором полей:
- Id;
- name;
- address – поле должно быть вложенным классом, иметь свои поля;
- birthDate;
Создать DTO для нее.
Создать параметризированный интерфейс, который будет предоставлять методы для работы с БД:
- получение одной сущности;
- получение всех сущностей;
- сохранение одной сущности;
- сохранение списка сущностей.
Реализация данного интерфейса: сохранине – выводим, что к нам пришло на вход, запись –
генерируем сущности с рандомными данными.
Далее нужен сервис который будет работать с нашей БД, он так же должен быть параметризирован
и на основе его типа должена быть построена работа с БД. У него должны быть все те же методы,
но на вход они должны принимать не сущности, а DTO классы, внутри необходимо будет сделать
конвертацию из DTO в сущность и уже их передавать в БД. Соответственно нужны будут конвертеры
из сущностей в DTO и обратно, так же не забываем, что адрес у нас отдельный класс и его тоже
нужно конвертировать отдельно.
 */
