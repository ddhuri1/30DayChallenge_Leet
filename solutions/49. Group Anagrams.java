class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            if(map.containsKey(String.valueOf(ch)))
            {
                map.get(String.valueOf(ch)).add(str);
            }
            else
            {
                List<String> li = new ArrayList<>();
                li.add(str);
                map.put(String.valueOf(ch), li);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}