import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.txt";
        int b1 = 10;
        int b2 = 20;
        int sequenceLength = 10;
        try {
            StringBuilder numbers = new StringBuilder();
            Set<Integer> generatedNumbers = new HashSet<>();
            while (generatedNumbers.size() < sequenceLength) {
                int randomNumber = new Random().nextInt(b2 - b1 + 1) + b1;
                if (!generatedNumbers.contains(randomNumber)) {
                    generatedNumbers.add(randomNumber);
                    numbers.append(randomNumber).append(" ");
                }
            }
            Files.write(Paths.get(fileName), numbers.toString().getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Послідовність випадкових чисел збережено в файлі " + fileName);
        } catch (IOException e) {
            System.out.println("Виникла помилка при записі у файл");
            e.printStackTrace();
        }

        try {
            System.out.println("Читання даних з файлу " + fileName + ":");
            Files.lines(Paths.get(fileName)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
            e.printStackTrace();
        }
    }
}
