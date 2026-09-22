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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        
        while (curr != null || !stack.isEmpty()) {
            // Reach the left-most node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Pop the node from the stack
            curr = stack.pop();
            count++;
            
            // If count matches k, return the value
            if (count == k) {
                return curr.val;
            }
            
            // Move to the right subtree
            curr = curr.right;
        }
        
        return -1; // Fallback statement (should not be reached if k is valid)
    }
}