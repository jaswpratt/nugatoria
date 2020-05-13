/**
 * nugatoria.js
 * @author Sabine
 * https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
 */
   var count = {id : "10", value: "10"};
   var category = {id : "any", value: "Any Category"};
   var type = {id : "any", value: "Any Type"};
   var difficulty = {id : "any", value: "Any Difficulty"};
   var results = "";
   var triviaQuestionList = new Array();
   var panelQuestions = new Array();
   var triviaQuestion = {
         category : "",
         question : "",
         type : "",
         correctAnswer : "",
         incorrectAnswers : new Array(),
         selectedAnswer : "",
         difficulty : ""
   }

   $( document ).ready(function() {
      $('#count').combobox({
         url:'json/count.json',
         valueField:'id',
         textField:'count',
         onSelect: function(rec){
            count.id = rec.id;
            count.value = rec.count;
         }
      });
      $('#category').combobox({
         url:'json/category.json',
         valueField:'id',
         textField:'category',
         onSelect: function(rec){
            category.id = rec.id;
            category.value = rec.category;
         }
      });
      $('#type').combobox({
          url:'json/type.json',
          valueField:'id',
          textField:'type',
          onSelect: function(rec){
             type.id = rec.id;
             type.value = rec.type;
          }
       });
      $('#difficulty').combobox({
          url:'json/difficulty.json',
          valueField:'id',
          textField:'difficulty',
          onSelect: function(rec){
             difficulty.id = rec.id;
             difficulty.value = rec.difficulty;
          }
     });
     $('#getTriviaQuiz').linkbutton({
        iconCls: 'icon-search',
        onClick: function(){
           $.post("trivia",{
                  count: count.id,
                  category: category.id,
                  type: type.id,
                  difficulty: difficulty.id
           }, function(data, status, xhr){
              triviaQuizCallback(data, status);
           }, "json");
        } 
     });
   });

   function triviaQuizCallback(data, status){
      if(data.length == 0){
         var message = "Unable to get trivia questions for:";
         message += "\n  - count = " + count.id;
         message += "\n  - category = " + category.id;
         message += "\n  - type = " + type.id;
         message += "\n  - difficulty = " + difficulty.id;
         alert(message);
         return null;
      }

      data.forEach(createQuestionList);
      createQuestionPanel(triviaQuestionList);

   }
   
   function createQuestionList(question) {
      triviaQuestion = {  //Create a new triviaQuestion object each time
         category : "",
         question : "",
         type : "",
         correctAnswer : "",
         incorrectAnswers : new Array(),
         selectedAnswer : "",
         difficulty : ""
      }
      triviaQuestion.category = question.category;
      triviaQuestion.question = question.question;
      triviaQuestion.type = question.type;
      triviaQuestion.correctAnswer = question.correctAnswer;
      triviaQuestion.incorrectAnswers = question.incorrectAnswers;
      triviaQuestion.difficulty = question.difficulty;
      triviaQuestionList.push(triviaQuestion);     
   }

   function createQuestionPanel(questionList){
	   panelQuestions = new Array();
	   var questionHtml = "";
	   for(var i= 0; i < questionList.length; i++){
		   questionHtml = "";
		   questionHtml += "<span id='tq'" + i + ">" + questionList[i].question + "</span>\n<p>";
		   questionHtml += "<ol type='a'>\n";
		   questionHtml += "   <li><input type='radio' id='a' name='answer' value='"+ questionList[i].incorrectAnswers[0] + "'>  " + questionList[i].incorrectAnswers[0] + "</input></li>\n";
		   questionHtml += "   <li><input type='radio' id='b' name='answer' value='"+ questionList[i].correctAnswer + "'>  " + questionList[i].correctAnswer + "</input></li>\n";
		   questionHtml += "   <li><input type='radio' id='c' name='answer' value='"+ questionList[i].incorrectAnswers[1] + "'>  " + questionList[i].incorrectAnswers[1] + "</input></li>\n";
		   questionHtml += "   <li><input type='radio' id='d' name='answer' value='"+ questionList[i].incorrectAnswers[2] + "'>  " + questionList[i].incorrectAnswers[2] + "</input></li>\n";
		   questionHtml += "</ol>";
		   panelQuestions.push(questionHtml);
	   }
   }