import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

   // TODO: Write method to create and output all permutations of the list of names.
   public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
	   
	   ArrayList<String> tempNames = nameList;
	
	   if (tempNames.size() < 1) {
		   for (String s : permList) {
			   System.out.print(s + " ");
		   }
		   System.out.println();
	   }
	   else {
		   for (int i = 0; i < nameList.size(); i++) {
			   permList.add(nameList.get(i));
			   tempNames = removeIndex(nameList, i);
			   
			   allPermutations(permList, tempNames);
			   
			   permList.remove(permList.size()-1);
		   }		   
	   }
   }
   
   public static ArrayList<String> removeIndex(ArrayList<String> list, int index) {
	   ArrayList<String> tempList = new ArrayList<String>();
	   
	   for (int i = 0; i < list.size(); i++) {
		   if (i != index) {
			   tempList.add(list.get(i));
		   }
	   }
	   
	   return tempList;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;
      
      // TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
      name = scnr.next();
      while(!name.equals("-1")) {
    	  nameList.add(name);
    	  name = scnr.next();
      }

      allPermutations(permList, nameList);
      
      scnr.close();
   }
}
