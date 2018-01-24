package StackAndQueue;


import java.util.*;
import java.util.HashMap;

import javafx.util.Pair;


// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/description/
// 时间复杂度: O(nlogk)
// 空间复杂度: O(n + k)
class TopKFrequentElements {

    private class PairComparator implements Comparator<Pair<Integer, Integer>>{

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num1 : nums)
            if (freq.containsKey(num1))
                freq.put(num1, freq.get(num1) + 1);
            else
                freq.put(num1, 1);

        if(k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new PairComparator());
        for(Integer num: freq.keySet()){
            int numFreq = freq.get(num);
            if(pq.size() == k){
                if(numFreq > pq.peek().getKey()){
                    pq.poll();
                    pq.add(new Pair<>(numFreq, num));
                }
            }
            else
                pq.add(new Pair<>(numFreq, num));
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.add(pq.poll().getValue());

        return res;
    }

    public List<Integer> MyTopKFrequent(int[] nums, int k){
        assert k>0 && k<=nums.length;

        //元素 出现次数
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        //最小堆 次数-元素
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(new PairComparator());//自定义比较器

        //统计出现次数
        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        assert k<=freqMap.size();

        //保持前K个出现次数最多的
        for (Integer elem : freqMap.keySet()){
            Integer freq = freqMap.get(elem);
            if(priorityQueue.size()<k)//
                priorityQueue.add(new Pair<>(freq,elem));
            else if (priorityQueue.size() == k){
                if(freq > priorityQueue.peek().getKey()){
                    priorityQueue.poll();
                    priorityQueue.add( new Pair<>(freq,elem));
                }
            } else
                throw new IllegalStateException();
        }

        //获得结果
        ArrayList<Integer> list = new ArrayList<>();
        while (priorityQueue.size()!=0){
            list.add(priorityQueue.poll().getValue());
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : list){
            stack.push(num);
        }
        list.clear();
        while (stack.size()!=0){
            list.add(stack.pop());
        }
        return list;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new TopKFrequentElements()).MyTopKFrequent(nums, k));
    }
}
