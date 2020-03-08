package Lukyanov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //Test data creation
        Human[] humanArray = new Human[10];

        //Duplicates: 0-1, 2-3, 4-5
        humanArray[0] = new Human("John Doe", 30, null);
        humanArray[0].setAddress(humanArray[0].new Address("Togliatti", "Frunze", "31", 46));
        humanArray[1] = new Human("John Doe", 30, null);
        humanArray[1].setAddress(humanArray[1].new Address("Togliatti", "Frunze", "31", 46));

        humanArray[2] = new Human("Kye Thomas", 54, null);
        humanArray[2].setAddress(humanArray[2].new Address("Самара", "Пермитина", "37", 57));
        humanArray[3] = new Human("Kye Thomas", 54, null);
        humanArray[3].setAddress(humanArray[3].new Address("Самара", "Пермитина", "37", 57));

        humanArray[4] = new Human("Conner Rodriguez", 54, null);
        humanArray[4].setAddress(humanArray[4].new Address("Дубовское", "Прогонная", "68", 326));
        humanArray[5] = new Human("Conner Rodriguez", 54, null);
        humanArray[5].setAddress(humanArray[5].new Address("Дубовское", "Прогонная", "68", 326));

        humanArray[6] = new Human("Silas Torres", 23, null);
        humanArray[6].setAddress(humanArray[6].new Address("Турочак", "Автономная", "28", 258));

        humanArray[7] = new Human("Benson White", 34, null);
        humanArray[7].setAddress(humanArray[7].new Address("Северодвинск", "Энергетиков проезд", "93", 291));

        humanArray[8] = new Human("Sabrina James", 25, null);
        humanArray[8].setAddress(humanArray[8].new Address("Ухта", "Полковая", "82", 167));

        humanArray[9] = new Human("Lilith Richardson", 28, null);
        humanArray[9].setAddress(humanArray[9].new Address("Светлоград", "Бахрушина", "65", 1));

        System.out.println("1. Заполнить ArrayList этими объектами:");
        List<Human> humans = new ArrayList<>();
        Collections.addAll(humans, humanArray);
        System.out.println(humans);

        printSeparator('#');
        System.out.println("2. Найти дубли в коллекции и вывести их в консоль.");
        System.out.println("3. Удалить дубли из коллекции, должно остаться 7 объектов.");
        removeDuplicates(humans);
        System.out.println(humans);

        printSeparator('#');
        System.out.println("4. Отсортировать людей по ФИО");
        sortHumansByFio(humans);
        System.out.println(humans);

        printSeparator('#');
        System.out.println("Отсортировать людей по возрасту");
        sortHumansByAge(humans);
        System.out.println(humans);

        printSeparator('#');
        System.out.println("6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)");
        sortHumansByAddress(humans);
        System.out.println(humans);
    }

    private static void printSeparator(char ch) {
        for (int i=0; i<30; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    private static void removeDuplicates(List<Human> humanList) {

        int size = humanList.size();
        int duplicates = 0;

        for (int i=0; i <size-1; i++) {
            for (int j = i+1; j<size; j++) {
                // no need for if ( i == j ) here
                if (!humanList.get(j).equals(humanList.get(i)))
                    continue;
                duplicates++;
                System.out.println("Duplicate #"+duplicates+": "+humanList.get(j).toString()+" has been found!");
                humanList.remove(j);
                j--;
                size--;
            }
        }
        if(duplicates!=0) {
            System.out.println(duplicates+" duplicates has been found and removed");
        }
    }

    private static void sortHumansByFio(List<Human> humanList) {
        Comparator<Human> humanComparatorByFio = (o1, o2) -> o1.getFio().compareTo(o2.getFio());
        humanList.sort(humanComparatorByFio);
    }

    private static void sortHumansByAge(List<Human> humanList) {
        Comparator<Human> humanComparatorByAge = (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) return 0;
            return o1.getAge() > o2.getAge() ? 1 : -1;
        };
        humanList.sort(humanComparatorByAge);
    }

    private static void sortHumansByAddress(List<Human> humanList) {
        Comparator<Human> humanComparatorByAddress = (o1, o2) -> o1.getAddress().toString().compareTo(o2.getAddress().toString());
        humanList.sort(humanComparatorByAddress);
    }

}


/*
Написать класс Human с полями:
ФИО
возраст
адресс (это структура, состоит из полей (город, улица, дом, квартира)

Необходимо создать 10 объектов этого класса из которых 3 объекта должны быть дублями(не более одного дубля на каждого) и сделать с ними следующее:
1. Заполнить ArrayList этими объектами.
2. Найти дубли в коллекции и вывести их в консоль.
3. Удалить дубли из коллекции, должно остаться 7 объектов.
4. Отсортировать людей по ФИО
5. Отсортировать людей по возрасту
6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
7. Создать класс User добавить в него поля ФИО, и роль которое является перечислением и содержит в себе ADMIN, USER, MODERATOR
8. Необходимо написать метод в который входным значением будет являтся объект класса User, метод должен на основании роли пользователя выводить приветственное сообщение, что-то вроде "Приветствуем ФИО с ролью " + ОПИСАНИЕ_РОЛИ
описание роли должно вычисляться на основании роли пользователя, запрещено использовать if и switch, а так же описание роли в перечислении.
9. Написать программу сортирующую HashMap по ключу. (Создание и генерация данными какими захотите)
10. Написать программу сортирующую HashMap по значнию. (Создание и генерация данными какими захотите)
11. Заполнить рандомными значениями LinkedList, вывести содержимое каждого элемента и его индекс.
 */