class Solution 
{
    public int countSubstrings(String s) 
    {
      char[] charArr = s.toCharArray();
        int same = 0;
        int ans = 0;
        for(int i=0; i<charArr.length; i += same) 
        {
            int left = i-1;
            int right = i+1;
            while(right < charArr.length && charArr[i] == charArr[right]) 
                ++right;
            same = right-i;
            ans += same*(same+1)/2;
            while(left>=0 && right < charArr.length && charArr[left] == charArr[right])
            {
                ++ans;
                --left;
                ++right;
            }
        }
        return ans;  
    }
}