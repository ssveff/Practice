class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j = 0;
        for(int key: map.keySet()){
            if(map.get(key) == 1){
                res[j] = key;
                j++;
            }
            if(j > 1){
                break;
            }
        }
        return res;
    }
}