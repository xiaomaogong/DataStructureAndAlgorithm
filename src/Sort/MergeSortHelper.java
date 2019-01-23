package Sort;

import Utils.Utils;

public class MergeSortHelper {
    /*
    Time complexity: O(n), 等于A和B的长度,呈正相关
     */
    public int[] mergeSortedArray(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int sizeA = a.length;
        int sizeB = b.length;
        int[] resultArr = new int[sizeA+sizeB];

        while (i < sizeA && j < sizeB) {
            if (a[i] <= b[j]) {
                resultArr[k++] = a[i++];
            }else {
                resultArr[k++] = b[j++];
            }
        }

        while (i < sizeA) {
            resultArr[k++] = a[i++];
        }

        while (j < sizeB) {
            resultArr[k++] = b[j++];
        }

        return  resultArr;
    }

    public void testMergeArray() {
        int[] a = new int[] {1, 3,6,8};
        int[] b = new int[] {-1, 0,2,8,9};
        int[] result = mergeSortedArray(a, b);
        System.out.printf("Merged sort array: %s", Utils.getArrayString(result));
    }
}
