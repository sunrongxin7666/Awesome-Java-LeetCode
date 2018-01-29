package SortedAlgorithm;

public class SelectSort {
    public void ChooseSort(int[] array){

        for (int i = 0; i < array.length ; i++) {
            //最小下标
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                //发现更小的，记录下标
                if(array[minIndex]>array[j])
                    minIndex = j;
            }
            //交换
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] intgArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5, 11, 10, 1 };
        SelectSort sort = new SelectSort();
        sort.ChooseSort(intgArr);
        for(Integer intObj:intgArr){
            System.out.print(intObj + " ");
        }
    }
}
