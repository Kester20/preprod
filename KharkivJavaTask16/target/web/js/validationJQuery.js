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
        $(element).parent().next().html(text);
    } else {
        setValidClass(element);
        $(element).parent().next().html("");
    }
}

function setInvalidClass(element) {
    $(element).parent().prev().addClass("text-info-invalid");
    $(element).addClass("invalid");
}

function setValidClass(element) {
    $(element).parent().prev().removeClass("text-info-invalid");
    $(element).removeClass("invalid");
}

function isNotEmptyInput(input) {
    var result = $(input).val() != "";
    validateField(result, input, "Empty field");
    return result;
}

function checkLengthPassword(pass) {
    var result = $(pass).val().length >= 8;
    validateField(result, pass, "Password less then 8 symbols");
    return result;
}

function validateEmail(email) {
    var regex = /^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
    var result = regex.test($(email).val());
    validateField(result, email, "Invalid email format");
    return result;
}

function validatePhone(phone) {
    var regex = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4,5})$/;
    var result = regex.test($(phone).val());
    validateField(result, phone, "Invalid mobile number format");
    return result;
}

function checkStringEquals(element, element2) {
    var result = $(element).val() == $(element2).val();
    validateField(result, element2, "Passwords are different");
    return result;
}
