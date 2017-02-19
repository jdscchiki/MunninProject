$(document).ajaxStart(function () {
    $("#ajaxModal").modal({
        backdrop: 'static',
        keyboard: false
    });
});

$(document).ajaxStop(function () {
    $("#ajaxModal").modal("hide");
});

/**
 * funcion para enviar formularios de forma asincrona
 * 
 * @param {type} $form
 * @returns {undefined}
 */
function sendAjaxFormMunnin($form) {
    $.ajax({
        type: "POST",
        url: $form.attr("data-ajax-url"),
        data: $form.serialize(),
        success: function (response) {
            $("#" + $form.data("id-display-answer")).html(response);
        }
    });
//    var $formName = $form.attr('data-refresh-form');
//    if (!!$formName) {
//        sendAjaxFormMunnin($('form[data-form-name="' + $formName + '"]'));
//    }
}

/**
 * funcion para cargar contenido de una pagina web de forma asincrona
 * 
 * @param {type} url
 * @param {type} idDisplayZone
 * @returns {undefined}
 */
function loadAjaxContentMunnin(url, idDisplayZone) {
    $.ajax({
        type: "POST",
        url: url,
        success: function (response) {
            $("#" + idDisplayZone).html(response);
        }
    });
}

$(document).ready(function () {

    $(document).on("click", "a[data-page]", function (event) {
        event.preventDefault();
        var $link = $(this);
        var $page = $link.attr('data-page');
        var $form = $('form[data-form-name="' + $link.attr('data-form-send') + '"]');
        $form.children("input[data-name='page']").val($page);
        sendAjaxFormMunnin($form);
    });

    //Para procesar el evento de envio de formularios ajax
    $(document).on("submit", "form[data-ajax-url]", function (event) {
        event.preventDefault();
        var $form = $(this);
        sendAjaxFormMunnin($form);

    });

    $(document).on("click", "button[data-munnin-action]", function (event) {
        event.preventDefault();
        var $btn = $(this);
        var $action = $btn.attr('data-munnin-action');
        var $form = $('form[data-form-name="' + $btn.attr('data-form-send') + '"]');
        $form.children("input[data-name='action']").val($action);
        sendAjaxFormMunnin($form);
    });

    $(document).on("click", "tr[data-munnin-id]", function (event) {
        event.preventDefault();

        var $row = $(this);
        var $group = $row.parent();
        var $idSelected = $row.attr('data-munnin-id');//selecciona el valor del id de la fila seleccionada
        var $form = $('form[data-form-name="' + $row.attr('data-munnin-ajax-form') + '"]');//selecciona el formulario al que va a ser enviado
        $form.children("input[data-name='idSelected']").val($idSelected);//el valor del id en el formulario cambia por el valor de la fila seleccionada

        //elimina la clase de la fila entes seleccionada y se la agrega a la nueva fila seleccionada
        $group.children('.selected').removeClass('selected');
        $row.addClass("selected");
    });
});