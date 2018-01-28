package DynamicProgramming;

import java.util.Arrays;

/// 416. Partition Equal Subset Sum
/// https://leetcode.com/problems/partition-equal-subset-sum/description/
/// 记忆化搜索
/// 时间复杂度: O(len(nums) * O(sum(nums)))
/// 空间复杂度: O(len(nums) * O(sum(nums)))
public class PartitionEqualSubsetSum {

    // memo[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] <= 0)
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            sum += nums[i];
        }

        if(sum % 2 == 1)
            return false;

        memo = new int[nums.length][sum / 2 + 1];
        for(int i = 0 ; i < nums.length ; i ++)
            Arrays.fill(memo[i], -1);
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    // 使用nums[0...index], 是否可以完全填充一个容量为sum的背包
    private boolean tryPartition(int[] nums, int index, int sum){

        if(sum == 0)
            return true;

        if(sum < 0 || index < 0)
            return false;

        if(memo[index][sum] != -1)
            return memo[index][sum] == 1;

        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }

    public boolean canPartitionByDp(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            if (num <= 0)
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            sum += num;
        }

        //如果不能平分，则说明不存在解
        if(sum % 2 == 1)
            return false;

        int n = nums.length;
        int C = sum / 2;

        //记录【0，C】的背包问题结果；
        boolean[] memo = new boolean[C + 1];
        //只是用nums[0]的背包结果
        for(int i = 0 ; i <= C ; i ++)
            memo[i] = (nums[0] == i);

        //依次增加使用nums中元素的个数
        for(int i = 1 ; i < n ; i ++)
            //
            for(int j = C; j >= nums[i] ; j --)
                memo[j] = memo[j] || memo[j - nums[i]];

        return memo[C];
    }

    private static void printBool(boolean res){
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new PartitionEqualSubsetSum()).canPartitionByDp(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new PartitionEqualSubsetSum()).canPartitionByDp(nums2));
    }
}
