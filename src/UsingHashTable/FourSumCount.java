package UsingHashTable;


import java.util.HashMap;
import java.util.Map;

// 454. 4Sum II
// https://leetcode.com/problems/4sum-ii/description/
// 时间复杂度: O(n^2)
// 空间复杂度: O(n^2)
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("Illegal argument");

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < C.length ; i ++)
            for(int j = 0 ; j < D.length ; j ++){
                int sum = C[i] + D[j];
                if(map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }

        int res = 0;
        for(int i = 0 ; i < A.length ; i ++)
            for(int j = 0 ; j < B.length ; j ++)
                if(map.containsKey(-A[i]-B[j]))
                    res += map.get(-A[i]-B[j]);

        return res;
    }
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {

        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("Illegal argument");

        HashMap<Integer, Integer> mapAB = new HashMap<Integer, Integer>();
        for (int aA : A)
            for (int j = 0; j < B.length; j++) {
                int sum = aA + B[j];
                if (mapAB.containsKey(sum))
                    mapAB.put(sum, mapAB.get(sum) + 1);
                else
                    mapAB.put(sum, 1);
            }

        HashMap<Integer, Integer> mapCD = new HashMap<Integer, Integer>();
        for (int aC : C)
            for (int aD : D) {
                int sum = aC + aD;
                if (mapCD.containsKey(sum))
                    mapCD.put(sum, mapCD.get(sum) + 1);
                else
                    mapCD.put(sum, 1);
            }

        int res = 0;
        for(Integer sumab: mapAB.keySet()){
            if(mapCD.containsKey(-sumab))
                res += mapAB.get(sumab) * mapCD.get(-sumab);
        }

        return res;
    }

    public int myFourSumCount(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer, Integer> mapAB = new HashMap<>();

        for (int a : A){
            for (int b : B){
//                if(mapAB.containsKey(a+b)) {
//                    mapAB.put(a + b, mapAB.get(a + b) + 1);
//                } else
//                    mapAB.put(a + b, 1);
                mapAB.put(a+b, mapAB.getOrDefault(a+b, 0)+1);
            }
        }

        HashMap<Integer, Integer> mapCD = new HashMap<>();
        for (int c : C){
            for (int d : D){
//                if(mapCD.containsKey(c+d)) {
//                    mapCD.put(c + d, mapAB.get(c + d) + 1);
//                } else
//                    mapCD.put(c + d, 1);
                mapCD.put(c+d, mapCD.getOrDefault(c+d,0)+1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer,Integer> entry1 : mapAB.entrySet()){
            if(mapCD.containsKey(-entry1.getKey()))
                res += entry1.getValue() * mapCD.get(-entry1.getKey());
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new FourSumCount()).myFourSumCount(a, b, c, d));
    }
}
