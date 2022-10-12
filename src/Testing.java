import java.nio.file.FileSystems;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Testing {
    private  static int[] arr;
    String correct;
    
    /**
     * 
     */
    @BeforeEach
    public void initEach(){
        arr = new int[] { 7, 9, 0, 4, 1, 23 };
        correct = "[ 0 1 4 7 9 23 ]";
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
        String location  = FileSystems.getDefault().getPath("user.dir").toAbsolutePath().toString()+("/" + "WrittingrTest.txt");
        Assert.assertTrue(TimeComplexity.writedToFile(location,correct));
       Assert.assertTrue(TimeComplexity.writedToFile(location,"this is the testing page ignore"));
    } 

}
