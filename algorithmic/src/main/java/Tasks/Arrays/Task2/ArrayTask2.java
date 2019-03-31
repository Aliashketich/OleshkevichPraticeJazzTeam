package Tasks.Arrays.Task2;

/*В матрице A[4][5] путем перестановки строк упорядочить элементы первого столбца по убыванию*/

import java.util.Arrays;

class ArrayTask2 {
    int[][] normalisation(int[][] array) {
        Arrays.sort(array, (o1, o2) -> {
            Integer i1 = o1[0];
            Integer i2 = o2[0];
            return i2.compareTo(i1);
        });
        return array;
    }
}
