package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    private final String usuario = "root";
    private String pass = "usbw";
    private String url = "jdbc:mysql://localhost:3306/eventos";

    private Connection connection;

    public BaseDatos() throws  Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(this.url,this.usuario,this.pass);

        if (connection == null){
            throw new Exception("Problemas con conexion");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() throws Exception {
        connection.close();
    }
}
