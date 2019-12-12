/**
 * 
 */
package va.loudoun.leesburg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import va.loudoun.leesburg.dao.TriviaSourceDAO;
import va.loudoun.leesburg.model.TriviaParams;

/**
 * @author Sabine
 *
 */
@WebServlet(name = "trivia", urlPatterns = { "/trivia.do" }, loadOnStartup = 1)
public class TriviaServlet extends HttpServlet{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
    * Constructor
    */
   public TriviaServlet() { }
    
   public void init() throws ServletException {
      // Do required initialization
       
   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Entering TriviaServlet doPost()");
      TriviaSourceDAO triviaSourceDAO = new TriviaSourceDAO();
      TriviaParams triviaParams = new TriviaParams();
      String count = request.getParameter("count") != null ? request.getParameter("count") : "";
      String category = request.getParameter("category") != null ? request.getParameter("category") : "";
      String type = request.getParameter("type") != null ? request.getParameter("type") : "";
      String difficulty = request.getParameter("difficulty") != null ? request.getParameter("difficulty") : "";
      triviaParams.setAmount(count);
      triviaParams.setCategory(category);
      triviaParams.setType(type);
      triviaParams.setDifficulty(difficulty);
      triviaSourceDAO.getTriviaQuestions(triviaParams);
      
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();

   }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   public void destroy() {
      // do nothing for the moment.
   }
}
