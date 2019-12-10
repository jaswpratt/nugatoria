/**
 * nugatoria.js
 * https://www.tutorialsteacher.com/d3js/loading-data-from-file-in-d3js
 * https://www.w3schools.com/js/js_json_files.asp
 */


function loadQuestionParams(){
  d3.json("json/questionData.json", function(data) {
      for (var i = 0; i < data.length; i++) {
          console.log(data);
          console.log(data);
      }
  });
}


   $( document ).ready(function() {
      $('#category').combobox({
         url:'json/categoryData.json',
         valueField:'id',
         textField:'category'
      });
      $('#type').combobox({
          url:'json/type.json',
          valueField:'id',
          textField:'category'
       });
      $('#difficulty').combobox({
          url:'json/difficulty.json',
          valueField:'id',
          textField:'category'
       });
   });

