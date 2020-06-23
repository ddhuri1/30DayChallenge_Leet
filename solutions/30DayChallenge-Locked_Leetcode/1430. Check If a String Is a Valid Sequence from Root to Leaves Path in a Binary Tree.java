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
class Solution
{
    public boolean isValidSequence(TreeNode root, int[] arr)
    {
        return isValid(root, arr, 0);
    }
    
    private boolean isValid(TreeNode node, int[] arr, int index)
    {
        if (index >= arr.length || node == null ) return false;
        if (index == arr.length -1 && arr[index] == node.val && node.left == null && node.right == null)
            return true;
        else
        {
            if (arr[index] == node.val)
            {
                if (isValid(node.left, arr, index+1))
                    return true;
                else if (isValid(node.right, arr, index+1)) 
                    return true;
            }
        }
        return false;
    }
}