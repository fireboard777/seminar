public class ExceptionExample {

    // Метод, генерирующий исключение ArrayIndexOutOfBoundsException
    public static void arrayOutOfBoundsException() {
        int[] arr = new int[5];
        // Попытка обратиться к элементу, выходящему за пределы массива
        int element = arr[10];
    }

    // Метод, генерирующий исключение ArithmeticException (деление на 0)
    public static void divisionByZero() {
        int numerator = 10;
        int denominator = 0;
        // Попытка деления на 0
        int result = numerator / denominator;
    }

    // Метод, генерирующий исключение NumberFormatException
    public static void numberFormatException() {
        String str = "abc";
        // Попытка преобразования строки "abc" в число
        int num = Integer.parseInt(str);
    }

    public static void main(String[] args) {
        try {
            // Вызываем каждый из методов для генерации исключений
            arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: ArrayIndexOutOfBoundsException");
        }

        try {
            divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: ArithmeticException (деление на 0)");
        }

        try {
            numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Поймано исключение: NumberFormatException");
        }
    }
}
