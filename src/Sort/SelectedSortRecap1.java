package Sort;

import Utils.Utils;

public class SelectedSortRecap1 {
    public void selectedSort(int[] arr) {
        int k;
        for (int i = 0; i < arr.length; i++) {
            k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr [j]) {
                    k = j;
                }
            }
            Utils.swapArray(arr, i, k);
        }
    }
}
