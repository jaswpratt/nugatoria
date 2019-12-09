/**
 * 
 */
package va.loudoun.leesburg.model;

/**
 * @author Sabine
 *
 */
public class Response {

   public Response() {
      super();
   }
   
   private String code = null;
   private String result = null;;
   private String comment = null;
   
   /**
    * @return the code
    */
   public String getCode() {
      return code;
   }
   
   /**
    * @param code the code to set
    */
   public void setCode(String code) {
      this.code = code;
   }
   
   /**
    * @return the result
    */
   public String getResult() {
      return result;
   }
   
   /**
    * @param result the result to set
    */
   public void setResult(String result) {
      this.result = result;
   }
   
   /**
    * @return the comment
    */
   public String getComment() {
      return comment;
   }
   
   /**
    * @param comment the comment to set
    */
   public void setComment(String comment) {
      this.comment = comment;
   }
   
   @Override
   public String toString() {
      return "Response [code=" + code + 
            ", result=" + result + 
            ", comment=" + comment + 
            ", getCode()=" + getCode() + 
            ", getResult()=" + getResult() + 
            ", getComment()=" + getComment() + 
            ", getClass()=" + getClass() + 
            ", hashCode()=" + hashCode() + 
            ", toString()=" + super.toString() + "]";
   }
}
