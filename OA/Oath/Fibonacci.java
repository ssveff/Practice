public class Solution {
    /*
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int a = 0;
        int b = 1;
        for(int i = 0; i < n - 1; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}