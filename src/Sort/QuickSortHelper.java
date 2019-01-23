package Sort;

import Utils.Utils;

public class QuickSortHelper {
    //Time complexity: O(n * log n)
    //Space complexity: O(log n)
    public void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int i = low;
        int j = high;
        int axis = arr[i];

        //Make sure the point can scan the entire array using i and j
        //Since we have scanned the entire array, the time complexity would be O(n) at this point
        while (i < j) {
            //Right
            while (i < j && arr[j] > axis) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            //Left
            while (i < j && arr[i] < axis) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        arr[i] = axis;

        //Since using the binary scan, the time complexity would be O(log n)
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1 , high);
    }

    public void testQuickSort() {
        int[] arr = new int[] {2, 1, 1, 7, 9 ,8, 2 ,5, 6, 3};
        System.out.printf("Input:%s", Utils.getArrayString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.printf("Output:%s", Utils.getArrayString(arr));
    }
}
