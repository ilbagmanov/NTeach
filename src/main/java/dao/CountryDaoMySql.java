package dao;

import liquibase.pro.packaged.M;
import model.Article;
import model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoMySql implements CountryDao {

    private static MySqlConnection connection = new MySqlConnection();

    //language=SQL
    private static final String SQL_SELECT = "Select * from country";
    private static final String SQL_SELECT_BY_NAME = "Select * from country where name = ?";

    @Override //TODO
    public Country findById(int id) {
        return null;
    }

    @Override
    public Country findByName(String name) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_NAME)) {
                statement.setString(1, name);
                try (ResultSet resultSet = statement.executeQuery()) {
                    Country country = null;
                    if (resultSet.next()) {
                        country = Country.builder()
                                .countryId(resultSet.getInt("country_id"))
                                .country(resultSet.getString("name"))
                                .build();
                    }
                    return country;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override //TODO
    public boolean update(Country update) {
        return false;
    }

    @Override //TODO
    public void save(Country save) {

    }

    @Override //TODO
    public boolean delete(Country delete) {
        return false;
    }

    @Override
    public List<Country> findAll() {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Country> countries = new ArrayList<>();
                    while (resultSet.next()) {
                        Country country = Country.builder()
                                .countryId(resultSet.getInt("country_id"))
                                .country(resultSet.getString("name"))
                                .build();
                        countries.add(country);
                    }
                    return countries;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }
}
