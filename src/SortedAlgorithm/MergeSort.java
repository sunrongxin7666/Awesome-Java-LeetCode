package SortedAlgorithm;

public class MergeSort {
    public void MergeSort(int[] array,int low,int high){
        if(low == high){
            //说明子数组长度为1，无需分解，直接返回即可
        }else{
            int m = low + (high-low)/2;
            MergeSort(array,low,m);
            MergeSort(array,m+1,high);
            //完成相邻两个子集合的归并
            MergeTwoData(array,low,m,high);
        }
    }

    /*用于排序两个子序列的归并排序算法实现*/
    public void MergeTwoData(int[] array,int low, int m, int high){
        int len = high-low+1;
        int[] arrCopy = new int[len];
        int l,r;
        l = low;
        r=  m+1;
        for (int i=0; i<len; i++){
            //如果左边子数组长度小于右边数组长度，当左数组全部入库之后，右侧数组不用做比较直接入库
            if(l== m+1){
                arrCopy[i] = array[r++];
            }
            //如果右侧数组长度小于左侧数组长度，当右侧数组全部入库之后，左侧数组不用做比较直接入库
            else if(r==high+1){
                arrCopy[i]=array[l++];
            }else if(array[l]<array[r]){
                arrCopy[i]=array[l++];
            }else{
                arrCopy[i] = array[r++];
            }
        }
        r = 0;
        //按顺序写回原数组
        for(int i=low;i<=high;i++) {
            array[i] = arrCopy[r++];
        }
    }

    public static void main(String[] args) {
        int[] intgArr = { 7, 2, 4, 3, 12, 1, 9, 6, 8, 5, 11, 10, 1 };
        MergeSort sort = new MergeSort();
        sort.MergeSort(intgArr,0,intgArr.length-1);
        for(Integer intObj:intgArr){
            System.out.print(intObj + " ");
        }
    }
}
