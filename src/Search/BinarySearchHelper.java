package Search;

import java.rmi.server.SkeletonNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.IntPredicate;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import Utils.*;

public class BinarySearchHelper {
	
		private static  final LongAdder adder = new LongAdder();
				
		//Recursive way
		public static int binarySearch(int[] arr,  int key) {
			//O(log n)
			return startBinarySearch(arr, key, 0, arr.length - 1);
		}
		
		private static int startBinarySearch(int[] arr,  int key, int start, int end) {
			if(end < start) {
				return -1;
			}
			
			System.out.println("searching...");
			adder.increment();
			
			int middleIndex = (end - start)  / 2 + start;
			
			if (arr[middleIndex] == key) {
				return middleIndex;
			} else if (arr[middleIndex] > key) {
				return startBinarySearch(arr, key, start, middleIndex - 1);
			} else {
				return startBinarySearch(arr, key, middleIndex + 1, end );
			}
		}
		
		//For loop way
		public static int binarySearchInLoop(int[] arr, int key) {
			int start = 0;
			int end = arr.length -1 ;
			
			while (end  >= start) {
				adder.increment();
				int middleIndex = (end - start) / 2 + start;
				if (arr[middleIndex] == key) {
					return middleIndex;
				} else if (arr[middleIndex] > key) {
					end = middleIndex - 1;
				} else {
					start = middleIndex + 1;
				}
			}
			
			return -1;
		}
		
		public static int normalSearch(int[] arr,  int key) {
			//O(n)
			for (int i = 0; i < arr.length; i++) {
				System.out.println("searching...");
				if (arr[i] == key) {
					return i;
				}
			}
			return -1;
		}
		
		public static void testBinarySearch() {
			int capacity = 1024;
			int[] inputArr = new int[capacity];
			for (int i = 0; i < capacity; i++) {
				inputArr[i] = i;
			}
			Date date1 = new Date();
			System.out.println("Start to search value");
			int result =  binarySearchInLoop(inputArr, 1023);
			System.out.printf("End to search value with result: %s using: %s MILLISECONDS and times: %s", result, Utils.getDateDiff(date1, new Date(), TimeUnit.MILLISECONDS), adder.sumThenReset());
		}
		
		public static void testNormalSearch() {
			int capacity = 100000000;
			int[] inputArr = new int[capacity];
			for (int i = 0; i < capacity; i++) {
				inputArr[i] = i;
			}
			Date date1 = new Date();
			System.out.println("Start to search value");
			int result =  normalSearch(inputArr, 98999946);
			System.out.printf("End to search value with result: %s using %s", result, Utils.getDateDiff(date1, new Date(), TimeUnit.MILLISECONDS));
		}
}
