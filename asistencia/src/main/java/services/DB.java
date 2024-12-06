package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public ResultSet getUserData(String id) {
        try {
            String query = "SELECT * FROM historico WHERE employee_id = ?";
            Connection connection = DBconnect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            return statement.executeQuery();  // No necesitas pasar el query aquí
        } catch (Exception e) {
            System.err.println("Error al ejecutar la consulta:");
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAdmin() {
        try {
            String query = "select users.username , users.name ,historico.created_at , users.country from users inner JOIN historico on users.id = historico.employee_id";
            Connection connection = DBconnect();
            PreparedStatement statement = connection.prepareStatement(query);

            return statement.executeQuery();  // No necesitas pasar el query aquí
        } catch (Exception e) {
            System.err.println("Error al ejecutar la consulta:");
            e.printStackTrace();
        }
        return null;
    }

}
