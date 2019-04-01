package Tasks.Arrays.Task1;

import exception.MyExceptionForFileWork;

class ArrayTask {
    private int[] iCoordinateOfOne = new int[20];
    private int[] jCoordinateOfOne = new int[20];

    int[][] deleteRowAndColumn(int[][] array) throws MyExceptionForFileWork {
        boolean flagEntryIntoCoordinatesArrays = false;
        int numberOfDeleteRow = 0;
        int numberOfDeleteColumn = 0;

        int column = 4;
        int row = 5;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] == 1) {
                    flagEntryIntoCoordinatesArrays = true;
                    iCoordinateOfOne[numberOfDeleteRow] = i;
                    jCoordinateOfOne[numberOfDeleteColumn] = j;
                    numberOfDeleteColumn++;
                    numberOfDeleteRow++;
                }
            }
        }

        int newRow = row - 1;
        int newColumn = column - 1;

        for (int deletionCount = 0; deletionCount < numberOfDeleteRow; deletionCount++) {
            int[][] newArray = new int[newRow][newColumn];
            int iCoordinateOfDeleteElement = iCoordinateOfOne[deletionCount];
            int jCoordinateOfDeleteElement = jCoordinateOfOne[deletionCount];
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
            if (iCoordinateOfOne[deletionCount + 1] != 0)
                iCoordinateOfOne[deletionCount + 1]--;
            if (jCoordinateOfOne[deletionCount + 1] != 0)
                jCoordinateOfOne[deletionCount + 1]--;
            array = newArray;
            newRow--;
            newColumn--;
        }
        if (flagEntryIntoCoordinatesArrays)
            return array;
        else {
            throw new MyExceptionForFileWork("Primary array haven't 1.");
        }
    }
}
