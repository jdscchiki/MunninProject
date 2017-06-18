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
                    $("#divPassword_message").html(response);
                }
            });
        }

    });

    $("#changePassword").on('hidden.bs.modal', function () {
        $('#formChangePassword').trigger("reset");
        $("#divPassword_message").html("");
    });
});

function validarPass() {
    var pass1, pass2, pass3;
    pass1 = $("#passwordCurrent").val();
    pass2 = $("#passwordNew").val();
    pass3 = $("#passwordNewC").val();
    var divMensaje = $("#divPassword_message");
    var alertDiv1 = '<div class="alert alert-warning alert-dismissible">';
    var alertDiv2 = '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>';
    var alertDiv3 = '<p id="textPassword_message"></p>';
    var alertDiv4 = '</div>';
    var alertDiv = alertDiv1 + alertDiv2 + alertDiv3 + alertDiv4;
    
    
    if (pass1 === "") {
        divMensaje.html(alertDiv);
        $("#textPassword_message").text("El campo Contraseña Actual esta vacio");
        return false;
    } else if (pass2 === "") {
        divMensaje.html(alertDiv);
        $("#textPassword_message").text("El campo Nueva Contraseña esta vacio");
        return false;
    } else if (pass3 === "") {
        divMensaje.html(alertDiv);
        $("#textPassword_message").text("El campo Repite Contraseña esta vacio");
        return false;
    } else if (pass2 !== pass3) {
        divMensaje.html(alertDiv);
        $("#textPassword_message").text("Las contraseñas no coinciden");
        return false;
    } else {
        divMensaje.html("");
        return true;
    }
}