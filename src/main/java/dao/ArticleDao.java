package dao;

import model.Article;
import model.Theme;

import java.util.List;

public interface ArticleDao extends CRUDDao<Article> {
    List<Article> findByThemeId(int id);
    List<Article> findByUserId(int id);
    Article findByArticleId(int id);
}
