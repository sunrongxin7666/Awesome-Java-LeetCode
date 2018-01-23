package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 144. Binary Tree Preorder Traversal
/// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/// 非递归二叉树的前序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class NonRecursiveTraversal {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while(!stack.empty()){
            Command command = stack.pop();

            if(command.s.equals("print"))
                res.add(command.node.val);
            else{//中左右的倒序
                assert command.s.equals("go");
                if(command.node.right != null)
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }


    enum CommandCode{
        Print,
        Visit
    }

    public class Cmm{
        public CommandCode code;
        public TreeNode node;


        public Cmm(CommandCode code, TreeNode node) {
            this.code = code;
            this.node = node;
        }
    }

    public List<Integer> myPreorderTraversal(TreeNode root){
        ArrayList<Integer> resList = new ArrayList<>();
        if(root==null)
            return resList;

        Stack<Cmm> cmmStack = new Stack<>();
        cmmStack.push(new Cmm(CommandCode.Visit,root));

        while (cmmStack.size()!=0){
            Cmm cur = cmmStack.pop();
            if(cur.code==CommandCode.Print){
                System.out.println(cur.node.val);
                resList.add(cur.node.val);
            } else {
                assert cur.code == CommandCode.Visit;

                if(cur.node.right!=null)
                    cmmStack.push(new Cmm(CommandCode.Visit,cur.node.right));
                if(cur.node.left!=null)
                    cmmStack.push(new Cmm(CommandCode.Visit,cur.node.left));

                cmmStack.push(new Cmm(CommandCode.Print,cur.node));
            }
        }
        return  resList;
    }
}