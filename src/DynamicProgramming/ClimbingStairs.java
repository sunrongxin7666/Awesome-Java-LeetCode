package DynamicProgramming;


/// 70. Climbing Stairs
/// https://leetcode.com/problems/climbing-stairs/description/
/// 动态规划
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class ClimbingStairs {

    public int climbStairs(int n) {

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

    public int MyClimbStairs(int n) {
        int[] res = new int[n];

        res[0]=1;
        res[1]=2;

        for (int i = 2; i<n ; i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res[n-1];
    }

    public static void main(String[] args) {

        System.out.println((new ClimbingStairs()).MyClimbStairs(10));
    }
}
