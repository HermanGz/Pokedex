package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BDD {

    private String username;
    private String clave;
    private String pNombre;
    private String pPeso;
    private String pAltura;
    private String pTipo;
    private String pAttack;
    private String pDefense;
    private int cantidadPokemon;
    private final String bdUsername = "root";
    private final String bdPassword = "";
    public Connection conexion;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/pokedex?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Statement stm;

    private void setDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setConnection() throws SQLException {

        try {
            conexion = DriverManager.getConnection(url, bdUsername, bdPassword);
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getCredenciales(String username) {

        try {
            setDriver(driver);
            setConnection();
            stm = conexion.createStatement();
            ResultSet rs = stm
                    .executeQuery("SELECT USUARIO, CLAVE FROM CREDENCIALES WHERE USUARIO = '" + username + "'");
            if (rs.next()) {
                this.username = rs.getString("USUARIO");
                this.clave = rs.getString("CLAVE");
                stm.close();
                rs.close();
            } else {
                this.username = null;
                this.clave = null;
                stm.close();
                rs.close();
                conexion.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPokemonInfo(String pokemonID) {

        try {
            setDriver(driver);
            setConnection();
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(
                    "SELECT NOMBRE, PESO, ALTURA, ATTACK, DEFENSE FROM POKEMON WHERE ID = '" + pokemonID + "'");
            if (rs.next()) {
                this.pNombre = rs.getString("NOMBRE");
                this.pPeso = rs.getString("PESO");
                this.pAltura = rs.getString("ALTURA");
                this.pAttack = rs.getString("ATTACK");
                this.pDefense = rs.getString("DEFENSE");
                stm.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(
                    "SELECT NOMBRE FROM TIPO WHERE ID = (SELECT TIPO FROM POKEMON WHERE ID = " + pokemonID + " )");
            if (rs.next()) {
                this.pTipo = rs.getString("NOMBRE");
                stm.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int cantidadPokemones() {

        try {
            setDriver(driver);
            setConnection();
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(ID) AS CANTIDAD FROM POKEMON");
            if (rs.next()) {
                cantidadPokemon = rs.getInt("CANTIDAD");
                stm.close();
                rs.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidadPokemon;
    }

    public void registrarUsuario(String pseudonimo, String correo, String clave) {

        int ID = 0;

        try {
            setDriver(driver);
            setConnection();
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT ID FROM CREDENCIALES WHERE USUARIO ='" + pseudonimo + "'");
            if (rs.next()) {
                ID = rs.getInt("ID");
            }
            stm.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ID == 0) {
            try {
                setDriver(driver);
                setConnection();
                stm = conexion.createStatement();
                stm.executeUpdate("INSERT INTO credenciales (USUARIO,CLAVE,CORREO) VALUES ('" + pseudonimo + "','" + clave + "','" + correo + "')");
                stm.close();
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Usario Ya Existe", null, 0);
        }
    }

    public String getUsername() {

        return username;
    }

    public String getClave() {

        return clave;
    }

    public String getpNombre() {
        return pNombre;
    }

    public String getpPeso() {
        return pPeso;
    }

    public String getpAltura() {
        return pAltura;
    }

    public String getpTipo() {
        return pTipo;
    }

    public String getpAttack() {
        return pAttack;
    }

    public String getpDefense() {
        return pDefense;
    }
}
