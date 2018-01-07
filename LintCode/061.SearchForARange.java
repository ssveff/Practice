public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        
        if(A == null || A.length == 0){
            return new int[]{-1, -1};
        }
        
        int[] result = new int[2];
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target){
                end = mid;
            }
            else if(A[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if(A[start] == target){
            int i = start + 1;
            while(i < A.length && A[i] == target){
                i ++;
            }
            result[0] = start;
            result[1] = i - 1;
            return result;
        }
        if(A[end] == target){
            int i = end + 1;
            while(i < A.length && A[i] == target){
                i ++;
            }
            result[0] = end;
            result[1] = i - 1;
            return result; 
        }
        return new int[]{-1, -1};
    }
}