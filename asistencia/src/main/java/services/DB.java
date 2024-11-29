package services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private final String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10748427";
    private final String usuario = "sql10748427";
    private final String contraseña = "SpJbiMYyqh";

    public Connection DBconnect() {
        try {

            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("DB connected");
            return connection;

        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
        return null;
    }
}
