package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

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

    public JSONObject Login(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, dbPassword)) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    JSONObject data = new JSONObject();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = resultSet.getObject(i);
                        data.put(columnName, columnValue);
                    }
                    return data;
                } else {
                    System.out.println("Contraseña incorrecta");
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } else {
                System.out.println("Usuario no encontrado");
                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Registra el error en la consola
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return new JSONObject();
        }
    }

    public void Register(String id) {

        try {
            String query = "INSERT INTO historico (employee_id) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, id);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Created successfully", "Created successfully", 1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", 0);
        }

    }

}
