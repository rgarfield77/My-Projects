//Name:Garfield Robinson ID:2101010151
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.time.LocalTime.now;

public class Invoice implements Payable {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double priceperItem;

    public Invoice(String partNumber,String partDescription,int quantity,double priceperItem){
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.priceperItem = priceperItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getquantity() {
        return quantity;
    }

    public double getPriceperItem() {
        return priceperItem;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPriceperItem(double priceperItem) {
        this.priceperItem = priceperItem;
    }

    @Override
    public double getPaymentAmount() {
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + partDescription);
        System.out.println("Quantity of Item: " + quantity);
        System.out.println("Price Per Item: " + priceperItem);

        return 0;
    }

    @Override
    public void writetoFile() {
        try {
            File myObj = new File("Paystub.txt");
            if (myObj.createNewFile())
            System.out.println("File has been created: " + myObj.getName());
            FileWriter myWriter = new FileWriter("Paystub.txt",true);
            myWriter.write("....... " +"Invoice"+ ".........");
            myWriter.write("\n");
            myWriter.write("\n");
            myWriter.write("Part Number: \t\t" + getPartNumber());
            myWriter.write("\n");
            myWriter.write("Part Description: \t\t" + getPartDescription());
            myWriter.write("\n");
            myWriter.write("Quantity of Item: \t\t" + getquantity());
            myWriter.write("\n");
            myWriter.write("Price Per Item: \t\t" + getPriceperItem());
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
