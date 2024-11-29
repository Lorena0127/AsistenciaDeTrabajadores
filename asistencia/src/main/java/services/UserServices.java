package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserServices {

    private DB db = new DB();
    private Connection connection = db.DBconnect();

    public void Create(User newUser) {
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
                System.out.println("Usuario insertado correctamente");
            }

        } catch (Exception e) {
            System.err.println("Error creating user");
            e.printStackTrace();
        }

    }

}
