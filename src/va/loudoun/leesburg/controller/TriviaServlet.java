/**
 * 
 */
package va.loudoun.leesburg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sabine
 *
 */
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

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      TriviaSourceDAO triviaSourceDAO = new TriviaSourceDAO();
      String count = request.getParameter("count") != null ? request.getParameter("count") : "";
      String category = request.getParameter("category") != null ? request.getParameter("category") : "";
      String type = request.getParameter("type") != null ? request.getParameter("type") : "";
      String difficulty = request.getParameter("difficulty") != null ? request.getParameter("difficulty") : "";
      
      
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
