$(document).ajaxStart(function () {
    $("#ajaxModal").modal("show");
});

$(document).ajaxStop(function () {
    $("#ajaxModal").modal("hide");
});

//Enviar formularios ajax
function sendAjaxFormMunnin($form) {
    $.ajax({
        type: "POST",
        url: $form.attr("data-ajax-url"),
        data: $form.serialize(),
        success: function (response) {
            $("#" + $form.data("id-display-answer")).html(response);
        }
    });
}

$(document).ready(function () {

    //para cambiar de pagina se usa el siguiente codigo
    $(document).on("click", "a[data-page]", function (event) {
        event.preventDefault();
        var $link = $(this);
        var $page = $link.attr('data-page');
        var $form = $('form[data-form-name="'+$link.attr('data-form-send')+'"]');
        $form.children("input[data-name='page']").val($page);
        sendAjaxFormMunnin($form);
    });

    //Para procesar el evento de envio de formularios ajax
    $(document).on("submit", "form[data-ajax-url]", function (event) {
        event.preventDefault();
        var $form = $(this);
        sendAjaxFormMunnin($form);
    });
});