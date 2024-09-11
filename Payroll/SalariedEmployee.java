//Name:Garfield Robinson ID:2101010151
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.time.LocalTime.now;

public class SalariedEmployee extends Employee implements  Payable{

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        weeklySalary = 14.7;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        super.getPaymentAmount();
        System.out.println("Week Salary: " + weeklySalary);
        return 0;
    }

    @Override
    public void writetoFile() {
        {
            try {
                File myObj = new File("Paystub.txt");
                if (myObj.createNewFile())
                    System.out.println("File has been created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("Paystub.txt", true);
                myWriter.write("....... " + "SalariedEmployee" + ".........");
                myWriter.write("\n");
                myWriter.write("First Name: \t\t" + getFirstName());
                myWriter.write("\n");
                myWriter.write("Last Name: \t\t" + getLastName());
                myWriter.write("\n");
                myWriter.write("Social Security Number: \t\t" + getSocialSecurityNumber());
                myWriter.write("\n");
                myWriter.write("Week Salary:\t\t" + getWeeklySalary());
                myWriter.write("\n");
                myWriter.write("Date of Payment: " + now());
                myWriter.close();


            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}
