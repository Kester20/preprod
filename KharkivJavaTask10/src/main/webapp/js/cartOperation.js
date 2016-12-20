function addToCart(id) {
    var xmlhttp = getXmlHttp();
    xmlhttp.open('GET', 'cart/add/*?idLaptop=' + id, true);
    xmlhttp.send("idLaptop=" + encodeURIComponent(id));
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                var res = JSON.parse(xmlhttp.responseText);
                document.getElementById("total_head").innerHTML = res.amount;
                document.getElementById("size_head").innerHTML = res.size;
            }
        }
    };
}

function deleteLaptopFromCart(id) {
    var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
    xmlhttp.open('GET', 'delete_from_cart_servlet?idLaptop=' + id, true);
    xmlhttp.send("idLaptop=" + encodeURIComponent(id));
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                window.location.reload();
            }
        }
    };
}

function setKeyValue(idLaptop, value) {
    var xmlhttp = getXmlHttp();
    xmlhttp.open('GET', 'get_amount_servlet?idLaptop=' + idLaptop + "&value=" + value, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                document.getElementById("total").innerHTML = xmlhttp.responseText;
                document.getElementById("total_head").innerHTML = xmlhttp.responseText;
            }
        }
    };
}

function updateTotal(idLaptop, value) {
    setKeyValue(idLaptop, value);
}

function clearCart() {
    var xmlhttp = getXmlHttp();
    xmlhttp.open('GET', 'clear_cart_servlet', true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
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
