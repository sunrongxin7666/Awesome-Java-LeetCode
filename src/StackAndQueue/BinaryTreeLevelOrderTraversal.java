package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import javafx.util.Pair;

/// 102. Binary Tree Level Order Traversal
/// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
/// 二叉树的层序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(n)
class BinaryTreeLevelOrderTraversal {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;

        // 我们使用LinkedList来做为我们的先入先出的队列
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.addLast(new Pair<>(root, 0));

        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if(level == res.size())
                res.add(new ArrayList<>());
            assert level < res.size();

            res.get(level).add(node.val);
            if(node.left != null)
                queue.addLast(new Pair<>(node.left, level + 1));
            if(node.right != null)
                queue.addLast(new Pair<>(node.right, level + 1));
        }

        return res;
    }

    public List<List<Integer>> MyLevelOrder(TreeNode root){
        ArrayList<List<Integer>> resLists = new ArrayList<>();
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        //判断根节点是否为空
        if(root==null)
            return resLists;
        //添加根节点
        queue.add(new Pair<>(root,0));

        //循环条件为队列不为空
        while (queue.size()!=0){
            //获得第一个元素，如果是linkedQueue需要移除第一个元素；
            Pair<TreeNode, Integer> cur = queue.removeFirst();

            //将第一个元素放入到结果集中对应的位置；
            if(cur.getValue() == resLists.size())
                resLists.add(new ArrayList<>());
            resLists.get(cur.getValue()).add(cur.getKey().val);

            if(cur.getKey().left!=null)//处理左子树
                queue.add(new Pair<>(cur.getKey().left, cur.getValue() + 1));
            if(cur.getKey().right!=null)//处理又子数
                queue.add(new Pair<>(cur.getKey().right, cur.getValue() + 1));
        }
        return resLists;
    }
}