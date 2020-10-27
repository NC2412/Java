import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class PizzaSpectacular {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scnr = new Scanner(System.in);
    	ArrayList<Integer> prices = new ArrayList<Integer>();
    	
    	while (scnr.hasNext()) {
    		prices.add(scnr.nextInt());
    	}
    	
    	int budget = prices.get(prices.size() - 1);
    	prices.remove(prices.size() - 1);
    	
    	Collections.sort(prices);
    	
    	System.out.println(getMaxPrice(prices, budget));
    }
    
    public static int getMaxPrice(ArrayList<Integer> arr, int max) {
    	int retAmount = 0;
    	int curAmount = 0;
    	
    	for (int i = 0; i < arr.size(); i++) {
    		curAmount = arr.get(i);
    		
    		for (int j = arr.size() - 1; j >= 0; j--) {
    			if (i == j)
    				continue;
    			
    			if (curAmount + arr.get(j) <= max)
    				curAmount += arr.get(j);
    		}
    		
    		if (curAmount > retAmount)
    			retAmount = curAmount;
    	}
    	
    	return retAmount;
    }
}