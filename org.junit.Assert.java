import java.util.*;
/**
 * 
 */
public class SentimentAnalyzer {
    

    static double DEFAULT_SCORE = 2.0;
	ArrayList<Review> reviews1 = new ArrayList<Review>(); 

	/**
	* Compares and check all words to be lowercase.
    *
    * @param review string word
    * @param word string
    * @return true if it contains
	 */
	
	private static boolean containsWord(Review review, String word) {
		 
	      String[] text = review.getText();
	      for (String t: text) {
	      
	         String[] test = t.split(" ");
	         
	         for (String r: test) {
	         
	            if (r.toLowerCase().compareTo(word.toLowerCase()) == 0) {
	               return true;
	            }
	         }  
	      }  
	      return false;
	      
	   }
	
    /**
	* Instantiates an object with empty arrayList
    *
    * 
    * 
	 */
	public SentimentAnalyzer() {
		this.reviews1 = new ArrayList<Review>();
	}

	/**
	 * Instatntiates Class with the array of objects passed
	 * @parm reviews Array of Review objects
	 */
	public SentimentAnalyzer(Review[] reviews) {
		// TODO Auto-generated constructor stub
		this.reviews1 = new ArrayList<Review>(Arrays.asList(reviews)); 
	}
	

	/**
	 * Instatntiates Class with the arrayList of objects of Review
	 * @parm filename String name  
	 */
	public SentimentAnalyzer(String fileName) {
		// TODO Auto-generated constructor stub
		this.reviews1 = new ArrayList<Review>(Arrays.asList(ReviewLoader.loadReviews(fileName));
	}

	/**
	 * Adds new review to the arrayList
	 * @parm newReview review object of class Review
	 */

	public void addReview(Review newReview){
		this.reviews1.add(newReview);
	}
	
	/**
	 * Returns arrayList of Reviews
	 * @return newList
	 */

	public ArrayList<Review> getReviews(){
		ArrayList<Review> newList = new ArrayList<Review>();
		newList = this.reviews1;
		return newList;
	}
    
    /**
	 * Returns string with the number of reviews in the class
	 * @return str 
	 */

	public String toString() {
       String str = "SentimentAnalyzer containing ";
       str = str + reviews1.size();
       str = str + " reviews";
       return str;
       
 	}
	
	
	   
	   /**
	    *
	    * The method start exectution.
	    *
	    * @param reviews Sring word
	    * @param word review
	    * @return score
	    *
	    **/

	   public static double evaluateWord( Review[] reviews, String word) {
	      int count = 0;
	      double score = 0.0;
	      for (Review x : reviews) {
	         if (containsWord(x, word)) {       
	            count++;
	            score = score + x.getScore();
	         }
	          
	      }
	      if (count == 0) {
	         return DEFAULT_SCORE;
	      } else {
	         score = score / count;
	         return score;
	      }
	      
	   }
	   
	   /**
	    *
	    * @param reviews string text
	    * @param text review string
	    * @return DEFAULT_SCORE if it's equal to 0
	    *
	    **/

	   public static double evaluateText(Review[] reviews, String[] text) {
	      int count = 0;
	      double score = 0.0;
	      double totScore = 0.0;
	     
	      if (text.length == 0) {
	         return DEFAULT_SCORE;  
	      }
	      
	      for (int i = 0; i < text.length; i++) { 

	         score = evaluateWord(reviews, text[i]);     
	         totScore = totScore + score;
	      }
	      totScore = totScore / text.length;
	      return totScore;   
	      
	   }
}
