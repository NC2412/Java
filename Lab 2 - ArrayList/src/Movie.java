/**
 *
 * @author Joseph Riva
 * @since 05/19/2020
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Movie {
    //the name of the movie
    private String name;
    //a list of the movies ratings
    private List<Integer> ratings;
    //length of the movie(in minutes)
    private int length;

    /** TODO Finish the constructor
     * The constructor should set the values of the class variables name and length to the parameters
     * name and length which are passed into the constructor
     * The constructor should also initialize the List<Integer> rating
     * @param name
     * @param length
     */
    public Movie(String name, int length){
        //CODE HERE
        ratings = new ArrayList<Integer>();
        this.name = name;
        this.length = length;
    }
    /** TODO Create getters/setters
     * Create getters and setters for ALL fields of this class.
     * Be sure to name them properly. For example, the getter for name
     * would be called getName() and the setter would be called setName()
     *
     * There should be a getter/setter for name, ratings and length
     */
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getLength() {
    	return length;
    }
    public void setLength(int length) {
    	this.length = length;
    }
    
    public List<Integer> getRatings() {
    	return ratings;
    }
    public void setRatings(ArrayList<Integer> ratings) {
    	this.ratings = ratings;
    }

    // @param rating - a rating which should be between 0 and 5
    public void addRating(int rating){
    	if (0 <= rating && rating <= 5) {
    		ratings.add(rating);
    	}
    }

    public double getAverageRating(){
        double sum = 0;
        
        for (Integer i : ratings) {
        	sum += i;
        }
        
        return sum / ratings.size();
    }

    @Override
    public String toString() {
        return String.format("Movie Name: %s, Movie Length(in minutes): %d", name, length);
    }

    public static void main(String[] args){
        Movie nemo = new Movie("Finding Nemo", 100);
        System.out.println("Constructor Check: " + nemo);
        Random r = new Random(5192020);
        //adds one hundred random ratings to the list for nemo
        for(int i = 0; i < 100; i++){
            //gives us a number between 0 and 5
            int rating = r.nextInt(6);
            nemo.addRating(rating);
        }
        System.out.printf("Average Rating: %.2f" , nemo.getAverageRating());
    }
}
