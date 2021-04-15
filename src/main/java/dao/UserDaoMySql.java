package dao;

import model.User;
import util.Hash;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoMySql implements UserDao {

    private MySqlConnection connection = new MySqlConnection();

    //language=SQL
    private static String SQL_SELECT_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    //language=SQL
    private static String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE user_id = ?";
    //language=SQL
    private static String SQL_SAVE = "INSERT INTO `user` (`user`.`name`, surname, age, country_id, email, password) values (?,?,?,?,?,?) ";


    @Override
    public User findUserByEmail(String email) {

        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_EMAIL)) {
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();
                User user = null;
                if (resultSet.next()) {
                    user = User.builder()
                            .name(resultSet.getString("name"))
                            .age(resultSet.getInt("age"))
                            .countryId(resultSet.getInt("country_id"))
                            .email(resultSet.getString("email"))
                            .userId(resultSet.getInt("user_id"))
                            .password(resultSet.getString("password"))
                            .surname(resultSet.getString("surname"))
                            .build();

                }
                return user;
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public User findUserById(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_ID)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                User user = null;
                if (resultSet.next()) {
                    user = User.builder()
                            .name(resultSet.getString("name"))
                            .age(resultSet.getInt("age"))
                            .countryId(resultSet.getInt("country_id"))
                            .email(resultSet.getString("email"))
                            .userId(resultSet.getInt("user_id"))
                            .password(resultSet.getString("password"))
                            .surname(resultSet.getString("surname"))
                            .build();
                }
                return user;
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override //TODO
    public boolean update(User update) {
        return false;
    }

    @Override
    public void save(User user) {
        try (Connection con = connection.getNewConnection()) {
            //language=SQL
           try (PreparedStatement statement = con.prepareStatement(SQL_SAVE)) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getSurname());
                statement.setInt(3, user.getAge());
                statement.setInt(4, user.getCountryId());
                statement.setString(5, user.getEmail());
                try {
                    statement.setString(6, Hash.hashPassword(user.getPassword()));
                } catch (NoSuchAlgorithmException e) {
                    throw new IllegalStateException(e);
                }

                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override //TODO
    public boolean delete(User delete) {
        return false;
    }

    @Override //TODO
    public List<User> findAll() {
        return null;
    }
}
