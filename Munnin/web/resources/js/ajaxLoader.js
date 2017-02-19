$(document).ready(function () {
    
    $(document).on("click", "tr[data-munnin-input-bind]", function (event) {
        event.preventDefault();
        
        var $row = $(this);
        var $value = $row.attr('data-munnin-id');
        var $input = $('input[data-munnin-name='+$row.attr('data-munnin-input-bind')+']');
        $input.val($value);
        
        var $parent = $row.parent();
        $parent.children(".selected").removeClass('selected');
        $row.addClass('selected');
    });
});