<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $servername = "localhost";
    $username = "your_username";
    $password = "your_password";
    $dbname = "login_system";

    $conn = new mysqli($servername, $username, $password, $dbname);

   
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    
    $usernameOrEmail = validateInput($_POST['usernameOrEmail']);
    $password = validateInput($_POST['password']);

    
    $sql = "SELECT * FROM users WHERE (username = '$usernameOrEmail' OR email = '$usernameOrEmail') AND password = '$password'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        
        header("Location: success.php");
    } else {
        
        echo "Authentication failed. Please check your username/email and password.";
    }

    $conn->close();
}

function validateInput($input) {
    
    $input = trim($input);
    $input = htmlspecialchars($input);
    return $input;
}
?>
