import java.util.InputMismatchException;
import java.util.Scanner;

class Player {
  private String name;
    private char symbol;
    private final Scanner scanner; 
  
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
                    //число в діапазоні 1-3
                    if (input >= 1 && input <= 3) {
                        return input;
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
     
    public void printInfo() {
        System.out.println("Гравець: " + name + ", фігура: " + symbol);
    }
}  