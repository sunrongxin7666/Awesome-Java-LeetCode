package DynamicProgramming;

/// LCS问题
/// 动态规划
/// 时间复杂度: O(len(s1)*len(s2))
/// 空间复杂度: O(len(s1)*len(s2))
public class LCS2 {

    public String lcs(String s1, String s2){

        int m = s1.length();
        int n = s2.length();

        // 对memo的第0行和第0列进行初始化
        int[][] memo = new int[m][n];
        for(int j = 0 ; j < n ; j ++)
            if(s1.charAt(0) == s2.charAt(j))
                memo[0][j] = 1;

        for(int i = 0 ; i < m ; i ++)
            if(s1.charAt(i) == s2.charAt(0))
                memo[i][0] = 1;

        // 动态规划的过程
        for(int i = 1 ; i < m ; i ++)
            for(int j = 1 ; j < n ; j ++)
                if(s1.charAt(i) == s2.charAt(j))
                    memo[i][j] = 1 + memo[i-1][j-1];
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);

        System.out.println(memo[m-1][n-1]);
        // 通过memo反向求解s1和s2的最长公共子序列
        m = s1.length() - 1;
        n = s2.length() - 1;
        StringBuilder res = new StringBuilder("");
        while(m >= 0 && n >= 0)
            if(s1.charAt(m) == s2.charAt(n)){
                res.insert(0, s1.charAt(m));
                m --;
                n --;
            }
            else if(m == 0)
                n --;
            else if(n == 0)
                m --;
            else{
                if(memo[m-1][n] > memo[m][n-1])
                    m --;
                else
                    n --;
            }

        return res.toString();
    }

    public static int getLCS(String x, String y) {

        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        int[][] array = new int[x.length() + 1][y.length() + 1];//此处的棋盘长度要比字符串长度多加1，需要多存储一行0和一列0

        for (int j = 0; j < array[0].length; j++) {//第0行第j列全部赋值为0
            array[0][j] = 0;
        }
        for (int i = 0; i < array.length; i++) {//第i行，第0列全部为0
            array[i][0] = 0;
        }

        for (int m = 1; m < array.length; m++) {//利用动态规划将数组赋满值
            for (int n = 1; n < array[m].length; n++) {
                if (s1[m - 1] == s2[n - 1]) {
                    array[m][n] = array[m - 1][n - 1] + 1;//动态规划公式一
                } else {
                    array[m][n] = Math.max(array[m - 1][n], array[m][n - 1]);//动态规划公式二
                }
            }
        }
        return array[x.length() ][y.length() ];
    }

    public static void main(String[] args) {

        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        //System.out.print((new LCS2()).lcs(s1, s2));
        System.out.println(getLCS(s1,s2));
    }
}
