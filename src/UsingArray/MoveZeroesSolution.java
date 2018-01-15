package UsingArray;

import java.util.ArrayList;

// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/

public class MoveZeroesSolution {
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public void moveZeroes(int[] nums) {

        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        // 将vec中所有非0元素放入nonZeroElements中
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                nonZeroElements.add(nums[i]);

        // 将nonZeroElements中的所有元素依次放入到nums开始的位置
        for(int i = 0 ; i < nonZeroElements.size() ; i ++)
            nums[i] = nonZeroElements.get(i);

        // 将nums剩余的位置放置为0
        for(int i = nonZeroElements.size() ; i < nums.length ; i ++)
            nums[i] = 0;
    }

    // 原地(in place)解决该问题
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public void moveZeroes2(int[] nums) {
        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        for(int i = 0 ; i < nums.length ; i ++)
            if( nums[i] != 0 )
                nums[k++] = nums[i];

        // 将nums剩余的位置放置为0
        for(int i = k ; i < nums.length ; i ++)
            nums[i] = 0;
    }


    // 原地(in place)解决该问题,0与非0元素交换，避免再赋值
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public void moveZeroes3(int[] nums) {

        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                swap(nums, k++, i);
    }

    // 原地(in place)解决该问题，避免等值交换
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public void moveZeroes4(int[] nums) {

        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                if(k != i)
                    swap(nums, k++, i);
                else
                    k ++;
    }

    public void myMoveZeroes(int[] nums){
        int flag = 0; // 该坐标之前的元素都是非零的 [0.flag)
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                if(i!=flag)
                    swap(nums,flag,i);
                flag++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new MoveZeroesSolution()).myMoveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
