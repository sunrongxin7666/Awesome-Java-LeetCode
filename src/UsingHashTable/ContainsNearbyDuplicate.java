package UsingHashTable;


import java.util.HashSet;
import java.util.LinkedHashSet;

// 219. Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/description/
// 时间复杂度: O(n)
// 空间复杂度: O(k)
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || nums.length <= 1)
            return false;

        if(k <= 0)
            return false;

        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length; i ++){
            if(record.contains(nums[i]))
                return true;

            record.add(nums[i]);
            if(record.size() == k + 1)
                record.remove(nums[i-k]);
        }

        return false;
    }

    public boolean MyContainsNearbyDuplicate(int[] nums, int k){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num))
                return true;

            set.add(num);

            if (set.size() > k)//维护窗口的大小不超过k，因为下一次会插入新值，所以此时必须小于K
                set.remove(nums[i-k]);//具体举例分析
        }


        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int k = 2;
        printBool((new ContainsNearbyDuplicate()).containsNearbyDuplicate(nums, k));
    }
}
