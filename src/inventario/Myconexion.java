package inventario;


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
public class Myconexion {
    public static Connection getConnection() {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginp","root","123456");
            }catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return con;
    }
    
}


