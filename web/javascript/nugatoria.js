/**
 * nugatoria.js
 * https://www.tutorialsteacher.com/d3js/loading-data-from-file-in-d3js
 * https://www.w3schools.com/js/js_json_files.asp
 */
   var count {id : "10", value: "10"};
   var category {id : "any",value: ""};
   var type {id : "any", value: ""};
   var difficulty {id : "any", value: ""};

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
         url:'json/categoryData.json',
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
   });

