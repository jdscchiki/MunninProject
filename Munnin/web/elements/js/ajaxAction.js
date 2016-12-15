$(document).ready(function () {
    $("#formChangePassword").submit(function (event) {
        event.preventDefault();
        var $form = $(this);
        if (validarPass()) {
            $.ajax({
                type: "POST",
                url: $form.attr("action"),
                data: $form.serialize(),
                success: function (response) {
                    $("#formPassword_message").html(response);
                    refreshTable(currentPage);
                }
            });
        }

    });
});

function validarPass() {
    var pass1, pass2, pass3;
    pass1 = $("#passwordCurrent").val();
    pass2 = $("#passwordNew").val();
    pass3 = $("#passwordNewC").val();
    var divMensaje = $("#formPassword_message");
    if (pass1 === "") {
        divMensaje.addClass("alert");
        divMensaje.addClass("alert-danger");
        divMensaje.text("El campo Contraseña Actual esta vacio");
        return false;
    } else if (pass2 === "") {
        divMensaje.addClass("alert");
        divMensaje.addClass("alert-danger");
        divMensaje.text("El campo Nueva Contraseña esta vacio");
        return false;
    } else if (pass3 === "") {
        divMensaje.addClass("alert");
        divMensaje.addClass("alert-danger");
        divMensaje.text("El campo Repite Contraseña esta vacio");
        return false;
    } else if (pass2 !== pass3) {
        divMensaje.addClass("alert");
        divMensaje.addClass("alert-danger");
        divMensaje.text("Las contraseñas no coinciden");
        return false;
    } else {
        divMensaje.removeClass("alert");
        divMensaje.removeClass("alert-danger");
        divMensaje.text("");
        return true;
    }
}