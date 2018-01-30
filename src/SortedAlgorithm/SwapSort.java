package SortedAlgorithm;

public class SwapSort {

    //冒泡排序
    public void MyBubble(int[] array) {
        if(array==null||array.length==0||array.length==1)
            return;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0 ; j+1 < array.length-i; j++) {
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }

    //快排算法
    public void FastSort(int[] array,int low,int high){
        if(low<high){
            int pos = OneFastSort(array,low,high);
            FastSort(array,low,pos-1);
            FastSort(array,pos+1,high);
        }
    }
    //一次快排
    public int OneFastSort(int[] array, int low,int high){
       int l = low-1;  //[low,l]<key
       int r = high+1; //[r, high]>key
       int key = array[low];

        for (int i = low; i<r ; ) {
            if(array[i]<key){//必须是严格小于
                swap(array,++l,i++);
            } else if(array[i]>key){
                swap(array,--r,i);
            } else
                i++;
        }

        //key值找个合适的位置赋值
        array[l+1] = key;
        return l+1;
    }

    /**
     * 交换数组中的两个元素的位置
     * @param array 待交换的数组
     * @param i 第一个元素
     * @param j 第二个元素
     */
    public void swap(int[] array, int i, int j) {
        if (i != j) {//只有不是同一位置时才需交换
            Integer tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }


    /**
    * 测试
    * @param args
    */
   public static void main(String[] args) {
        int[] intgArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5, 11, 10, 1 };
        SwapSort sort = new SwapSort();
        sort.FastSort(intgArr,0,intgArr.length-1);
        for(Integer intObj:intgArr){
            System.out.print(intObj + " ");
        }
    }
}
