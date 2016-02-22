
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import static javafx.beans.binding.Bindings.select;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bozhidar
 */
public class NewClass {
                private static final String USERNAME = "b4a0b236938a80";
                private static final String PASSWORD ="f0e9b6fd";
                private static final String url ="Database=b.tashev;Data Source=eu-cdbr-azure-north-d.cloudapp.net;User Id=b4a0b236938a80;Password=f0e9b6fd";
                private static final String url2 ="eu-cdbr-azure-north-d.cloudapp.net";
                private static final String str = "jdbc:mysql://eu-cdbr-azure-north-d.cloudapp.net:3306/b.tashev?zeroDateTimeBehavior=convertToNull";
                private static Statement stmt = null;
                private static String query =  "SELECT * FROM user";
 
               // private static String insert = "INSERT INTO 'btashev'.'user' VALUES ('"+user_ID+"','"+username+"','"+password+"','"+balance+"')";
                
                public static void main(String[] args){        
                   
                    
            Connection conn = null;
            
            try{               
               conn = DriverManager.getConnection(str,USERNAME,PASSWORD);             
                System.out.println(query);
              stmt =conn.createStatement();
              ResultSet rs = stmt.executeQuery(query);
                 int user_ID = 123456889;
                 String username = "test544644";
                 int password = 1234789; 
                 double balance = 999.99;
              //String insert = "INSERT INTO 'btashev'.'user' VALUES ('"+user_ID+"','"+username+"','"+password+"','"+balance+"')";
                
             // String insert = "INSERT INTO 'user' VALUES ('+user_ID+','"+username+"','"+password+"','+balance+')";
                //stmt.executeUpdate("INSERT INTO user " + "VALUES (68486, 'na6me1', 'pa6ssword1',9595.54)");  
                stmt.executeUpdate("INSERT INTO user " + "VALUES ('"+user_ID+"', '"+username+"', '"+password+"',"+balance+")");     
               
                
                System.out.println("HEYYY");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("ARRR");
            }
            
        }
}
