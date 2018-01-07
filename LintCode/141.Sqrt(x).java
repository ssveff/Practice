public class Solution {
    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x == 0){
            return 0;
        }
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid == x / mid){
                return mid;
            }
            else if(mid < x /mid){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return end;
    }
}