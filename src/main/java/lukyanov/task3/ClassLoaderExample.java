package lukyanov.task3;

import lombok.extern.slf4j.Slf4j;

/**
 * Task 3
 * Написать свой загрузчик класса, который будет подгружать классы из директории вне вашего проекта.
 *  - Создайте директорию myClasses вне вашего проекта
 *  - В этой директории создайте класс TestClass, где переопределите метод toString, чтобы он выводил какой-то текст.
 *  - Реализуйте загрузчик класса CustomClassLoader, который будет подгружать классы из директории myClasses.
 *  При написании загрузчика нужно ориентироватся на последний слайд в презентации.
 *  - Проверить, что ваш загрузчик классов работает корректно можно следующим способом:
 *
 * CustomClassLoader classLoader = new CustomClassLoader();
 * Class clazz = classLoader.loadClass("TestClass");
 * Object obj = c.newInstance();
 * System.out.println(obj);
 *
 *  - Текст, который выведет метод println должен совпадать с текстом из переопределенного метода toString из класса
 *  TestClass
 */
@Slf4j
public class ClassLoaderExample {
    public static void main(String[] args) {
        CustomClassLoader classLoader = new CustomClassLoader("D:\\Users\\1\\Desktop\\myClasses\\");
        Class<?> clazz;
        try {
            clazz = classLoader.loadClass("TestClass");
            log.info("Loaded " + clazz.getName() + ".class");
            Object obj = clazz.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error(e.getMessage());
        }
    }
}
