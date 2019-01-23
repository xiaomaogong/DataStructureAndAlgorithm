package Sort;

public class QuickSortRecap1 {
    public void quickSort(int[] arr, int low , int high) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int axis = arr[i];

        while (i < j) {

            //right
            while (i < j) {
                if (arr[j] > axis) {
                    j--;
                }
            }
            if (i < j) {
                //等价交换此时i所对应的值一定比要j大,i应该换成更小的值
                arr[i] = arr[j];
                i++;
            }

            //left
            while (i < j) {
                if (arr[i] < axis) {
                    i++;
                }
            }
            if (i < j) {
                //等价交换此时j所对应的值一定比要j大,j应该换成更大的值
                arr[j] = arr[i];
                j--;
            }
        }

        arr[i] = axis;

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}
