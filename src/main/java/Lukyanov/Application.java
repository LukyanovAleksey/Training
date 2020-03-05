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
Создать доменную сущность для БД – Human со следующим набором полей:
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
