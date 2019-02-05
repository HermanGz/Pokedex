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

    public BDD() {
        setDriver(driver);
        try {
            setConnection(url, bdUsername, bdPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
    }

    public void getCredenciales(String username) {

        try {

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
            }

        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPokemonInfo(String pokemonID) {

        try {
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(
                    "SELECT NOMBRE, PESO, ALTURA, HP, ATTACK, DEFENSE FROM POKEMON WHERE ID = '" + pokemonID + "'");
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

    }

    public int cantidadPokemones() {

        try {
            stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(ID) AS CANTIDAD FROM POKEMON");
            if (rs.next()) {
                cantidadPokemon = rs.getInt("CANTIDAD");
                stm.close();
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidadPokemon;
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
