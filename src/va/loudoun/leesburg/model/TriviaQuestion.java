/**
 * 
 */
package va.loudoun.leesburg.model;

import java.util.ArrayList;

/**
 * @author Sabine
 *
 */
public class TriviaQuestion {

   /**
    * 
    */
   public TriviaQuestion() { }
   
   private String category = null;
   private String type = null;
   private String difficulty = null;
   private String question = null;
   private String correctAnswer = null;
   private ArrayList<String> incorrectAnswers = null;
   
   /**
    * @return the category
    */
   public String getCategory() {
      return category;
   }
   
   /**
    * @param category the category to set
    */
   public void setCategory(String category) {
      this.category = category;
   }
   
   /**
    * @return the type
    */
   public String getType() {
      return type;
   }
   
   /**
    * @param type the type to set
    */
   public void setType(String type) {
      this.type = type;
   }
   
   /**
    * @return the difficulty
    */
   public String getDifficulty() {
      return difficulty;
   }
   
   /**
    * @param difficulty the difficulty to set
    */
   public void setDifficulty(String difficulty) {
      this.difficulty = difficulty;
   }
   
   /**
    * @return the question
    */
   public String getQuestion() {
      return question;
   }
   
   /**
    * @param question the question to set
    */
   public void setQuestion(String question) {
      this.question = question;
   }
   
   /**
    * @return the correctAnswer
    */
   public String getCorrectAnswer() {
      return correctAnswer;
   }
   
   /**
    * @param correctAnswer the correctAnswer to set
    */
   public void setCorrectAnswer(String correctAnswer) {
      this.correctAnswer = correctAnswer;
   }
   
   /**
    * @return the incorrectAnswers
    */
   public ArrayList<String> getIncorrectAnswers() {
      return incorrectAnswers;
   }
   
   /**
    * @param incorrectAnswers the incorrectAnswers to set
    */
   public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
      this.incorrectAnswers = incorrectAnswers;
   }
   
   

}
