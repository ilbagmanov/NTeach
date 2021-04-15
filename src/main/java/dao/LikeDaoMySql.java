package dao;

import liquibase.pro.packaged.M;
import model.Comment;
import model.Like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDaoMySql implements LikeDao {
    private final static MySqlConnection connection = new MySqlConnection();

    //language=SQL
    private static final String SQL_SAVE = "INSERT INTO `like` (`article_id`, `user_id`) VALUES (?, ?)";
    //language=SQL
    private static final String SQL_SELECT_BY_USER_AND_ARTICLE
            = "SELECT * from `like` where user_id = ? AND article_id = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_USER_ID
            = "SELECT * from `like` where user_id = ?";


    @Override
    public Like findByUserIdAndArticleId(int userId, int articleId) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_USER_AND_ARTICLE)) {
                statement.setInt(1, userId);
                statement.setInt(2, articleId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    Like like = null;
                    if (resultSet.next()) {
                        like = Like.builder()
                                .articleId(resultSet.getInt("article_id"))
                                .userId(resultSet.getInt("user_id"))
                                .build();
                    }
                    return like;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public List<Like> findByUserId(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_USER_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Like> likes = new ArrayList<>();
                    while (resultSet.next()) {
                        Like like = Like.builder()
                                .articleId(resultSet.getInt("article_id"))
                                .userId(resultSet.getInt("user_id"))
                                .build();
                        likes.add(like);
                    }
                    return likes;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public boolean update(Like update) {
        return false;
    }

    @Override
    public void save(Like save) {
        try(Connection con = connection.getNewConnection()) {
            try(PreparedStatement statement = con.prepareStatement(SQL_SAVE)) {
                statement.setInt(1, save.getArticleId());
                statement.setInt(2, save.getUserId());
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

    @Override
    public boolean delete(Like delete) {
        return false;
    }

    @Override
    public List<Like> findAll() {
        return null;
    }
}
