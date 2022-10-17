import java.nio.file.FileSystems;
import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Testing {
    private final static int  inputs = 1000;
    private  int[] sorted;
    private  int[] unsorted;
    private  int[] duplicate;
    private  int[] reverse;
    private String correct ="";
    
    /**
     * 
     */
    @BeforeEach
    public void initEach(){
        sorted = createlist(0);
        unsorted = createlist(1);
        duplicate = createlist(2);
        reverse = createlist(3);
        correct =SortingAlgos.print(sorted);
    }

    @Test
    public void mergeSortTest() {
        SortingAlgos.mergeSort(reverse);
        Assert.assertEquals(correct,
        SortingAlgos.print(sorted));
    }

    @Test
    public void quickSortTest() {
        SortingAlgos.quickSort(reverse);
        Assert.assertEquals(correct,
        SortingAlgos.print(sorted));
    }

    @Test
    public void inserstionSortTest() {
        SortingAlgos.insertionSort(reverse);
        Assert.assertEquals(correct,
        SortingAlgos.print(sorted));
    } 

    @Test
    public void selctionSortTest() {
        SortingAlgos.selectionSort(reverse);
        Assert.assertEquals(correct,
        SortingAlgos.print(sorted));
    } 

    @Test
    public void bubbleSortTest() {
        SortingAlgos.bubbleSort(reverse);
        Assert.assertEquals(correct,
        SortingAlgos.print(sorted));
    } 
    @Test
    public void writingTest() {
        String location  = FileSystems.getDefault().getPath("resultsForTime").toAbsolutePath().toString()+"/WrittingrTest2.txt";
        // for tha above line the file will be sent to the 
        // red hat app support workspace or whatever test support extention's 
        // workspace
        Assert.assertTrue(TimeComplexity.writedToFile(location,correct));
       Assert.assertTrue(TimeComplexity.writedToFile(location,"this is the testing page ignore"));
    } 
    private static int[] createlist(int cat) {
        int[] arr = new int[inputs];
        Random rand = new Random();
        if (cat != 3) {
                for (int i = 0; i < inputs; i++) {
                        arr[i] = cat == 0 ? i : cat == 1 ? rand.nextInt() : 1;
                }
        } else {
                int[] temp = new int[inputs];
                for (int i = 0; i < inputs; i++) {
                        temp[i] = i;
                }
                for (int i = 0; i < temp.length; i++) {
                        arr[i] = temp[(temp.length - 1) - i];
                }
        }
        return arr;
}
}
