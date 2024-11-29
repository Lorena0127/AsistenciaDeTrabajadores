package services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private final String url = "jdbc:mysql://192.168.0.153:3306/asistencia";
    private final String usuario = "root";
    private final String contraseña = "123456";

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
