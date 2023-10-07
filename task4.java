import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        try {
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя.");
            }
            System.out.println("Вы ввели: " + input);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        
        scanner.close();
    }
}
