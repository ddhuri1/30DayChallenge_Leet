class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] prod1 = new int[nums.length];
        if(nums == null || nums.length == 0) return prod1;
        int len = nums.length;
        int[] prod2 = new int[len];
        int[] ans = new int[len];
        
        prod1[0] = 1;
        prod2[len - 1] = 1;
        
        for(int i = 1; i < len; i++)
            prod1[i] = prod1[i - 1] * nums[i - 1];
        
        for(int i = len - 2; i >= 0; i--)
            prod2[i] = prod2[i + 1] * nums[i + 1];
        
        for(int i = 0; i < len; i++)
            ans[i] = prod1[i] * prod2[i];
        
        return ans;
    }
    
    /*Alternate Method
    public int[] productExceptSelf(int[] nums) 
    {
        int[] prod = new int[nums.length];
        if(nums == null || nums.length == 0) return prod;
        int len = nums.length;
        int temp = 1;
        for(int i = 0; i < len; i++)
        {    
            prod[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i = len - 1; i >= 0; i--)
         {    
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }
    */
}