$(document).ready(function () {
    $(document).on("click", "a[data-ajax-url]", function (event) {
        event.preventDefault();
        var $link = $(this);
        var data = {
            page : $link.attr("data-page")
        };
        
        $.ajax({
            type: "POST",
            url: $link.attr("data-ajax-url"),
            data: $.param(data) ,
            success: function (response) {
                $("#"+$link.data("id-display-answer")).html(response);
            }
        });
    });
});