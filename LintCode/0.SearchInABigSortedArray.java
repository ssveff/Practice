/*
Given a big sorted array with positive integers sorted by ascending order. 
The array is so big so that you can not get the length of the whole array directly, 
and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). 
Find the first index of a target number. 
Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.
*/

public class Solusion{
	public int searchBigSortedArray(ArrayReader reader, int target){
		//倍增算法：ArrayList的实现也用到。网络里的Exponential backoff也是用的这个思想
		//1. Get the index that ArrayReader.get(index) >= target in O(logk)
		//2. Binary search the target between 0 and index
		int index = 1;
		while(ArrayReader.get(index - 1) < target){
			index = index * 2;
		}
		int start = 0;
		int end = index - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(ArrayReader.get(mid) < target){
				start = mid;
			} else{
				end = mid;
			}
		}
		if(ArrayReader.get(start) == target){
			return start;
		}
		if(ArrayReader.get(end) == target){
			return end;
		}
		return -1;
	}
}