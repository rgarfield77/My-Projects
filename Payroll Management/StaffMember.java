//Name:Garfield Robinson ID:2101010151

public class StaffMember {
    private String firstName;
    private String lastName;
    private String deptNumber;
    private double hoursWorked;

    public StaffMember(String firstName, String lastName, String deptNumber, double hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptNumber = deptNumber;
        this.hoursWorked = hoursWorked;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
   // public abstract double calculateSalary();

    // Display method
    public void display() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Department Number: " + deptNumber);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}
