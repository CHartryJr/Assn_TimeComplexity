import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.Random;

/**
 * @author Carl Hartry Jr W/contributation From Benjamin Strait
 * @CHartryJr
 * @Benjamin-Strait
 */

public class TimeComplexity {
        private static final int BASE = 10;
        private static final int MAX_INTERVALS = 10;
        private static final int POWER = 5;
        private static int inputs = 1000;
        // inputs * base^power = max input size
        public static void main(String[] args) {
                long startTime;
                long endTime;
                long time;
                for (int h = 0; h <= POWER; h++) {
                        long averageU = 0;
                        long averageS = 0;
                        long averageD = 0;
                        long averageR = 0;
                        String message = "";
                        
                        for (SortingAlgos.sortNames x : SortingAlgos.sortNames.values()) {
                                String location = FileSystems.getDefault().getPath("resultsForTime").toAbsolutePath()
                                        .toString();
                                for (int i = 0; i < MAX_INTERVALS; i++) {

                                        int[] sorted = createlist(0);
                                        int[] unsorted = createlist(1);
                                        int[] duplicate = createlist(2);
                                        int[] reversed = createlist(3);
                                        message += "\n>>>>>>>>>>>>>>>Iteration " + (i + 1) + " of input size " + inputs
                                                        + "<<<<<<<<<<<<<<<<<<<<\n";

                                        switch (x) {
                                                case SELECTION:
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(sorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Sorted");
                                                                averageS += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with sorted array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(unsorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Usorted");
                                                                averageU += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with unsorted array";
                                                        }
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(duplicate);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Duplicated");
                                                                averageD += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with Dupicated array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(reversed);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Reversed");
                                                                averageR += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " of Reversed array";
                                                        }

                                                        location = i == 0 ? location += "/SelectionSortTime.txt"
                                                                        : location;

                                                        writedToFile((location), message);
                                                        break;

                                                case INSERTION:
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.insertionSort(sorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Sorted");
                                                                averageS += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with sorted array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.insertionSort(unsorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Usorted");
                                                                averageU += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with unsorted array";
                                                        }
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.insertionSort(duplicate);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Duplicated");
                                                                averageD += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with Dupicated array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.insertionSort(reversed);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Reversed");
                                                                averageR += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " of Reversed array";
                                                        }
                                                        location = i == 0 ? location += "/InsertionSortTime.txt"
                                                                        : location;
                                                        writedToFile((location), message);

                                                        break;

                                                case MERGESORT:
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.mergeSort(sorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Sorted");
                                                                averageS += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with sorted array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.mergeSort(unsorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Usorted");
                                                                averageU += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with unsorted array";
                                                        }
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.mergeSort(duplicate);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Duplicated");
                                                                averageD += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with Dupicated array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.mergeSort(reversed);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Reversed");
                                                                averageR += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " of Reversed array";
                                                        }

                                                        location = i == 0 ? location += "/MergeSortTime.txt" : location;
                                                        writedToFile((location), message);
                                                        break;

                                                case BUBBLE:
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.bubbleSort(sorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Sorted");
                                                                averageS += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with sorted array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.bubbleSort(unsorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Usorted");
                                                                averageU += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with unsorted array";
                                                        }
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.bubbleSort(duplicate);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Duplicated");
                                                                averageD += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with Dupicated array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.bubbleSort(reversed);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Reversed");
                                                                averageR += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " of Reversed array";
                                                        }

                                                        location = i == 0 ? location += "/BubbleSortTime.txt"
                                                                        : location;
                                                        writedToFile((location), message);
                                                        break;

                                                case QUICKSORT:
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(sorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Sorted");
                                                                averageS += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with sorted array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(unsorted);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Usorted");
                                                                averageU += time;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with unsorted array";
                                                        }
                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(duplicate);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Duplicated");
                                                                averageD += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " with Dupicated array";
                                                        }

                                                        try {
                                                                startTime = System.nanoTime();
                                                                SortingAlgos.selectionSort(reversed);
                                                                endTime = System.nanoTime();
                                                                time = endTime - startTime;
                                                                message += appendTimeMessage(time, "Reversed");
                                                                averageR += endTime - startTime;
                                                        } catch (StackOverflowError e) {
                                                                message += "Could not preform with given data. Stack overflow occured with input size "
                                                                                + inputs + " of Reversed array";
                                                        }
                                                        location = i == 0 ? location += "/QuickSortTime.txt" : location;
                                                        writedToFile((location), message);

                                                        break;
                                        }
                                        message = "";
                                }
                                message += appendAveMessage(message, averageS, averageU, averageD, averageR);
                                writedToFile(location, message);
                                message="";
                        }
                        inputs *= BASE;
                }
                System.out.println("Completed");
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

        private static int[] createlist(int cat) {
                int[] arr = new int[inputs];
                Random rand = new Random();
                if (cat < 3) {
                        for (int i = 0; i < inputs; i++) {
                                arr[i] = cat == 0 ? i : cat == 1 ? (rand.nextInt(inputs - 4) + 4) : cat== 2? 1:1;
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

        private static String appendTimeMessage(long time, String arrName) {
                String message ="";
                message += ("Time With" + arrName + " Inputs:" + inputs
                                + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                
                message += ("nanoseconds: " + (time))
                                + "\n";

                message += ("seconds: " + (time) / 1000000000)
                                + "\n";

                message += ("minutes: "
                                + ((time) / 1000000000) / 60)
                                + "\n";

                message += ("hours: "
                                + (((time) / 1000000000) / 60)
                                                / 60)
                                + "\n";
                message += ("days: "
                                + ((((time) / 1000000000) / 60)
                                                / 60) / 24)
                                + "\n\n";

                return message;
        }

        private static String appendAveMessage(String message, long averageS, long averageU, long averageD,
                        long averageR) {
                message += ("\nAeverage Time For Input: " + inputs
                                + "\n======================================================================\nSORTED::::\nNanoseconds: "
                                + (averageS / MAX_INTERVALS));
                message += "\n Seconds: " + ((averageS / 1000000000)) / MAX_INTERVALS;
                message += "\n Minutes: " + ((averageS / 1000000000) / 60) / MAX_INTERVALS;
                message += "\n Hours: " + (((averageS / 1000000000) / 60) / 60) / MAX_INTERVALS;
                message += "\n Days: "
                                + ((((averageS / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                message += ("\nUNSORTED::::\nNanoseconds: "
                                + ((averageU / MAX_INTERVALS)));
                message += "\n Seconds"+((averageU / 1000000000) / MAX_INTERVALS);
                message += "\n Minutes: " + ((averageU / 1000000000) / 60) / MAX_INTERVALS;
                message += "\n Hours: " + (((averageU / 1000000000) / 60) / 60) / MAX_INTERVALS;
                message += "\n Days: "
                                + ((((averageU / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                message += ("\nDuplicate::::\nNanoseconds: "
                                + (averageD));
                message += "\n Seconds: " + ((averageD / 1000000000)) / MAX_INTERVALS;
                message += "\n Minutes: " + ((averageD / 1000000000) / 60) / MAX_INTERVALS;
                message += "\n Hours: " + (((averageD / 1000000000) / 60) / 60) / MAX_INTERVALS;
                message += "\n Days: "
                                + ((((averageD / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                message += ("\nReversed::::\nNanoseconds: "
                                + (averageR / MAX_INTERVALS));
                message += "\n Minutes: " + ((averageR / 1000000000)) / MAX_INTERVALS;
                message += "\n Minutes: " + ((averageR / 1000000000) / 60) / MAX_INTERVALS;
                message += "\n Hours: " + (((averageR / 1000000000) / 60) / 60) / MAX_INTERVALS;
                message += "\n Days: "
                                + ((((averageR / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                message += "\n\n";
                return message;
        }

}