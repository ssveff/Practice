public class Solution {
    /*
     * @param : An integer array
     * @param : the first index
     * @param : the second index
     * @return: 
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        int swap = A[index1];
        A[index1] = A[index2];
        A[index2] = swap;
    }
}