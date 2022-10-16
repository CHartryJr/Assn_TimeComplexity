import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.Random;

public class TimeComplexity {
        private static final int MULTIPLIER = 10;
        private static final int MAX_INTERVALS = 5;
        private static int inputs = 10;

        public static void main(String[] args) {

                long startTime;
                long endTime;
                for (int j = 0; j < 10; j++) {

                        for (SortingAlgos.sortNames x : SortingAlgos.sortNames.values()) {
                                long averageU = 0;
                                long averageS = 0;
                                long averageD = 0;
                                String message = "";
                                String location = FileSystems.getDefault().getPath("resultsForTime").toAbsolutePath()
                                                .toString();

                                for (int i = 0; i < MAX_INTERVALS; i++) {
                                        int[] sorted = createlist(0);
                                        int[] unsorted = createlist(1);
                                        int[] duplicate = createlist(2);
                                        int[] reversed = createlist(3);

                                        switch (x) {
                                                case SELECTION:
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(unsorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Unsorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageU += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(sorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Sorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageS += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(duplicate);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Duplicate Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/SelectionSortTime.txt"
                                                                        : location;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(reversed);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Reversed Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/SelectionSortTime.txt"
                                                                        : location;
                                                        writedToFile((location), message);
                                                        break;

                                                case INSERTION:
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(unsorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Unsorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageU += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(sorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Sorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageS += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(duplicate);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Duplicate Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/InsertionSortTime.txt"
                                                                        : location;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(reversed);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Reversed Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/InsertionSortTime.txt"
                                                                        : location;
                                                        writedToFile((location), message);
                                                        break;

                                                case MERGESORT:
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(unsorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Unsorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageU += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(sorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Sorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageS += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(duplicate);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Duplicate Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/MergeSortTime.txt" : location;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(reversed);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Reversed Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/MergeSortTime.txt" : location;
                                                        writedToFile((location), message);
                                                        break;

                                                case BUBBLE:
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(unsorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Unsorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageU += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(sorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Sorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageS += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(duplicate);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Duplicate Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/BubbleSortTime.txt"
                                                                        : location;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(reversed);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Reversed Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/BubbleSortTime.txt"
                                                                        : location;
                                                        writedToFile((location), message);
                                                        break;

                                                case QUICKSORT:
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(unsorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Unsorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageU += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(sorted);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Sorted Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageS += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(duplicate);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Duplicate Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        startTime = System.nanoTime();
                                                        SortingAlgos.selectionSort(reversed);
                                                        endTime = System.nanoTime();
                                                        message += ("Time With Reversed Inputs:" + inputs
                                                                        + "\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                                                        message += ("second: " + (endTime - startTime) / 1000000000)
                                                                        + "\n";
                                                        message += ("minutes: "
                                                                        + ((endTime - startTime) / 1000000000) / 60)
                                                                        + "\n";
                                                        message += ("hours: "
                                                                        + (((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60)
                                                                        + "\n";
                                                        message += ("days: "
                                                                        + ((((endTime - startTime) / 1000000000) / 60)
                                                                                        / 60) / 24)
                                                                        + "\n\n";
                                                        averageD += endTime - startTime;
                                                        location = i == 0 ? location += "/QuickSortTime.txt" : location;
                                                        writedToFile((location), message);
                                                        break;
                                        }
                                }
                                message += ("\n\nAeverage Time  For Run:" + j + " Interval: " + inputs
                                                + "\n======================================================================\nSORTED::::\nSeconds: "
                                                + ((averageS / 1000000000) / MAX_INTERVALS));
                                message += "\n Minutes: " + ((averageS / 1000000000) / 60) / MAX_INTERVALS;
                                message += "\n Hours: " + (((averageS / 1000000000) / 60) / 60) / MAX_INTERVALS;
                                message += "\n Days: " + ((((averageS / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                                message += ("\nUNSORTED::::\nSeconds: " + ((averageU / 1000000000) / MAX_INTERVALS));
                                message += "\n Minutes: " + ((averageU / 1000000000) / 60) / MAX_INTERVALS;
                                message += "\n Hours: " + (((averageU / 1000000000) / 60) / 60) / MAX_INTERVALS;
                                message += "\n Days: " + ((((averageU / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                                message += ("\nDuplicate::::\nSeconds: " + ((averageU / 1000000000) / MAX_INTERVALS));
                                message += "\n Minutes: " + ((averageD / 1000000000) / 60) / MAX_INTERVALS;
                                message += "\n Hours: " + (((averageD / 1000000000) / 60) / 60) / MAX_INTERVALS;
                                message += "\n Days: " + ((((averageD / 1000000000) / 60) / 60) / 24) / MAX_INTERVALS;
                                message += "\n\n";
                                writedToFile(location, message);
                        }
                        inputs *= MULTIPLIER;
                }
        }

        protected static boolean writedToFile(String fileLocation, String message) {
                PrintWriter editor = null;
                try {
                        editor = new PrintWriter(new BufferedWriter(new FileWriter(fileLocation, true)));
                        editor.write(message);
                        editor.flush();
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
                if (cat != 3) {
                        for (int i = 0; i < inputs; i++) {
                                arr[i] = cat == 0 ? i : cat == 1 ? rand.nextInt() : 1;
                        }
                } else {
                        int[] temp = new int[inputs];
                        ;
                        for (int i = 0; i < inputs; i++) {
                                temp[i] = i;
                        }
                        for (int i = 0; i < temp.length; i++) {
                                if (i == 0)

                                        arr[i] = temp[(temp.length - 1) - i];
                        }
                }
                return arr;
        }
}