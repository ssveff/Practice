public class Solution {
    /*
     * @param str: A string
     * @return: A string
     */
    public String lowercaseToUppercase2(String str) {
        // write your code here
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if (Character.isLowerCase(c)){
                sb.setCharAt(i, Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
}