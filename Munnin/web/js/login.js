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
        $state.html('Bienvenido !');
        /*--aqui se redirecciona--*/
        location.href="muninn-new.jps";
        setTimeout(function() {
            $state.html('Log in');
            $this.removeClass('ok loading');
            working = false;
        }, 1000);
    }, 1000);
});