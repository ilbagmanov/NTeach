package dao;

import model.Theme;

public interface ThemeDao extends CRUDDao<Theme> {
    Theme findByTheme(String theme);
    Theme findByThemeId(int id);
}
