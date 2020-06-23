class Solution
{
    public int[][] reconstructQueue(int[][] people)
    {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> (p1[0] == p2[0])? p1[1] - p2[1] : p2[0] - p1[0]);
        for (int[] person : people) 
            queue.offer(person);
        List<int[]> solution = new ArrayList<>();
        while (!queue.isEmpty()) 
        {
            int[] person = queue.poll();
            solution.add(person[1], person);
        }
        return solution.toArray(people);
    }
}