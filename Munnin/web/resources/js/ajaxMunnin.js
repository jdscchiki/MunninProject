/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ajaxLoadContent($url, $idDisplay) {
    $.ajax({
        type: 'POST',
        url: $url,
        success: function (response) {
            $("#" + $idDisplay).html(response);
        }
    });
}

$(document).ready(function () {

    //attributes
    var $ajaxFormAttr = 'data-ajax-form';//true to process via jquery ajax
    var $displayResultAttr = 'data-display';//selector of the result of the request
    var $linkPageAttr = 'data-link-page';//attr for the info to change the page
    var $linkServletAttr = 'data-servlet';//attr for the link of the servlet

    /**
     * function to send forms via ajax JQuery
     * 
     * @param {} $form A form selected via JQuery
     * @returns {void}
     */
    function ajaxSendForm($form) {
        $.ajax({
            type: $form.attr('method'),
            url: $form.attr('action'),
            data: $form.serialize(),
            success: function (response) {
                $("#" + $form.attr($displayResultAttr)).html(response);
            }
        });
    }

    /**
     * function to change of page 
     * 
     * @param {type} $link JQuery Selected link
     * @returns {void}
     */
    function ajaxChangePage($link) {
        var $ul = $link.closest('ul');
        var linkServlet = $ul.attr($linkServletAttr);
        $.ajax({
            type: "POST",
            url: linkServlet,
            data: $link.attr($linkPageAttr),
            success: function (response) {
                $('#' + $ul.attr($displayResultAttr)).html(response);
            }
        });
    }

    //event Triggers

    $(document).on("submit", "form[" + $ajaxFormAttr + "=true]", function (event) {
        event.preventDefault();
        ajaxSendForm($(this));
    });

    $(document).on("click", "a[" + $linkPageAttr + "]", function (event) {
        event.preventDefault();
        ajaxChangePage($(this));
    });

    $(document).on("click", "button[" + $linkServletAttr + "]", function (event) {
        event.preventDefault();
        var $this = $(this);
        ajaxLoadContent($this.attr($linkServletAttr), $this.attr($displayResultAttr));
    });

});
