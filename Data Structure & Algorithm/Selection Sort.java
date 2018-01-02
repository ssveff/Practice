public void selectionSort(int[] arr){
	int minIndex, temp;
	for(int i = 0; i < arr.length - 1; i++){
		minIndex = i;
		for(int j = i + 1; j < arr.length; j++){
			if(arr[minIndex] > arr[j]){
				minIndex = j;
			}
		}
		if (minIndex != i){
			temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}	
	}
}
//comlexity: o(n^2)