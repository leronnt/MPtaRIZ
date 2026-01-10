import java.util.Scanner;
public class mtlab1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        
        GameBoard board = new GameBoard();
        
        Player player1 = new Player("Гравець 1", 'X', scanner);
        Player player2 = new Player("Гравець 2", 'O', scanner);

        Player current = player1;

         
        System.out.println("\n*** Гра Хрестики-Нолики ***");
        player1.printInfo();
        player2.printInfo();
        System.out.println("---------------------------\n");

        while (true) {
            board.printBoard();
            System.out.println(current.getName() + " (" + current.getSymbol() + ") ваш хід:");

            int row = current.makeMove("Введіть рядок (1-3): ");
            int col = current.makeMove("Введіть колонку (1-3): ");

            //Координати (1-3) автоматично перетворюються на індекси (0-2) у makeMove.
            if (!board.updateCell(row, col, current.getSymbol())) {
                System.out.println("Помилка: Неправильний хід (невірні координати або клітинка зайнята)! Спробуйте ще раз.");
                continue;
            }

            //Перемоги
            if (board.checkWin(current.getSymbol())) {
                board.printBoard();
                System.out.println("\n*** Переміг " + current.getName() + "! ***");
                break;
            }

            //Нічию
            if (board.isFull()) {
                board.printBoard();
                System.out.println("\n*** Нічия! Ігрове поле заповнене. ***");
                break;
            }

            // Зміна гравця
            current = (current == player1) ? player2 : player1;
        }
        
        scanner.close(); 
    }
}
   