package Search;

import java.rmi.server.SkeletonNotFoundException;
import java.util.concurrent.atomic.LongAdder;

public class BinarySearchRecap {
   
	private final LongAdder adder = new LongAdder();
			
	public int binarySearch(int[] arr,  int key) {
		int start = 0;
		int end = arr.length - 1;
	
		while (end >= start) {
			adder.increment();
			int middle = (start + end) / 2;
			if (arr[middle] == key) {
				return middle;
			} else if (arr[middle] > key) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		
		return -1;
	}
	
	public void testBinraySearch() {
		int length = 1024;
		int[] arr =  new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		int foundIndex = this.binarySearch(arr, 1023);
		System.out.printf("Binary search result find index: %s, useing: %s times", foundIndex, this.adder.sumThenReset());
		
	}
}
