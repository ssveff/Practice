public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        return (a & b << 1) + a ^ b;
    }
