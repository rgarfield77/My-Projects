function setFormMessage(formElement, type, message) {
    const messageElement = formElement.querySelector(".form__message");

    messageElement.textContent = message;
    messageElement.classList.remove("form__message--success", "form__message--error");
    messageElement.classList.add(`form__message--${type}`);
}

function setInputError(inputElement, message) {
    inputElement.classList.add("form__input--error");
    inputElement.parentElement.querySelector(".form__input-error-message").textContent = message;
}

function clearInputError(inputElement) {
    inputElement.classList.remove("form__input--error");
    inputElement.parentElement.querySelector(".form__input-error-message").textContent = "";
}

document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector("#login");
    const createAccountForm = document.querySelector("#createAccount");



    document.querySelector("#linkCreateAccount").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.add("form--hidden");
        createAccountForm.classList.remove("form--hidden");
    });

    document.querySelector("#linkLogin").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.remove("form--hidden");
        createAccountForm.classList.add("form--hidden");
    });


    loginForm.addEventListener("submit", e => {
        e.preventDefault();



        setFormMessage(loginForm, "error", "Invalid username/password combination");
    });
    document.querySelector(".form__link--forgot-password").addEventListener("click", e => {
        e.preventDefault();
        setFormMessage(loginForm, "success", "Password reset link has been sent to your email.");
    });



    document.querySelectorAll(".form__input").forEach(inputElement => {
        inputElement.addEventListener("blur", e => {
            if (e.target.id === "signupUsername" && e.target.value.length > 0 && e.target.value.length < 10) {
                setInputError(inputElement, "Username must be at least 10 characters in length");
            }
        });

        inputElement.addEventListener("input", e => {
            clearInputError(inputElement);
        });
    });
});
function registerUser() {
    var username = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        var resultDiv = document.getElementById('registrationResult');
        resultDiv.textContent = 'Password and Confirm Password do not match.';
        return;
    }



   
    var registrationData = {
        username: username,
        email: email,
        password: password,
        confirmPassword: confirmPassword

    };

   
    var success = simulateBackendRegistration(registrationData);

    var resultDiv = document.getElementById('registrationResult');
    if (success) {
        resultDiv.textContent = 'Account created successfully.';
    } else {
        resultDiv.textContent = 'Error creating account. Please try again.';
    }
}


function simulateBackendRegistration(data) {
    
    return true;
}