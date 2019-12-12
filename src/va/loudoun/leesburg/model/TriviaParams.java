/**
 * 
 */
package va.loudoun.leesburg.model;

/**
 * @author Sabine
 *
 */
public class TriviaParams {

   /**
    * 
    */
   public TriviaParams() { }
   
   private String amount = null;
   private String category = null;
   private String difficulty = null;
   private String type = null;
   private String encoding = null;
   
   /**
    * @return the amount
    */
   public String getAmount() {
      return amount;
   }
   
   /**
    * @param count the amount to set
    */
   public void setAmount(String count) {
      this.amount = count;
   }
   
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
    * @return the encoding
    */
   public String getEncoding() {
      return encoding;
   }

   /**
    * @param encoding the encoding to set
    */
   public void setEncoding(String encoding) {
      this.encoding = encoding;
   }

   @Override
   public String toString() {
      return "TriviaParams [amount=" + amount + 
         ", category=" + category + 
         ", difficulty=" + difficulty + 
         ", type=" + type + 
         ", encoding=" + encoding + "]";
   }
}
