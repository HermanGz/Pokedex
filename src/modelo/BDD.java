package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {

	private String username;
    private String clave;
    private final String bdUsername = "root";
    private final String bdPassword = "";
    public Connection conexion;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/pokedex?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Statement stm;

    public BDD() 
    {
        setDriver(driver);
        try {
			setConnection(url, bdUsername, bdPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    public String getUsername() 
    {
        
    	return username;
    }

    public String getClave()
    {
        
    	return clave;
    }
    
    

    private void setDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setConnection(String url, String username, String password) throws SQLException {

        try {
            conexion = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        stm = conexion.createStatement();

    }
    

    public void getCredenciales(String username)
    {
        
        try {
           
            ResultSet rs = stm.executeQuery("SELECT NOMBRE, CLAVE FROM USUARIOS WHERE NOMBRE = '" + username +"'" );
            if(rs.next())
            {
                this.username = rs.getString("NOMBRE");
                this.clave = rs.getString("CLAVE");
                rs.close();
            }
            else
            {
                this.username = null;
                this.clave = null;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
