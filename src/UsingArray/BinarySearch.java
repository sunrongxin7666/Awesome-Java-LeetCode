package UsingArray;



public class BinarySearch {
    private BinarySearch(){}

    public static int binarySearch(Comparable[] arr, int n, Comparable target){

        //要清楚维护"循环不变量",保证其意义在循环中不变；
        int l = 0, r = n - 1; // 在[l...r]的范围里寻找target
        while(l <= r){    // 当 l == r时,区间[l...r]依然是有效的
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(target) == 0) return mid;
            if(target.compareTo(arr[mid]) > 0)
                l = mid + 1;  // target在[mid+1...r]中; [l...mid]一定没有target
            else    // target < arr[mid]
                r = mid - 1;  // target在[l...mid-1]中; [mid...r]一定没有target
        }

        return -1;
    }

    //使用了范式，效率会慢一些
    public static <T> Comparable<T> myBinarySearch(Comparable<T>[] arr, T target){
        int left = 0;
        int right = arr.length;
        int middle;
        Comparable<T> tmp;

        while(left <= right){
            middle = left + (right - left)/2; // 防止两个很大的整形求和太大了，超出最大值
            tmp = arr[middle];
            if(tmp.compareTo(target)==0)
                return arr[middle];
            else if(tmp.compareTo(target) < 0)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return null;
    }


    public static void main(String[] args) {

        int n = (int)Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < n ; i ++)
            if(i != binarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();
        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");

        for(int i = 0 ; i < n ; i ++)
            if(null == myBinarySearch(data, i))
                throw new IllegalStateException("find i failed!");
        endTime = System.currentTimeMillis();

        System.out.println("My Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
