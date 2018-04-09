//Time: O(nlogn), Space: O(1)
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i+=2){
            swap(nums, i, i+1);
        }
    }
    private int[] swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}