function changeLanguage(locale) {

    location.hash = "lang="+ locale;

    $.ajax({
        type: "GET",
        url: "change_locale",
        dataType: "text",
        data: "locale=" + locale,
        success: function(result) {
            window.location.reload();
        }
    });
}
