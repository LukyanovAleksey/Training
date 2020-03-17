package Lukyanov.util;

import java.io.*;
import java.util.List;

public class MyUtil {

    public static void readFileToList(String path, List<String> lines) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                lines.add(line);
                // read next line
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFileToConsole(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFromListToFile(String path, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File(path)
                        )
                ))) {
            for(String line:lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
