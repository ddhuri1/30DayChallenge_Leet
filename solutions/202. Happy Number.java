class Solution 
{
    public boolean isHappy(int n) 
    {
        if(n == 1 || n == 7) return true;
        int res = 0;
        int loop = 0;
        while (n > 0) 
        {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        if(res == 1 || res == 7) return true;
        else if (res < 10 && res != 1 && res != 7) return false;
            
        return (res == 1) | (isHappy(res));    
    }
}