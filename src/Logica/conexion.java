package Logica;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Ismael
 */
public class conexion {
    public String db="congreso";
    public String url="jdbc:mysql://127.0.0.1/" +db;
    public String user="root";
    public String password="";

    public conexion() {
    }
   public Connection conectar() 
    {
        Connection link;
        link = null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=(Connection) DriverManager.getConnection(this.url, this.user, this.password);
            } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
                  }
       return link;
    }  
   }
