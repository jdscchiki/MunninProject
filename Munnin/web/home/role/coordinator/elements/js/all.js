var selected = "-1";
var currentPage = "1";
function refreshTable(page) {
    var data = {
        page: page
    };
    $.ajax({
        type: "POST",
        url: contextPath + "home/role/coordinator/pagerFunctionary",
        data: $.param(data),
        success: function (response) {
            $("#fulltable").html(response);
            currentPage = page;
        }
    });
    selected = "-1";
}
;

function ajaxElementLoadedEvent() {

    $("#point tr").click(function () {
        $("#point tr.selected").removeClass("selected");
        $(this).toggleClass("selected");
        selected = $(this).data("id");
    });

    $(".pagination a").click(function (event) {
        event.preventDefault();
        var page = $(this).data("page");
        refreshTable(page);
    });
}
;

$(document).ready(function () {
    ajaxElementLoadedEvent();

    $("#remove").on("click", function (event) {
        event.preventDefault();
        var data = {
            id: selected,
            operation: "remove"
        };

        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/adminFuncionarios",
            data: $.param(data),
            success: function (response) {
                $("#div_message").html(response);
                refreshTable(currentPage);
            }
        });
    });

    $("#formRegisterFunctionary").submit(function (event) {
        event.preventDefault();
        var tipoDoc = $("#formRegisterFunctionaryTipoDoc").val();
        var documento = $("#formRegisterFunctionaryDocumento").val();
        var correo = $("#formRegisterFunctionaryCorreo").val();
        var nombre = $("#formRegisterFunctionaryNombre").val();
        var apellido = $("#formRegisterFunctionaryApellido").val();

        var divMensaje = $("#divRegisterFunctionary_message");
        var alertDiv1 = '<div class="alert alert-warning alert-dismissible">';
        var alertDiv2 = '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>';
        var alertDiv3 = '<p id="textRegisterFunctionary_message"></p>';
        var alertDiv4 = '</div>';
        var alertDiv = alertDiv1 + alertDiv2 + alertDiv3 + alertDiv4;

        if (tipoDoc === "") {
            divMensaje.html(alertDiv);
            $("#textRegisterFunctionary_message").text("El campo tipo de documento esta vacio");
        } else if (documento === "") {
            divMensaje.html(alertDiv);
            $("#textRegisterFunctionary_message").text("El campo documento esta vacio");
        } else if (correo === "") {
            divMensaje.html(alertDiv);
            $("#textRegisterFunctionary_message").text("El campo correo esta vacio");
        } else if (nombre === "") {
            divMensaje.html(alertDiv);
            $("#textRegisterFunctionary_message").text("El campo nombre esta vacio");
        } else if (apellido === "") {
            divMensaje.html(alertDiv);
            $("#textRegisterFunctionary_message").text("El campo apellido esta vacio");
        } else {
            
            divMensaje.html("");
            
            var $form = $(this);

            $.ajax({
                type: "POST",
                url: $form.attr("action"),
                data: $form.serialize(),
                success: function (response) {
                    divMensaje.html(response);
                    refreshTable(currentPage);
                }
            });
        }
    });

    $("#registerFunctionary").on('hidden.bs.modal', function () {
        $('#formRegisterFunctionary').trigger("reset");
        $("#divRegisterFunctionary_message").html("");
    });
});

$(document).ajaxComplete(function () {
    ajaxElementLoadedEvent();
});

