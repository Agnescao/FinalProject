function change(id,inputObj){
        var quantity=inputObj.value;

        if(quantity==null || quantity=="") {
            alert("The input can not be null");
            inputObj.value = defaultValue;
            return;
        }
        
        if(quantity.match(/^[1-9][0-9]*$/)==null) {
            alert("The quantity must be positive integer !");
            inputObj.value = defaultValue;
            return;
        }
        
        if(parseInt(quantity)>999) {
            alert(" Your shopping cart is full , you are not allowed to add new product !");
            inputObj.value = defaultValue;
            return;
        }
        window.location="UpdateServlet?orderID="+id+"&quantity="+quantity;
}     