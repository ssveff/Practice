//My naive solution: Careful about the boundary
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; 
        int temp = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                j = i;
                i++;
            }
            while(i < nums.length - 1 && nums[i] == 0){
                i++;
            }
            if(nums[j] == 0){
                temp = nums[i];
                nums[j] = nums[i];
                nums[i] = 0;
                i = j; 
            }
        }
    }
}

//Solution2: Two-pointer
class Solution {
    public void moveZeroes(int[] nums) {
        int last = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[last++] = nums[i];
            }
        }
        for(int j = last; j < nums.length; j++){
            nums[j] = 0;
        }
    }
}

//Solution3: Optimal Two-pointer
class Solution {
    public void moveZeroes(int[] nums) {
        int last = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                temp = nums[i];
                nums[i] = nums[last];
                nums[last] = temp;
                last++;
            }
        }
    }
}