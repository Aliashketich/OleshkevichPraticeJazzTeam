package ArrayTask;


public class ArrayTask {
    private int column = 5;
    private int row = 4;
    private int finalColumn = column;
    private int finalRow = row;
    private int flagI=0, flagJ=0;
    private int[][] array = new int[row][column];

    int[][] newArray;

    ArrayTask(int[][] array){
        int[][] resultArray = deleteRowAndColumn(array);
        for(int i =0; i<finalRow;i++){
            for(int j = 0; j<finalColumn; j++){
                System.out.print(resultArray[i][j]+" ");
            }
            System.out.println();
        }
    }
    private int[][] deleteRowAndColumn(int[][] array){
//        for(int i =0; i<4;i++){
//            for(int j = 0; j<5; j++){
//                System.out.print(array[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int i =0; i<row;i++){
            for(int j = 0; j<column;j++){
                if(array[i][j]==1){
                    flagI=i;
                    flagJ=j;
                    newArray = new int[row--][column--];
                    for(int iii=0;iii<row-1;iii++){
                        for(int jjj=0;jjj<column-1;jjj++){
                            for(int ii=0;ii<row;ii++){
                                if (ii!=flagI){
                                    for(int jj=0;jj<column;jj++){
                                        if(jj!=flagJ){
                                            newArray[iii][jjj]=array[i][j];
                                        }
                                    }
                                }
                            }

                        }
                    }
                    deleteRowAndColumn(newArray);
                }
            }
            if(i==row){
                flagI =0;
                flagJ=0;
            }
        }
        return newArray;
    }

}
