package util;

import dao.MySqlConnection;
import dao.ThemeDaoMySql;
import dao.UserDao;
import dao.UserDaoMySql;
import liquibase.pro.packaged.C;
import liquibase.pro.packaged.E;
import liquibase.pro.packaged.M;
import liquibase.pro.packaged.U;
import model.User;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws Exception {
        MySqlConnection connection = new MySqlConnection();
        Connection con = connection.getNewConnection();
        //language=SQL
        PreparedStatement statement = con.prepareStatement("select * from comment");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Timestamp s = resultSet.getTimestamp("date");
    }
}
