function addToCart(id) {
    alert("!!!");
    var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
    xmlhttp.open('GET', 'cart_servlet?id=' + id, true); // Открываем асинхронное соединение
    /* xmlhttp.setRequestHeader('Content-Type',
    		'application/x-www-form-urlencoded'); // Отправляем тип содержимого */
    xmlhttp.send("id=" + encodeURIComponent(id)); // Отправляем POST-запрос
    xmlhttp.onreadystatechange = function() { // Ждём ответа от сервера
        if (xmlhttp.readyState == 4) { // Ответ пришёл
            if (xmlhttp.status == 200) { // Сервер вернул код 200 (что хорошо)
                window.location.href = xmlhttp.responseText;
                window.location.reload();
                xmlhttp.abort();
            }
        }
    };

}
