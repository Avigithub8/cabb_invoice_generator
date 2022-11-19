
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dbconnect {
    static public Connection c;
    static public Statement st;
    static public PreparedStatement insertUser;
    static public PreparedStatement getUsers;
    static public PreparedStatement executeUsers;
    static public PreparedStatement insertInvoice;
    static public PreparedStatement getInvoice;
    static public PreparedStatement executeInvoice;
    static{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "Avnish","Avnish");
            st=c.createStatement();
           insertUser=c.prepareStatement("insert into cabb_info(cab_no,name,father_name,today_date,mobile_no,address,area,aadharcard_no)values(?,?,?,?,?,?,?,?)");
          // insertUser=c.prepareStatement("insert into cabb_info (cab_no) values(?)");
           getUsers=c.prepareStatement("select * from cabb_info where name like?");
            executeUsers=c.prepareStatement("update cabb_info set cab_no=?,name=?,father_name,date=?,mobile_no=?,"
                    + "address=?,area=?,aadharcard_no=?");
            insertInvoice=c.prepareStatement("insert into invoic_info(pickup_spot,destination,tdate,today_time,driver_name,distance,starting_fare,fare_km,fare)values(?,?,?,?,?,?,?,?,?)");
            getInvoice=c.prepareStatement("select * from invoic_info where name like");
            executeInvoice=c.prepareStatement("update  invoic_info set pickup_spot=?,destination=?,tdate=?,today_time=?,driver_name=?,distance=?,starting_fare=?,fare_km=?,fare=?");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    
}
