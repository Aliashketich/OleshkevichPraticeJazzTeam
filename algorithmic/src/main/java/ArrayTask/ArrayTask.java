package ArrayTask;


public class ArrayTask {
    private int column = 4;
    private int row = 5;
    private int[] flagI = new int[20];
    private int[] flagJ = new int[20];

    ArrayTask(int[][] array) {
        int[][] resultArray = deleteRowAndColumn(array);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] deleteRowAndColumn(int[][] array) {

        int numberOfDeleteRow = 0;
        int numberOfDeleteColumn = 0;
        int t;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] == 1) {
                    flagI[numberOfDeleteRow] = i;
                    for (t = 0; t < 20; t++) {
                        if (flagJ[t] == j) {
                            t = 50;
                        }
                    }
                    if (t != 50) {
                        flagJ[numberOfDeleteColumn] = j;
                        numberOfDeleteColumn++;
                    }
                    j = column;
                    numberOfDeleteRow++;
                }
            }
        }
        System.out.print("flagI: ");
        for (int i = 0; i < numberOfDeleteRow; i++) {
            System.out.print(flagI[i] + " ");
        }
        System.out.println();

        System.out.print("flagJ: ");
        for (int i = 0; i < numberOfDeleteColumn; i++) {
            System.out.print(flagJ[i] + " ");
        }
        System.out.println();

        int newRow = row - numberOfDeleteRow;
        int newColumn = column - numberOfDeleteColumn;
        System.out.println("newRow " + newRow);
        System.out.println("newColumn " + newColumn);
        int[][] newArray = new int[newRow][newColumn];
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newColumn; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
        return newArray;
    }
}
