import java.util.*;

import javax.swing.JOptionPane;

class Employee {
    public String name;
    public double salary;
    public double deduction;
    public double bonus;

    protected Employee(String name, double salary, double deduction, double bonus) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.deduction = deduction;
    }
}

class RegularEmployee extends Employee {
    public int id;

    public RegularEmployee(int id, String name, double salary, double deduction, double bonus) {
        super(name, salary, deduction, bonus);
        this.id = id;
    }

    public void loadDataRegular(){
        App.addRecord(id, name, 0, 0, deduction, bonus, "R", salary);
    }
}

class ContractEmployee extends Employee {
    public int id;
    public int workDays;
    public double dailyWage;

    public ContractEmployee(int id, String name, double salary, int workDays, double deduction, double bonus, double dailyWage) {
        super(name, salary, deduction, bonus);
        this.id = id;
        this.workDays = workDays;
        this.dailyWage = dailyWage;
    }

    public void loadDataContract(){
        App.addRecord(id, name, workDays, dailyWage, deduction, bonus, "C", (workDays * dailyWage));
    }
}

public class CS {
    
    public void addRegularEmployee(int id, String name, double salary, double deductions, double bonuses) {
        RegularEmployee temp = new RegularEmployee(id, name, salary, deductions, bonuses);
        temp.loadDataRegular();
    }
    
    public void addContractEmployee(int id, String name, double salary, int workingDays, double dailyWage, double deductions, double bonuses) {
        ContractEmployee temp = new ContractEmployee(id, name, salary, workingDays, deductions, bonuses, dailyWage);
        temp.loadDataContract();
    }

    public void generatePaySlipRegularEmployee(int id, String[] data) {
        if(data == null){
            JOptionPane.showMessageDialog(null, "Regular employee with ID " + id + " not found.");
            return;
        }
        double salary = Double.parseDouble(data[7]);
        double deduction = Double.parseDouble(data[4]);
        double bonus = Double.parseDouble(data[5]);
    

        String writeThis = "\n\n_____|/|/|/|:PAY SLIP:|/|/|/|_____\n" + "Pay Slip for Regular Employee:\n\n" + "Name: " + data[1] + "\n" + "ID: " + data[0] + "\n" + "Salary: " + data[7] + "\n" + "Deduction: " + data[4] + "\n" + "Bonus: " + data[5] + "\n" + "Employee Type: " + data[6] + "\n" + "Net Salary: " + (salary - deduction + bonus) + "\n";

        JOptionPane.showMessageDialog(null, writeThis);

    }

    public void generatePaySlipContractEmployee(int id, String[] data) {
        if(data == null){
            JOptionPane.showMessageDialog(null, "\nContract employee with ID " + id + " not found.\n\n");
            return;
        }
        double salary = Double.parseDouble(data[7]);
        double deduction = Double.parseDouble(data[4]);
        double bonus = Double.parseDouble(data[5]);

        String writeThis = "\n\n_____|/|/|/|:PAY SLIP:|/|/|/|_____\n"+"Pay Slip for Contract Employee:\n\n"+"\nName: " + data[1]+"\nID: " + data[0]+"\nSalary: " + data[7]+"\nWorking Days: " + data[2]+"\nDaily Wage: " + data[3]+"\nDeduction: "+ data[4]+"\nBonus: " + data[5]+"\nEmployee Type: " + data[6]+"\nNet Salary: " + (salary - deduction + bonus) + "\n";
        JOptionPane.showMessageDialog(null, writeThis);
    }

    public static void main(String[] args) {
        App.createTable();
        
    }
}