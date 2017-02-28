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
    var $ajaxForm = 'data-ajax-form';//true to process via jquery ajax
    var $displayResult = 'data-diplay';//selector of the result of the request
    var $linkPage = 'data-link-page';//attr for the info to change the page
    var $linkServlet = 'data-servlet';//attr for the link of the servlet

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
                $("#" + $form.attr($displayResult)).html(response);
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
        var linkServlet = $ul.attr($linkServlet);
        $.ajax({
            type: "POST",
            url: linkServlet,
            data: $link.attr($linkPage),
            success: function (response) {
                $('#' + $ul.attr($displayResult)).html(response);
            }
        });
    }


    //event Triggers

    $(document).on("submit", "form[" + $ajaxForm + "=true]", function (event) {
        event.preventDefault();
        ajaxSendForm($(this));
    });

    $(document).on("click", "a[" + $linkPage + "]", function (event) {
        event.preventDefault();
        ajaxChangePage($(this));
    });

});
