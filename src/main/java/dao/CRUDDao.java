package dao;

import java.util.List;

public interface CRUDDao<T> {

    boolean update(T update);
    void save(T save);
    boolean delete(T delete);
    List<T> findAll();
}
