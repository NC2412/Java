import java.util.Scanner;

public class DescendingOrder {
   public static void selectionSortDescendTrace(int [] numbers, int numElements) {
      int temp = 0;
      int maxIndex = 0;
      int i = 0;
      int j = 0;
      int [] retArr = numbers;

      for (i = 0; i < numElements - 1; i++) {
    	 maxIndex = i;
    	 
         for (j = i+1; j < numElements; j++) {
        	 if (retArr[j] > retArr[maxIndex]) {
        		 // Setting the biggest value in the unsorted section to maxIndex.
        		 maxIndex = j;
        	 }
         }
         
         // Swapping values.
         temp = retArr[i];
         retArr[i] = retArr[maxIndex];
         retArr[maxIndex] = temp;
         
         for (int x = 0; x < numElements; x++) {
        	 // Printing values for each iteration of i.
        	 System.out.print(numbers[x] + " ");
         }
       
         System.out.println();
      }
   }
   
   
   public static void main(String[] args) {
	  Scanner scnr = new Scanner(System.in);
      
      int input = 0;
      int count = 0;
      int [] numbers = new int[10];
      
      while (count < 10) {
    	  input = scnr.nextInt();
    	  
    	  if (input == -1) {
    		  // Stopping the loop if input == -1
    		  break;
    	  }
    	  
    	  numbers[count] = input;
    	  count++;
      }
      
      selectionSortDescendTrace(numbers, count);
      
      scnr.close();
   }
}

