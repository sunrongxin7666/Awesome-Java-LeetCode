package UsingHashTable;

import java.util.*;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class IntersectionOf2Arrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> record = new TreeMap<>();
        for(int num: nums1)
            if(!record.containsKey(num))
                record.put(num, 1);
            else
                record.put(num, record.get(num) + 1);

        ArrayList<Integer> result = new ArrayList<>();
        for(int num: nums2)
            if(record.containsKey(num) && record.get(num) > 0){
                result.add(num);
                record.put(num, record.get(num) - 1);
            }

        int[] ret = new int[result.size()];
        int index = 0;
        for(Integer num: result)
            ret[index++] = num;

        return ret;
    }

    public int[] myIntersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1){
            if(map1.containsKey(num)){
                map1.put(num, map1.get(num)+1);
            } else {
                map1.put(num,1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2){
            if(map1.containsKey(num)&&map1.get(num)!=0){
                resultList.add(num);
                map1.put(num, map1.get(num)-1);
            }
        }

        int[] res = new int[resultList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=resultList.get(i);
        }
        return res;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new IntersectionOf2Arrays2()).myIntersect(nums1, nums2);
        printArr(res);
    }
}
