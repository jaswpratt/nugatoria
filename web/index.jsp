<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <link rel="stylesheet" type="text/css" href="css/nugatoria.css"></link>
      <link rel="stylesheet" type="text/css" href="jsLib/jquery-easyui-1.9.0/themes/default/easyui.css"></link>
      <link rel="stylesheet" type="text/css" href="jsLib/bootstrap-4.4.1/css/bootstrap.css"></link>
      <script type="text/javascript" src="jsLib/jQuery.3.4.1/jquery-3.4.1.js" ></script>
      <script type="text/javascript" src="jsLib/jquery-ui-1.12.1/jquery-ui.js" ></script>
      <script type="text/javascript" src="jsLib/bootstrap-4.4.1/js/bootstrap.js" ></script>
      <script type="text/javascript" src="jsLib/jquery-easyui-1.9.0/jquery.easyui.min.js" ></script>
      
      <script type="text/javascript" src="javascript/nugatoria.js" ></script>
      
      <title>Nugatoria</title>
   </head>
   <body>
<div class="jumbotron text-center">
  <h1>Nugatoria is Nugatory</h1>
  <p>A trivia game with questions of little or no consequence.</p> 
</div>

   <div class="container">
     <div class="row">
       <div class="col-sm-4">
         <h3>Trivia Quiz Selection</h3>
         <p>Choose the number of questions, question type and category for your game.</p>
         <div id="gameQuestionParams">
           <input id="category" class="easyui-combobox" name="category"><br>
           <input id="type" class="easyui-combobox" name="type"><br>
           <input id="difficulty" class="easyui-combobox" name="difficulty">
         </div>
       </div>
       <div class="col-sm-4">
         <h3>Here is your quiz.</h3>
         <div id="gameQuestions">
         </div>
       </div>
       <div class="col-sm-4">
         <h3>Quiz Status</h3>        
         <div id="gameStatus">
         </div>
       </div>
     </div>
   </div>

   </body>
</html>