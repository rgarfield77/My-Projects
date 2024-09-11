//Name:Garfield Robinson ID:2101010151
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.time.LocalTime.now;

public class HourlyEmployee extends Employee implements Payable {

    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        wage = 35.7;
        hours = 34.9;

    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    public double gethourlyPayment()
    {
        return (wage * hours);
    }

    @Override
    public double getPaymentAmount() {
        super.getPaymentAmount();
        System.out.println("Wage: " + wage);
        System.out.println("Hours: " + hours);
        System.out.println("Hourly Pay: " + gethourlyPayment());


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
                myWriter.write("....... " + "HourlyEmployee" + ".........");
                myWriter.write("\n");
                myWriter.write("First Name: \t\t" + getFirstName());
                myWriter.write("\n");
                myWriter.write("Last Name: \t\t" + getLastName());
                myWriter.write("\n");
                myWriter.write("Social Security Number: \t\t" + getSocialSecurityNumber());
                myWriter.write("\n");
                myWriter.write("Wage: \t\t" + getWage());
                myWriter.write("\n");
                myWriter.write("Hours: \t\t" + getHours());
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
