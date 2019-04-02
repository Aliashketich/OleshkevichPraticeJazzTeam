package tasks.arrays;

import exception.MyException;

import java.util.Arrays;

class ArrayTask {
    private int[] iCoordinateWithOneValue = new int[20];
    private int[] jCoordinateOfOneValue = new int[20];

    int[][] deleteRowAndColumn(int[][] array) throws MyException {
        boolean arrayHaveOneValue = false;
        int numberOfDeleteRow = 0;
        int numberOfDeleteColumn = 0;

        int column = 4;
        int row = 5;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] == 1) {
                    arrayHaveOneValue = true;
                    iCoordinateWithOneValue[numberOfDeleteRow] = i;
                    jCoordinateOfOneValue[numberOfDeleteColumn] = j;
                    numberOfDeleteColumn++;
                    numberOfDeleteRow++;
                }
            }
        }

        if (numberOfDeleteRow >= 5) {
            throw new MyException("Method should delete all elements of array because each row has 1");
        }
        int newRow = row - 1;
        int newColumn = column - 1;

        for (int deletionCount = 0; deletionCount < numberOfDeleteRow; deletionCount++) {
            int[][] newArray = new int[newRow][newColumn];
            int iCoordinateOfDeleteElement = iCoordinateWithOneValue[deletionCount];
            int jCoordinateOfDeleteElement = jCoordinateOfOneValue[deletionCount];
            for (int i = 0, countOfLine = 0; countOfLine < newRow; ) {
                if (i != iCoordinateOfDeleteElement) {
                    for (int j = 0, countOfColumn = 0; countOfColumn < newColumn; j++, countOfColumn++) {
                        if (j == jCoordinateOfDeleteElement) j++;
                        newArray[countOfLine][countOfColumn] = array[i][j];
                    }
                    i++;
                    countOfLine++;
                } else i++;
            }
            if (iCoordinateWithOneValue[deletionCount + 1] != 0)
                iCoordinateWithOneValue[deletionCount + 1]--;
            if (jCoordinateOfOneValue[deletionCount + 1] != 0)
                jCoordinateOfOneValue[deletionCount + 1]--;
            array = newArray;
            newRow--;
            newColumn--;
        }
        if (arrayHaveOneValue)
            return array;
        else {
            throw new MyException("Primary array haven't 1.");
        }
    }

    int[][] normalisation(int[][] array) {
        Arrays.sort(array, (o1, o2) -> {
            Integer i1 = o1[0];
            Integer i2 = o2[0];
            return i2.compareTo(i1);
        });
        return array;
    }
}
