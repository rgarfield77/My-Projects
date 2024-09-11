<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $name = $_POST['name'];
  $email = $_POST['email'];
  $message = $_POST['message'];

  $to = 'recipient@example.com'; // Replace with the recipient's email address
  $subject = ' Diamond Cosmetrics New Contact Form Submission';
  $headers = "From: $email";

  $message_body = "Name: $name\nEmail: $email\n\nMessage:\n$message";

  if (mail($to, $subject, $message_body, $headers)) {
    echo " You have successfully contacted Diamond Cosmetrics!";
  } else {
    echo "Failed to contact Diamond Cosmetrics.";
  }
}
?>
