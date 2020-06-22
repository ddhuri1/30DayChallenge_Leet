class Solution {
    public int search(int[] nums, int target) {
        if(nums.length < 1) return -1;
        if(nums.length == 1 && target == nums[0]) return 0;
        else if(nums.length == 1 && target != nums[0]) return -1;
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(target == nums[mid]) return mid;
            if(target == nums[left]) return left;
            if(target == nums[right]) return right;
            if(nums[mid] < nums[left])
            {
                if((target > nums[mid] && target < nums[right]))
                     left = mid+1;
                else
                    right = mid-1;
            }
            else 
            {
                if((target < nums[mid] && target > nums[left]))
                    right = mid-1;
                else 
                    left = mid+1;
            }
        }
        return -1;
    }
}