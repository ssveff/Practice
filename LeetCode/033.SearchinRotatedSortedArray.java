class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= nums[0]){
                if(target > nums[mid] || target < nums[0]){
                    start = mid;
                } else{
                    end = mid;
                }
            } else{
                if(target < nums[mid] || target > nums[nums.length - 1]){
                    end = mid;
                } else{
                    start = mid;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
}