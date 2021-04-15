package dao;

import model.Article;
import model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoMySql implements CommentDao {
    private static MySqlConnection connection = new MySqlConnection();

    //language=SQL
    private final static String SQL_SELECT_BY_ARTICLE_ID = "SELECT * from comment where article_id = ?";
    //language=SQL
    private static final String SQL_SAVE = "INSERT INTO `comment` (`user_id`, `article_id`, `comment`) VALUES (?, ?, ?)";

    @Override
    public List<Comment> findByArticleId(int id) {
        try (Connection con = connection.getNewConnection()) {
            try (PreparedStatement statement = con.prepareStatement(SQL_SELECT_BY_ARTICLE_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Comment> comments = new ArrayList<>();
                    while (resultSet.next()) {
                        Comment comment = Comment.builder()
                                .commentId(resultSet.getInt("comment_id"))
                                .articleId(resultSet.getInt("article_id"))
                                .userId(resultSet.getInt("user_id"))
                                .comment(resultSet.getString("comment"))
                                .date(resultSet.getTimestamp("date"))
                                .build();
                        comments.add(comment);
                    }
                    return comments;
                }
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    public boolean update(Comment update) {
        return false;
    }

    @Override
    public void save(Comment save) {
        try(Connection con = connection.getNewConnection()) {
            try(PreparedStatement statement = con.prepareStatement(SQL_SAVE)) {
                statement.setInt(1, save.getUserId());
                statement.setInt(2, save.getArticleId());
                statement.setString(3, save.getComment());
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
    public boolean delete(Comment delete) {
        return false;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
