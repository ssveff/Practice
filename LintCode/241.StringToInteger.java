class Solution {
    /*
     * @param str: A string
     * @return: An integer
     */
    public int stringToInteger(String str) {
        // write your code here
        //naive solution: return Integer.valueOf(str);
        /*
        拆分问题：
        1.先考虑正数情况
        2.再考虑负数情况
        3.最后考虑有overflow的情况
        */
        int integer = 0;
        int minus = 0;
        if (str.charAt(0) == '-'){
            minus = 1;
        }
        for (int i = minus; i < str.length(); i++){
            integer = integer * 10 + (str.charAt(i) - '0');
        }
        if (minus == 1){
            integer = -integer;
        }
        return integer;
    }
}