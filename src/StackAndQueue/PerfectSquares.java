package StackAndQueue;

import javafx.util.Pair;

import java.util.LinkedList;

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

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

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
        //用来记录该数字是否被访问过了
        boolean[] isVisited = new boolean[n+1];//如果是Boolean则没有默认的初始值

        //加入头结点
        queue.add(new Pair<>(n,0));
        isVisited[n]=true;

        while (queue.size()!=0){
            //获取当前的移动的情况
            Pair<Integer, Integer> curPair = queue.removeFirst();
            Integer curValue = curPair.getKey();
            Integer curStep = curPair.getValue();

            if(curValue==0)//如果已经是0则返回当前步数
                return curStep;

            for (int i = 1; ; i++) {
                int tmp = curValue - i * i;
                if(tmp<0)
                    break;
                else if(tmp==0)
                    return curStep + 1;
                else if(!isVisited[tmp]){
                    queue.add(new Pair<>(tmp,curStep+1));
                    isVisited[tmp] = true;
                }
            }

        }

        throw new IllegalStateException("no solution!");
    }

    public static void main(String[] args) {

        System.out.println((new PerfectSquares()).MyNumSquares(12));
        System.out.println((new PerfectSquares()).MyNumSquares(13));
        System.out.println((new PerfectSquares()).MyNumSquares(0));
    }
}
