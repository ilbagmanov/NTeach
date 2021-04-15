package dao;

import model.Article;
import model.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoMySql implements ArticleDao {

    private static final MySqlConnection connection = new MySqlConnection();

    //language=SQL
    private static final String SQL_SELECT_BY_THEME_ID = "SELECT * from article where theme_id = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_USER_ID = "SELECT * from article where user_id = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_ARTICLE_ID = "SELECT * from article where article_id = ?";
    private static final String SQL_SELECT = "Select * from article";
    //language=SQL
    private static final String SQL_SAVE = "INSERT INTO `article` (`user_id`, `theme_id`, `text`, `topic`) VALUES (?, ?, ?, ?)";

    @Override
    public List<Article> findByThemeId(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_THEME_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Article> articles = new ArrayList<>();
                    while (resultSet.next()) {
                        Article article = Article.builder()
                                .articleId(resultSet.getInt("article_id"))
                                .themeId(resultSet.getInt("theme_id"))
                                .text(resultSet.getString("text"))
                                .topic(resultSet.getString("topic"))
                                .date(resultSet.getTimestamp("date"))
                                .build();
                        articles.add(article);
                    }
                    return articles;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public List<Article> findByUserId(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_USER_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Article> articles = new ArrayList<>();
                    while (resultSet.next()) {
                        Article article = Article.builder()
                                .articleId(resultSet.getInt("article_id"))
                                .themeId(resultSet.getInt("theme_id"))
                                .text(resultSet.getString("text"))
                                .topic(resultSet.getString("topic"))
                                .userId(resultSet.getInt("user_id"))
                                .date(resultSet.getTimestamp("date"))
                                .build();
                        articles.add(article);
                    }
                    return articles;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public Article findByArticleId(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_ARTICLE_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    Article article = null;
                    if (resultSet.next()) {
                        article = Article.builder()
                                .articleId(resultSet.getInt("article_id"))
                                .themeId(resultSet.getInt("theme_id"))
                                .text(resultSet.getString("text"))
                                .topic(resultSet.getString("topic"))
                                .userId(resultSet.getInt("user_id"))
                                .date(resultSet.getTimestamp("date"))
                                .build();
                    }
                    return article;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override //TODO
    public boolean update(Article update) {
        return false;
    }

    @Override
    public void save(Article save) {
        try(Connection con = connection.getNewConnection()) {
            try(PreparedStatement statement = con.prepareStatement(SQL_SAVE)) {
                statement.setInt(1, save.getUserId());
                statement.setInt(2, save.getThemeId());
                statement.setString(3, save.getText());
                statement.setString(4,save.getTopic());
                try {
                    statement.executeUpdate();
                } catch (SQLException throwables) {
                    throw new IllegalStateException(throwables);
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override //TODO
    public boolean delete(Article delete) {
        return false;
    }

    @Override
    public List<Article> findAll() {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Article> articles = new ArrayList<>();
                    while (resultSet.next()) {
                        Article article = Article.builder()
                                .articleId(resultSet.getInt("article_id"))
                                .themeId(resultSet.getInt("theme_id"))
                                .text(resultSet.getString("text"))
                                .topic(resultSet.getString("topic"))
                                .userId(resultSet.getInt("user_id"))
                                .date(resultSet.getTimestamp("date"))
                                .build();
                        articles.add(article);
                    }
                    return articles;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }
}
