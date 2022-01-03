import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.sound.sampled.SourceDataLine;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.result.SqlDateValueFactory;

public class mySQLAccess{

    static String url = "jdbc:mysql://127.0.0.1:3306/loginsystem";
    static String userName = "root";
    static String userPassword = "password";
    static String uName;
    static String uPassword;
    static ResultSet rs;

    public mySQLAccess(String uName, String uPassword){
        this.uName = uName;
        this.uPassword = uPassword;
    }

    

    public boolean checkUser(){ 
            try{
                // Database Connection
                Connection myConn = DriverManager.getConnection(url, userName, userPassword);
                
                // Create Statement
                Statement myStmt = myConn.createStatement();
                
                // Execute SQL Query
                String sql = "SELECT userName FROM loginauthentication WHERE EXISTS(SELECT userName FROM loginauthentication WHERE userName = '" + uName +"')";
               rs =  myStmt.executeQuery(sql);

               if(rs.next() == true){
                   System.out.println("That user exists");
                   return true;
               }else{
                System.out.println("That user does not exist");
                return false;
               }
        
            }catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }
        
            return false;
}

    public void createUser(){
        try{
            // Database Connection
            Connection myConn = DriverManager.getConnection(url, userName, userPassword);

            // Create Statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO loginauthentication (userName, userPassword)" + "VALUES('" + uName +"', '" + uPassword +"')";

           // String locationnames = "taplejung";

            // String sql = "Select * from production AS cust INNER JOIN location AS comp ON cust.location_id = comp.location_id where comp.name ='"+ locationnames +"' AND crop_id =1";

            myStmt.executeUpdate(sql);

            System.out.println("INSERT COMPLETE");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUserName() {
        return uName;
    }

    public static String getUserPassword() {
        return uPassword;
    }
}

