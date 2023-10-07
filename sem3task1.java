import java.io.*;
import java.util.*;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в произвольном порядке (Фамилия Имя Отчество датарождения номертелефона пол):");
            String input = scanner.nextLine();

            String[] inputData = input.split(" ");
            if (inputData.length != 6) {
                throw new IllegalArgumentException("Недостаточно данных или слишком много данных");
            }

            String lastName = inputData[0];
            String firstName = inputData[1];
            String middleName = inputData[2];
            String birthDate = inputData[3];
            long phoneNumber = Long.parseLong(inputData[4]);
            char gender = inputData[5].charAt(0);

            // Проверка формата даты рождения
            if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }

            // Проверка пола
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверный пол (должен быть 'f' или 'm')");
            }

            // Создание строки для записи в файл
            String userDataString = lastName + firstName + middleName + birthDate + " " + phoneNumber + gender;

            // Создание или открытие файла для записи данных
            File file = new File(lastName + ".txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(userDataString + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + file.getName());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
