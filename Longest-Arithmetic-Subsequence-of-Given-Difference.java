/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
    
    private TreeNode lcaHelper(TreeNode node, int depth, int currentDepth) {
        if (node == null) {
            return null;
        }
        
        if (currentDepth == depth) {
            return node;
        }
        
        TreeNode left = lcaHelper(node.left, depth, currentDepth + 1);
        TreeNode right = lcaHelper(node.right, depth, currentDepth + 1);
        
        if (left != null && right != null) {
            return node;
        }
        
        return left != null ? left : right;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = depth(root); 
        return lcaHelper(root, depth, 1); 
    }
}
