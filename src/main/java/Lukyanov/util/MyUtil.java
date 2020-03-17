package Lukyanov.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtil {

    public static List<String> readFileToList(String path) {
        List<String> lines = new ArrayList<>();
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
            System.out.println("Something went wrong during I/O");
        }
        return lines;
    }

    public static void printFileToConsole(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            System.out.println("File contents:");
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            System.out.println("Something went wrong during I/O");
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
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Something went wrong during I/O");
        }
    }


}
