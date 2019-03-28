package ArrayTask;

import org.apache.log4j.Logger;

public class ArrayTask {
    private static final Logger logger = Logger.getLogger(ArrayTask.class);
    private int column = 4;
    private int row = 5;
    private int[] flagI = new int[20];
    private int[] flagJ = new int[20];

    int[][] deleteRowAndColumn(int[][] array) {
        int[][] primaryArrayCopy = array;
        int flagEntryIntoFlagsArays = 0;
        int numberOfDeleteRow = 0;
        int numberOfDeleteColumn = 0;
        int t;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] == 1) {
                    flagEntryIntoFlagsArays++;
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
            if (flagI[mn + 1] != 0)
                flagI[mn + 1]--;
            if (flagJ[mn + 1] != 0)
                flagJ[mn + 1]--;
            array = newArray;
            newRow--;
            newColumn--;
        }
        if (flagEntryIntoFlagsArays != 0)
            return array;
        else
            return primaryArrayCopy;
        /*@todo Вернуться сюда после работы над Exception*/
    }
}
