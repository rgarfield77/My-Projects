<?php
require_once 'connect.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $name = $_POST['name'];
    $roll_no = $_POST['roll_no'];
    $locality = $_POST['locality'];
    $subjects = isset($_POST['subjects']) ? implode(',', $_POST['subjects']) : '';

    // Handle file upload
    $target_dir = "uploads/";
    $target_file = $target_dir . basename($_FILES["photo"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
    $error_message = "";

    // Check if directory exists
    if (!is_dir($target_dir)) {
        $error_message .= "Directory does not exist.<br>";
        $uploadOk = 0;
    }

    // Check if directory is writable
    if (!is_writable($target_dir)) {
        $error_message .= "Directory is not writable.<br>";
        $uploadOk = 0;
    }

    // Check if file already exists
    if (file_exists($target_file)) {
        $error_message .= "Sorry, file already exists.<br>";
        $uploadOk = 0;
    }

    // Check file size
    if ($_FILES["photo"]["size"] > 500000) {
        $error_message .= "Sorry, your file is too large.<br>";
        $uploadOk = 0;
    }

    // Allow certain file formats
    if ($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif") {
        $error_message .= "Sorry, only JPG, JPEG, PNG & GIF files are allowed.<br>";
        $uploadOk = 0;
    }

    // Check for duplicates
    $sql_check = "SELECT COUNT(*) as count FROM student_info WHERE Name = ? AND Roll_No = ?";
    $stmt_check = $conn->prepare($sql_check);
    $stmt_check->bind_param("ss", $name, $roll_no);
    $stmt_check->execute();
    $result = $stmt_check->get_result();
    $row = $result->fetch_assoc();
    $count = $row['count'];

    if ($count > 0) {
        $error_message .= "Record with Name '$name' and Roll No '$roll_no' already exists.<br>";
        $uploadOk = 0;
    }

    if ($uploadOk == 0) {
        // Redirect back to form with error message
        $stmt_check->close();
        header("Location: manage_students.php?error_message=" . urlencode($error_message));
        exit();
    } else {
        if (move_uploaded_file($_FILES["photo"]["tmp_name"], $target_file)) {
            $photo = $target_file;
            // Insert data into database using prepared statement
            $sql_insert = "INSERT INTO student_info (Name, Roll_No, Locality, Photo, Subjects) VALUES (?, ?, ?, ?, ?)";
            $stmt_insert = $conn->prepare($sql_insert);
            $stmt_insert->bind_param("sssss", $name, $roll_no, $locality, $photo, $subjects);

            if ($stmt_insert->execute()) {
                // Redirect to the manage students page upon successful insertion
                header("Location: manage_students.php");
                exit();
            } else {
                $error_message .= "Error: " . $sql_insert . "<br>" . $conn->error;
                header("Location: manage_students.php?error_message=" . urlencode($error_message));
                exit();
            }
            $stmt_insert->close(); // Close statement
        } else {
            $error_message .= "Sorry, there was an error uploading your file.<br>";
            $error_message .= "Debugging information:<br>";
            $error_message .= "Error code: " . $_FILES["photo"]["error"] . "<br>";
            header("Location: manage_students.php?error_message=" . urlencode($error_message));
            exit();
        }
    }

    $stmt_check->close(); // Close statement
    $conn->close(); // Close database connection
}
?>
