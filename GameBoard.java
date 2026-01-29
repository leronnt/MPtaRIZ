class GameBoard {
    private final char[][] board = new char[3][3];
    private final char EMPTY_CELL = ' ';
    private final int SIZE = 3;

    public GameBoard() {
        // Ініціалізація поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    //Вивід ігрового поля на екран
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean updateCell(int row, int col, char symbol) { 
        // введена 1-3)
        if (row < 1 || row > SIZE || col < 1 || col > SIZE) return false; 
        
        // Перевірка на зайнятість
        if (board[row - 1][col - 1] != EMPTY_CELL) return false; 
        
        board[row - 1][col - 1] = symbol;
        return true;
    }

    //Перемога.
     
    public boolean checkWin(char symbol) {
        //Перевірка рядків і стовпців
        for (int i = 0; i < SIZE; i++) {
            //Рядки
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            //Стовпці
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }

        // Перевірка діагоналей
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;

        return false;
    }

    //все поле зайнято
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) return false;
            }
        }
        return true;
    }
}