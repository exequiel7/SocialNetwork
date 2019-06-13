
package SocialNetwork.ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MySqlConexion {
    public String db = "basesocialnetwork";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root"; //para xampp
    public String pass = "";

    public MySqlConexion() {
    
    }
    
    public Connection conectar(){
        Connection link = null; //connection instance
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //load connection driver
            link = DriverManager.getConnection(this.url, this.user, this.pass); //link to DB
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;              
    }
}
