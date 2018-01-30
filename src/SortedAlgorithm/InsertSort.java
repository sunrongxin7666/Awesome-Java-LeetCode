package SortedAlgorithm;

public class InsertSort {
    public void insertSort(int[] array){
        for (int i = 0; i < array.length ; i++) {
            //从i开始依次调整位置
            for (int j = i; j - 1 >= 0 ; j--) {
                //发现位置不合适就调换
                if(array[j] < array[j-1]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] intgArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5, 11, 10, 1 };
        InsertSort sort = new InsertSort();
        sort.insertSort(intgArr);
        for(Integer intObj:intgArr){
            System.out.print(intObj + " ");
        }
    }
}
