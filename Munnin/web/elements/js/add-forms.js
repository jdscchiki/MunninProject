$(document).ready(function(){
    $('[data-toggle="popover"]').popover();
});

var counter = 1;
var limit = 10;
function addInput(divName){
     if (counter == limit)  {
          alert("Ya a alcanzado el limite de " + counter + " items posibles.");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "<input type='checkbox'>"+"<label> Item "+(counter + 1)+"</label><textarea class='form-control' cols='77' rows='3'></textarea><br/>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
