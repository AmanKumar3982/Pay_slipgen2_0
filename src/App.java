// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.sql.ResultSet;

// public class App{
//     void createTable(){
//         final String DB_URL = "jdbc:mysql://localhost:3306/";
//         final String USER = "root";
//         final String PASS = "Aman@2023";
//         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);Statement stmt = conn.createStatement();){
//             String sql = "CREATE TABLE PAYSLIP.PAYSLIP (ID INT ,NAME VARCHAR(100),SALARY DOUBLE , WORKING_DAYS INT,DAILYWAGES DOUBLE,DEDUCTION DOUBLE , BONUS DOUBLE ,TYPE VARCHAR(2), SALARY DOUBLE)";
//             stmt.executeUpdate(sql);
//             // System.out.println("Successfully.");
//             // JOptionPane.showMessageDialog(null, "TABLE CREATED.");
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     static void addRecord(int id, String name, int workingDays, double dailyWage, double deductions, double bonuses, String type, double salary){
//         final String DB_URL = "jdbc:mysql://localhost:3306/";
//         final String USER = "root";
//         final String PASS = "Aman@2023";
//         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);Statement stmt = conn.createStatement();){
//             name = "'" + name + "'";
//             type = "'" + type + "'";
            
//             name = name.toUpperCase();
//             type = type.toUpperCase();
            
//             String sql = "INSERT INTO PAYSLIP.PAYSLIP VALUES(" + id + ',' + name + ',' + workingDays + ',' + dailyWage + ',' + deductions + ',' + bonuses + ',' + type + "," + salary + ")";
//             stmt.executeUpdate(sql);
            
//             // System.out.println("Successfully.");
//             // JOptionPane.showMessageDialog(null, sql);
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }

//         return;
//     }


//     public static String[] generatePaySlipContract(int id){
//         final String DB_URL = "jdbc:mysql://localhost:3306/";
//         final String USER = "root";
//         final String PASS = "Aman@2023";
//         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);Statement stmt = conn.createStatement();){
//             ResultSet r;
            
//             String sql = "SELECT * from payslip.payslip where id = " + id + " and type = " + "'C'";

//             // Calculate Gross Salary
//             // sql = "SELECT ((dailywages * working_days) - deduction + bonus) as salary from payslip.payslip where id = " + id;
//             r = stmt.executeQuery(sql);
//             while (r.next()) {
//                 String[] data = {
//                     Integer.toString(r.getInt("ID")),
//                     r.getString("NAME"),
//                     Integer.toString(r.getInt("WORKING_DAYS")),
//                     Double.toString(r.getDouble("DAILYWAGES")),
//                     Double.toString(r.getDouble("DEDUCTION")),
//                     Double.toString(r.getDouble("BONUS")),
//                     r.getString("TYPE"),
//                     Double.toString(r.getDouble("SALARY"))
//                 };
//                 return data;
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return null;
//     }


//     public static String[] generatePaySlipRegular(int id){
//         final String DB_URL = "jdbc:mysql://localhost:3306/";
//         final String USER = "root";
//         final String PASS = "Aman@2023";
//         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);Statement stmt = conn.createStatement();){
//             ResultSet r;
            
//             String sql = "SELECT * from payslip.payslip where id = " + id + " and type = " + "'R'";

//             // Calculate Gross Salary
//             // sql = "SELECT ((dailywages * working_days) - deduction + bonus) as salary from payslip.payslip where id = " + id;
//             r = stmt.executeQuery(sql);
//             while (r.next()) {
//                 String[] data = {
//                     Integer.toString(r.getInt("ID")),
//                     r.getString("NAME"),
//                     Integer.toString(r.getInt("WORKING_DAYS")),
//                     Double.toString(r.getDouble("DAILYWAGES")),
//                     Double.toString(r.getDouble("DEDUCTION")),
//                     Double.toString(r.getDouble("BONUS")),
//                     r.getString("TYPE"),
//                     Double.toString(r.getDouble("SALARY"))
//                 };
//                 return data;
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return null;
//     }
// }



import java.sql.*;

import javax.swing.JOptionPane;
public class App{
    public static void createTable(){
        final String DB_URL = "jdbc:mysql://localhost:3306/";
        final String USER = "root", PASS = "Aman@2023";
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS);Statement s = c.createStatement()){
            String sql = "CREATE TABLE PAYSLIP.PAYSLIP(ID INT PRIMARY KEY ,NAME VARCHAR(100), WORKING_DAYS INT,DAILYWAGES DOUBLE,DEDUCTION DOUBLE,BONUS DOUBLE,TYPE VARCHAR(2),SALARY DOUBLE)";
            s.executeUpdate(sql);
            System.out.println("Table created successfully.");
        }catch(SQLException e){System.out.println("Table already exists.");}
        return;
    }
    static void addRecord(int id, String name, int workingDays, double dailyWage, double deductions, double bonuses, String type, double salary){
        final String DB_URL = "jdbc:mysql://localhost:3306/";
        final String USER = "root", PASS = "Aman@2023";
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS);Statement s = c.createStatement()){
            name = "'" + name.toUpperCase() + "'";
            type = "'" + type.toUpperCase() + "'";
            String sql = "INSERT INTO PAYSLIP.PAYSLIP VALUES(" + id + ',' + name + ',' + workingDays + ',' + dailyWage + ',' + deductions + ',' + bonuses + ',' + type + "," + salary + ")";
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
        }catch(Exception e){ JOptionPane.showMessageDialog(null, "Please enter valid data in all fields!"); }
    }
    public static String[] generatePaySlipContract(int id){ return generatePaySlip(id, "'C'"); }
    public static String[] generatePaySlipRegular(int id){ return generatePaySlip(id, "'R'"); }
    private static String[] generatePaySlip(int id, String type){
        final String DB_URL = "jdbc:mysql://localhost:3306/";
        final String USER = "root", PASS = "Aman@2023";
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS);Statement s = c.createStatement()){
            String sql = "SELECT * FROM payslip.payslip WHERE id = " + id + " AND type = " + type;
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                return new String[]{
                    Integer.toString(r.getInt("ID")),
                    r.getString("NAME"),
                    Integer.toString(r.getInt("WORKING_DAYS")),
                    Double.toString(r.getDouble("DAILYWAGES")),
                    Double.toString(r.getDouble("DEDUCTION")),
                    Double.toString(r.getDouble("BONUS")),
                    r.getString("TYPE"),
                    Double.toString(r.getDouble("SALARY"))
                };
            }
        }catch(SQLException e){ e.printStackTrace(); }
        return null;
    }
}
