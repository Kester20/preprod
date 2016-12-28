function validateRegisterForm() {
    return invokeAllFunctions();
}

function invokeAllFunctions() {
    var resultOfFunctions = true;
    var validAllFields = true;
    var callbacks = [
        function() {
            return isNotEmptyInput(document.registerForm.firstName);
        },
        function() {
            return isNotEmptyInput(document.registerForm.lastName);
        },
        function() {
            return checkLengthPassword(document.registerForm.pass);
        },
        function() {
            return validateEmail(document.registerForm.email);
        },
        function() {
            return validatePhone(document.registerForm.mobileNumber);
        },
        function() {
            return checkStringEquals(document.registerForm.pass, document.registerForm.pass2);
        }
    ];

    callbacks.forEach(function(callback) {
        resultOfFunctions = callback();
        if (resultOfFunctions == false) {
            validAllFields = false;
        }
    });
    return validAllFields;
}

function validateField(condition, element, text) {
    if (!condition) {
        setInvalidClass(element);
        element.parentNode.nextSibling.nextSibling.innerHTML = text;
    } else {
        setValidClass(element);
        element.parentNode.nextSibling.nextSibling.innerHTML = "";
    }
}

function setInvalidClass(element) {
    element.parentNode.previousSibling.previousSibling.className = "text-info-invalid";
    element.className = "invalid";
}

function setValidClass(element) {
    element.parentNode.previousSibling.previousSibling.className = "text-info";
    element.className = "valid";
}

function isNotEmptyInput(input) {
    var result = input.value != "";
    validateField(result, input, "Empty field(JS)");
    return result;
}

function checkLengthPassword(pass) {
    var result = pass.value.length >= 8;
    validateField(result, pass, "Password less then 8 symbols(JS)");
    return result;
}

function validateEmail(email) {
    var regex = /^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
    var result = regex.test(email.value);
    validateField(result, email, "Invalid email format(JS)");
    return result;
}

function validatePhone(phone) {
    var regex = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4,5})$/;
    var result = regex.test(phone.value);
    validateField(result, phone, "Invalid mobile number format(JS)");
    return result;
}

function checkStringEquals(element, element2) {
    var result = element.value == element2.value;
    validateField(result, element2, "Passwords are different(JS)");
    return result;
}
