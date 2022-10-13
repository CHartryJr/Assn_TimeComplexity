import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.Random;

public class TimeComplexity {
    private static final int MULTIPLIER = 10;
    private static final int MAX_INTERVALS = 4;
    private static int inputs = 1000000;
    
    public static void main(String[] args) {
        String location = FileSystems.getDefault().getPath("resultsForTime").toAbsolutePath().toString();
        String Message = "";
        long startTime;
        long endTime;
        for (int i = 0; i < MAX_INTERVALS; i++) {
            int[] sorted = createlist(true);
            int[] unsorted = createlist(false);
            for (SortingAlgos.sortNames x : SortingAlgos.sortNames.values()) {
                switch (x) {
                    case SELECTION:
                        break;
                    case INSERTION:
                        break;
                    case BUBBLE:
                        break;
                    case MERGESORT:
                        break;
                    case QUICKSORT:
                        break;
                }
            }
            inputs *= MULTIPLIER;
        }
    }

    protected static boolean writedToFile(String fileLocation, String message) {
        PrintWriter editor = null;
        try {
            editor = new PrintWriter(new BufferedWriter(new FileWriter(fileLocation, true)));
            editor.write(message);
            editor.close();
            return true;
        } catch (Exception e) {
            editor.close();
            e.printStackTrace();
        }
        return false;
    }

    private static int[] createlist(boolean sorted) {
        int[] arr = new int[inputs];
        if (sorted) {
            for (int i = 0; i < inputs; i++) {
                arr[i] = i;
            }
        } else {
            Random rand = new Random();
            for (int i = 0; i < inputs; i++) {
                arr[i] = rand.nextInt();
            }
        }
        return arr;
    }
}