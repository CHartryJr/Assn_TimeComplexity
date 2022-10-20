
enum SortingAlgos {
	INSERTION, BUBBLE, SELECTION, QUICKSORT, MERGESORT;

	protected int value;

	protected void ordinace() {
		this.value = ordinal();
	}

	public int[] sort(int[] arr) {
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
				mergeSort(arr, 0, arr.length - 1);
				break;
			case QUICKSORT:
				quickSort(arr, 0, arr.length - 1);
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

	protected static void quickSort(int[] list, int low, int high) {
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
}

