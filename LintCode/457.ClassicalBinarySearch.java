public class Solution {
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        //相邻就退出，可以解决length为2的时候找last position出现死循环的问题
        while(start + 1 < end){
            //相当于(start + end)/2,为了防止溢出
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target){
                //or end = mid - 1
                end = mid;
            }
            else if(nums[mid] > target){
                end = mid;
            }
            else{
                //or start = mid + 1
                start = mid;
            }
            //double check
            if(nums[start] == target){
                return start;
            }
            if(nums[end] == target){
                return end;
            }
        }
        return -1;
    }
}