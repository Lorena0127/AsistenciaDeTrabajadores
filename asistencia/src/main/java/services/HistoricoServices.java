package services;

import entities.Historico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HistoricoServices {

    private final DB db = new DB();
    private final Connection connection = db.DBconnect();

    public void saveAttendance(Historico attendanceHistory) throws SQLException {
        String sql = "INSERT INTO historico (employee_id, employee_name, date, time_in, time_out, status, created_at) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, attendanceHistory.getEmployeeId());
            statement.setString(2, attendanceHistory.getEmployeeName());
            statement.setDate(3, attendanceHistory.getDate());
            statement.setTime(4, attendanceHistory.getTimeIn());
            statement.setTime(5, attendanceHistory.getTimeOut());
            statement.setString(6, attendanceHistory.getStatus());
            statement.setTimestamp(7, attendanceHistory.getCreatedAt());

            statement.executeUpdate();
        }
    }

    // Método para obtener todos los registros de asistencia
    public List<Historico> getAllAttendanceRecords() throws SQLException {
        List<Historico> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM historico";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String employeeId = resultSet.getString("employee_id");
                String employeeName = resultSet.getString("employee_name");
                Date date = resultSet.getDate("date");
                Time timeIn = resultSet.getTime("time_in");
                Time timeOut = resultSet.getTime("time_out");
                String status = resultSet.getString("status");
                Timestamp createdAt = resultSet.getTimestamp("created_at");

                attendanceList.add(new Historico(id, employeeId, employeeName, date, timeIn, timeOut, status, createdAt));
            }
        }
        return attendanceList;
    }

    // Método para buscar registros de asistencia por ID de empleado
    public List<Historico> findByEmployeeId(String employeeId) throws SQLException {
        List<Historico> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM historico WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String employeeName = resultSet.getString("employee_name");
                    Date date = resultSet.getDate("date");
                    Time timeIn = resultSet.getTime("time_in");
                    Time timeOut = resultSet.getTime("time_out");
                    String status = resultSet.getString("status");
                    Timestamp createdAt = resultSet.getTimestamp("created_at");

                    attendanceList.add(new Historico(id, employeeId, employeeName, date, timeIn, timeOut, status, createdAt));
                }
            }
        }
        return attendanceList;
    }

}
