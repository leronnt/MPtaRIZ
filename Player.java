import java.util.InputMismatchException;
import java.util.Scanner;

class Player {
  private String name;
    private char symbol;
    private final Scanner scanner; 

    //Конструктор: задає ім'я, символ гравця та об'єкт Scanner.
     
    public Player(String name, char symbol, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int makeMove(String message) {
        int input;
        
        while (true) {
            System.out.print(message);
            
            try {
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    //число знаходиться в діапазоні 1-3
                    if (input >= 1 && input <= 3) {
                        return input; // Повертаємо 1, 2 або 3
                    } else {
                        System.out.println("Помилка: Введіть число від 1 до 3.");
                    }
                } else {
                    System.out.println("Помилка: Невірний тип вводу. Будь ласка, введіть число.");
                    scanner.next(); // Очищення невірного вводу
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка вводу: Будь ласка, введіть число.");
                scanner.nextLine(); // Очищення вводу
            }
        }
    }

    //Вивід інформації про ігрока.
     
    public void printInfo() {
        System.out.println("Гравець: " + name + ", фігура: " + symbol);
    }
}  