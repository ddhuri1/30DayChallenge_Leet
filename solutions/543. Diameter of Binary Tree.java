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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root == null) return 0;
        dfs(root);
        return ans ;
    }
     public int dfs(TreeNode node)
     {
         if(node == null) return 0;
         if(node.left == null && node.right == null) return 1;
         int left = dfs(node.left);
         int right = dfs(node.right);
         ans = Math.max(ans, left + right);
         return Math.max(left, right) + 1;
     }
}