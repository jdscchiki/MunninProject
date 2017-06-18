var $splitKeyword = ";";

function printTagCloud($output, $values) {
    var $arr = $values.split($splitKeyword);
    var $before = "<li><div>";
    var $after = '</div><a data-destroy="li">&times;</a></li>';
    $output.html("");
    for (var i = 0; i < $arr.length; i++) {
        if ($arr[i].length > 0) {
            var $html = $before + $arr[i] + $after;
            $output.append($html);
        }
    }
}
$(document).ready(function () {
    $(".keywordhidden").each(function (index, item) {
        var $output = $("[data-bind-input=" + $(item).attr("id") + "] ul");
        var $values = $(item).val();
        printTagCloud($output, $values);
    });
});
$(document).on("click", "a[data-destroy=li]", function (event) {
    event.preventDefault();
    var $this = $(this);
    var $keyword = $this.parent().children("div").text();
    var $input = $("#" + $this.closest("[data-bind-input]").attr("data-bind-input"));

    var $value = "";
    var $arr = $input.val().split($splitKeyword);
    for (var i = 0; i < $arr.length; i++) {
        if ($arr[i] != $keyword) {
            $value += $arr[i] + $splitKeyword;
        }
    }
    $input.val($value);
    $input.trigger("change");
});
$(document).on("change", "input.keywordhidden", function (event) {
    event.preventDefault();
    var $output = $("[data-bind-input=" + $(this).attr("id") + "] ul");
    var $values = $(this).val().toLowerCase();

    var $arr = $values.split($splitKeyword);
    $values = "";
    for (var i = 0; i < $arr.length; i++) {
        if ($arr[i].length > 0) {
            if ($arr.indexOf($arr[i], i + 1) == -1) {
                $values += $arr[i] + $splitKeyword;
            }
        }
    }
    $(this).val($values);

    printTagCloud($output, $values);
});
$(document).on("keypress", "input.keyword", function (event) {
    var $this = $(this);
    if (event.keyCode == 13) {
        event.preventDefault();

        var $hidden = $("#" + $this.attr("data-bind-input"));
        $hidden.val($hidden.val() + $this.val() + $splitKeyword);
        $this.val("");
        $hidden.trigger("change");
    }
});