package lukyanov.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    /**
     * 1. Одним стримом сгенерировать коллекцию с 10000 рандомными элементами UUID.
     */
    public static List<String> getUuidList(int number) {
        Stream<UUID> uuidStream = Stream.generate(UUID::randomUUID).limit(number);
        return uuidStream.map(UUID::toString).collect(Collectors.toList());
    }

    /**
     * 2. Записать в файл.
     */
    public static void writeToFile(String path, List<String> list) {
        Path filePath = Path.of(path);
        try {
            Files.write(filePath, list, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3. Одним стримом считать этот файл и посчитать количество элементов UUID, в которых сумма цифр > 100
     */
    public static long getUuidCount(String path, int threshold) {
        Path filePath = Path.of(path);
        long count = 0;
        try {
            Stream<Integer> stream = Files.lines(filePath, StandardCharsets.UTF_8)
                    .map(s -> s.replaceAll("\\D", ""))
                    .map(s -> s.chars().map(Character::getNumericValue).sum());
            count = stream.filter(v -> v > threshold).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * 4.	Найти дату конца света по формуле: сегодня + N месяцев + M дней,
     * где N – первые два числа от полученного значения, а М – вторые.
     * Значение с ведущими нулями, если цифр меньше 4.
     * По тихоокеанской временной зоне.
     * Дату вывести в формате ISO с датой и временем (см DateTimeFormatter)
     */
    public static void getEndDate(long value) {
        LocalDate localDate = LocalDate.now();

        Stream.of(String.valueOf(value).chars()).limit(4);
    }
}
