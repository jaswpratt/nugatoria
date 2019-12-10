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
		
		callOtdbUrl(otdbUrlGetRequest.toString());
		
		List triviaQuestionsList = new ArrayList<TriviaQuestion>();
		TriviaQuestion triviaQuestion = new TriviaQuestion();
		
		
		return triviaQuestionsList;
	}
	
	private callOtdbUrl(String otdbUrl){
		UrlConnection urlConnection = new UrlConnection():
	}
}
