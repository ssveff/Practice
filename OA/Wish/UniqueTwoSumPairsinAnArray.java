import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UniqueTwoSumPairsinAnArray {
	static int numberOfPairs(int[] a, long k){
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for(int i = 0; i < a.length; i++){
			for(int j = i + 1; j < a.length; j++){
				if(a[i] + a[j] == k && map.get(a[i]) == null){
					res += 1;
					map.put(a[i], a[j]);
					map.put(a[j], a[i]);
				}
			}
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		int[] a1 = {1, 3, 46, 1, 3, 9};
		long k1 = 47;
		numberOfPairs(a1, k1);
		int[] a2 = {6, 6, 3, 9, 3, 5};
		long k2 = 12;
		numberOfPairs(a2, k2);
		int[] a3 = {3, 7, 5, 7, 1, 4, 4};
		long k3 = 8;
		numberOfPairs(a3, k3);
	}
}

//[1,3,46,1,3,9]  --- 47:1
//[6,6,3,9,3,5,1] --- 12:2
//[3,7,5,7,2,1,4, 4] --- 8: 3
