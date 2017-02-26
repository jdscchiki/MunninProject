// function highlight(e) {
//     if (selected[0]) selected[0].className = '';
//     e.target.parentNode.className = 'selected';
// }

// var table = document.getElementById('point'),
//     selected = table.getElementsByClassName('selected');
// table.onclick = highlight;

$(document).ready(function(){
    $("#point tr").click(function(){
        $("#point tr.selected").removeClass("selected");
        $(this).toggleClass("selected");
    });
});