//Name:Garfield Robinson ID:2101010151
import java.util.ArrayList;
public class Payroll {
    public static void main(String[] args) {
        
        StaffMember staff = new StaffMember("John", "Wick", "001", 40);
        Manager manager = new Manager("Mark", "Smith", "002", 45, 500);
        SalesRep salesRep = new SalesRep("Alice", "Johnson", "003", 50, 100);
        
        
        System.out.println("--- Staff Information ---");
        staff.display();
        System.out.println();

        System.out.println("--- Manager Information ---");
        manager.display();
        System.out.println();
        
        ArrayList<SalesRep> salesReps = new ArrayList<>();
        //ArrayList<StaffMember> staffList = new ArrayList<>();
        ArrayList<StaffMember> staffList = new ArrayList<>();

        // Adding 5 SalesRep objects to the ArrayList
        salesReps.add(new SalesRep("Alice", "Johnson", "001", 40, 100));
        salesReps.add(new SalesRep("Bob", "Smith", "002", 35, 150));
        salesReps.add(new SalesRep("Charlie", "Brown", "003", 45, 120));
        salesReps.add(new SalesRep("Diana", "Miller", "004", 38, 130));
        salesReps.add(new SalesRep("Eva", "Wilson", "005", 42, 110));
        /*
        staffList.add(new StaffMember("Mario", "Lopez", "009", 26));
        staffList.add(new Manager("Anna", "Robinson", "007", 52, 900));
        staffList.add(new SalesRep("Boris", "Johnson", "022", 44, 200));
        */
        
        
        staffList.add(new StaffMember("John", "Wick", "001", 40));
        staffList.add(new Manager("Mary", "Jane", "005", 50, 700));
        staffList.add(new SalesRep("Daniela", "Nelson", "009", 80, 170));
       


       for (SalesRep SalesRep : salesReps) {
            System.out.println("--- Sales Representative Information ---");
            salesRep.display();
            System.out.println();
        }
        for (int i = 0; i < salesReps.size(); i++) {
            System.out.println("--- Sales Representative " + (i+1) + " Information ---");
            salesReps.get(i).display();
            System.out.println();
        }
        /*
         for (StaffMember staffMember : staffList) {
            System.out.println("--- Staff Information ---");
            staffMember.display();
            if (staffMember instanceof Manager) {
                System.out.println("Salary: $" + ((Manager) staffMember).calculateSalary());
            } else if (staffMember instanceof SalesRep) {
                System.out.println("Salary: $" + ((SalesRep) staffMember).calculateSalary());
            }
            System.out.println();
        }
        */
        
        for (StaffMember staffMember : staffList) {
            System.out.println("--- Staff Information ---");
            staffMember.display();
            System.out.println();
        }
        
    }
}
