package ArrayTask;


public class ArrayTask {
    private int column = 4;
    private int row = 5;
    private int[] flagI = new int[20];
    private int[] flagJ = new int[20];


    int[][] deleteRowAndColumn(int[][] array) {

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
                    numberOfDeleteRow++;
                }
            }
        }
//        System.out.print("flagI: ");
//        for (int i = 0; i < numberOfDeleteRow; i++) {
//            System.out.print(flagI[i] + " ");
//        }
//        System.out.println();

//        System.out.print("flagJ: ");
//        for (int i = 0; i < numberOfDeleteColumn; i++) {
//            System.out.print(flagJ[i] + " ");
//        }
//        System.out.println();

        int newRow = row - 1;
        int newColumn = column - 1;
        for (int mn = 0; mn < numberOfDeleteRow; mn++) {
            int[][] newArray = new int[newRow][newColumn];
            int deli = flagI[mn];
            int delj = flagJ[mn];
            for (int i = 0, ln = 0; ln < newRow; ) {
                if (i != deli) {
                    for (int j = 0, cn = 0; cn < newColumn; j++, cn++) {
                        if (j == delj) j++;
                        newArray[ln][cn] = array[i][j];
                    }
                    i++;
                    ln++;
                } else i++;
            }
            array = newArray;
            for (int i = 0; i < newRow; i++) {
                for (int j = 0; j < newColumn; j++) {
                    System.out.print(array[i][j] + "    ");
                }
                System.out.println();
            }
            System.out.println();
            newRow--;
            newColumn--;
        }
//        for (int i = 0; i < newRow; i++) {
//            for (int j = 0; j < newColumn; j++) {
//                System.out.print(array[i][j] + "    ");
//            }
//            System.out.println();
//        }
        return array;
    }
}
