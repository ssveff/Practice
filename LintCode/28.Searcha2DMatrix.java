public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        
        int start = 0;
        int end = row * column - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int num = matrix[mid / column][mid % column];
            if(num == target){
                end = mid;
            }
            else if(num < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(matrix[start/column][start%column] == target || matrix[end/column][end%column] == target){
            return true;
        }
        return false;
    }
}