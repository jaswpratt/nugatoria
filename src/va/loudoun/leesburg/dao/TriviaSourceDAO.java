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

      public List getTriviaQuestions(String count, String category, String type, String difficulty) {
         StringBuffer otdbUrlGetRequest = new StringBuffer();
         otdbUrlGetRequest.append(opentdbUrl);
         otdbUrlGetRequest.append("?amount=" + count);
         otdbUrlGetRequest.append("&category=" + category);
         otdbUrlGetRequest.append("&difficulty=" + difficulty);
         otdbUrlGetRequest.append("&type=" + type);
         otdbUrlGetRequest.append("&encode=url3986");
         System.out.println(otdbUrlGetRequest.toString());
         String triviaJson = callOtdbUrl(otdbUrlGetRequest.toString());
         System.out.println(triviaJson);
         //triviaQuestionsList = new ArrayList<TriviaQuestion>();
         //TriviaQuestion triviaQuestion = new TriviaQuestion();

         return triviaQuestionsList;
      }

      private callOtdbUrl(String otdbUrl){
         UrlConnection urlConnection = new UrlConnection();
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
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
         } 
 
      }
   }
