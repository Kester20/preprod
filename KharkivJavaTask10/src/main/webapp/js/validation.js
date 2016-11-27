
function validateRegisterForm (){
    alert(document.getElementsByClassName("text-info")[0].lastChild.textContent + "invalid input");
	return isNotEmptyInput() && checkLengthPassword(document.registerForm.pass.value)
	 && validateEmail(document.registerForm.email.value)
	 && validatePhone(document.registerForm.mobileNumber.value);
}

function isNotEmptyInput(){
    isNotEmpty = true;
    var inputs = document.registerForm.getElementsByTagName("input");
    for (i=0; i<inputs.length; i++){
        if(inputs[i].value == ""){
            isNotEmpty = false;
            break;
        }
    }
    return isNotEmpty;
}

function checkLengthPassword(pass){
    return pass.length >= 8;
}

function validateEmail(email) {
    var regex = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
    return regex.test(email);
}

function validatePhone(phone){
    var regex = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4,5})$/;
    return regex.test(phone);
}
