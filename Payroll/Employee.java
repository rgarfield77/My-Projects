//Name:Garfield Robinson ID:2101010151
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.time.LocalTime.now;

public class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName,String lastName,String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public double getPaymentAmount() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " +lastName);
        System.out.println("Social Security Number: " + socialSecurityNumber);

        return 0;
    }

    @Override
    public void writetoFile() {

            try {
                File myObj = new File("Paystub.txt");
                if (myObj.createNewFile()) System.out.println("File has been created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("Paystub.txt",true);
                myWriter.write("....... " +"Employee"+ ".........");
                myWriter.write("\n");
                myWriter.write("\n");
                myWriter.write("First Name: \t\t" + getFirstName());
                myWriter.write("\n");
                myWriter.write("Last Name: \t\t" + getLastName());
                myWriter.write("\n");
                myWriter.write("Social Security Number: \t\t" + getSocialSecurityNumber());
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

