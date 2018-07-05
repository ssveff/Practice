class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j && numbers[i] + numbers[j] != target){
            if(numbers[i] + numbers[j] < target){
                i++;
            } else{
                j--;
            }
        }
        int[] result = {i+1, j+1};
        return result;
    }
}