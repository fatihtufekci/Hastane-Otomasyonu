/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaneotomasyon2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class JDBCUtil2 {
    private static Connection conn;
    
    public static synchronized Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastaneotomasyon2?useSSL=false", "root", "password");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return conn;
    }
    
    public static void main(String[] args){
        Connection conn = getConnection();
            if (conn != null)
		System.out.println(conn);
            else
		System.out.println("No connection!");
    }
}
