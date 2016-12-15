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
};

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
};

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
    
    $("#formRegisterFunctionary").submit(function (event){
        event.preventDefault();
        var $form = $(this);

        $.ajax({
            type: "POST",
            url: $form.attr("action"),
            data: $form.serialize(),
            success: function (response) {
                $("#formRegisterFunctionary_message").html(response);
                refreshTable(currentPage);
            }
        });
    });
    
    $("#registerFunctionary").on('hidden.bs.modal', function () {
        $('#formRegisterFunctionary').trigger("reset");
        $("#formRegisterFunctionary_message").html("");
    });
});
$(document).ajaxComplete(function () {
    ajaxElementLoadedEvent();
});
