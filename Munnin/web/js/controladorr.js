$(document).ready(function() {

	var showText='Mostrar';
	var hideText='Ocultar';

	var is_visible = false;

	$('.toggle').prev().append(' <a href="#" class="toggleLink">'+hideText+'</a>');

	$('.toggle').show();

	$('a.toggleLink').click(function() {
		is_visible = !is_visible;
		if ($(this).text()==showText) {
			$(this).text(hideText);
			$(this).parent().next('.toggle').slideDown('slow');
		}
		else {
			$(this).text(showText);
			$(this).parent().next('.toggle').slideUp('slow');
		}
		return false;
	});
});