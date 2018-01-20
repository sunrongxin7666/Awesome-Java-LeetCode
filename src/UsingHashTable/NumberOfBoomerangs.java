package UsingHashTable;


import java.util.HashMap;
import java.util.Map;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class NumberOfBoomerangs {

    private int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for( int i = 0 ; i < points.length ; i ++ ){

            // record中存储 点i 到所有其他点的距离出现的频次
            HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
            for(int j = 0 ; j < points.length ; j ++)
                if(j != i){
                    // 计算距离时不进行开根运算, 以保证精度
                    int dis = dis(points[i], points[j]);
                    if(record.containsKey(dis))
                        record.put(dis, record.get(dis) + 1);
                    else
                        record.put(dis, 1);
                }

            for(Integer dis: record.keySet())
                res += record.get(dis) * (record.get(dis) - 1);
        }

        return res;
    }

    private int MyNumberOfBoomerangs(int[][] points){
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] mpair = points[i];
            HashMap<Integer, Integer> disMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(j!=i) {
                    int[] epair = points[j];
                    int dis = dis(mpair, epair);
                    disMap.put(dis, disMap.getOrDefault(dis, 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> disEntry : disMap.entrySet()) {
                res += disEntry.getValue() * (disEntry.getValue() - 1);
            }
        }
        return  res;
    }

    private int dis(int[] pa, int pb[]){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new NumberOfBoomerangs()).MyNumberOfBoomerangs(points));
    }
}
