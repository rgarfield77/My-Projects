//Name:Garfield Robinson ID:2101010151
public class SalesRep extends StaffMember {
    private double allowance;

    public SalesRep(String firstName, String lastName, String deptNumber, double hoursWorked, double allowance) {
        super(firstName, lastName, deptNumber, hoursWorked);
        this.allowance = allowance;
    }

    // Getter and setter for allowance
    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    // Display method
    @Override
    public void display() {
        super.display();
        System.out.println("Allowance: " + allowance);
    }
}