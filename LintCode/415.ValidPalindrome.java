public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        /*
        1.先判断字符串是否为空
        2.过滤特殊字符
        3.比较head&tail
        关注方法：.toLowerCase(),  Character.isLetterorDigit();
        */
        if(s.isEmpty()){
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail){
            char cHead = s.charAt(head);
            char cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)){
                head++;
            }
            else if (!Character.isLetterOrDigit(cTail)){
                tail--;
            }
            else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){
                return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}