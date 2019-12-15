# Nugatoria is Nugatory - <em style="color:#660000;">(Under Developement)</em>
<em>Nugatoria is Nugatory</em> is a web application trivia question and answer game of little or no consequence. It allows players to chose:
  <ul>
    <li>A Trivia Category
    <li>The number questions to answer
    <li>Type of question - True/False, Multiple Choice
    <li>and Difficulty level
  </ul>

Once the player has selected the criteria for their game, the web app retrieves questions for the game from the <a href="https://opentdb.com/" target="_blank">Open Trivia Database</a> using their API. <br>
<em>Nugatoria</em> sends a <i><b>get</b></i> request to the <a href="https://opentdb.com/" target="_blank">Open Trivia Database</a> API with these 5 parameters:
    <ul>
      <li>amount
      <li>category
      <li>difficulty
      <li>type
      <li>encode
    </ul>
  
The <a href="https://opentdb.com/" target="_blank">Open Trivia Database</a> then responds with a json string back to the  <em>Nugatoria</em> web app. 
<em>Nugatoria</em> then processes the json string into a collection of questions and answers to be displayed one at a time in the browser for the player to answer. The web app keeps track of the players right and wrong answers and displays their quiz results when all questions have been answered. 

# Architecture Overview
<ol>
  <li>Platform/IDE
    <ul>
      <li>Java JDK 1.8</li>
      <li>Eclipse 2019-09</li>
    </ul>
  </li>
  <li>Servers
    <ul>
      <li>Apache Tomcat 8 - currently running locally as <tt>localhost:port#/nugatoria</tt></li>
      <li>nugatoria.war - created using Ant build.xml task <b>war</b></li>
    </ul>
  </li>
  <li>Data Source
    <ul>
      <li><a href="https://opentdb.com/" target="_blank">Open Trivia Database</a>
    </ul>
  </li>
</ol>
  
# Software
<ul>
  <li>Java libraries
    <ul>
       <li>javax.servlet-3.0.jar</li>
      <li><a href="https://github.com/google/gson">gson-2.8.6.jar</a></li>
    </ul>
  </li>
  <li>Javascript libraries
    <ul>
      <li><a href="https://getbootstrap.com/" target="_blank">bootstrap-4.4.1</a></li>
      <li><a href="https://jquery.com/" target="_blank">jQuery.3.4.1</a></li>
      <li><a href="https://jqueryui.com/" target="_blank">jquery-ui-1.12.1</a></li>
      <li><a href="http://www.jeasyui.com/" target="_blank">jquery-easyui-1.9.0</a></li>
      <li><a href="http://d3js.org/" target="_blank">d3.js &#183; Data-Driven Documents</a></li>
    </ul>
  </li>
</ul>

# Java Classes
<ul>
  <li>Controller
    <ul>
      <li><a href="https://github.com/jaswpratt/nugatoria/blob/master/src/va/loudoun/leesburg/controller/TriviaServlet.java">TriviaServlet.java</a></li>
    </ul>
  </li>
  
  
  <li>Model Objects
    <ul>
       <li><a href="https://github.com/jaswpratt/nugatoria/blob/master/src/va/loudoun/leesburg/model/Categories.java">Categories.java</a></li>
       <li><a href="https://github.com/jaswpratt/nugatoria/blob/master/src/va/loudoun/leesburg/model/Response.java">Response.java</a></li>
       <li><a href="https://github.com/jaswpratt/nugatoria/blob/master/src/va/loudoun/leesburg/model/TriviaParams.java">TriviaParams.java</a></li>
       <li><a href="https://github.com/jaswpratt/nugatoria/blob/master/src/va/loudoun/leesburg/model/TriviaQuestion.java">TriviaQuestion.java</a></li>
    </ul>
  </li>
  
  
  <li>Data Access Objects (DAO)
    <ul>
      <li><a href="https://github.com/jaswpratt/nugatoria/blob/master/src/va/loudoun/leesburg/dao/TriviaSourceDAO.java">TriviaSourceDAO.java</a></li>
    </ul>
  </li>
</ul>
  
