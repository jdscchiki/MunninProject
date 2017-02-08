$(document).ready(function () {
    $(document).on("submit", "form[data-ajax-url]", function (event) {
        event.preventDefault();
        var $form = $(this);
        $.ajax({
            type: "POST",
            url: $form.attr("data-ajax-url"),
            data: $form.serialize(),
            success: function (response) {
                $("#"+$form.data("id-display-answer")).html(response);
            }
        });
    });
});