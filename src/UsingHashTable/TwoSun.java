package UsingHashTable;

import java.util.HashMap;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
// 时间复杂度：O(n)
// 空间复杂度：O(n)
public class TwoSun {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length; i ++){

            int complement = target - nums[i];
            if(record.containsKey(complement)){
                int[] res = {i, record.get(complement)};
                return res;
            }

            record.put(nums[i], i);
        }

        throw new IllegalStateException("the input has no solution");
    }

    public int[] myTwoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalStateException("the input has no solution");
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {0,4,3,0};
        int target = 7;
        printArr((new TwoSun()).myTwoSum(nums, target));
    }
}
