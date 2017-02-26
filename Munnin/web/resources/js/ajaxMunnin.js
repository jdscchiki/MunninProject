/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    //attributes
    var $displayResult = 'data-diplay-result';
    var $ajaxForm = 'data-ajax-form';
    var $ajaxAction = 'data-ajax-action';
    var $actionForm = 'data-form';
    var $inputAction = 'data-action';

    /**
     * funcyion to send forms via ajax JQuery
     * 
     * @param {} $form A form selected via JQuery
     * @returns {void}
     */
    function ajaxSendForm($form) {
        $.ajax({
            type: "POST",
            url: $form.attr('action'),
            data: $form.serialize(),
            success: function (response) {
                $($form.attr($displayResult)).html(response);
            }
        });
    }

    function ajaxChangePage($link) {
        
    }

    function ajaxAction($btn) {
        var $form = $('form'+$btn.attr($actionForm));
        $form.children('input['+$inputAction+']').val($btn.attr($ajaxAction));
        ajaxSendForm($form);
    }

    $(document).on("submit", "form[" + $ajaxForm + "=true]", function (event) {
        event.preventDefault();
        ajaxSendForm($(this));
    });

    $(document).on("submit", "button[" + $ajaxAction + "]", function (event) {
        event.preventDefault();
        ajaxAction($(this)); 
    });
    
    
});
