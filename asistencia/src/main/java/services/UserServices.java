package services;

import controllers.LoginPageController;
import entities.Historico;
import entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public boolean Login(String username, String password) {

        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            String id = "";
            String nombre = "";

            System.out.println(resultSet);
            while (resultSet.next()) {
                
                id = resultSet.getString("id");
                nombre = resultSet.getString("name");
                /*System.out.println("Nombre: " + resultSet.getString("name"));*/

            }
            /*if (resultSet.last()) {*/
                System.out.println("Existe");

                LocalDate currentDate = LocalDate.now();  // Fecha actual del sistema
            LocalTime currentTime = LocalTime.now();  // Hora actual del sistema

            // Convertir la fecha y hora a los tipos de SQL adecuados
            Date sqlDate = Date.valueOf(currentDate); // Convertir LocalDate a SQL Date
            Time sqlTimeIn = Time.valueOf(currentTime); // Convertir LocalTime a SQL Time
            Time sqlTimeOut = Time.valueOf(currentTime.plusHours(9)); // Hora de salida (ejemplo: +9 horas)

            // Crear un nuevo registro de asistencia con la fecha y hora del sistema
            Historico attendance = new Historico(
                    0, id , nombre, 
                    sqlDate, sqlTimeIn, sqlTimeOut,
                    "Presente", new Timestamp(System.currentTimeMillis())
            );

                // Guardar el registro en la base de datos
                HistoricoServices services = new HistoricoServices();

                try {
                    services.saveAttendance(attendance);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
                }

         

        /*}else{
                System.err.println("No existe");
            }
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("id"));
            System.out.println("Nombre: " + resultSet.getString("name"));
        }*/

    }
    catch (SQLException e) {

        }


return false;

    }

}
