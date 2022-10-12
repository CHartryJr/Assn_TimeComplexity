import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class TimeComplexity {
    private static final  int MULTIPLIER = 10;
    private static int inputs = 1000000;
    private static int[] arr;

    public static void main(String[] args) {
        arr = new int[inputs] ;

    }

    protected static boolean writedToFile(String fileLocation, String message) {
        try {
            PrintWriter editor = new PrintWriter(new BufferedWriter(new FileWriter(fileLocation, true)));
            editor.write(message);
            editor.close();
            System.out.println("Data has been written to " + fileLocation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}