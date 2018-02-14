public class Solution {
    /*
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int a = 0;
        int b = 1;
        for(int i = 1; i < n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}