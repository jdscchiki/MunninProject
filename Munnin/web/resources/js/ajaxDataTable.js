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
    var $actionMultiple = 'data-action-multiple';
    var $actionDisplay = 'data-action-display';
    var $actionUrlServlet = 'data-action-url-servlet';

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
                var $panelTable = $('form[' + $dataTableAttr + '=' + $dataTable.attr('id') + ']');
                $panelTable.find("input[" + $selectedItemAttr + "]").val(-1);
                $panelTable.find('input[' + $actionAttr + ']').val("");
            }
        });
    }

    function executeAction($actionButton) {
        var $panelTable = $("form#" + $actionButton.attr($panelTableAttr));
        var $action = $actionButton.attr($actionAttr);
        var $displayElement = $("#" + $panelTable.attr($displayAttr));
        var $dataTable = $("#" + $panelTable.attr($dataTableAttr));

        $panelTable.find('input[' + $actionAttr + ']').val($action);

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

        $dataTable.find("." + $selectedCls).removeClass($selectedCls);
        $item.addClass($selectedCls);
    }

    function selectItemSingleAction($item) {
        var $dataTable = $item.parent();
        var $displayElement = $("#"+$dataTable.attr($actionDisplay));
        var params = {
            id: $item.attr($idAttr)
        };
        $.ajax({
            type: "POST",
            url: $dataTable.attr($actionUrlServlet),
            data: $.param(params),
            success: function (response) {
                $displayElement.html(response);
            },
            complete: function (response) {
                refreshDataTable($dataTable);
            }
        });
    }

    $(document).on("click", "tbody[" + $actionMultiple + "=true] tr[" + $idAttr + "]", function (event) {
        event.preventDefault();
        selectItem($(this));
    });

    $(document).on("click", "tbody[" + $actionMultiple + "=false] tr[" + $idAttr + "]", function (event) {
        event.preventDefault();
        selectItemSingleAction($(this));
    });

    $(document).on("click", "button[" + $actionAttr + "]", function (event) {
        event.preventDefault();
        executeAction($(this));
    });
});