package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServices {

    private final DB db = new DB();
    private final Connection connection = db.DBconnect();

    public String Create(User newUser) {
        try {
            String query = "INSERT INTO users (id, name, username, password, role, avatar, gender, city, state, country, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, newUser.getId());
            preparedStatement.setString(2, newUser.getName());
            preparedStatement.setString(3, newUser.getUsername());
            preparedStatement.setString(4, newUser.getPassword());
            preparedStatement.setString(5, newUser.getRole());
            preparedStatement.setString(6, newUser.getAvatar());
            preparedStatement.setString(7, newUser.getGender());
            preparedStatement.setString(8, newUser.getCity());
            preparedStatement.setString(9, newUser.getState());
            preparedStatement.setString(10, newUser.getCountry());
            preparedStatement.setInt(11, newUser.getAge());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                return "Usuario insertado correctamente";
            }

        } catch (SQLException e) {
            return "Username alredy exist";
        }
        return null;

    }

    public String Login(String username, String password) {

        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            System.out.println(resultSet);
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("name"));            
                
            }
            if (resultSet.last()) {
                System.out.println("Existe");
            }else{
                System.err.println("No existe");
            }
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("id"));
                System.out.println("Nombre: " + resultSet.getString("name"));
            }

        } catch (SQLException e) {

        }

        return null;

    }

}
