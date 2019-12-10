/**
 * nugatoria.js
 * https://www.tutorialsteacher.com/d3js/loading-data-from-file-in-d3js
 * https://www.w3schools.com/js/js_json_files.asp
 */

   $( document ).ready(function() {
      $('#count').combobox({
         url:'json/count.json',
         valueField:'id',
         textField:'count'
      });
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

