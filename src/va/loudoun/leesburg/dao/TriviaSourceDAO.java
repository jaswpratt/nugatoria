/**
 * 
 */
package va.loudoun.leesburg.dao;

import java.util.ArrayList;
import java.util.List;

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
		otdbUrlGetRequest.append("&type=" + type);&encode=url3986
	        otdbUrlGetRequest.append("&encode=url3986");
		List triviaQuestionsList = new ArrayList<TriviaQuestion>();
		TriviaQuestion triviaQuestion = new TriviaQuestion();
		
		
		return triviaQuestionsList;
	}
}
