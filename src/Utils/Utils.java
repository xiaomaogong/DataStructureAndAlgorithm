package Utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}

	public static String getArrayString(int[] arr) {
		StringBuilder builder = new StringBuilder();
		for (Object o : arr) {
			builder.append(o).append(",");
		}

		return builder.toString();
	}

	public static void swapArray(int[] arr, int indexA, int indexB) {
		if (indexA < arr.length && indexB < arr.length) {
			int temp = arr[indexA];
			arr[indexA] = arr[indexB];
			arr[indexB] = temp;
		}
	}
}
