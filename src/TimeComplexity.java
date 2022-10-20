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
        private static String inputF = "";

        // inputs * base^power = max input size
        public static void main(String[] args) {
                long time;
                for (int h = 0; h <= POWER; h++) {
                        
                        String message = "";
                        inputF = String.format("%,d\n", inputs);
                        for (SortingAlgos x : SortingAlgos.values()) {
                        long averageU = 0;
                        long averageS = 0;
                        long averageD = 0;
                        long averageR = 0;
                                String location = FileSystems.getDefault().getPath("results").toAbsolutePath()
                                                .toString();
                                for (int i = 0; i < MAX_INTERVALS; i++) {

                                        int[] sorted = createlist(0);
                                        int[] unsorted = createlist(1);
                                        int[] duplicate = createlist(2);
                                        int[] reversed = createlist(3);
                                        message += "\n>>>>>>>>>>>>>Iteration " + (i + 1) + " of input size " + inputF
                                                        + "<<<<<<<<<<<<<<<<<<\n";
                                        time = getTime(x, sorted);
                                        message += time != -1 ? appendTimeMessage(time, "Sorted")
                                                        : "\nFailed with Sorted input " + inputF + "StackOverFlow\n";
                                        averageS += time;
                                        time = getTime(x, unsorted);
                                        message += time != -1 ? appendTimeMessage(time, "Unsorted")
                                                        : "\nFailed with Unsorted at input " + inputF + "StackOverFlow\n";
                                        averageU += time;
                                        time = getTime(x, duplicate);
                                        message += time != -1 ? appendTimeMessage(time, "Duplicated")
                                                        : "\nFailed with Duplicated input " + inputF + "StackOverFlow\n";
                                        averageD += time;
                                        time = getTime(x, reversed);
                                        message += time != -1 ? appendTimeMessage(time, "Reversed")
                                                        : "\nFailed with Reversed input " + inputF + "StackOverFlow\n";
                                        averageR += time;

                                        location = i == 0 ? location += "/" + x + "TimeResults.txt"
                                                        : location;
                                        writedToFile((location), message);
                                        message = "";
                                }

                                message += appendAveMessage(message, new long[]{averageS,averageU,averageD,averageR});
                                writedToFile(location, message);
                                message = "";
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
                                arr[i] = cat == 0 ? i : cat == 1 ? (rand.nextInt(inputs - 4) + 4) : cat == 2 ? 1 : 1;
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
                String message = "";
                String timeF = String.format("%,d", time);
                message += ("\nTime With " + arrName + " Inputs: " + inputF
                                + "VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
                timeF = String.format("%,d\n", time);
                message += ("nanoseconds: " + timeF + "\n");
                time /= 1000000000;
                timeF = String.format("%,d\n", time);
                message += ("seconds: " + timeF + "\n");
                time /= 60;
                timeF = String.format("%,d\n", time);
                message += ("minutes: " + timeF + "\n");
                time /= 60;
                timeF = String.format("%,d\n", time);
                message += ("hours: " + timeF + "\n");
                time /= 24;
                timeF = String.format("%,d\n", time);
                message += ("days: " + timeF + "\n\n");
                return message;
        }

        private static String appendAveMessage(String message, long [] averages) {
                int count = 0;
                message+=("\nAeverage Time For Input: " + inputF
                + "======================================================================\n");
                for(long x :averages){
                String type  = count ==0 ?"SORTED": count ==1?"UNSORTED":count==2?"Duplicated":count==3?"Reversed":"";
                long time = x / MAX_INTERVALS;
                String timeF = String.format("%,d\n", time);
                message += ("\n"+type+"::::\nNanoseconds: "+ timeF);
                time /= 1000000000;
                timeF = String.format("%,d\n", (time));
                message += "\n Seconds: " + timeF;
                time /= 60;
                timeF = String.format("%,d\n", (time));
                message += "\n Minutes: " + timeF;
                time /= 60;
                timeF = String.format("%,d\n", (time));
                message += "\n Hours: " + timeF;
                time /= 24;
                timeF = String.format("%,d\n", (time));
                message += "\n Days: "
                                + timeF;
                count ++;
                }
                return message;  
        }

        private static long getTime(SortingAlgos x, int[] arr) {
                long time = 0;
                try {
                        long startTime = System.nanoTime();
                        x.sort(arr);
                        long endTime = System.nanoTime();
                        time = endTime - startTime;
                } catch (StackOverflowError e) {
                        return -1;
                }
                return time;
        }
}