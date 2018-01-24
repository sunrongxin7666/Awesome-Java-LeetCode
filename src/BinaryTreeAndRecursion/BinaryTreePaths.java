package BinaryTreeAndRecursion;

import java.util.ArrayList;
import java.util.List;

/// 257. Binary Tree Paths
/// https://leetcode.com/problems/binary-tree-paths/description/
/// 时间复杂度: O(n), n为树中的节点个数
/// 空间复杂度: O(h), h为树的高度
public class BinaryTreePaths {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<String>();

        if(root == null)
            return res;

        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        addCurNodeToPath(root, res, leftPaths);

        List<String> rightPaths = binaryTreePaths(root.right);
        addCurNodeToPath(root, res, rightPaths);

        return res;
    }

    private void addCurNodeToPath(TreeNode root, ArrayList<String> res, List<String> leftPaths) {
        for(String s: leftPaths){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
    }
}
