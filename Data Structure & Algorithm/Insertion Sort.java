//complexity: o(n^2). Apply to small arrays of data. Ourperforms selection sort and bubble sort.
public void insertionSort(int[] arr){
	int i , j, newValue;
	for(i = 1, i < arr.length; i++){
		newValue = arr[i];
		j = i;
		while(j > 0 && arr[j] > newValue){
			arr[j] = arr[j - 1];
			j--;
		}
		arr[j] = newValue;
	}
}