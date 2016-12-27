var selected = "-1";
var currentPage = "1";

$(document).ready(function () {
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

    $(document).on("click", "#point tr", function () {
        $("#point tr.selected").removeClass("selected");
        $(this).toggleClass("selected");
        selected = $(this).data("id");
    });

    $(document).on("click", ".pagination a", function (event) {
        event.preventDefault();
        var page = $(this).data("page");
        refreshTable(page);
    });

    $(document).on("click", "#remove", function (event) {
        event.preventDefault();
        var data = {
            id: selected,
            operation: "Remove"
        };

        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/admin-functionary",
            data: $.param(data),
            success: function (response) {
                $("#div_message").html(response);
                refreshTable(currentPage);
            }
        });
    });

    $(document).on("click", "#ChangeRoles", function (event) {
        event.preventDefault();
        var data = {
            id: selected,
            operation: "ChangeRoles"
        };

        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/admin-functionary",
            data: $.param(data),
            success: function (response) {
                $("#div_message").html(response);
                $("#assignRole").modal();
            }
        });
    });
    
    $(document).on("click", "#ShowDisabled", function (event) {
        event.preventDefault();
        var data = {
            id: selected,
            operation: "ChangeRoles"
        };

        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/show-disabled-functionary",
            data: $.param(data),
            success: function (response) {
                $("#div_message").html(response);
                $("#assignRole").modal();
            }
        });
    });

    $(document).on("submit", "#formAssignRole", function (event) {
        event.preventDefault();
        var form = $(this);
        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/assign-roles",
            data: form.serialize(),
            success: function (response) {
                $("#formAssignRole_message").html(response);
            }
        });
    });

    $(document).on("submit", "#formRegisterFunctionary", function (event) {
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

    $(document).on('hidden.bs.modal', "#registerFunctionary", function () {
        $('#formRegisterFunctionary').trigger("reset");
        $("#divRegisterFunctionary_message").html("");
    });

    $(document).on('hidden.bs.modal', "#assignRole", function () {
        $("#div_message").html("");
    });
    
    $('[data-toggle="tooltip"]').tooltip();
    
});