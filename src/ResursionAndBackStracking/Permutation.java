package ResursionAndBackStracking;


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Permutation {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];//标记哪些元素被使用了
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, p);

        return res;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, LinkedList<Integer> p){

        if(p.size() == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, p);
                p.removeLast();
                used[i] = false;
            }
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Permutation()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}
