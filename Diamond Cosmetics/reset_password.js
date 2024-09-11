function resetPassword() {
    var newPassword = document.getElementById('newPassword').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    if (newPassword !== confirmPassword) {
        displayResult('Passwords do not match.', true);
    } else {
       
        displayResult('Password reset successfully.', false);
    }
}

function displayResult(message, isError) {
    var resultDiv = document.getElementById('resetResult');
    resultDiv.textContent = message;
    resultDiv.style.color = isError ? 'red' : 'green';
}

