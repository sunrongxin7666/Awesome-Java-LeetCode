package UsingArray;

// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/description/
//
// 计数排序的思路
// 对整个数组遍历了两遍
public class SortColors {
    public void sortColorsSolution(int[] nums) {

        int[] count = {0, 0, 0};    // 存放0, 1, 2三个元素的频率
        for(int i = 0 ; i < nums.length ; i ++){
            assert nums[i] >= 0 && nums[i] <= 2;
            count[nums[i]] ++;
        }

        int index = 0;
        for(int i = 0 ; i < count[0] ; i ++)
            nums[index++] = 0;
        for(int i = 0 ; i < count[1] ; i ++)
            nums[index++] = 1;
        for(int i = 0 ; i < count[2] ; i ++)
            nums[index++] = 2;

        // 小练习: 自学编写计数排序算法
    }


    // 三路快速排序的思想
    // 对整个数组只遍历了一遍
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public void sortColorsSolution2(int[] nums) {

        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for(int i = 0 ; i < two ; ){
            if(nums[i] == 1)
                i ++;
            else if (nums[i] == 2)
                swap(nums, i, --two);
            else{ // nums[i] == 0
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }


    public void MysortColorsSolution(int[] nums){
        int f0 = 0;
        int f2 = nums.length-1;
        // [0,f0) = 0
        // [f0,i) =1
        // [i,f2] 待搜索
        // (f2, len-1] =2
        for (int i = 0; i <= f2;) { //知道碰到f2说明全部有序；
            if(nums[i] == 0){
                swap(nums,f0++,i++); //f0+1 为已排序过的
            } else if(nums[i]==1){
                i++;
            } else if(nums[i] ==2){
                swap(nums,i,f2--); //f2-1 为未排序过的；
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }

    public static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        (new SortColors()).MysortColorsSolution(nums);
        printArr(nums);
    }
}
