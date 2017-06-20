// Create a "close" button and append it to each list item
var myNodelist = document.getElementsByClassName("cl");
var i;
for (i = 0; i < myNodelist.length; i++) {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "closeLi";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("closeLi");
var i;
for (i = 0; i < close.length; i++) {
    close[i].onclick = function () {
        var div = this.parentElement;
//    div.style.display = "none";
        $(div).remove();
    }
}

// Create a new list item when clicking on the "Add" button
function newElement() {    
    var li = document.createElement("li");
    li.setAttribute("class", "cl");
    var inputValue = document.getElementById("myInput").value;
    var input = document.createElement("INPUT");
    input.setAttribute("type", "text");
    input.setAttribute("name", "itemchecklist");
    input.setAttribute("value", inputValue);
    input.setAttribute("disabled", "disabled");
    var inputT = document.createElement("INPUT");
    inputT.setAttribute("type", "hidden");
    inputT.setAttribute("name", "itemchecklist");
    inputT.setAttribute("value", inputValue);
    li.appendChild(input);
    if (inputValue === '') {
        alert("HEY! LISTEN! Debes escribir algo. ");
    } else {
        document.getElementById("myUL").appendChild(li);
    }
    document.getElementById("myInput").value = "";

    li.appendChild(inputT);
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "closeLi";
    span.appendChild(txt);
    li.appendChild(span);

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }
}

$(document).on("keypress", "input.IngresarItem", function (event) {
    var $this = $(this);
    if (event.keyCode == 13) {
        event.preventDefault();

        newElement();
    }
});

