package dao;

import model.Comment;

import java.util.List;

public interface CommentDao extends CRUDDao<Comment> {
    List<Comment> findByArticleId(int id);
}
