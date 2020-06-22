class Solution 
{
    /*public boolean canJump(int[] nums) 
    {
        if(nums.length == 0 ||nums.length == 1) return true; 
        if(nums[0] >= nums.length) return true;
        int ladder = 0;
        int curEnd = 0;
        for(int i = 0; i < nums.length; i++)
        {
            ladder = Math.max(ladder, i + nums[i]);
            if(i == curEnd)
            {
                curEnd = ladder;
                if(curEnd >= nums.length - 1)
                    return true;
            }
        }
        return false;
    }
    */
    
    public boolean canJump(int[] nums) 
    {
        int ladder = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i > ladder) return false;
            ladder = Math.max(ladder, i + nums[i]);
        }
        return true;
    }
    
}