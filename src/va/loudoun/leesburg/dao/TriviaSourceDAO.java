/**
 * Example URL returns json string:
 * http://opentdb.com/api.php?amount=13&category=20&difficulty=medium&type=multiple&encode=url3986
 */
package va.loudoun.leesburg.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;

import va.loudoun.leesburg.model.TriviaParams;
import va.loudoun.leesburg.model.TriviaQuestion;

/**
 * @author Sabine
 *
 */
public class TriviaSourceDAO {
   public static final String opentdbUrl = "https://opentdb.com/api.php";
   public static final int OTDB_RESPONSE_SUCCESS = 0;
   
   /**
    * 
    */
   public TriviaSourceDAO() { }

      public List<TriviaQuestion> getTriviaQuestions(TriviaParams triviaParams) {
         JSONObject jsonObject = new JSONObject();
         JSONArray otdbJsonArray = new JSONArray();
         Long openTDBResponse = (long) -1;
         StringBuffer otdbUrlGetRequest = new StringBuffer();
         ArrayList<TriviaQuestion> triviaArrayList = new ArrayList<TriviaQuestion>();
         
         otdbUrlGetRequest.append(opentdbUrl);
         otdbUrlGetRequest.append("?amount=" + triviaParams.getAmount());
         otdbUrlGetRequest.append("&category=" + triviaParams.getCategory());
         otdbUrlGetRequest.append("&difficulty=" + triviaParams.getDifficulty());
         otdbUrlGetRequest.append("&type=" + triviaParams.getType());
         //otdbUrlGetRequest.append("&encode=url3986");
         
      System.out.println(otdbUrlGetRequest.toString());
         String triviaJson = callOtdbUrl(otdbUrlGetRequest.toString());
         
      System.out.println("- - - - \n" + triviaJson);
         
         jsonObject = new JSONObject();
         otdbJsonArray = new JSONArray();
            
         jsonObject = (JSONObject)JSONValue.parse(triviaJson);
         openTDBResponse =  (Long) jsonObject.get("response_code");
         otdbJsonArray = (JSONArray) jsonObject.get("results");
         System.out.println("otdbJsonArray response code ++++  " + openTDBResponse + "\n");
         System.out.println("otdbJsonArray ++++\n" + otdbJsonArray);
         
         if(openTDBResponse == OTDB_RESPONSE_SUCCESS) {
            triviaArrayList = createTriviaArrayList(otdbJsonArray);
         } 

         return triviaArrayList;
      }

      private String callOtdbUrl(String otdbUrl){
         System.out.println("Entering callOtdbUrl()");
         URLConnection urlConnection = null;
         InputStreamReader in = null;
         StringBuilder sb = new StringBuilder();
         
         try {
            URL url = new URL(otdbUrl);
            urlConnection = url.openConnection();
            urlConnection.connect();

            if (!urlConnection.equals(null)){ 
               urlConnection.setReadTimeout(60 * 1000); 
            }
            
            Map<String, List<String>> map = urlConnection.getHeaderFields();
            
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
              System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            System.out.println("Get Header by key:");
            String serverResponseStatus = urlConnection.getHeaderField(urlConnection.getHeaderField(null));

            if (serverResponseStatus == null) {
              System.out.println("Key 'Status' is not found!");
            } else {
              System.out.println("Server Response Status: " + serverResponseStatus);
            }
            
            
            System.out.println("---- Fest == " + (urlConnection != null && urlConnection.getInputStream() != null));
         
          if (urlConnection != null && !urlConnection.getInputStream().equals(null)) { 
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
      
      @SuppressWarnings("unchecked")
      private ArrayList<TriviaQuestion> createTriviaArrayList(JSONArray otdbJsonArray) {
         ArrayList<TriviaQuestion> otdbArrayList = new ArrayList<TriviaQuestion>();
         
         Iterator<JSONObject> iterator = otdbJsonArray.iterator();
         while(iterator.hasNext()) {
            TriviaQuestion triviaQuestion = new TriviaQuestion();
            JSONObject questionJsonObj = (JSONObject) iterator.next();
            triviaQuestion.setDifficulty((String) questionJsonObj.get("difficulty"));
            triviaQuestion.setCategory((String) questionJsonObj.get("category"));
            triviaQuestion.setCorrectAnswer((String) questionJsonObj.get("correct_answer"));
            triviaQuestion.setQuestion((String) questionJsonObj.get("question"));
            triviaQuestion.setType((String) questionJsonObj.get("type"));
            triviaQuestion.setIncorrectAnswers((JSONArray) questionJsonObj.get("incorrect_answers"));
            System.out.println("=-=-= " + triviaQuestion.getIncorrectAnswers());
            otdbArrayList.add(triviaQuestion);
          }
         
          return otdbArrayList;
      }
   }
