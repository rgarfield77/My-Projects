//Name:Garfield Robinson ID:2101010151
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.time.LocalTime.now;

public class CommissionEmployee extends Employee implements Payable{

    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName,String lastName,String socialSecurityNumber){
        super(firstName,lastName,socialSecurityNumber);
        grossSales = 14.6;
        commissionRate = 17.9;
    }


    public void setcommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getcommissionRate() {
        return commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommission(){
        return grossSales * commissionRate;
    }


    @Override
    public double getPaymentAmount() {
        super.getPaymentAmount();
        System.out.println("Gross Sales: " + grossSales);
        System.out.println("commission Rate: " + commissionRate);
        System.out.println("Commission: " + getCommission());
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
                myWriter.write("....... " + "ComissionEmployee" + ".........");
                myWriter.write("\n");
                myWriter.write("First Name: \t\t" + getFirstName());
                myWriter.write("\n");
                myWriter.write("Last Name: \t\t" + getLastName());
                myWriter.write("\n");
                myWriter.write("Social Security Number: \t\t" + getSocialSecurityNumber());
                myWriter.write("\n");
                myWriter.write("Gross Sales: \t\t" + getGrossSales());
                myWriter.write("\n");
                myWriter.write("Commission Rate: \t\t" + getcommissionRate());
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

    }}