/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or we found p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recurse on left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If p and q are found in left and right respectively, current root is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null child (or null if neither was found)
        return left != null ? left : right;
    }
}