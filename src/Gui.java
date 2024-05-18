import javax.swing.*;

import java.awt.Font;
// import java.awt.*;
import java.awt.event.*;

public class Gui {

    public void add_contract() {

        ImageIcon i = new ImageIcon("contractor.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel(); // Added JPanel
        panel.setLayout(null); // Set layout to null for manual component positioning
        j.setVisible(true);
        j.setTitle("ADD Contract EMPLOYEE");
        j.setSize(450, 550); // Adjusted the JFrame size
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Enter ID:  ");
        label1.setBounds(50, 70, 300, 30);
        panel.add(label1);

        JTextField F1 = new JTextField();
        F1.setBounds(50, 100, 300, 30);
        panel.add(F1);

        JLabel label2 = new JLabel("Enter Name:  ");
        label2.setBounds(50, 140, 300, 30);
        panel.add(label2);

        JTextField F2 = new JTextField();
        F2.setBounds(50, 170, 300, 30);
        panel.add(F2);

        JLabel label3 = new JLabel("Enter NO OF WORKING DAYS:  ");
        label3.setBounds(50, 210, 300, 30);
        panel.add(label3);

        JTextField F3 = new JTextField();
        F3.setBounds(50, 240, 300, 30);
        panel.add(F3);

        JLabel label4 = new JLabel("Enter DAILY WAGES(IN RS):  ");
        label4.setBounds(50, 280, 300, 30);
        panel.add(label4);

        JTextField F4 = new JTextField();
        F4.setBounds(50, 310, 300, 30);
        panel.add(F4);

        JLabel label5 = new JLabel("Enter DEDUCTION :  ");
        label5.setBounds(50, 350, 300, 30);
        panel.add(label5);

        JTextField F5 = new JTextField();
        F5.setBounds(50, 380, 300, 30);
        panel.add(F5);

        JLabel label6 = new JLabel("Enter BONUS :  ");
        label6.setBounds(50, 420, 300, 30);
        panel.add(label6);

        JTextField F6 = new JTextField();
        F6.setBounds(50, 450, 300, 30);
        panel.add(F6);

        CS C = new CS();
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 490, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 

                int id = Integer.parseInt(F1.getText());
                String name = F2.getText();
                int workingDays = Integer.parseInt(F3.getText());
                double dailyWage = Double.parseDouble(F4.getText());
                double deductions = Double.parseDouble(F5.getText());
                double bonuses = Double.parseDouble(F6.getText()); 
                C.addContractEmployee(id, name, 0, workingDays, dailyWage, deductions, bonuses);
            }
        });
        panel.add(submitButton);


        j.add(panel);
    }


    public void add_permanent() {

        ImageIcon i = new ImageIcon("Permanent.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel(); 
        panel.setLayout(null); 
        j.setVisible(true);
        j.setTitle("ADD PERMANENT EMPLOYEE");
        j.setSize(450, 550); 
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Enter ID:  ");
        label1.setBounds(50, 70, 300, 30);
        panel.add(label1);

        JTextField F1 = new JTextField();
        F1.setBounds(50, 100, 300, 30);
        panel.add(F1);

        JLabel label2 = new JLabel("Enter Name:  ");
        label2.setBounds(50, 140, 300, 30);
        panel.add(label2);

        JTextField F2 = new JTextField();
        F2.setBounds(50, 170, 300, 30);
        panel.add(F2);

        JLabel label3 = new JLabel("Enter SALARY (in RS):  ");
        label3.setBounds(50, 210, 300, 30);
        panel.add(label3);

        JTextField F3 = new JTextField();
        F3.setBounds(50, 240, 300, 30);
        panel.add(F3);

        JLabel label4 = new JLabel("Enter DEDUCTION(IN RS):  ");
        label4.setBounds(50, 280, 300, 30);
        panel.add(label4);

        JTextField F4 = new JTextField();
        F4.setBounds(50, 310, 300, 30);
        panel.add(F4);

        JLabel label5 = new JLabel("Enter BONUS(in RS) :  ");
        label5.setBounds(50, 350, 300, 30);
        panel.add(label5);

        JTextField F5 = new JTextField();
        F5.setBounds(50, 380, 300, 30);
        panel.add(F5);

        
        CS C = new CS();
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 420, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                    // Get values from text fields
                    int id = Integer.parseInt(F1.getText());
                    String name = F2.getText();
                    double salary = Double.parseDouble(F3.getText());
                    double deductions = Double.parseDouble(F4.getText());
                    double bonuses = Double.parseDouble(F5.getText());
                    

                    
                    C.addRegularEmployee(id, name, salary, deductions, bonuses);
               
            }
        });
        panel.add(submitButton);


        j.add(panel); 
    }

    public void generatePaySlip_Regular_Emply(){
        ImageIcon i = new ImageIcon("abc.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null); 
        j.setVisible(true);
        j.setTitle("GENERATE PAYSLIP FOR REGULAR EMPLOYEE"); // Adjusted JFrame title
        j.setSize(450, 550); 
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l = new JLabel("Enter Data ");
        l.setBounds(50, 70, 300, 30);
        panel.add(l);
        JTextField F5 = new JTextField();
        F5.setBounds(50, 100, 300, 30);
        panel.add(F5);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 420, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(F5.getText());
                String[] data_regular = App.generatePaySlipContract(id);
                CS user = new CS();
                user.generatePaySlipRegularEmployee(id, data_regular);
            }
        });
        panel.add(submitButton);
        j.add(panel);
    }
    public void generatePaySlip_Contract_Emply(){
        ImageIcon i = new ImageIcon("abc.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null); 
        j.setVisible(true);
        j.setTitle("GENERATE PAYSLIP FOR Contract EMPLOYEE"); 
        j.setIconImage(i.getImage());
        j.setSize(450, 550); 
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel Lt = new JLabel(" Generate Payslip ");
        Lt.setHorizontalAlignment(JLabel.CENTER);
        Lt.setVerticalAlignment(JLabel.TOP);
        
        
        JLabel l = new JLabel("Enter Data ");
        l.setBounds(50, 100, 300, 30);
        panel.add(l);
        JTextField F5 = new JTextField();
        F5.setBounds(50, 125, 300, 30);
        panel.add(F5);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 420, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(F5.getText());
                String[] data_regular = App.generatePaySlipContract(id);
                CS user = new CS();
                user.generatePaySlipContractEmployee(id, data_regular);
            }
        });
        panel.add(submitButton);
        j.add(panel);
    }
    

    public static void main(String[] args) {
        JFrame j = new JFrame();
        Gui g = new Gui();
        ImageIcon i = new ImageIcon("payslip.png");
        JLabel l = new JLabel();
        JLabel Li = new JLabel();
        Font f = new Font("Times New Roman", Font.BOLD, 26);
        l.setFont(f);
        l.setVisible(true);
        l.setText("PAYSLIP GENERATOR");
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.TOP);
        j.add(l);

        // Li.setIcon(i);
        // Li.setHorizontalAlignment(JLabel.LEFT);
        // Li.setVerticalAlignment(JLabel.TOP);
        // j.add(Li);
        JButton CE = new JButton("ADD CONTRACT EMPLOYEE");
        CE.setBounds(50, 100, 300, 50);

        CE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.add_contract(); // Calling add_contract() function
            }
        });

        JButton PE = new JButton("ADD PERMANENT EMPLOYEE");
        PE.setBounds(50, 160, 300, 50);
        PE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.add_permanent(); // Calling add_contract() function
            }
        });

        JButton GCE = new JButton("GENERATE PAYSLIP FOR CONTRACT EMPLOYEE");
        GCE.setBounds(50, 220, 300, 50);
        GCE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.generatePaySlip_Contract_Emply();// Calling add_contract() function
            }
        });

        JButton GPE = new JButton("GENERATE PAYSLIP FOR PERMANENT EMPLOYEE");
        GPE.setBounds(50, 280, 300, 50);
        GPE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.generatePaySlip_Regular_Emply();;// Calling add_contract() function
            }
        });

        
        j.setVisible(true);
        j.setTitle("Payslip Generator");
        j.setSize(450, 550); 
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.add(l);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null); 
        j.add(CE);
        j.add(PE);
        j.add(GCE);
        j.add(GPE);
    }
}
