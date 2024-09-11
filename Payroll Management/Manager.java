//Name:Garfield Robinson ID:2101010151
public class Manager extends StaffMember {
    private double bonus;

    public Manager(String firstName, String lastName, String deptNumber, double hoursWorked, double bonus) {
        super(firstName, lastName, deptNumber, hoursWorked);
        this.bonus = bonus;
    }

    // Getter and setter for bonus
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Display method
    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonus);
    }
}
