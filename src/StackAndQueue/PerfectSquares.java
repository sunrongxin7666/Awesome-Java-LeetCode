package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/
// 进一步优化
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class PerfectSquares {

    public int numSquares(int n) {

        if(n == 0)
            return 0;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            for(int i = 1 ; num - i*i >= 0 ; i ++){
                int a = num - i*i;
                if(!visited[a]){
                    if(a == 0) return step + 1;
                    queue.addLast(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        throw new IllegalStateException("No Solution.");
    }

    public int MyNumSquares(int n){
        //queue中保存《目前的数字，已经移动的次数》
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        ArrayList<Boolean> isVisited = new ArrayList<>();
        return 1;
    }

    public static void main(String[] args) {

        System.out.println((new PerfectSquares()).numSquares(12));
        System.out.println((new PerfectSquares()).numSquares(13));
    }
}