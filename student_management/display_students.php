<?php
require_once 'connect.php';

$sql = "SELECT * FROM student_info";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<table border='1'>
            <tr>
                <th>Photo</th>
                <th>Name</th>
                <th>Roll No</th>
                <th>Locality</th>
                <th>Actions</th>
            </tr>";
            while($row = $result->fetch_assoc()) {
                echo "<tr>
                        <td><img src='" . $row["Photo"] . "' alt='Photo' width='50' height='50'></td>
                        <td>" . $row["Name"] . "</td>
                        <td>" . $row["Roll_No"] . "</td>
                        <td>" . $row["Locality"] . "</td>
                        <td class='actions'>
                        
                        <form action='delete_student.php' method='POST' style='display:inline'>
                                <input type='hidden' name='id' value='" . $row["ID"] . "'>
                                <button type='submit' class='delete-btn'>Delete</button>
                            </form>
                            <form action='edit_student.php' method='GET' style='display:inline'>
                                <input type='hidden' name='id' value='" . $row["ID"] . "'>
                                <button type='submit' class='edit-btn'>Edit</button>
                            </form>
                        </td>
                      </tr>";
            }
            
    echo "</table>";
} else {
    echo "<p>0 results</p>";
}

$conn->close();
?>
