class Solution
{
    public int[] dailyTemperatures(int[] T)
    {
        if (T == null || T.length == 0) 
            return new int[]{};        
        int[] result = new int[T.length];
        int max = T[T.length - 1];
        for (int i = T.length - 2; i >= 0; i--) 
        {
            if (T[i] >= max) 
                max = T[i];
            else
            {
                int next = 1;
                while (T[i] >= T[i + next]) 
                    next += result[i + next];
                result[i] = next;
            }
        }
        return result;
    }
}
