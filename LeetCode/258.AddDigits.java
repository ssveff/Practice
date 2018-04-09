//Solution1: Use Loop
class Solution {
    public int addDigits(int num) {
        int remain;
        int sum = num;
        if(num < 10){
            return num;
        }
        while(sum > 9){
            sum = 0;
            while(num > 0){
            remain = num % 10;
            sum += remain;
            num = num / 10;
            }
            num = sum;
        }
        return sum;
    }
}
//Solution2: 
class Solution {
    public int addDigits(int num) {
        if(num == 0){
            return 0;
        }
        if(num % 9 == 0){
            return 9;
        }
        else{
            return num % 9;
        }
    }
}