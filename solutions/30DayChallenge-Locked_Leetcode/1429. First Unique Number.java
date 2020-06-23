class FirstUnique
{    
    private HashMap<Integer, Node> map;
    private Node head = new Node(-1, null, null);
    private Node tail = new Node(-1, head, null);
    
    private class Node
    {
        int value;
        Node prev, next;
        public Node(int value, Node prev, Node next)
        {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private void addVal(int val) 
    {
        Node node = new Node(val, tail.prev, tail);
        tail.prev.next = node; 
        tail.prev = node;
        map.put(val, node);
    }
    
    private void removeVal(Node node) 
    {
        if (node.prev == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    public FirstUnique(int[] nums) 
    {
        head.next = tail;
        map = new HashMap<>((int) Math.ceil(nums.length / 0.75f));
        for (int n : nums) 
        {
            Node node = map.get(n);
            if (node != null) 
                removeVal(node);
            else
                addVal(n);
        }
    }
    
    public int showFirstUnique()
    {
        if (head.next == null) 
            return -1;        
        else
            return head.next.value;
    }
    
    public void add(int n) 
    {
        Node node = map.get(n);
        if (node != null) 
            removeVal(node);
        else
            addVal(n);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */