function addToCart(id) {
    $.ajax({
        type: "GET",
        url: "cart/add/*",
        dataType: "json",
        data: "idLaptop=" + id,
        success: function(result) {
            $("#total_head").html(result.amount);
            $("#size_head").html(result.size);
        }
    });
}

function deleteLaptopFromCart(id){
  $.ajax({
      type: "GET",
      url: "delete_from_cart_servlet",
      dataType: "text",
      data: "idLaptop=" + id
  });
}

function setKeyValue(id, value){
  $.ajax({
      type: "GET",
      url: "get_amount_servlet",
      dataType: "text",
      data: "idLaptop=" + id + "&value=" + value,
      success: function(result) {
          $("#total").html(result);
          $("#total_head").html(result);
      }
  });
}


function updateTotal(idLaptop, value) {
    setKeyValue(idLaptop, value);
}

function clearCart(){
  $.ajax({
      type: "GET",
      url: "clear_cart_servlet"
  });
}
