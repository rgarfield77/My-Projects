document.addEventListener('DOMContentLoaded', function () {
    const forgotPasswordForm = document.getElementById('forgotPasswordForm');
    const messageDiv = document.getElementById('message');

    forgotPasswordForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const email = document.getElementById('email').value;

        setTimeout(function () {
            messageDiv.textContent = 'Password reset instructions sent to your email.';
        }, 1000);
    });
});
