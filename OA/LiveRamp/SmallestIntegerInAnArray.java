import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 1;
        HashMap<Integer> map = HashMap<Integer>();
        for(int i = 0; i < A.length; i++){
            if(!map.contains(A[i])){
                map.put(A[i]);
            }
        }
        while(map.contains(res){
            res++;
        }
        return res;
    }
}