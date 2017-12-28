public class Solution {
    /*
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        if (num < 0){
            return false;
        }
        return num == reverse(num);
    }
    
    public int reverse(int num){
        int res = 0;
        while (num != 0){
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }
}