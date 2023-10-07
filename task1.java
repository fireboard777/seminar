import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float userInput = getFloatInput();
        System.out.println("Вы ввели: " + userInput);
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float result = 0;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.print("Введите дробное число (типа float): ");
                result = scanner.nextFloat();
                inputValid = true;
            } catch (InputMismatchException e) {
                // Ошибка при вводе, очищаем буфер ввода и пробуем снова
                System.out.println("Ошибка ввода. Введите дробное число.");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }

        return result;
    }
}
