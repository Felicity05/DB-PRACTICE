
package DBASE;

import java.sql.*;

/**
 *
 * @author aalva456
 */
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection myconObj = null;     //connect to te database
        Statement mystatObj = null;     //execute queries on the database and get the results
        ResultSet myresObj = null;     //results will be stored here, present the data
        String query = "Select * from AALVA456.SCHOOLS";
        String url;
        String user;
        String password;
        
        try{
           myconObj = DriverManager.getConnection("jdbc:derby://localhost1527/Information", "aalva456", "123456");
           mystatObj = myconObj.createStatement();
           myresObj = mystatObj.executeQuery(query);
           while(myresObj.next()){
               int number = myresObj.getInt("NUMBER");
               String name = myresObj.getString("NAME");
               Date date = myresObj.getDate("DATE");
               String phonenumb = myresObj.getString("PHONENUMBER");
               System.out.println(number + name + date + phonenumb);
           }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
