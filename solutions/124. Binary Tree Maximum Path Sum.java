/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        max_gain(root);
        return max_sum;
    }
    public int max_gain(TreeNode node)
    {
        if (node == null) return 0;

        int left = Math.max(max_gain(node.left), 0);
        int right = Math.max(max_gain(node.right), 0);
        int sum = node.val + left + right;
        max_sum = Math.max(max_sum, sum);
        return node.val + Math.max(left, right);
    }
}