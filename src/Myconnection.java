
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18297
 */
public class Myconnection {
    
    public static Connection getconnection() {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferreteria_nyt","root","123456");
            }catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return con;
    }
    
}
