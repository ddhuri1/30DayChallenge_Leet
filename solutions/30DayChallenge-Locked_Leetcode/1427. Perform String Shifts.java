class Solution 
{
    public String stringShift(String s, int[][] shift)
    {
        int direction = 0;
        for (int[] pair : shift) 
        {
            if (pair[0] == 0) 
                direction -= pair[1];
            else
                direction += pair[1];
        }

        return shift(s, direction);
    }

    private String shift(String s, int direction) 
    {
        if (direction == 0) return s;
        direction = direction % s.length();
        if (direction < 0) 
            direction = s.length() - Math.abs(direction);
        char[] result = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) 
        {
            int index = (i + direction) % s.length();
            result[index] = s.charAt(i);
        }
        for (char c : result)
            sb.append(c);
        return sb.toString();
    }
}