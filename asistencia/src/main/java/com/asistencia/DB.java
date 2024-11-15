package com.asistencia;

import java.sql.*;

public class DB {

    public void createUserRow(User newUser) {
        String url = "jdbc:mysql://localhost:3306/asistencia";
        String usuario = "root";
        String contraseña = "root1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "INSERT INTO users (id, name, username, password, role, avatar, gender, city, state, country, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
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
                    System.out.println("¡Usuario insertado correctamente!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
