package Sort;

import Utils.Utils;

public class SelectedSortHelper {
    /**
    Time： O（n*n）
     Space: O(1)
     */
    public void selectedSort(int[] arr) {
        int k;
        for (int i = 0; i < arr.length; i++) {
            //Presume the smallest value index is i for now
            k = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }

                Utils.swapArray(arr, k , i);
            }
        }
    }

    public void testSelectedSort() {
        int[] arr = new int[] {6, 2, 1, 0, 3, 2, 8 ,4};
        System.out.printf("Input:%s", Utils.getArrayString(arr));
        selectedSort(arr);
        System.out.printf("Otput:%s", Utils.getArrayString(arr));
    }

}
