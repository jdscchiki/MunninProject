$(document).ready(function () {
    var selectedEnabledFunctionary = "-1";
    var currentPage = "1";
    
    var selectedDisabledFunctionary = "-1";
    
    function refreshTable(page, search) {
        var data = {
            page: page,
            search : search
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
        selectedEnabledFunctionary = "-1";
    }
    ;
    
    function refreshTableDisabledF(search) {
        var data = {
            search: search
        };
        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/refresh-disabled-functionary",
            data: $.param(data),
            success: function (response) {
                $("#showDisabledFunctionary_Table").html(response);
            }
        });
    }
    ;
    
    $(document).on("click", "#showDisabledFunctionary_Table #point tr", function () {
        $("#showDisabledFunctionary_Table #point tr.selected").removeClass("selected");
        $(this).toggleClass("selected");
        selectedDisabledFunctionary = $(this).data("id");
    });

    $(document).on("click", "#fulltable #point tr", function () {
        $("#fulltable #point tr.selected").removeClass("selected");
        $(this).toggleClass("selected");
        selectedEnabledFunctionary = $(this).data("id");
    });

    $(document).on("click", ".pagination a[data-page]", function (event) {
        event.preventDefault();
        var page = $(this).data("page");
        var search = $(this).data("search");
        refreshTable(page, search);
    });

    $(document).on("click", "#remove", function (event) {
        event.preventDefault();
        var data = {
            id: selectedEnabledFunctionary,
            operation: "Remove"
        };

        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/admin-functionary",
            data: $.param(data),
            success: function (response) {
                $("#div_message").html(response);
                refreshTable(currentPage, "");
            }
        });
    });

    $(document).on("click", "#ChangeRoles", function (event) {
        event.preventDefault();
        var data = {
            id: selectedEnabledFunctionary,
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
        });//
    });
    
    $(document).on("click", "#showDisabled", function (event) {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/show-disabled-functionary",
            success: function (response) {
                $("#div_message").html(response);
                $("#disabledFunctionary").modal();
            }
        });
    });
    
    $(document).on("click", "#enable-functionary", function (event) {
        event.preventDefault();
        var data = {
            id: selectedDisabledFunctionary
        };
        $.ajax({
            type: "POST",
            url: contextPath + "home/role/coordinator/enable-functionary",
            data: $.param(data),
            success: function (response) {
                $("#showDisabledFunctionary_message").html(response);
                refreshTableDisabledF("");
                refreshTable(currentPage, "");
            }
        });
    });
    
    $(document).on("submit", "#formSearchFunctionaryEnable", function (event) {
        event.preventDefault();
        var search = $("#formSearchFunctionaryEnable input:text[name=search]").val();
        currentPage = "1";
        refreshTable(currentPage, search);
    });
    
    $(document).on("submit", "#formDisabledFunctionary", function (event) {
        event.preventDefault();
        var form = $(this);
        $.ajax({
            type: "POST",
            url: form.attr("action"),
            data: form.serialize(),
            success: function (response) {
                $("#showDisabledFunctionary_Table").html(response);
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
                    refreshTable(currentPage, "");
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
    
    $(document).on('hidden.bs.modal', "#disabledFunctionary", function () {
        $("#div_message").html("");
    });
    
    $('[data-toggle="tooltip"]').tooltip();
    
});