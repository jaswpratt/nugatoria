# nugatoria
<em>Nugatoria is Nugatory</em> is a web application trivia question and answer game. It allows players to chose:
  <ul>
    <li>A Trivia Category
    <li>The number questions to answer
    <li>Type of question - True/False, Multiple Choice
    <li>and Difficulty level
  </ul>

Once the player has selected the criteria for their game, the web app retrieves questions for the game from the <a href="https://opentdb.com/" target="_blank">Open Trivia Database</a> using their API. <br>
<em>Nugatoria</em> sends a <i><b>get</b></i> request to <a href="https://opentdb.com/" target="_blank">Open Trivia Database</a> with these 5 parameters:
    <ul>
      <li>amount
      <li>category
      <li>difficulty
      <li>type
      <li>encode
    </ul>
  
The <a href="https://opentdb.com/" target="_blank">Open Trivia Database</a> then responds with a json string back to the  <em>Nugatoria</em> web app. 
<em>Nugatoria</em> then processes the json string into a collection of questions and answers to be displayed one at a time in the browser for the player to answer. The web app keeps track of the players right and wrong answers and displays their quiz results when all questions have been answered. 
