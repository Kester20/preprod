
function validateRegisterForm (){
    var valid = true;
    var inputs = document.registerForm.getElementsByTagName("input");
        for (i=0; i<inputs.length - 1; i++){
            if(inputs[i].className == "invalid" || inputs[i].value == ""){
                valid = false;
            }
        }
    return valid;
}

function setInvalidClass(element){
    element.parentNode.previousSibling.previousSibling.className = "text-info-invalid";
    element.className = "invalid";
}

function setValidClass(element){
    element.parentNode.previousSibling.previousSibling.className = "text-info";
    element.className = "valid";
}

function isNotEmptyInput(input){
    return input.value != "";
}

function checkLengthPassword(pass){
    var result = pass.value.length >= 8;
    if(!result){
        setInvalidClass(pass);
        pass.parentNode.nextSibling.nextSibling.innerHTML = "Password less then 8 symbols";
    }else{
        setValidClass(pass);
        pass.parentNode.nextSibling.nextSibling.innerHTML = "";
    }
    return result;
}

function validateEmail(email) {
    var regex = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
    var result = regex.test(email.value);
    if(!result){
        setInvalidClass(email);
        email.parentNode.nextSibling.nextSibling.innerHTML = "Invalidate email format";
    }else{
        setValidClass(email);
        email.parentNode.nextSibling.nextSibling.innerHTML = "";
    }
    return result;
}

function validatePhone(phone){
    var regex = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4,5})$/;
    var result = regex.test(phone.value);
    if(!result){
        setInvalidClass(phone);
        phone.parentNode.nextSibling.nextSibling.innerHTML = "Invalidate mobile number format";
    }else{
        setValidClass(phone);
        phone.parentNode.nextSibling.nextSibling.innerHTML = "";
    }
    return result;
}

function checkStringEquals(element, element2){
    var result = element.value == element2.value;
    if(!result){
        setInvalidClass(element2);
        element2.parentNode.nextSibling.nextSibling.innerHTML = "Passwords are different";
    }else{
        setValidClass(element2);
        element2.parentNode.nextSibling.nextSibling.innerHTML = "";
    }
    return result;
}
