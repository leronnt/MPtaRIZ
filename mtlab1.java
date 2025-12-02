class mtlab1 {
    public static void main(String[] args) {
        System.out.println("It's work");

        int levels = 6;
        System.out.println("\n1) Ялинка у вигляді піраміди:");
        Piramid.printTree(levels);

        System.out.println("\n2) Двовимірний масив:");
        int rows = 3;
        int cols = 5;
        int startValue = 0;
        int step = 3;

        int[][] array = Array2DGenerator.Array2D(rows, cols, startValue, step);
    }
}

class Piramid {
    public static void printTree(int levels) {
        for (int i = 0; i < levels; i++) {
            int stars = 2 * i + 1;
            int spaces = levels - i - 1;

            for (int j = 0; j < spaces; j++) {
                System.out.print("_");
            }

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

class Array2DGenerator {
    public static int[][] Array2D(int rows, int cols, int startValue, int step) {
        int[][] arr = new int[rows][cols];
        int value = startValue;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = value;
                value += step;
            }
        }

        for (int[] row : arr) {
            for (int num : row) {
                System.out.printf("%8d", num);
            }
            System.out.println();
        }

        return arr;
    }
}

//New Word
//Add