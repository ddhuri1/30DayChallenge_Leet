public class Solution 
{
    public int findTargetSumWays(int[] nums, int S)
    {
        int sum = 0;
        for (int num : nums) 
            sum += num;        
        if (sum < S) return 0;
        sum = (S + sum);
        if (sum % 2 == 1) return 0;
        sum = sum / 2;
        
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        
        for (int num : nums)
            for (int col = sum; col >= num; col--) 
                dp[col] += dp[col - num];
        return dp[sum];
    }
}