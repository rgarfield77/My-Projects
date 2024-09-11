<?php
require_once 'connect.php';

// Initialize variables for form fields
$id = $name = $roll_no = $locality = $photo = $subjects = "";

if ($_SERVER['REQUEST_METHOD'] == 'GET' && isset($_GET['id'])) {
    $id = $_GET['id'];

    // Fetch existing data of the student
    $sql = "SELECT * FROM student_info WHERE ID = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $id);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $name = $row['Name'];
        $roll_no = $row['Roll_No'];
        $locality = $row['Locality'];
        $photo = $row['Photo'];
        $subjects = explode(',', $row['Subjects']);
    } else {
        echo "Student record not found.";
        exit();
    }

    $stmt->close(); // Close statement
    $conn->close(); // Close database connection
} elseif ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Handle form submission for updating student record
    $id = $_POST['id'];
    $name = $_POST['name'];
    $roll_no = $_POST['roll_no'];
    $locality = $_POST['locality'];
    $subjects = isset($_POST['subjects']) ? implode(',', $_POST['subjects']) : '';

    // Update the student record
    $sql_update = "UPDATE student_info SET Name = ?, Roll_No = ?, Locality = ?, Subjects = ? WHERE ID = ?";
    $stmt_update = $conn->prepare($sql_update);
    $stmt_update->bind_param("ssssi", $name, $roll_no, $locality, $subjects, $id);

    if ($stmt_update->execute()) {
        // Redirect to manage students page upon successful update
        header("Location: manage_students.php");
        exit();
    } else {
        echo "Error updating record: " . $conn->error;
    }

    $stmt_update->close(); // Close statement
    $conn->close(); // Close database connection
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <link rel="stylesheet" href="edit-student.css">
</head>
<body>
    <div class="container">
        <div class="edit-form-container">
            <h2>Edit Student</h2>
            <form action="edit_student.php" method="post">
                <input type="hidden" name="id" value="<?php echo htmlspecialchars($id); ?>">

                <label for="name">Name:</label><br>
                <input type="text" name="name" id="name" value="<?php echo htmlspecialchars($name); ?>" required><br><br>

                <label for="roll_no">Roll No:</label><br>
                <input type="text" name="roll_no" id="roll_no" value="<?php echo htmlspecialchars($roll_no); ?>" required><br><br>

                <label for="locality">Locality:</label><br>
                <input type="text" name="locality" id="locality" value="<?php echo htmlspecialchars($locality); ?>" required><br><br>

                <label for="subjects">Subjects:</label><br>
                <input type="checkbox" name="subjects[]" value="Maths" <?php if (in_array('Maths', $subjects)) echo 'checked'; ?>> Maths
                <input type="checkbox" name="subjects[]" value="Science" <?php if (in_array('Science', $subjects)) echo 'checked'; ?>> Science<br><br>

                <input type="submit" value="Update">
            </form>
        </div>
    </div>
</body>
</html>



