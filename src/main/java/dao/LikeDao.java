package dao;

import model.Like;

import java.util.List;

public interface LikeDao extends CRUDDao<Like> {
    Like findByUserIdAndArticleId(int userId, int articleId);
    List<Like> findByUserId(int id);
}
