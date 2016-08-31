var working = false;
$('.login').on('submit', function(e) {
  e.preventDefault();
  if (working) return;
  working = true;
  var $this = $(this),
    $state = $this.find('button > .state');
  $this.addClass('loading');
  $state.html('Verificando');
  setTimeout(function() {
    $this.addClass('ok');
    $state.html('Bienvenido!');
    setTimeout(function() {
      $state.html('Ingresar');
      $this.removeClass('ok loading');
      window.location="muninn.jsp";
      working = false;
    }, 2000);
  }, 3000);
});