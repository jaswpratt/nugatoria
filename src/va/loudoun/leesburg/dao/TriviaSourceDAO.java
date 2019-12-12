/**
 * 
 */
package va.loudoun.leesburg.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import va.loudoun.leesburg.model.TriviaParams;
import va.loudoun.leesburg.model.TriviaQuestion;

/**
 * @author Sabine
 *
 */
public class TriviaSourceDAO {
   public static final String opentdbUrl = "https://opentdb.com/api.php";
   private List triviaQuestionsList = null;
   
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
         String triviaJson = callOtdbUrl(otdbUrlGetRequest.toString());
         System.out.println(triviaJson);
         //triviaQuestionsList = new ArrayList<TriviaQuestion>();
         //TriviaQuestion triviaQuestion = new TriviaQuestion();

         return triviaQuestionsList;
      }

      private String callOtdbUrl(String otdbUrl){
         URLConnection urlConnection = null;
         InputStreamReader in = null;
         StringBuilder sb = new StringBuilder();
         try {
            URL url = new URL(otdbUrl);
            urlConnection = url.openConnection();
            if (urlConnection != null){
               urlConnection.setReadTimeout(60 * 1000);
            }
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
            throw new RuntimeException("Exception while calling URL:", e);
         } 
         return null;
      }
   }
