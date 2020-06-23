class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        
        for(int i = s1.length - 1; i >= 0; i--)
        {
            for(int j = s2.length - 1; j >= 0; j--)
            {
                if(s1[i] == s2[j]) 
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else 
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
            
        return dp[0][0];
    }
}