public class Solution {
    /*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages == null || pages.length == 0){
            return 0;
        }
        int max = 0;
        int sum = 0;
        for(int i = 0; i < pages.length; i++){
            max = Math.max(max, pages[i]);
            sum += pages[i];
        }
        
        int start = max;
        int end = sum;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(countCopier(pages, mid) > k){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(countCopier(pages, start) <= k){
            return start;
        }
        if(countCopier(pages, end) <= k){
            return end;
        }
        return -1;
    }
    
    private int countCopier(int[] pages, int cut){
        int copier = 1;
        int sum = pages[0];
        for(int i = 1; i < pages.length; i++){
            if(sum + pages[i] > cut){
                copier ++;
                sum = 0;
            }
            sum += pages[i];
        }
        return copier;
    }
}