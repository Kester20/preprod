function changeLanguage(locale) {

    location.hash = "locale="+ locale;

    $.ajax({
        type: "GET",
        url: "",
        dataType: "text",
        data: "locale=" + locale,
        success: function(result) {
            window.location.reload();
        }
    });
}
