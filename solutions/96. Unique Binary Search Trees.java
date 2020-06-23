class Solution 
{
    public int numTrees(int n) 
    {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            dp[i] = 2 * dp[i-1];
            for(int j = 2; j <= i-1; j++)
            {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}