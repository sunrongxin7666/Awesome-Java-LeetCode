package UsingArray;

public class MinSubArrayLen {
    // 滑动窗口的思路
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1; // nums[l...r]为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){   // 窗口的左边界在数组范围内,则循环继续

            if(r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else // r已经到头 或者 sum >= s
                sum -= nums[l++];

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        if(res == nums.length + 1)
            return 0;
        return res;
    }


    public int MyMinSubArrayLen(int s, int[] nums){
        int l = 0, r = -1;  //nums[l...r)为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length){
            if(r < nums.length-1 && sum<s){
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }
        if(res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new MinSubArrayLen()).MyMinSubArrayLen(s, nums));
    }
}
