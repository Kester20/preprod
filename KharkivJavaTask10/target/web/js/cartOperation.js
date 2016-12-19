function addToCart(id) {
    var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
    xmlhttp.open('GET', 'add_to_cart_servlet?idLaptop=' + id, true); // Открываем асинхронное соединение
    /* xmlhttp.setRequestHeader('Content-Type',
    		'application/x-www-form-urlencoded'); // Отправляем тип содержимого */
    xmlhttp.send("idLaptop=" + encodeURIComponent(id)); // Отправляем POST-запрос
    xmlhttp.onreadystatechange = function() { // Ждём ответа от сервера
        if (xmlhttp.readyState == 4) { // Ответ пришёл
            if (xmlhttp.status == 200) { // Сервер вернул код 200 (что хорошо)
                /*window.location.href = xmlhttp.responseText;
                window.location.reload();*/
                //document.getElementById("vvv").innerHTML = ${sessionScope.cart.getAmount()};
                //xmlhttp.abort();
            }
        }
    };
}

function deleteLaptopFromCart(id) {
	var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
	xmlhttp.open('GET', 'delete_from_cart_servlet?idLaptop=' + id, true); // Открываем асинхронное соединение
	xmlhttp.send("idLaptop=" + encodeURIComponent(id)); // Отправляем POST-запрос
	xmlhttp.onreadystatechange = function() { // Ждём ответа от сервера
		if (xmlhttp.readyState == 4) { // Ответ пришёл
			if (xmlhttp.status == 200) { // Сервер вернул код 200 (что хорошо)
				//xmlhttp.abort();
			}
		}
	};
}

function setKeyValue(idLaptop, value) {
	var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
	xmlhttp.open('GET', 'get_amount_servlet?idLaptop=' + idLaptop + "&value=" + value, true);
	xmlhttp.send(); // Отправляем POST-запрос
	xmlhttp.onreadystatechange = function() { // Ждём ответа от сервера
		if (xmlhttp.readyState == 4) { // Ответ пришёл
			if (xmlhttp.status == 200) {
                document.getElementById("total").innerHTML = xmlhttp.responseText;
                document.getElementById("total_head").innerHTML = xmlhttp.responseText;
			}
		}
	};
}

function updateTotal(idLaptop,value) {
    setKeyValue(idLaptop, value);
}

function clearCart(){
    var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
	xmlhttp.open('GET', 'clear_cart_servlet', true);
	xmlhttp.send(); // Отправляем POST-запрос
	xmlhttp.onreadystatechange = function() { // Ждём ответа от сервера
		if (xmlhttp.readyState == 4) { // Ответ пришёл
			if (xmlhttp.status == 200) {

			}
		}
	};
}

function getXmlHttp() {
	var xmlhttp;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
		}
	}
	if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}
