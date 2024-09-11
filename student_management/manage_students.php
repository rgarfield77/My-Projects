<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Students</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="student-list">
            <h2>Manage Students</h2>
            <?php include 'display_students.php'; ?>
        </div>

        <div class="add-student-form">
            <br>
            <?php if (isset($_GET['error_message']) && !empty($_GET['error_message'])): ?>
                <div style="color: red;">
                    <?php echo $_GET['error_message']; ?>
                </div>
            <?php endif; ?>

            <form action="add_student.php" method="post" enctype="multipart/form-data">
                <label for="name">Name:</label><br>
                <input type="text" name="name" id="name" required><br><br>

                <label for="roll_no">Roll No:</label><br>
                <input type="text" name="roll_no" id="roll_no" required><br><br>

                <label for="locality">Locality:</label><br>
                <input type="text" name="locality" id="locality" required><br><br>

                <label for="photo">Image:</label><br>
                <input type="file" name="photo" id="photo" accept="image/*" required><br><br>

                <label for="subjects">Subjects:</label><br>
                <input type="checkbox" name="subjects[]" value="Maths"> Maths
                <input type="checkbox" name="subjects[]" value="Science"> Science<br><br>

                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>


