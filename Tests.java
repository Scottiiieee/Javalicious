import org.junit.Assert;


import static org.junit.Assert.*;


import org.junit.Before;

import org.junit.Test;


public class SentimentUtilsTest {


   Review[] testReviews = new Review[4];
 // Make space for four reviews
                             
   /** 
    * Set up the array of reviews so that it is available 
    * for any testing method.  This happens before each testing
    * method is called.  Even if a testing method changes the 
    * contents of reviews, the next method will get a clean copy.
    * (The array created here only includes one review.  You'll
    * want a more complete example.)
    */
   @Before public void setUp() {

      
      // Create the first review...
      String[] reviewText1 = {"The", "movie", "is", "rotten"};
      testReviews[0] = new Review(1, reviewText1);
      String[] reviewText2 = {"Sleek", "and", "Arty"};
      testReviews[1] = new Review(3, reviewText2);
      String[] reviewText3 = {"Stale", "and", "Uninspired"};
      testReviews[2] = new Review(1, reviewText3);
      String[] reviewText4 = {"This", "is", "a", "superior", "horror", "flick"};
      testReviews[3] = new Review(4, reviewText4);

      
      SentimentAnalyzer sa1 = new SentimentAnalyzer(testReviews);
      SentimentAnalyzer sa2 = new SentimentAnalyzer("movieReviews.txt");
   }

   /**
   * Method to test addReview method of SentimentAnalyzer Class that adds a review in the ArrayList
   *
   */

   @Test
   public void addReviewTest(){
      int expected = 0;
      SentimentAnalyzer sa = new SentimentAnalyzer();
      result = sa.reviews1.size();
      assertEquals(expected, result);
      expected = 1;
      sa.addReview(testReviews[0]);
      result = sa.reviews1.size();
      assertEquals(expected, result);
   }
   
   /**
   * Method to test getReviews method of SentimentAnalyzer Class that returns an arrayList of reviews
   *
   */

   @Test
   public void getReviewsTest(){
      ArrayList<Review> expected = new ArrayList<Review>(Arrays.asList(testReviews));   
      ArrayList<Review> result = sa1.getReviews(testReviews); 
      assertEquals(expected, result);
   }   

   /**
   * Method to test toString method of SentimentAnalyzer Class that adds a tells how many reviews are there
   *
   */

   @Test
   public void toString() {
      String expected = "SentimentAnalyzer containing  reviews";
      String result = sa2.toString();
      assertEquals(expected, result);
   }   

   @Test
   public void containsWordTest() {
   
      
      boolean result;
 
         result = SentimentUtils.containsWord(testReviews[0], "the");
      
      assertTrue(result);

      result = SentimentUtils.containsWord(testReviews[0], "and");
      
      assertFalse(result);

   }

   @Test
   public void evaluateWordTest() {
   
      double expected;
      double result;
     
      result = SentimentUtils.evaluateWord(testReviews, "this");
      expected = 4.00;
      assertEquals(expected, result, 0.01);


   }
   
      @Test
   public void evaluateWordTest2() {
   
      double expected;
      double result;
     
      result = SentimentUtils.evaluateWord(testReviews, "alkdsjfla");
      expected = 2.0;
      assertEquals(expected, result, 0.01);


   }

   @Test
   public void evaluateTextTest() {
   
      double expected;
      double result;
      String[] word = {"This", "is", "stale"};
      result = SentimentUtils.evaluateText(testReviews, word);
      expected = 2.50;
      assertEquals(expected, result, 0.01);


   }
 @Test
   public void evaluateTextTest2() {
   
      double expected;
      double result;
      String[] word={};
      result = SentimentUtils.evaluateText(testReviews, word);
      expected = 2.0;
      System.out.println(expected);
      System.out.println(result);
      assertEquals(expected, result, 0.01);


   }   
    
}















\













\\\