public class Solution {
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < L.length; i++){
            max = Math.max(max, L[i]);
        }
        int start = 1;
        int end = max;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(count(L, mid) >= k){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(count(L, end) >= k){
            return end;
        } 
        if(count(L, start) >= k){
            return start;
        }
        return 0;
    }
    private int count(int[]L, int length){
        int result = 0;
        for(int i = 0; i < L.length; i++){
            result += L[i] / length;
        }
        return result;
    }
}