package Lukyanov;

import Lukyanov.filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String path = "D:/Users/1/Desktop/myfile.txt";

        Filter filter = new Filter();
        filter.execute("add 4 myfile.txt \"gfasnishfda 34289 reiwhr 438yh ihige\"");

    }

}


/*
Разработать приложение которое умеет читать, и редактировать файл.
Приложение должно уметь принимать на вход 3 команды
add 5 fileName "text"
- add команда на добавление текста.
5 строка в файле (если в файле к примеру всего 3 строки, то необходимо будет добавить 2 строки).
Так же строка которая раньше находилась под номером 5 должна стать номером 6 и т.д., короче все сдвигается вниз на одну строку
fileName имя файла для редактирования
"text" собственно текст который мы хотим добавить. Текст указывается в двойных кавычках.
ВНИМАНИЕ, если мы не указываем номер строки, а к примеру даем команду add fileName "text", то мы добавляем просто новую строку с текстом.
Если номер строки не указан, то нужно просто добавить строку в конец файла.

delete 5 fileName
- delete команда на удаление строки
5 номер строки которую нам необходимо удалить.
ВНИМАНИЕ, если мы не указываем номер строки, а к примеру даем команду delete, то мы удаляем последнюю строку из файла.

print 4 fileName
- print команда на печать
4 это номер строки которую мы хотим распечатать.
ВНИМАНИЕ, если мы не указываем номер строки, а к примеру даем команду print, то мы печатаем весь файл.


Так же нужно будет после обработки каждой операции закрывать все потоки, которые вы открывали для чтения файла.

А теперь какие нужны классы:
Main - осуществляет постоянное чтение данных из консоли, после считывания и обработки команды программа не должна заканчивать
свое выполнение, а ждать новой команды. Команда должна передаваться в фильтр команд.
Фильтр команд - класс, который содержит внутри себя обработчики команд и определяет в какой обработчик должна быть передана
команда.
Обработчики команд - классы которые принимают на вход команду и выполняют с ней свои действия.
Общий код работы с файлами и т.д. необходимо выносить в отдельные классы для их повторного переисползования.
Необходимо корректно обрабатывать ошибки в процессе выполнения, если у нас возникает проблема она не должна прерывать выполнение
программы.

НЕ ЗАБЫВАЕМ корректно обрабатывать ошибки и стараемся писать код красиво без не понятных имен переменных, методов, классов.
 */