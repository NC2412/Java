import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PlantArrayListExample {

	public static void PrintArrayList(ArrayList<Plant> garden) {
		for (Plant p : garden) {
			p.printInfo();
			System.out.println();
		}
	}
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String input;
      ArrayList<Plant> myGarden = new ArrayList<Plant>();
      
      String plantName, plantCost, colorOfFlowers;
      boolean isAnnual;
      
      input = scnr.next();
      while(!input.equals("-1")) {
    	  
    	 StringTokenizer st = new StringTokenizer(scnr.nextLine());
    	 
    	 plantName = st.nextToken();
    	 plantCost = st.nextToken();
    	 
    	 if (input.toLowerCase().equals("plant")) {
    		 // plant
    		 Plant p = new Plant();
    		 
    		 p.setPlantName(plantName);
    		 p.setPlantCost(plantCost);
    		 
    		 myGarden.add(p);
    	 }
    	 else if (input.toLowerCase().equals("flower")) {
    		 // flower
    		 Flower f = new Flower();
    		 
    		 isAnnual = st.nextToken().toLowerCase().equals("true") ? true : false;
    		 colorOfFlowers = st.nextToken();
    		 
    		 f.setPlantName(plantName);
    		 f.setPlantCost(plantCost);
    		 f.setColorOfFlowers(colorOfFlowers);
    		 f.setPlantType(isAnnual);
    		 
    		 myGarden.add(f);
    	 }
      
         input = scnr.next();
      }

      PrintArrayList(myGarden);
      
      scnr.close();
   }
}
