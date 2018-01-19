package UsingHashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class IntersectionOf2Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> record = new TreeSet<Integer>();
        for(int num: nums1)
            record.add(num);

        TreeSet<Integer> resultSet = new TreeSet<Integer>();
        for(int num: nums2)
            if(record.contains(num))
                resultSet.add(num);

        int[] res = new int[resultSet.size()];
        int index = 0;
        for(Integer num: resultSet)
            res[index++] = num;

        return res;
    }

    public int[] myIntersection(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int aNums1 : nums1) {
            set1.add(aNums1);
        }
        for (int num : nums2){
            if(set1.contains(num))
                set2.add(num);
        }

        int[] result = new int[set2.size()];
        int i = 0;
        for (int num : set2){
            result[i++] = num;
        }
        return result;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }
    private static void printArr(Integer[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new IntersectionOf2Arrays()).myIntersection(nums1, nums2);
        printArr(res);
    }
}
