/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    //class
    var $selectedCls = 'selected';

    //attributes
    var $displayAttr = 'data-display';
    var $stateAttr = 'data-actual-state';
    var $urlAttr = 'data-url-receiver';
    var $dataTableAttr = 'data-data-table';
    var $idAttr = 'data-id';
    var $selectedItemAttr = "data-selected-item";
    var $panelTableAttr = 'data-panel-table';
    var $actionAttr = 'data-action';

    function refreshDataTable($dataTable) {
        var $displayElement = $("#" + $dataTable.attr($displayAttr));
        var $state = $dataTable.attr($stateAttr);
        var $url = $dataTable.attr($urlAttr);

        $.ajax({
            type: "POST",
            url: $url,
            data: $state,
            success: function (response) {
                $displayElement.html(response);
                var $panelTable = $('form['+$dataTableAttr+'='+$dataTable.attr('id')+']');
                $panelTable.find("input[" + $selectedItemAttr + "]").val(-1);
                $panelTable.find('input['+$actionAttr+']').val("");
            }
        });
    }

    function executeAction($actionButton) {
        var $panelTable = $("form#" + $actionButton.attr($panelTableAttr));
        var $action = $actionButton.attr($actionAttr);
        var $displayElement = $("#" + $panelTable.attr($displayAttr));
        var $dataTable = $("#" + $panelTable.attr($dataTableAttr));
        
        $panelTable.find('input['+$actionAttr+']').val($action);
        
        $.ajax({
            type: "POST",
            url: $panelTable.attr('action'),
            data: $panelTable.serialize(),
            success: function (response) {
                $displayElement.html(response);
            },
            complete: function (response) {
                refreshDataTable($dataTable);
            }
        });
    }

    function selectItem($item) {
        var $dataTable = $("#" + $item.attr($dataTableAttr));
        var $id = $item.attr($idAttr);

        var $panelTable = $("form[" + $dataTableAttr + "=" + $item.attr($dataTableAttr) + "]");

        $panelTable.find("input[" + $selectedItemAttr + "]").val($id);
        
        $dataTable.find("."+$selectedCls).removeClass($selectedCls);
        $item.addClass($selectedCls);
    }
    
    $(document).on("click", "tr["+$idAttr+"]", function (event) {
        event.preventDefault();
        selectItem($(this));
    });
    
    $(document).on("click", "button["+$actionAttr+"]", function (event) {
        event.preventDefault();
        executeAction($(this));
    });
});