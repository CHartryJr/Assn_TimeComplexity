
class SortingAlgos {
	enum sortNames {
		INSERTION, BUBBLE, SELECTION, QUICKSORT, MERGESORT
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
	//nlogn
	public  static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
//nlogn
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	protected  static void quickSort(int[] list, int low, int high) {
		if (list.length <= high) {
			System.out.print("\n");
			throw new IndexOutOfBoundsException("Index is out of bounds for high " + high);
		} else {
			if (low < high) {
				int partiion = partitioning(list, low, high);
				quickSort(list, low, partiion - 1);
				quickSort(list, partiion + 1, high);
			}
		}
	}

	private static int partitioning(int[] list, int first, int last) {
		int pivot = list[last];
		int i = first - 1;
		for (int j = first; j < last; j++) {
			if (list[j] <= pivot) {
				i++;
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		int temp = list[i + 1];
		list[i + 1] = list[last];
		list[last] = temp;
		return i + 1;
	}

	protected static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
		int midIndex;
		if (rightIndex > leftIndex) {
			midIndex = (leftIndex + rightIndex) / 2;
			mergeSort(arr, leftIndex, midIndex);
			mergeSort(arr, midIndex + 1, rightIndex);
			merge(arr, leftIndex, midIndex, rightIndex);
		}
	}

	// merge is a sub-fuction of mergesort.
	private static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
		int[] temp = new int[rightIndex - leftIndex + 1];
		int i = 0;
		int right = midIndex + 1;
		int left = leftIndex;

		while (left <= midIndex && right <= rightIndex) {
			if (arr[left] < arr[right]) {
				temp[i] = arr[left];
				left++;
			} else {
				temp[i] = arr[right];
				right++;
			}
			i++;
		}
		while (left <= midIndex) {
			temp[i] = arr[left];
			left++;
			i++;
		}
		while (right <= rightIndex) {
			temp[i] = arr[right];
			right++;
			i++;
		}
		//
		left = leftIndex;
		for (i = 0; i < temp.length; i++) {
			arr[left] = temp[i];
			left++;
		}
	}
//n^2
	public static void bubbleSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int f = 0; f < numbers.length - 1; f++) {
				if (numbers[f] > numbers[f + 1]) {
					int temp = numbers[f];
					numbers[f] = numbers[f + 1];
					numbers[f + 1] = temp;
				}
			}
		}
	}
//n^2
	public static void selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {

			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[i]) {
					int temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
	}
//n^2
	public static void insertionSort(int[] numbers) {
		int len = numbers.length;
		for (int i = 1; i < len; i++) {
			int numOfintrest = numbers[i];
			int j = i - 1;
			while (j >= 0 && numbers[j] > numOfintrest) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = numOfintrest;
		}
	}
}
