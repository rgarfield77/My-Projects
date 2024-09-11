<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Database connection (replace with your database details)
    $servername = "localhost";
    $username = "your_username";
    $password = "your_password";
    $dbname = "login_system";

    $conn = new mysqli($servername, $username, $password, $dbname);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Get user input
    $username = validateInput($_POST['username']);
    $email = validateInput($_POST['email']);
    $password = validateInput($_POST['password']);
    $confirmPassword = validateInput($_POST['confirmPassword']);

    // Check if passwords match
    if ($password !== $confirmPassword) {
        echo "Passwords do not match. Please try again.";
        exit;
    }

    // Check if the username or email already exists in the database (you should implement your own logic for this)
    $checkQuery = "SELECT * FROM users WHERE username = '$username' OR email = '$email'";
    $checkResult = $conn->query($checkQuery);

    if ($checkResult->num_rows > 0) {
        echo "Username or email already exists. Please choose a different one.";
    } else {
        // Insert the new user into the database (replace with your database schema)
        $insertQuery = "INSERT INTO users (username, email, password) VALUES ('$username', '$email', '$password')";
        if ($conn->query($insertQuery) === TRUE) {
            // Registration successful, redirect to a success page or login page
            header("Location: login.php");
        } else {
            echo "Error: " . $insertQuery . "<br>" . $conn->error;
        }
    }

    $conn->close();
}

function validateInput($input) {
    // Perform input validation here
    // Example: remove leading/trailing spaces and escape special characters
    $input = trim($input);
    $input = htmlspecialchars($input);
    return $input;
}
?>
