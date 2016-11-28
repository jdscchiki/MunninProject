function highlight(e) {
    if (selected[0]) selected[0].className = '';
    e.target.parentNode.className = 'selected';
}

var table = document.getElementById('point'),
    selected = table.getElementsByClassName('selected');
table.onclick = highlight;
