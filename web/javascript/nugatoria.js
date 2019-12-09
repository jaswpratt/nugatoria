/**
 * nugatoria.js
 * https://www.tutorialsteacher.com/d3js/loading-data-from-file-in-d3js
 */


function loadQuestionParams(){
  d3.json("json/questionData.json", function(data) {
      for (var i = 0; i < data.length; i++) {
          console.log(data);
          console.log(data);
      }
  });
}
