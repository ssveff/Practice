class Solution{
	public int myAtoi(String str){
		if(str == null){
			return 0;
		}
		str = str.trim();
		if(str.length() == 0){
			return 0;
		}
		int sign = 1;
		int index = 0;

		if(str.charAt(index) == '+'){
			index ++;
		}
		else if(str.charAt(index) == '-'){
			sign = -1;
			index ++;
		}
		long num = 0;
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
		for(; index < str.length(); index++){
			if(str.charAt(index) < '0' || str.charAt(index) > '9'){
				break;
			}
			num = num * 10 + str.charAt(index) - '0';
			if(num > INT_MAX){
				break;
			}
		}
		if(num * sign >= INT_MAX){
			return INT_MAX;
		}
		if(num * sign <= INT_MIN){
			return INT_MIN;
		}
		return (int)num * sign;
	}
}