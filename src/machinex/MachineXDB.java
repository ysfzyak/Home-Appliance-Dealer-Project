package machinex;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.SQLException;

/**
 *
 * @author ysfzyak
 */

public class MachineXDB {
    
    public void connect(){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/machinex","root","");  

            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT * FROM geraete");  //z.B Informationen aus der Geraete-Datenbank auslesen.
           
            while(rs.next()){ 
                System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getInt(5));  
                con.close();  
            }
            
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
        }  
    }
}

 