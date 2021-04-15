package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public Connection getNewConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        String url = "jdbc:mysql://localhost:3306/ntech?serverTimezone=UTC";
        String user = "root";
        String password = "qwerty808";
        return DriverManager.getConnection(url, user, password);
    }
}
