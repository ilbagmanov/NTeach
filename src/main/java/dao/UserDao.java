package dao;

import model.User;

import java.util.List;

public interface UserDao extends CRUDDao<User> {
    User findUserByEmail(String email);
    User findUserById (int id);
}
