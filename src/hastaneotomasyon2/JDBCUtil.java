
package hastaneotomasyon2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JDBCUtil{
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
