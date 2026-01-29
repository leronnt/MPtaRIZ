import java.util.Scanner;

public class mtlab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Db db = new Db();
        
        System.out.println("\n*** Авторизация игроков ***");

        String user1 = authorizePlayer(1, scanner, db);
        String user2 = authorizePlayer(2, scanner, db);

        // Создание игры только после успешного входа
        GameBoard board = new GameBoard();
        Player player1 = new Player(user1, 'X', scanner);
        Player player2 = new Player(user2, 'O', scanner);
        Player current = player1;

        System.out.println("\n*** Игра Крестики-Нолики начинается! ***");
        player1.printInfo();
        player2.printInfo();

        while (true) {
            board.printBoard();
            System.out.println(current.getName() + " (" + current.getSymbol() + ") ваш ход:");

            int row = current.makeMove("Введите строку (1-3): ");
            int col = current.makeMove("Введите колонку (1-3): ");

            if (!board.updateCell(row, col, current.getSymbol())) {
                System.out.println("Ошибка: Клетка занята или неверные координаты!");
                continue;
            }

            if (board.checkWin(current.getSymbol())) {
                board.printBoard();
                System.out.println("\n*** Победил " + current.getName() + "! ***");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("\n*** Ничья! ***");
                break;
            }

            current = (current == player1) ? player2 : player1;
        }

        db.close(); 
        scanner.close();
    }

    //повтор запроса , пока данные не будут верны
    private static String authorizePlayer(int playerNum, Scanner sc, Db db) {
        while (true) {
            System.out.println("Игрок " + playerNum + ":");
            System.out.print("Логин: ");
            String login = sc.nextLine();
            System.out.print("Пароль: ");
            String pass = sc.nextLine();
            if (db.authenticate(login, pass)) {
                System.out.println("Успешно!\n");
                return login;
            } else {
                System.out.println("Неверный логин или пароль. Попробуйте еще раз.\n");
            }
        }
    }
}