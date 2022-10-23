
enum RecursiveSortingAlgos {
    INSERTION, BUBBLE, SELECTION, QUICKSORT, MERGESORT;

    protected int value;

    protected void ordinace() {
        this.value = ordinal();
    }

    public int[] sort(int[] arr) {
        switch (this) {
            case BUBBLE:
                bubbleSort(arr, arr.length);
                break;
            case INSERTION:
                insertionSort(arr, arr.length);
                break;
            case SELECTION:
                selectionSort(arr,arr.length,0);
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

    // sorce for recursive bubble sort
    // https://www.geeksforgeeks.org/recursive-bubble-sort/
    protected void bubbleSort(int arr[], int n) {
        if (n == 1)
            return;

        int count = 0;
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1]) {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                count = count + 1;
            }

        // Check if any recursion happens or not
        // If any recursion is not happen then return
        if (count == 0)
            return;

        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, n - 1);
    }

    // Source for recursive insertion sort
    // https://www.geeksforgeeks.org/recursive-insertion-sort/
    protected void insertionSort(int arr[], int n) {
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSort(arr, n - 1);

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n - 1];
        int j = n - 2;

        /*
         * Move elements of arr[0..i-1], that are
         * greater than key, to one position ahead
         * of their current position
         */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
    // recursive selection sort source
    //https://www.geeksforgeeks.org/recursive-selection-sort/
    protected void selectionSort(int a[], int n, int index) {
        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n - 1);

        // Swapping when index nd minimum index are not same
        if (k != index) {
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        selectionSort(a, n, index + 1);

    }

    private int minIndex(int a[], int i, int j) {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k]) ? i : k;
    }
}
