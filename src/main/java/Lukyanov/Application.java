package Lukyanov;

import java.util.*;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        //Test data creation
        Human[] humanArray = new Human[10];

        //Duplicates: 0-1, 2-3, 4-5
        humanArray[0] = new Human("John Doe", 30, null);
        humanArray[0].setAddress(humanArray[0].new Address("Togliatti", "Frunze", "31", 46));
        humanArray[1]=humanArray[0];

        humanArray[2] = new Human("Kye Thomas", 54, null);
        humanArray[2].setAddress(humanArray[2].new Address("Samara", "Permitina", "37", 57));
        humanArray[3]=humanArray[2];

        humanArray[4] = new Human("Conner Rodriguez", 54, null);
        humanArray[4].setAddress(humanArray[4].new Address("Dubovskoe", "Progonnaya", "68", 326));
        humanArray[5]=humanArray[4];

        humanArray[6] = new Human("Silas Torres", 23, null);
        humanArray[6].setAddress(humanArray[6].new Address("Turochak", "Autonomnaya", "28", 258));

        humanArray[7] = new Human("Benson White", 34, null);
        humanArray[7].setAddress(humanArray[7].new Address("Severodvinsk", "Energetikov proezd", "93", 291));

        humanArray[8] = new Human("Sabrina James", 25, null);
        humanArray[8].setAddress(humanArray[8].new Address("Ukhta", "Polkovaya", "82", 167));

        humanArray[9] = new Human("Lilith Richardson", 28, null);
        humanArray[9].setAddress(humanArray[9].new Address("Svetlograd", "Bahrushina", "65", 1));

        printSeparator('#');
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

        printSeparator('#');
        System.out.println("Задание 7 и 8");
        User user = new User("John Doe", User.Role.ADMIN);
        userGreeting(user);

        printSeparator('#');
        System.out.println("9. Написать программу сортирующую HashMap по ключу. (Создание и генерация данными какими захотите)");
        Map<String, Human> map = new HashMap<>();
        for (Human human:humans) {
            map.put(human.getFio(), human);
        }
        TreeMap<String, Human> sortedMap = new TreeMap<>(map);
        System.out.println(sortedMap);

        printSeparator('#');
        System.out.println("10. Написать программу сортирующую HashMap по значнию. (Создание и генерация данными какими захотите)");
        Map<String, Human> sortedByValueMap = sortMapByValue(map);
        System.out.println(sortedByValueMap);

        printSeparator('#');
        System.out.println("11. Заполнить рандомными значениями LinkedList, вывести содержимое каждого элемента и его индекс.");
        fillLinkedListAndPrintOut();
    }

    private static void printSeparator(char ch) {
        System.out.println();
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

    private static void userGreeting(User user) {
        Map<User.Role, String> descriptionMap = new HashMap<>();
        descriptionMap.put(User.Role.ADMIN, "Administrator description");
        descriptionMap.put(User.Role.MODERATOR, "Moderator description");
        descriptionMap.put(User.Role.USER, "User description");
        System.out.println("Greeting user "+user.getFio() +" with role "+ user.getRole() +" with description " + descriptionMap.get(user.getRole()));
    }

    private static Map<String, Human> sortMapByValue(Map<String, Human> map) {
        Map<String, Human> result = new LinkedHashMap<>();
        Stream<Map.Entry<String, Human>> stream = map.entrySet().stream();
        stream.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    private static void fillLinkedListAndPrintOut() {
        Random rnd = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(rnd.nextInt());
        }
        for (int value:linkedList) {
            System.out.println("Index: "+linkedList.indexOf(value)+ "; Value: "+value);
        }
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