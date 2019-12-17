/**
 * https://opentdb.com/api.php?amount=13&category=20&difficulty=medium&type=multiple&encode=url3986
 */
package va.loudoun.leesburg.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import com.google.gson.*;

import va.loudoun.leesburg.model.TriviaParams;
import va.loudoun.leesburg.model.TriviaQuestion;

/**
 * @author Sabine
 *
 */
public class TriviaSourceDAO {
   public static final String opentdbUrl = "https://opentdb.com/api.php";
   private List triviaQuestionsList = null;
   
   String triviaJsonTest = "{\"response_code\":0,\"results\":[{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"The%20Hippogriff%2C%20not%20to%20be%20confused%20with%20the%20Griffon%2C%20is%20a%20magical%20creature%20with%20the%20front%20half%20of%20an%20eagle%2C%20and%20the%20back%20half%20of%20what%3F\",\"correct_answer\":\"A%20Horse\",\"incorrect_answers\":[\"A%20Dragon\",\"A%20Tiger\",\"A%20Lion\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Who%20was%20the%20Roman%20god%20of%20fire%3F\",\"correct_answer\":\"Vulcan\",\"incorrect_answers\":[\"Apollo\",\"Jupiter\",\"Mercury\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Neptune%27s%20greek%20name%20was...\",\"correct_answer\":\"Poseidon\",\"incorrect_answers\":[\"Ares\",\"Zeus\",\"Apollo\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Hera%20is%20god%20of...\",\"correct_answer\":\"Marriage\",\"incorrect_answers\":[\"Agriculture\",\"Sea\",\"War\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which%20of%20the%20following%20Mesopotamian%20mythological%20figures%20was%20NOT%20a%20deity%3F\",\"correct_answer\":\"Enkidu\",\"incorrect_answers\":[\"Enki\",\"Enlil\",\"Enkimdu\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which%20of%20these%20Roman%20gods%20doesn%27t%20have%20a%20counterpart%20in%20Greek%20mythology%3F\",\"correct_answer\":\"Janus\",\"incorrect_answers\":[\"Vulcan\",\"Juno\",\"Mars\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In%20Greek%20Mythology%2C%20who%20killed%20Achilles%3F\",\"correct_answer\":\"Paris\",\"incorrect_answers\":[\"Hector\",\"Helen\",\"Pericles\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"A%20minotaur%20is%20half%20human%20half%20what%3F\",\"correct_answer\":\"Bull\",\"incorrect_answers\":[\"Cow\",\"Horse\",\"Eagle\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What%20is%20the%20name%20of%20the%20Greek%20god%20of%20blacksmiths%3F\",\"correct_answer\":\"Hephaestus\",\"incorrect_answers\":[\"Dyntos\",\"Vulcan\",\"Artagatus\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which%20of%20the%20following%20is%20not%20one%20of%20the%20Greek%20Fates%3F\",\"correct_answer\":\"Narcissus\",\"incorrect_answers\":[\"Clotho\",\"Atropos\",\"Lachesis\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In%20African%20mythology%2C%20Anansi%20is%20a%20trickster%20and%20storyteller%20who%20takes%20the%20shape%20of%20which%20animal%3F\",\"correct_answer\":\"Spider\",\"incorrect_answers\":[\"Wild%20dog\",\"Monkey\",\"Crocodile\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"The%20Maori%20hold%20that%20which%20island%20nation%20was%20founded%20by%20Kupe%2C%20who%20discovered%20it%20under%20a%20long%20white%20cloud%3F\",\"correct_answer\":\"New%20Zealand\",\"incorrect_answers\":[\"Vanuatu\",\"Fiji\",\"Hawaii\"]},{\"category\":\"Mythology\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"According%20to%20Japanese%20folklore%2C%20what%20is%20the%20favorite%20food%20of%20the%20Kappa.\",\"correct_answer\":\"Cucumbers\",\"incorrect_answers\":[\"Kabocha\",\"Nasu\",\"Soba\"]}]}";
   
   /**
    * 
    */
   public TriviaSourceDAO() { }

      public List getTriviaQuestions(TriviaParams triviaParams) {
         StringBuffer otdbUrlGetRequest = new StringBuffer();
         otdbUrlGetRequest.append(opentdbUrl);
         otdbUrlGetRequest.append("?amount=" + triviaParams.getAmount());
         otdbUrlGetRequest.append("&category=" + triviaParams.getCategory());
         otdbUrlGetRequest.append("&difficulty=" + triviaParams.getDifficulty());
         otdbUrlGetRequest.append("&type=" + triviaParams.getType());
         otdbUrlGetRequest.append("&encode=url3986");
         System.out.println(otdbUrlGetRequest.toString());
         //String triviaJson = callOtdbUrl(otdbUrlGetRequest.toString());
         //System.out.println(triviaJson);
         //triviaQuestionsList = new ArrayList<TriviaQuestion>();
         //TriviaQuestion triviaQuestion = new TriviaQuestion();
         
         Gson gson = new Gson();
         String triviaJsonResults = "{" + triviaJsonTest.substring(triviaJsonTest.indexOf("\"response_code\":0") + 17, triviaJsonTest.length() - 1);
         System.out.println("==+-+== " + triviaJsonResults);
        ArrayList triviaArrayList = new ArrayList();
        //triviaArrayList = gson.fromJson(triviaJsonResults, ArrayList.class);
         
         JsonObject jsonObject = gson.fromJson(triviaJsonTest, JsonObject.class);
         System.out.println(jsonObject.get("results"));
         
       System.out.println(triviaArrayList);
         return triviaQuestionsList;
      }

      private String callOtdbUrl(String otdbUrl){
         System.out.println("Entering callOtdbUrl()");
         URLConnection urlConnection = null;
         InputStreamReader in = null;
         StringBuilder sb = new StringBuilder();
         
         try {
            URL url = new URL(otdbUrl);
            urlConnection = url.openConnection();
         
          if (urlConnection != null){ 
             urlConnection.setReadTimeout(60 * 1000); 
         }
          
            System.out.println("---- Test == " + (urlConnection != null && urlConnection.getInputStream() != null));
         
           if (urlConnection != null && urlConnection.getInputStream() != null) { 
              in = new InputStreamReader(urlConnection.getInputStream(), Charset.defaultCharset()); 
              BufferedReader bufferedReader = new BufferedReader(in); 
              if (bufferedReader != null) { 
                 int cp; 
                 while ((cp = bufferedReader.read()) != -1) { 
                    sb.append((char) cp); 
                 }
                   bufferedReader.close(); 
                } 
           }
           in.close();
         } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL: "+ otdbUrl, e);
         }
         System.out.println("Exiting callOtdbUrl()");
         return sb.toString();
      }
   }
