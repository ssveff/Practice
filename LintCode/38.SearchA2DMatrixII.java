public class Solution {
    /*
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    //Brute Force. Time O(m*n), Space O(1)
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int result = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == target){
                    result++;
                }
            }
        }
        return result;
    }

    //Search Space reduction. Time O(m + n), Space O(1)
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int i = row - 1;
        int j = 0;
        int result = 0;
        
        while(i >= 0 && j < column){
            if(matrix[i][j] < target){
                j ++;
            }
            else if(matrix[i][j] > target){
                i --;
            }
            else{
                result ++;
                i --;
                j ++;
            }
        }
        return result;
    }
}