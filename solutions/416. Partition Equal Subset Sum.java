class Solution 
{
    public boolean canPartition(int[] nums) 
    {
        int sum = 0;
        for(int num: nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        sum /= 2;
        return dfs(nums, 0, sum);
    }
    
    private boolean dfs(int[] nums, int index, int target)
    {
        if(target == 0) return true;
        if(index == nums.length || target < 0) return false;
        if(dfs(nums, index + 1, target - nums[index])) 
            return true;
        int next = index + 1;
        while(next < nums.length && nums[next] == nums[index]) 
            next++;
        return dfs(nums, next, target);
    }
}