package dao;

import model.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThemeDaoMySql implements ThemeDao {

    private static MySqlConnection connection = new MySqlConnection();

    //language=SQL
    private final static String SQL_SELECT_BY_THEME = "SELECT * from theme where theme = ?";
    //language=SQL
    private final static String SQL_SELECT_BY_THEME_ID = "SELECT * from theme where theme_id = ?";
    //language=SQL
    private final static String SQL_SELECT = "SELECT  * from theme";

    @Override
    public Theme findByTheme(String theme) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_THEME)) {
                statement.setString(1, theme);
                try (ResultSet resultSet = statement.executeQuery()) {
                    Theme themeObject = null;

                    if (resultSet.next())
                        themeObject = Theme.builder()
                                .themeId(resultSet.getInt("theme_id"))
                                .theme(resultSet.getString("theme"))
                                .build();
                    return themeObject;
                }
            }

        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public Theme findByThemeId(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_THEME_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    Theme themeObject = null;

                    if (resultSet.next())
                        themeObject = Theme.builder()
                                .themeId(resultSet.getInt("theme_id"))
                                .theme(resultSet.getString("theme"))
                                .build();
                    return themeObject;
                }
            }

        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override //TODO
    public boolean update(Theme update) {
        return false;
    }

    @Override //TODO
    public void save(Theme save) { }

    @Override //TODO
    public boolean delete(Theme delete) {
        return false;
    }


    @Override
    public List<Theme> findAll() {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Theme> list = new ArrayList<>();
                    while (resultSet.next()) {
                        Theme themeObject = Theme.builder()
                                .themeId(resultSet.getInt("theme_id"))
                                .theme(resultSet.getString("theme"))
                                .build();
                        list.add(themeObject);
                    }
                    return list;
                }
            }

        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }
}
