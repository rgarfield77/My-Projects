<?php
require_once 'connect.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['id'])) {
    $id = $_POST['id'];

    // Prepare SQL statement for deletion
    $sql = "DELETE FROM student_info WHERE ID = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $id);

    // Execute the deletion
    if ($stmt->execute()) {
        // Redirect to the manage students page upon successful deletion
        header("Location: manage_students.php");
        exit();
    } else {
        echo "Error deleting record: " . $conn->error;
    }

    $stmt->close(); // Close statement
    $conn->close(); // Close database connection
} else {
    echo "Invalid request. Please provide a student ID to delete.";
}
?>
