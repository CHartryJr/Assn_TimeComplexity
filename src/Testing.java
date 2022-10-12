import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Testing {
    private final int  NUM = 10;
    private  int[] arr;
    private String correct ="[";
    
    /**
     * 
     */
    @BeforeEach
    public void initEach(){
        Random rand = new Random();
        int limit = rand.nextInt((NUM -3))+3;
        ArrayList <Integer>converter = new ArrayList<Integer>();
        arr = new int[limit] ;
        for(int i =0; i < limit; i++){
            int x = rand.nextInt(limit);
            converter.add(x);
            arr[i] = x;
        }
        Collections.sort(converter);
        for (Integer x : converter) {
            correct+= (" "+ x);
        }
        correct += " ]";
    }

    @Test
    public void mergeSortTest() {
        SortingAlgos.mergeSort(arr);
        Assert.assertEquals(correct,
        SortingAlgos.print(arr));
    }

    @Test
    public void quickSortTest() {
        SortingAlgos.quickSort(arr);
        Assert.assertEquals(correct,
        SortingAlgos.print(arr));
    }

    @Test
    public void inserstionSortTest() {
        SortingAlgos.insertionSort(arr);
        Assert.assertEquals(correct,
        SortingAlgos.print(arr));
    } 

    @Test
    public void selctionSortTest() {
        SortingAlgos.selectionSort(arr);
        Assert.assertEquals(correct,
        SortingAlgos.print(arr));
    } 

    @Test
    public void bubbleSortTest() {
        SortingAlgos.bubbleSort(arr);
        Assert.assertEquals(correct,
        SortingAlgos.print(arr));
        
    } 
    @Test
    public void writingTest() {
        String location  = FileSystems.getDefault().getPath("user.dir").toAbsolutePath().toString()+"/WrittingrTest.txt";
        Assert.assertTrue(TimeComplexity.writedToFile(location,correct));
       Assert.assertTrue(TimeComplexity.writedToFile(location,"this is the testing page ignore"));
    } 

}
