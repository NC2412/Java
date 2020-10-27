import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
	
	// The first line contains an integer n, the number of pages in the book.
	// The second line contains an integer, p, the page to turn to.
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
    	int frontCount = p / 2;
    	int backCount = (n - p) / 2;
    	
    	if (n > 100000 || p <= 0 || p > n)
    		return -1;
    	
    	return frontCount <= backCount ? frontCount : backCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
