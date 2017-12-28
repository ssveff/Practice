class Solution {
    /*
     * @param : An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // 打擂台
        int max = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++){
            if (nums[i] > max){
                second = max;
                max = nums[i];
            }
            else if (nums[i] > second){
                second = nums[i];
            }
        }
        return second;
    }
}