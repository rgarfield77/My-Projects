//Name:Garfield Robinson ID:2101010151
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

  public class Main {
    public static void main(String[] args) {

        Employee e = new Employee("Garfield","Robinson","864-41-XXXX");
        e.writetoFile();
        Invoice i = new Invoice("3","Account",4,3.5);
        i.writetoFile();


        e.getPaymentAmount();
        i.getPaymentAmount();


        HourlyEmployee h = new HourlyEmployee("John","Cena","619-58-XXXX");
        double wage = h.getWage();
        double hours = h.getHours();
        System.out.println("Hourly Pay: " + h.gethourlyPayment());
        h.writetoFile();


        SalariedEmployee s = new SalariedEmployee("Jade", "Cargill","333-54-XXXX");
        double weeklySalary = s.getWeeklySalary();
        System.out.println("Weekly Salary: " + weeklySalary);
        s.writetoFile();

        CommissionEmployee c = new CommissionEmployee("Mark", "Robinson","789-12-XXXX");
        double grossSales = c.getGrossSales();
        double commissionRate = c.getcommissionRate();
        System.out.println("Gross Sales: " + grossSales);
        System.out.println("Commission Rate: " + commissionRate);
        System.out.println("Commission: " + c.getCommission());
        c.writetoFile();


    }

  }