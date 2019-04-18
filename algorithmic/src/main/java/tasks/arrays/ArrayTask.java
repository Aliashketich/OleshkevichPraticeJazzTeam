package tasks.arrays;

import exception.MyException;

import java.util.Arrays;

public class ArrayTask {
    private final int column = 4;
    private final int row = 5;


    public int[][] deleteRowAndColumnWhichContainsOneValue(int[][] entryArray) throws MyException {
        if (entryArray.length == 0)
            throw new MyException("Entry array is empty!");

        int[] jCoordinateOfOneValue = getCoordinateOfOneValueArray(entryArray, 'j');
        int[] iCoordinateWithOneValue = getCoordinateOfOneValueArray(entryArray, 'i');
        final int numberOfDeleteRow = iCoordinateWithOneValue.length;

        if (!isArrayHaveOneValue(entryArray, row, column))
            throw new MyException("Primary array haven't 1.");
        if (numberOfDeleteRow >= 5) {
            throw new MyException("Method should delete all elements of array because each row has 1");
        }

        int newRow = row - 1;
        int newColumn = column - 1;

        for (int deletionCount = 0; deletionCount < numberOfDeleteRow; deletionCount++) {
            int[][] arrayAfterDeleteIteration = new int[newRow][newColumn];
            int iCoordinateOfDeleteElement = iCoordinateWithOneValue[deletionCount];
            int jCoordinateOfDeleteElement = jCoordinateOfOneValue[deletionCount];
            for (int i = 0, countOfLine = 0; countOfLine < newRow; ) {
                if (i != iCoordinateOfDeleteElement) {
                    for (int j = 0, countOfColumn = 0; countOfColumn < newColumn; j++, countOfColumn++) {
                        if (j == jCoordinateOfDeleteElement) j++;
                        arrayAfterDeleteIteration[countOfLine][countOfColumn] = entryArray[i][j];
                    }
                    i++;
                    countOfLine++;
                } else i++;
            }
            decreaseElementIfNextHasZeroValue(iCoordinateWithOneValue, deletionCount);
            decreaseElementIfNextHasZeroValue(jCoordinateOfOneValue, deletionCount);

            entryArray = arrayAfterDeleteIteration;
            newRow--;
            newColumn--;
        }
        return entryArray;
    }

    public int[][] sortingArrayByDescendingByReshuffleRowsByElementsOfFirstColumn(int[][] arrayForSorting) {
        Arrays.sort(arrayForSorting, (o1, o2) -> {
            Integer i1 = o1[0];
            Integer i2 = o2[0];
            return i2.compareTo(i1);
        });
        return arrayForSorting;
    }

    public int[] getCoordinateOfOneValueArray(int[][] entryArray, char coordinate) {
        int[] coordinatesOfOneValues = new int[20];
        int countOfArrayElements = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (entryArray[i][j] == 1) {
                    if (coordinate == 'i')
                        coordinatesOfOneValues[countOfArrayElements] = i;
                    if (coordinate == 'j')
                        coordinatesOfOneValues[countOfArrayElements] = j;
                    countOfArrayElements++;
                }
            }
        }
        int[] coordinateArrayWithCorrectLegth = new int[countOfArrayElements];
        System.arraycopy(coordinatesOfOneValues, 0, coordinateArrayWithCorrectLegth, 0, countOfArrayElements);
        return coordinateArrayWithCorrectLegth;
    }

    public void decreaseElementIfNextHasZeroValue(int[] iCoordinateWithOneValue, int deletionCount) {
        if (deletionCount < iCoordinateWithOneValue.length - 1)
            if (iCoordinateWithOneValue[deletionCount + 1] != 0)
                iCoordinateWithOneValue[deletionCount + 1]--;
    }

    public boolean isArrayHaveOneValue(int[][] entryArray, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (entryArray[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
