package lukyanov;

import lombok.extern.slf4j.Slf4j;
import lukyanov.util.Util;

import java.util.List;

@Slf4j
public class Application {
    public static void main(String[] args) {

        List<String> list = Util.getUuidList(10000);

        Util.writeToFile("file.txt", list);
        Long uuidCount = Util.getUuidCount("file.txt", 100);
    }
}
