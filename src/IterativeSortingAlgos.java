import java.util.Arrays;

enum IterativeSortingAlgos {
	INSERTION, BUBBLE, SELECTION, QUICKSORT, MERGESORT;

	protected int value;
	

	protected void ordinace() {
		this.value = ordinal();
	}

	public int[] sort(int[] arr) {
		 int high = arr.length-1;
		 int low = 0;
		switch (this) {
			case BUBBLE:
				for (int i = 0; i < arr.length - 1; i++) {
					for (int f = 0; f < arr.length - 1; f++) {
						if (arr[f] > arr[f + 1]) {
							int temp = arr[f];
							arr[f] = arr[f + 1];
							arr[f + 1] = temp;
						}
					}
				}
				break;

			case INSERTION:
				for (int i = 1; i < arr.length; i++) {
					int numOfintrest = arr[i];
					int j = i - 1;
					while (j >= 0 && arr[j] > numOfintrest) {
						arr[j + 1] = arr[j];
						j--;
					}
					arr[j + 1] = numOfintrest;
				}
				break;

			case SELECTION:
				for (int i = 0; i < arr.length; i++) {
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[j] < arr[i]) {
							int temp = arr[j];
							arr[j] = arr[i];
							arr[i] = temp;
						}
					}
				}
				break;

			case MERGESORT:
				// source for iterative mergesort
				// https://www.techiedelight.com/iterative-merge-sort-algorithm-bottom-up/
				// sort array `A[]` using a temporary array `temp`
				int[] temp = Arrays.copyOf(arr, arr.length);

				// divide the array into blocks of size `m`
				// m = [1, 2, 4, 8, 16…]
				for (int m = 1; m <= high - low; m = 2 * m) {
					// for m = 1, i = 0, 2, 4, 6, 8 …
					// for m = 2, i = 0, 4, 8, 12 …
					// for m = 4, i = 0, 8, 16 …
					// …
					for (int i = low; i < high; i += 2 * m) {
						int from = i;
						int mid = i + m - 1;
						int to = Integer.min(i + 2 * m - 1, high);

						merge(arr, temp, from, mid, to);
					}
				}
				break; 

			case QUICKSORT:
			// Source for iterative quicksort
			// https://www.geeksforgeeks.org/iterative-quick-sort/
				int[] stack = new int[high - low + 1];
				// initialize top of stack
				int top = -1;
				// push initial values of l and h to stack
				stack[++top] = low;
				stack[++top] = high;
				// Keep popping from stack while is not empty
				while (top >= 0) {
					// Pop h and l
					high = stack[top--];
					low = stack[top--];
					// Set pivot element at its correct position
					// in sorted array
					int p = partition(arr, low, high);
					// If there are elements on left side of pivot,
					// then push left side to stack
					if (p - 1 > low) {
						stack[++top] = low;
						stack[++top] = p - 1;
					}
					// If there are elements on right side of pivot,
					// then push right side to stack
					if (p + 1 < high) {
						stack[++top] = p + 1;
						stack[++top] = high;
					}
				}
				break;

			default:
				break;
		}
		return arr;
	}

	public static String print(int[] numbers) {
		String arr = "[";
		for (int num : numbers) {
			arr += (" " + num);
		}
		arr += " ]";
		System.out.print(arr + "]");
		return arr;
	}

	// merge is a sub-fuction of mergesort.
	private static void merge(int[] A, int[] temp, int from, int mid, int to) {
		int k = from, i = from, j = mid + 1;

		// loop till no elements are left in the left and right runs
		while (i <= mid && j <= to) {
			if (A[i] < A[j]) {
				temp[k++] = A[i++];
			} else {
				temp[k++] = A[j++];
			}
		}

		// copy remaining elements
		while (i < A.length && i <= mid) {
			temp[k++] = A[i++];
		}

		/*
		 * no need to copy the second half (since the remaining items
		 * are already in their correct position in the temporary array)
		 */

		// copy back to the original array to reflect sorted order
		for (i = from; i <= to; i++) {
			A[i] = temp[i];
		}
	}
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
 
        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
		}
		int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
 
        return i + 1;
	}
}
